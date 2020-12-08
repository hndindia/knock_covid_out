package com.chhattisgarh.sora_11;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web_main extends AppCompatActivity {
    public WebView webView1;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_main);

        webView1 = findViewById(R.id.web_View);
        if(savedInstanceState == null){

            Bundle bundle =getIntent().getExtras();

            if(bundle != null){
                if(bundle.containsKey("Covid-19")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("https://www.google.com/covid19-map/");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    Log.d("GCM", "Notifications clicked");
                }else if(bundle.containsKey("Covid-19 Global")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("https://coronavirus.thebaselab.com/");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    Log.d("GCM", "Notifications clicked");
                }
                else if(bundle.containsKey("who")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("https://www.who.int/");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    Log.d("GCM", "Notifications clicked");
                }
                else if(bundle.containsKey("nph")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("https://www.nhp.gov.in/");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    Log.d("GCM", "Notifications clicked");
                }
                else if(bundle.containsKey("mohfw")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("https://www.mohfw.gov.in/");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    Log.d("GCM", "Notifications clicked");
                }

                //Donate->module(Chhattisgarh)
                else if(bundle.containsKey("donate")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("http://cmrf.cg.gov.in/donate.html");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                }
                //CurfewPass->Module
                else if(bundle.containsKey("pass")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("https://epasscovid19.pais.net.in/");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                }
                //OPD->Module
                else if(bundle.containsKey("opd")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("https://esanjeevaniopd.in/");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                }


//                //Hospital->Module
//                else if(bundle.containsKey("hospital")){
//                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
//                   
//                    webView1.setWebViewClient((new WebViewClient()));
//                    webView1.loadUrl("https://cmrf.punjab.gov.in/");
//                    WebSettings webSettings = webView1.getSettings();
//                    webSettings.setJavaScriptEnabled(true);
//                }
//

                //Government order->Module
                else if(bundle.containsKey("govOrder")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("http://covidhelp.punjab.gov.in");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                }
                //Shop registration->Module
                else if(bundle.containsKey("shopRegis")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("https://pblabour.gov.in/LicenceDescriptions/Details/5");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                }
                //Traveller registration->Module
                else if(bundle.containsKey("travelRegis")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("http://www.covidhelp.punjab.gov.in/");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                }


                //volunteer
                else if(bundle.containsKey("volunteer")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("https://www.mygov.in/task/join-war-against-covid-19-register-volunteer/");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                }

                //Symptoms
                else if(bundle.containsKey("checker")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("https://c19check.com/start");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                }

                //counseling Punjab
                else if(bundle.containsKey("counselingPunjab")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("https://www.onlinecounselling4u.com/counsellors-in-hoshiarpur");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                }

                //Donate food
                else if(bundle.containsKey("donateFood")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("https://www.feedingindia.org/contact");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                }

                //Share idea
                 else if(bundle.containsKey("ShareIdea")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("https://www.mygov.in/group-issue/share-your-ideas-suggestions-help-fight-coronavirus/?utm_source=webcampaign&group_issue&285571");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                }

                 //Quiz on covid 19
                else if(bundle.containsKey("QuizOnCovid")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient((new WebViewClient()));
                    webView1.loadUrl("https://quiz.mygov.in/quiz/quiz-on-covid-19/");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                }

                //Take pledge
                else if(bundle.containsKey("TakeAPledge")){
                    //String senderName = bundle.getString("SENDER_CLASS_NAME");
                   
                    webView1.setWebViewClient(new WebViewClient());
                    webView1.loadUrl("https://pledge.mygov.in/breakthestigma/");
                    WebSettings webSettings = webView1.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                }
                
                

                

            }
        }








    }








    @Override
    public void onBackPressed() {
        if(webView1.canGoBack()){
            webView1.goBack();
        }else {
            super.onBackPressed();
        }
    }





}
