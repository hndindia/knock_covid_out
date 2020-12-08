package com.chhattisgarh.sora_11.Login_Task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.chhattisgarh.sora_11.District_Select;
import com.chhattisgarh.sora_11.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Login extends AppCompatActivity {
    RelativeLayout rellay1;
    LinearLayout rellay2;
    Button btn_signup ,btn_forgotpass,btn_login;
    EditText edt_pass, edt_email;
    Handler handler = new Handler() ;
    Runnable runnable = new Runnable() {

        @Override
        public void run() {

            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_email = findViewById(R.id.mobile);
        edt_pass = findViewById(R.id.edt_pass);

        rellay1 =  findViewById(R.id.rellay1);
        rellay2 =  findViewById(R.id.rellay2);

        handler.postDelayed(runnable,2000);

        btn_signup = findViewById(R.id.btn_signup);
        btn_forgotpass = findViewById(R.id.btn_forgotpass);
        btn_login = findViewById(R.id.btn_login);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Signup.class);
                startActivity(i);
                onPause();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "Please wait....", Toast.LENGTH_LONG).show();
                userLogin();
            }
        });

        btn_forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(Login.this, forgotpass.class);
//                startActivity(i);
//                onPause();
            }
        });

    }
    private void userLogin() {
        //first getting the values
        final String mobile = edt_email.getText().toString();
        final String pass = edt_pass.getText().toString();

        //validating inputs
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

        //if everything is fine

        class UserLogin extends AsyncTask<Void, Void, String> {



            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);



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

                        Intent i = new Intent(Login.this,  District_Select.class);
                        startActivity(i);

                    } else {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("mobile", mobile);
                params.put("password", pass);

                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_LOGIN, params);
            }
        }

        UserLogin ul = new UserLogin();
        ul.execute();
    }
}
