package com.chhattisgarh.sora_11.Fetch_Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
    private static final String dbname ="mydb";
    private static final int version =1;
    public MyHelper(Context context)
    {
        super(context,dbname,null,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql;
        sql="CREATE TABLE STATEWISE(statecode TEXT, state TEXT, confirmed INTEGER, death INTEGER, recovered INTEGER, active INTEGER)";
        db.execSQL(sql);
        sql="CREATE TABLE COUNTRY(cocode TEXT, country TEXT, confirmed INTEGER, death INTEGER, recovered INTEGER, active INTEGER)";
        db.execSQL(sql);
        sql="CREATE TABLE GLOBAL(cocode TEXT, confirmed INTEGER, death INTEGER, recovered INTEGER, active INTEGER)";
        db.execSQL(sql);
        sql="CREATE TABLE DISTRICTWISE(state TEXT, district TEXT, confirmed INTEGER, death INTEGER, recovered INTEGER, active INTEGER)";
        db.execSQL(sql);
        sql="CREATE TABLE ZONE(state TEXT, district TEXT, zone TEXT)";
        db.execSQL(sql);

        sql  = "CREATE TABLE NEWS(ID INTEGER, des TEXT,don TEXT)";
        db.execSQL(sql);
    }

    public void districtInsert(String State,String District,int Confirmed,int Death,int Recovered,int Active,SQLiteDatabase database){
        ContentValues values = new ContentValues();
        values.put("state",State);
        values.put("district",District);
        values.put("confirmed",Confirmed);
        values.put("death",Death);
        values.put("recovered",Recovered);
        values.put("active",Active);
        database.insert("DISTRICTWISE",null,values);
    }
    public void zoneInsert(String State,String District,String zone,SQLiteDatabase database){
        ContentValues values = new ContentValues();
        values.put("state",State);
        values.put("district",District);
        values.put("zone",zone);
        database.insert("ZONE",null,values);
    }
    public void insertnews(int id,String news,String date,SQLiteDatabase database){
        ContentValues values = new ContentValues();
        values.put("des",news);
        values.put("don",date);
        values.put("ID",id);
        database.insert("NEWS",null,values);
    }

    public void insertData(String Statecode,String State,int Confirmed,int Death,int Recovered,int Active,SQLiteDatabase database){
        ContentValues values = new ContentValues();
        values.put("statecode",Statecode);
        values.put("state",State);
        values.put("confirmed",Confirmed);
        values.put("death",Death);
        values.put("recovered",Recovered);
        values.put("active",Active);
        database.insert("STATEWISE",null,values);
    }
    public void CoData(String Cocode,String Country,int Confirmed,int Death,int Recovered,int Active,SQLiteDatabase database){
        ContentValues values = new ContentValues();
        values.put("cocode",Cocode);
        values.put("country",Country);
        values.put("confirmed",Confirmed);
        values.put("death",Death);
        values.put("recovered",Recovered);
        values.put("active",Active);
        database.insert("COUNTRY",null,values);
    }
    public void GoData(String Cocode,int Confirmed,int Death,int Recovered,int Active,SQLiteDatabase database){
        ContentValues values = new ContentValues();
        values.put("cocode",Cocode);
        values.put("confirmed",Confirmed);
        values.put("death",Death);
        values.put("recovered",Recovered);
        values.put("active",Active);
        database.insert("GLOBAL",null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS STATEWISE");
        db.execSQL("DROP TABLE IF EXISTS GLOBAL");
        db.execSQL("DROP TABLE IF EXISTS COUNTRY");
        onCreate(db);



    }
}
