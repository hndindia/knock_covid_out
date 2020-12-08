package com.chhattisgarh.sora_11.Module;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chhattisgarh.sora_11.R;

public class NationalCareerServiceActivity extends AppCompatActivity {

    private TextView NCSLink;

    private ImageView findJobs,jobsForWomen,jobsForDisable,govJobs,careerInfo,careerCounseling;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_national_career_service);


        findJobs = findViewById(R.id.findJobs);
        findJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              openUrl("https://www.ncs.gov.in/job-seeker/Pages/Search.aspx");
            }
        });

        jobsForWomen = findViewById(R.id.jobsForWomen);
        jobsForWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.ncs.gov.in/Pages/Search.aspx?gn=8NNJp4uvENM%3D");
            }
        });

        jobsForDisable = findViewById(R.id.jobsForDisable);
        jobsForDisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.ncs.gov.in/Pages/Search.aspx?DA=6gqhwycyVHE%3D");
            }
        });

        govJobs = findViewById(R.id.govtJobs);
        govJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.ncs.gov.in/job-seeker/Pages/Search.aspx?OT=lp9dNs3%2FpQ%2FJ1WtoCNHP9Q%3D%3D");
            }
        });

        careerCounseling = findViewById(R.id.careerCounseling);
        careerCounseling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.ncs.gov.in/counsellor/Pages/default.aspx");
            }
        });

        careerInfo = findViewById(R.id.careerInfo);
        careerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.ncs.gov.in/content-repository/Pages/BrowseBySectors.aspx");
            }
        });

       NCSLink =findViewById(R.id.NCSLink_id);
        NCSLink.setMovementMethod(LinkMovementMethod.getInstance());
       //        NCSLink.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openUrl("https://www.ncs.gov.in/");
//            }
//        });

    }
    private void openUrl(final String url) {
        if (url!= null) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    }
}