package com.chhattisgarh.sora_11.Login_Task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.chhattisgarh.sora_11.District_Select;
import com.chhattisgarh.sora_11.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Signup extends AppCompatActivity {
    EditText edt_name, edt_email, edt_pass,edt_confirmpass;
    Button btn_signupnow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edt_name = findViewById(R.id.edt_name);
        edt_email = findViewById(R.id.edt_email);
        edt_pass = findViewById(R.id.edt_pass);
        edt_confirmpass = findViewById(R.id.edt_confirmpass);
        btn_signupnow = findViewById(R.id.btn_signupnow);
        btn_signupnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Signup.this, "Please wait....", Toast.LENGTH_LONG).show();
                registerUser();
            }
        });
    }
    private void registerUser() {
        final String name = edt_name.getText().toString().trim();
        final String mobile = edt_email.getText().toString().trim();
        final String pass = edt_pass.getText().toString().trim();
        final String cpass = edt_confirmpass.getText().toString().trim();



        //first we will do the validations

        if (TextUtils.isEmpty(name)) {
            edt_name.setError("Please enter name");
            edt_name.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(mobile)) {
            edt_email.setError("Please enter your mobile No.");
            edt_email.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(pass)) {
            edt_pass.setError("Enter a password");
            edt_pass.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(cpass)) {
            edt_confirmpass.setError("confirm password");
            edt_confirmpass.requestFocus();
            return;
        }
        if(!pass.equals(cpass))
        {
            edt_confirmpass.setError("Password Does not match");
            edt_confirmpass.requestFocus();
            return;
        }

        //if it passes all the validations

        class RegisterUser extends AsyncTask<Void, Void, String> {

            private ProgressBar progressBar;

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("mobile", mobile);
                params.put("password", pass);


                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_REGISTER, params);
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

                        //getting the user from the response
                        JSONObject userJson = obj.getJSONObject("user");

                        SharedPreferences userDetails = getApplicationContext().getSharedPreferences("userdetails", MODE_PRIVATE);
                        SharedPreferences.Editor edit = userDetails.edit();
                        edit.putBoolean("notLogged", false);
                        edit.apply();
                        edit.putString("username",userJson.getString("name"));
                        edit.apply();
                        edit.putString("usermobile",userJson.getString("mobile"));
                        edit.apply();

                        Intent i = new Intent(Signup.this,  District_Select.class);
                        startActivity(i);

                        //creating a new user object


                        //storing the user in shared preference

                        //starting the profile activity
                        // finish();
                        //startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        //executing the async task
        RegisterUser ru = new RegisterUser();
        ru.execute();
    }
}
