package com.chhattisgarh.sora_11.Module;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.chhattisgarh.sora_11.Login_Task.RequestHandler;
import com.chhattisgarh.sora_11.Login_Task.URLs;
import com.chhattisgarh.sora_11.MainActivity;
import com.chhattisgarh.sora_11.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class BecomeVolunteer extends AppCompatActivity {
    public static TextView dob,startDate,endDate;
    public EditText fullName, phoneNumber,edt_Email,edt_fow,edt_occ,edt_address;
    public Button submitForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_become_volunteer);

        //spin = findViewById(R.id.Dist)

        fullName = findViewById(R.id.FullName);
        phoneNumber = findViewById(R.id.PhoneNumber);
        edt_Email = findViewById(R.id.Email);
        edt_fow = findViewById(R.id.FieldOfWork);
        edt_occ = findViewById(R.id.occupation);
        edt_address = findViewById(R.id.PermanentAddress);


        dob = findViewById(R.id.DOB);
        startDate = findViewById(R.id.StartDate);
        endDate = findViewById(R.id.EndDate);


        submitForm = findViewById(R.id.submitForm);
        submitForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();

            }
        });


    }
    //---------------------------set date of birth----------------------------------------
    public void DOB(View view) {
        DialogFragment fragment =new DatePickerFragmentDOB();
        fragment.show(getSupportFragmentManager(),"date picker");
    }
    public static  void setDOB(int year,int month,int day){
        dob.setText(year + "-" +month + "-" + day );
        dob.setTextColor(Color.BLACK);
    }
    //----------------------------------------------------------------------------------

    //------------------------set Start date--------------------------------------------
    public void startDate(View view) {
        DialogFragment fragment =new DatePickerFragmentStartDate();
        fragment.show(getSupportFragmentManager(),"date picker");
    }
    public static void setStartDate(int year,int month,int day){
        startDate.setText(year + "-"+month + "-" + day);
        startDate.setTextColor(Color.BLACK);
    }
    //----------------------------------------------------------------------------------

    //-------------------------set End date---------------------------------------------
    public void endDate(View view) {
        DialogFragment fragment =new DatePickerFragmentEndDate();
        fragment.show(getSupportFragmentManager(),"date picker");
    }

    public static void setEndDate(int year,int month,int day){
        endDate.setText(year +"-"+month + "-" + day);
        endDate.setTextColor(Color.BLACK);
    }
    //--------------------------------------------------------------------------------

    //----------------------submit form-----------------------------------------------
    private void submitForm() {
        final String name = fullName.getText().toString().trim();
        final String mobile = phoneNumber.getText().toString().trim();
        final String doba = dob.getText().toString().trim();
        final String email = edt_Email.getText().toString().trim();
        final String fow = edt_fow.getText().toString().trim();
        final String occupation = edt_occ.getText().toString().trim();
        final String start = startDate.getText().toString().trim();
        final String enda = endDate.getText().toString().trim();
        final String address = edt_address.getText().toString().trim();

        //first we will do the validations

        if (TextUtils.isEmpty(name)) {
            fullName.setError("required");
            fullName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(mobile)) {
            phoneNumber.setError("required.");
            phoneNumber.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(doba)) {
            dob.setError("required");
            dob.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(fow)) {
            edt_Email.setError("required");
            edt_Email.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(occupation)) {
            edt_occ.setError("required");
            edt_occ.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(start)) {
            startDate.setError("required");
            startDate.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(enda)) {
            endDate.setError("required");
            endDate.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(address)) {
            edt_address.setError("required");
            edt_address.requestFocus();
            return;
        }


        //if it passes all the validations

        class VolunteerForm extends AsyncTask<Void, Void, String> {

            private ProgressBar progressBar;

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("dob", doba);
                params.put("mobile", mobile);
                params.put("email", email);
                params.put("fow", fow);
                params.put("occu", occupation);
                params.put("start", start);
                params.put("end", enda);
                params.put("addr", address);
                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_Volunteer, params);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //displaying the progress bar while user registers on the server

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //hiding the progressbar after completion

                //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                        //-------------------
                        startActivity(new Intent(BecomeVolunteer.this, MainActivity.class));
                        finish();
                        //----------------
                    } else {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        //executing the async task
        VolunteerForm volunteerForm = new VolunteerForm();
        volunteerForm.execute();
    }



}