package com.chhattisgarh.sora_11.Splash_And_Story;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.chhattisgarh.sora_11.Fetch_Data.Bgfetch;

import com.chhattisgarh.sora_11.LoginActivity_Firebase;
import com.chhattisgarh.sora_11.MainActivity;
import com.chhattisgarh.sora_11.R;

public class Splash_animation extends AppCompatActivity {
    Handler handler;
    private static int SPLASH_SCREEN = 1800;
    public static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_animation);

        context = Splash_animation.this;
        new Bgfetch().execute();

        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        SharedPreferences userDetails = context.getSharedPreferences("userdetails", MODE_PRIVATE);
        boolean isnotlogged = userDetails.getBoolean("notLogged", true);

        handler = new Handler();
        if (isFirstRun) {
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).apply();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Splash_animation.this, Story_main.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_SCREEN);
        }

//        else if(isnotlogged) {
//
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Intent intent = new Intent(Splash_animation.this, LoginActivity_Firebase.class);
//                    startActivity(intent);
//                    finish();
//                }
//            }, SPLASH_SCREEN);
//        }

        else {

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Splash_animation.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_SCREEN);
        }


    }
}
