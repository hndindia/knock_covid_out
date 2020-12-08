package com.chhattisgarh.sora_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class UsefulLinks extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useful_links);
    }


    public void covid(View view){
        String covid19 = this.getClass().getSimpleName();
        Intent intent = new Intent(UsefulLinks.this,web_main.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Covid-19", covid19);
        startActivity(intent);
    }
    public void global(View view){
        String covidGlobal = this.getClass().getSimpleName();
        Intent intent = new Intent(UsefulLinks.this,web_main.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Covid-19 Global", covidGlobal);
        startActivity(intent);
    }
    public void who(View view){
        String cdc = this.getClass().getSimpleName();
        Intent intent = new Intent(UsefulLinks.this,web_main.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("who", cdc);
        startActivity(intent);
    }
    public void nph(View view){
//        String nph = this.getClass().getSimpleName();
//        Intent intent = new Intent(UsefulLinks.this,web_main.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.putExtra("nph", nph);
//        startActivity(intent);
        openUrl("http://gad.cg.gov.in/cgcorona/");

    }
    public void mohfw(View view){
        String mohfw = this.getClass().getSimpleName();
        Intent intent = new Intent(UsefulLinks.this,web_main.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("mohfw", mohfw);
        startActivity(intent);
    }

    private void openUrl(final String url) {
        if (url!= null) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    }
}
