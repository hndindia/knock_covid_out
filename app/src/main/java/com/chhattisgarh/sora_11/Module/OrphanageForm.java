package com.chhattisgarh.sora_11.Module;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.chhattisgarh.sora_11.Login_Task.RequestHandler;
import com.chhattisgarh.sora_11.Login_Task.URLs;
import com.chhattisgarh.sora_11.MainActivity;
import com.chhattisgarh.sora_11.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class OrphanageForm extends AppCompatActivity {
    public CheckBox orphanageCheckBox;
    public Button submitForm;
    public EditText edt_orphName,edt_regNum,edt_head,edt_mobile,edt_city,edt_pin,edt_orphNum,edt_need,edt_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orphanage_form);

        orphanageCheckBox = findViewById(R.id.OrphanageCheckBox);
        edt_address = findViewById(R.id.Address);
        edt_city = findViewById(R.id.City);
        edt_orphName =findViewById(R.id.OrphanageName);
        edt_regNum = findViewById(R.id.OrphanageRegistrationNumber);
        edt_head = findViewById(R.id.HeadName);
        edt_mobile = findViewById(R.id.PhoneNumber);
        edt_pin = findViewById(R.id.PinCode);
        edt_need = findViewById(R.id.AnyNeed);
        edt_orphNum = findViewById(R.id.NoOfOrphan);

        submitForm = findViewById(R.id.submitOrphanageForm);
        submitForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(orphanageCheckBox.isChecked()){

                    submitForm();
                }else if(!orphanageCheckBox.isChecked()){
                    Toast.makeText(OrphanageForm.this, "Check Box is not checked", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    private void submitForm() {
        final String orphname = edt_orphName.getText().toString().trim();
        final String mobile = edt_mobile.getText().toString().trim();
        final String regNum= edt_regNum.getText().toString().trim();
        final String head = edt_head.getText().toString().trim();
        final String city = edt_city.getText().toString().trim();
        final String orphNum = edt_orphNum.getText().toString().trim();
        final String pin = edt_pin.getText().toString().trim();
        final String need = edt_need.getText().toString().trim();
        final String address = edt_address.getText().toString().trim();

        //first we will do the validations

        if (TextUtils.isEmpty(orphname)) {
            edt_orphName.setError("required");
            edt_orphName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(mobile)) {
            edt_mobile.setError("required.");
            edt_mobile.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(regNum)) {
            edt_regNum.setError("required");
            edt_regNum.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(head)) {
            edt_head.setError("required");
            edt_head.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(city)) {
            edt_city.setError("required");
            edt_city.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(pin)) {
            edt_pin.setError("required");
            edt_pin.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(orphNum)) {
            edt_orphNum.setError("required");
            edt_orphNum.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(need)) {
            edt_need.setError("required");
            edt_need.requestFocus();
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
                params.put("orph_name", orphname);
                params.put("reg_no", regNum);
                params.put("head_name", head);
                params.put("mobile", mobile);
                params.put("city", city);
                params.put("pincode", pin);
                params.put("orph_no", orphNum);
                params.put("needs", need);
                params.put("addr", address);
                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_orphanage, params);
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



                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);

                    //if no error in response

                    if (!obj.getBoolean("error")) {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                        //-------------------
                        startActivity(new Intent(OrphanageForm.this, MainActivity.class));
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
