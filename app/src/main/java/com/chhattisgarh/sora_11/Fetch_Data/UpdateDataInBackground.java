package com.chhattisgarh.sora_11.Fetch_Data;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class UpdateDataInBackground extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public Context context = this;
    public Handler handler = null;
    public static Runnable runnable = null;



    @Override
    public void onCreate() {


        handler = new Handler();
        runnable = new Runnable() {
            public void run() {



                new Bgfetch().execute();
                handler.postDelayed(runnable, 6_00_000);
            }
        };

        handler.postDelayed(runnable, 15000);
    }

    @Override
    public void onDestroy() {
        /* IF YOU WANT THIS SERVICE KILLED WITH THE APP THEN UNCOMMENT THE FOLLOWING LINE */
        //handler.removeCallbacks(runnable);
        // Toast.makeText(this, "Service stopped", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart(Intent intent, int startid) {

    }
}

