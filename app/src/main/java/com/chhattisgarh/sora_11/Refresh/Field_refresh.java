package com.chhattisgarh.sora_11.Refresh;

import com.chhattisgarh.sora_11.Fetch_Data.Bgfetch;

public class Field_refresh {
    Bgfetch bg;
    public void stats_refresh(){
        bg = new Bgfetch();
        //final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bg.statsfetch();
            }
        };
        //new Handler().postDelayed(runnable,1000);
    }

}
