package com.chhattisgarh.sora_11.Fetch_Data;

import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.chhattisgarh.sora_11.MainActivity;

import com.chhattisgarh.sora_11.Splash_And_Story.Splash_animation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

import static android.content.Context.MODE_PRIVATE;


public class Bgfetch extends AsyncTask<Void,Void,Void> {


    private RequestQueue mQueue;
    static MyHelper helper;
    static SQLiteDatabase database;



    DecimalFormat formatter = new DecimalFormat("#,##,###");


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        helper =new MyHelper(Splash_animation.context);
        database =helper.getWritableDatabase();
        String url = "https://script.google.com/macros/s/AKfycbzLySFwJNojgOyaJb9JvcY0lSafNRjSIBimSPJ3d_PeMFAtNldV/exec?id=19DI7iAoSOHlN466WoVb2aoVY2x1mu5_k3ha7cjIY4ec&sheet=Sheet9";
        mQueue = Volley.newRequestQueue(Splash_animation.context);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray=response.getJSONArray("records");
                            String news[] = new String[jsonArray.length()];
                            String date[] = new String[jsonArray.length()];
                            int id[] = new int[jsonArray.length()];
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jo = jsonArray.getJSONObject(i);
                                id[i]= jo.getInt("id");
                                news[i] = jo.getString("description");
                                date[i] = jo.getString("date");
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);

        url = "https://corona.lmao.ninja/v2/all";
        mQueue = Volley.newRequestQueue(Splash_animation.context);
        request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //JSONArray jsonArray=response.getJSONArray("statewise");

                            int GConfirmed = response.getInt("cases");
                            int GDeath = response.getInt("deaths");
                            int GRecovered = response.getInt("recovered");
                            int GActive = response.getInt("active");

                            Cursor cursor = database.rawQuery("SELECT COUNT(cocode) FROM GLOBAL",new String[]{});
                            if(cursor !=null) {
                                cursor.moveToNext();
                            }
                            int rows = cursor.getInt(0);
                            if(rows==0)
                            {
                                helper.GoData("GT",GConfirmed,GDeath,GRecovered,GActive,database);
                            }
                            else {
                                ContentValues values = new ContentValues();
                                values.put("confirmed",GConfirmed);
                                values.put("death",GDeath);
                                values.put("recovered",GRecovered);
                                values.put("active",GActive);
                                database.update("GLOBAL",values,"cocode=?",new String[]{"GT"});
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);

        url = "https://api.covid19india.org/data.json";
        mQueue = Volley.newRequestQueue(Splash_animation.context);
        request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray=response.getJSONArray("statewise");
                            Cursor cursor = database.rawQuery("SELECT COUNT(statecode) FROM STATEWISE",new String[]{});
                            if(cursor !=null) {
                                cursor.moveToNext();
                            }
                            int rows = cursor.getInt(0);
                            if(rows>0&&rows!=38){
                                database.delete("STATEWISE",null,new String[]{});
                                inse(jsonArray);
                            }
                            else if(rows==38) {
                                upd(jsonArray);
                            }
                            else {
                                inse(jsonArray);
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);


        url = "https://api.covid19india.org/v2/state_district_wise.json";
        mQueue = Volley.newRequestQueue(Splash_animation.context);
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {

                            for(int i=0;i<response.length();i++) {
                                JSONObject jo = response.getJSONObject(i);
                                String stateName = jo.getString("state");
                                if(stateName.equals("Chhattisgarh")) {
                                    JSONArray disArray = jo.getJSONArray("districtData");
                                    Cursor cursor = database.rawQuery("SELECT COUNT(state) FROM DISTRICTWISE",new String[]{});
                                    if(cursor !=null) {
                                        cursor.moveToNext();
                                    }
                                    int rows = cursor.getInt(0);
                                    if(rows>0&&rows!=28){
                                        database.delete("DISTRICTWISE",null,new String[]{});
                                        insertDistrict(disArray,stateName);
                                    }
                                    else if(rows==28) {
                                        updateDistrict(disArray,stateName);
                                    }
                                    else {
                                        insertDistrict(disArray,stateName);
                                    }
                                }
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }catch(Exception e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(arrayRequest);


        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }
    public void insertZone(JSONArray jsonArray){
        try{
            for(int i = 0 ;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String district = jsonObject.getString("District");
                String zone = jsonObject.getString("Zone");
                helper.zoneInsert("Punjab",district,zone,database);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    public void updateZone(JSONArray jsonArray){
        try{
            for(int i = 0 ;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String district = jsonObject.getString("District");
                String zone = jsonObject.getString("Zone");
                helper.zoneInsert("Punjab",district,zone,database);
                ContentValues values = new ContentValues();
                values.put("zone",zone);
                database.update("ZONE",values,"district=?",new String[]{district});
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    public void insertDistrict(JSONArray disArray,String stateName)
    {
        try
        {
           // System.out.println(disArray.length());
            for(int j=0;j<disArray.length();j++)
            {
                JSONObject districtObject = disArray.getJSONObject(j);
                String district = districtObject.getString("district");
                if(district.equals("Other State"))
                        continue;;
                int Active = districtObject.getInt("active");
                int Death = districtObject.getInt("deceased");
                int Recovered = districtObject.getInt("recovered");
                int Confirmed = districtObject.getInt("confirmed");
                //System.out.println(district+",");
                helper.districtInsert(stateName,district,Confirmed,Death,Recovered,Active,database);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public void updateDistrict(JSONArray disArray,String stateName)
    {
        try
        {
            for(int j=0;j<disArray.length();j++)
            {
                JSONObject districtObject = disArray.getJSONObject(j);
                String district = districtObject.getString("district");
                int Active = districtObject.getInt("active");
                int Death = districtObject.getInt("deceased");
                int Recovered = districtObject.getInt("recovered");
                int Confirmed = districtObject.getInt("confirmed");
                ContentValues values = new ContentValues();
                values.put("confirmed",Confirmed);
                values.put("death",Death);
                values.put("recovered",Recovered);
                values.put("active",Active);
                database.update("DISTRICTWISE",values,"district=?",new String[]{district});
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

    }


    public void inse(JSONArray jsonArray)
    {

        try
        {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jo = jsonArray.getJSONObject(i);
                String Code = jo.getString("statecode");
                String State = jo.getString("state");
                int Confirmed = Integer.parseInt(jo.getString("confirmed"));
                int Death = Integer.parseInt(jo.getString("deaths"));
                int Recovered = Integer.parseInt(jo.getString("recovered"));
                int Active = Integer.parseInt(jo.getString("active"));


                helper.insertData(Code,State,Confirmed,Death,Recovered,Active,database);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    public void upd(JSONArray jsonArray)
    {
        try
        {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jo = jsonArray.getJSONObject(i);
                String State = jo.getString("state");
                int Confirmed = Integer.parseInt(jo.getString("confirmed"));
                int Death = Integer.parseInt(jo.getString("deaths"));
                int Recovered = Integer.parseInt(jo.getString("recovered"));
                int Active = Integer.parseInt(jo.getString("active"));

                ContentValues values = new ContentValues();
                values.put("confirmed",Confirmed);
                values.put("death",Death);
                values.put("recovered",Recovered);
                values.put("active",Active);
                database.update("STATEWISE",values,"state=?",new String[]{State});
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    public void coinse(JSONArray jsonArray)
    {

        try
        {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jo = jsonArray.getJSONObject(i);
                String Code = jo.getString("CountryCode");
                String Country = jo.getString("Country");
                int Confirmed = jo.getInt("TotalConfirmed");
                int Death = jo.getInt("TotalDeaths");
                int Recovered = jo.getInt("TotalRecovered");
                int Active = Confirmed-Death-Recovered;

                helper.CoData(Code,Country,Confirmed,Death,Recovered,Active,database);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    public void coupd(JSONArray jsonArray)
    {
        try
        {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jo = jsonArray.getJSONObject(i);
                String Code = jo.getString("CountryCode");
                //String Country = jo.getString("Country");
                int Confirmed = jo.getInt("TotalConfirmed");
                int Death = jo.getInt("TotalDeaths");
                int Recovered = jo.getInt("TotalRecovered");
                int Active = Confirmed-Death-Recovered;
                ContentValues values = new ContentValues();
                values.put("confirmed",Confirmed);
                values.put("death",Death);
                values.put("recovered",Recovered);
                values.put("active",Active);
                database.update("COUNTRY",values,"cocode=?",new String[]{Code});


            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public void count(final TextView textView, int x){
        final ValueAnimator valueAnimator = ValueAnimator.ofInt(0, x);

        valueAnimator.setDuration(4500);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                textView.setText(String.valueOf(formatter.format(valueAnimator.getAnimatedValue())));
            }
        });
        valueAnimator.start();

    }


    public void statsfetch()
    {
        Cursor jo = database.rawQuery("SELECT confirmed,death,recovered,active FROM STATEWISE WHERE state=?",new String[]{"Total"});
        while (jo.moveToNext()) {

            //MainActivity.INDIA_Recovered.setText(formatter.format(Integer.parseInt(jo.getString(2))));
            //count(MainActivity.INDIA_Recovered, Integer.parseInt(jo.getString(2)));

            //MainActivity.INDIA_Deaths.setText(formatter.format(Integer.parseInt(jo.getString(1))));
            count(MainActivity.INDIA_Deaths, Integer.parseInt(jo.getString(1)));

            //MainActivity.INDIA_Confirmed.setText(formatter.format(Integer.parseInt(jo.getString(0))));
            count(MainActivity.INDIA_Confirmed, Integer.parseInt(jo.getString(0)));

//            MainActivity.INDIA_Active.setText(formatter.format(Integer.parseInt(jo.getString(3))));
            count(MainActivity.INDIA_Active, Integer.parseInt(jo.getString(3)));
        }

        jo = database.rawQuery("SELECT confirmed,death,recovered,active FROM GLOBAL WHERE cocode=?",new String[]{"GT"});

        while (jo.moveToNext()) {


            //MainActivity.WORLD_Recovered.setText(formatter.format(Integer.parseInt(jo.getString(2))));
            // count(MainActivity.WORLD_Recovered, Integer.parseInt(jo.getString(2)));

            // MainActivity.WORLD_Deaths.setText(formatter.format(Integer.parseInt(jo.getString(1))));
            count(MainActivity.WORLD_Deaths, Integer.parseInt(jo.getString(1)));

            // MainActivity.WORLD_Confirmed.setText(formatter.format(Integer.parseInt(jo.getString(0))));
            count(MainActivity.WORLD_Confirmed, Integer.parseInt(jo.getString(0)));

            //MainActivity.WORLD_Active.setText(formatter.format(Integer.parseInt(jo.getString(3))));
            count(MainActivity.WORLD_Active, Integer.parseInt(jo.getString(3)));
        }

    }

    public void statsfetchState(String userState){

        Cursor jo = database.rawQuery("SELECT confirmed,death,recovered,active FROM STATEWISE WHERE state=?",new String[]{""+userState});

        while (jo.moveToNext()) {


            // MainActivity.STATE_Active.setText(formatter.format(Integer.parseInt(jo.getString(3))));
            count(MainActivity.STATE_Active, Integer.parseInt(jo.getString(3)));

            //MainActivity.STATE_Death.setText (formatter.format(Integer.parseInt(jo.getString(1))));
            count(MainActivity.STATE_Death, Integer.parseInt(jo.getString(1)));

            //MainActivity.STATE_Recovered.setText(formatter.format(Integer.parseInt(jo.getString(2))));
//            count(MainActivity.STATE_Recovered, Integer.parseInt(jo.getString(2)));

            //MainActivity.STATE_Confirmed.setText (formatter.format(Integer.parseInt(jo.getString(0))));
            count(MainActivity.STATE_Confirmed, Integer.parseInt(jo.getString(0)));

        }
    }
    public void statsfetchDistrict(String userDistrict){

        Cursor jo = database.rawQuery("SELECT confirmed,death,recovered,active FROM DISTRICTWISE WHERE district=?",new String[]{""+userDistrict});

        while (jo.moveToNext()) {

            MainActivity.districtName.setText(userDistrict);
            // MainActivity.STATE_Active.setText(formatter.format(Integer.parseInt(jo.getString(3))));
            count(MainActivity.district_Active, Integer.parseInt(jo.getString(3)));

            //MainActivity.STATE_Death.setText (formatter.format(Integer.parseInt(jo.getString(1))));
            count(MainActivity.district_Death, Integer.parseInt(jo.getString(1)));

            //MainActivity.STATE_Recovered.setText(formatter.format(Integer.parseInt(jo.getString(2))));
//            count(MainActivity.STATE_Recovered, Integer.parseInt(jo.getString(2)));

            //MainActivity.STATE_Confirmed.setText (formatter.format(Integer.parseInt(jo.getString(0))));
            count(MainActivity.district_Confirmed, Integer.parseInt(jo.getString(0)));

        }
    }


    public String[][] fetchDataTable(String sortBy, String sortOrder){

        String sqlQuery;

        sqlQuery = "SELECT state,confirmed,death,recovered,active FROM STATEWISE ORDER BY " + sortBy + " " + sortOrder;

        Cursor jo = database.rawQuery(sqlQuery, null);

        String[][] tableData = new String[38][5];
        int count = 0;
        while (jo.moveToNext()) {
            tableData[count][0] = jo.getString(0);
            tableData[count][1] = jo.getString(1);
            tableData[count][2] = jo.getString(2);
            tableData[count][3] = jo.getString(3);
            tableData[count][4] = jo.getString(4);
            count++;
        }
        return tableData;
    }
    public String[][] fetchDataDistrictTable(String state,String sortBy, String sortOrder){

        String sqlQuery;
        sqlQuery = "SELECT count(district) FROM DISTRICTWISE WHERE state ='"+state+"'";

        Cursor jo = database.rawQuery(sqlQuery, null);
        if(jo !=null) {
            jo.moveToNext();
        }
        int rows = jo.getInt(0);

        sqlQuery = "SELECT district,confirmed,death,recovered,active FROM DISTRICTWISE WHERE state = '"+state+"' ORDER BY " + sortBy + " " + sortOrder;
        jo = database.rawQuery(sqlQuery, null);
        String[][] tableData = new String[rows][5];
        int count = 0;
        while (jo.moveToNext()) {
            tableData[count][0] = jo.getString(0);
            tableData[count][1] = jo.getString(1);
            tableData[count][2] = jo.getString(2);
            tableData[count][3] = jo.getString(3);
            tableData[count][4] = jo.getString(4);
            count++;
        }
        return tableData;
    }
    public String[][] fetchCountryData(String option, String sortBy, String sortOrder){

        String sqlQuery ="SELECT country,confirmed,death,recovered,active FROM COUNTRY ORDER BY "+sortBy +" " +sortOrder;

        Cursor jo = database.rawQuery(sqlQuery, null);

        String[][] tableData = new String[248][5];
        int count = 0;
        while (jo.moveToNext()) {
            tableData[count][0] = jo.getString(0);
            tableData[count][1] = jo.getString(1);
            tableData[count][2] = jo.getString(2);
            tableData[count][3] = jo.getString(3);
            tableData[count][4] = jo.getString(4);
            count++;
        }
        return tableData;
    }




}

