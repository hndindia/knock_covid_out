package com.chhattisgarh.sora_11;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Donation_state extends AppCompatActivity {
WebView WebView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_state);

        WebView = (WebView) findViewById(R.id.Donation_state);
        WebView.loadUrl("https://drive.google.com/file/d/1npQ1_nYfegq65p_dgohbZ8jbrrGZxG46/view?usp=sharing");

        // Enable Javascript

        WebSettings webSettings = WebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        WebView.setWebViewClient(new WebViewClient());


    }
}
