package com.chhattisgarh.sora_11;


import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class ContactForHelp extends AppCompatActivity {
   public WebView WebView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_for_help);
        WebView = (WebView) findViewById(R.id.WEB_VIEW_CONTACTS);
        WebView.loadUrl("https://drive.google.com/file/d/1EAr8w7ysNb68xBTBdKV1pdp2dzEhZaPY/view?usp=sharing");
        // Enable Javascript
        WebSettings webSettings = WebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        WebView.setWebViewClient(new WebViewClient());
    }
}






























