package com.chhattisgarh.sora_11;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Corona_Hospitals extends AppCompatActivity {
    String[] country = { "India", "USA", "China", "Japan", "Other"};
public WebView webView1;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona__hospitals);

//        //Getting the instance of Spinner and applying OnItemSelectedListener on it
//        Spinner spin = (Spinner) findViewById(R.id.spinner);
//        spin.setOnItemSelectedListener(this);
//                                                                                      implements AdapterView.OnItemSelectedListener
//        //Creating the ArrayAdapter instance having the country list
//        ArrayAdapter<String> aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,country);
//        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        //Setting the ArrayAdapter data on the Spinner
//        spin.setAdapter(aa);

        webView1 = findViewById(R.id.webView);
        webView1.setWebViewClient((new WebViewClient()));
        webView1.loadUrl("https://drive.google.com/open?id=1H9PYLV-iFMOjWRVznsUZoAkXqWl7C2F5");
        WebSettings webSettings = webView1.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
//
//    //Performing action onItemSelected and onNothing selected
//    @Override
//    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
//        Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_LONG).show();
//    }
//
//
//    @Override
//    public void onNothingSelected(AdapterView<?> arg0) {
//        // TODO Auto-generated method stub
//    }
}
