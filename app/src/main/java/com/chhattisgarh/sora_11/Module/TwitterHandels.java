package com.chhattisgarh.sora_11.Module;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chhattisgarh.sora_11.R;

public class TwitterHandels extends AppCompatActivity implements View.OnClickListener {

    private Button pibFacts,PIB,NIC,modiJi,indiaFightsCorona,startUpIndia,WHO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_handels);

        modiJi = findViewById(R.id.ModiJi);
        modiJi.setOnClickListener(this);

        pibFacts = findViewById(R.id.PibFacts);
        pibFacts.setOnClickListener(this);

        PIB = findViewById(R.id.PIB);
        PIB.setOnClickListener(this);

        NIC = findViewById(R.id.NationalInformaticsCentre);
        NIC.setOnClickListener(this);

        indiaFightsCorona = findViewById(R.id.IndiaFightsCorona);
        indiaFightsCorona.setOnClickListener(this);

        startUpIndia = findViewById(R.id.StartUp);
        startUpIndia.setOnClickListener(this);

        WHO =findViewById(R.id.WHO);
        WHO.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ModiJi:
                    openUrl("https://twitter.com/narendramodi");

            case R.id.PibFacts:
                    openUrl("https://twitter.com/PIBFactCheck?ref_src=twsrc%5Etfw%7Ctwcamp%5Eembeddedtimeline%7Ctwterm%5Eprofile%3APIBFactCheck&ref_url=https%3A%2F%2Fpib.gov.in%2Findexd.aspx");

            case R.id.PIB:
                    openUrl("https://twitter.com/PIB_India?ref_src=twsrc%5Etfw%7Ctwcamp%5Eembeddedtimeline%7Ctwterm%5Eprofile%3APIB_India&ref_url=https%3A%2F%2Fpib.gov.in%2Findexd.aspx");

            case R.id.NationalInformaticsCentre:
                    openUrl("https://twitter.com/NICMeity");

            case R.id.IndiaFightsCorona:
                    openUrl("https://twitter.com/COVIDNewsByMIB");

            case R.id.StartUp:
                    openUrl("https://twitter.com/startupindia");

            case R.id.WHO:
                    openUrl("https://twitter.com/WHO");

        }
    }
    private void openUrl(final String url) {
        if (url!= null) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    }
}