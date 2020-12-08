package com.chhattisgarh.sora_11.FAQ;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.chhattisgarh.sora_11.R;

public class FOR_MORE_FAQ extends AppCompatActivity {
WebView WebView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_more_f_a_q);
        WebView = (WebView) findViewById(R.id.web_View_Hindi);
        WebView.loadUrl("https://drive.google.com/file/d/18l8aTFYN5PGKACb2PC_006Gh-xFZQT_8/view?usp=sharing");

        // Enable Javascript

        WebSettings webSettings = WebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        WebView.setWebViewClient(new WebViewClient());
    }
}
