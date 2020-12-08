package com.chhattisgarh.sora_11.Module;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.chhattisgarh.sora_11.R;

public class Courses_Module extends AppCompatActivity {
public ImageView internshala,eSkillIndia,amity,skillSigma,learnVern,linkedIn,tcs,coursera,nptel,alison,startUpIndia;
public ImageView iibmIndia,udemy,prebBytes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses__module);

        internshala = findViewById(R.id.Internshal);
        internshala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://trainings.internshala.com/?referral=ISRP5231386&utm_source=ISRP_share_link&utm_medium=ISRP5231386&utm_campaign=TRAINING");
            }
        });

        eSkillIndia = findViewById(R.id.eSkillIndia);
        eSkillIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://eskillindia.org/Home/course_detail_sector_list");
            }
        });

        amity = findViewById(R.id.Amity);
        amity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://application.amityonline.com/online-courses");
            }
        });

        skillSigma = findViewById(R.id.SkillSigma);
        skillSigma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openUrl("https://www.skillsigma.com/all-courses/");
            }
        });

        learnVern = findViewById(R.id.LearnVern);
        learnVern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.learnvern.com/");
            }
        });

        linkedIn = findViewById(R.id.LinkedIn);
        linkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.linkedin.com/learning/me?trk=nav_neptune_learning");
            }
        });

        tcs = findViewById(R.id.TCS);
        tcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://learning.tcsionhub.in/iDH/India/home");
            }
        });

        coursera = findViewById(R.id.Coursera);
        coursera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.coursera.org/");
            }
        });

        nptel = findViewById(R.id.Nptel);
        nptel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://nptel.ac.in/");
            }
        });

        alison = findViewById(R.id.Alison);
        alison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://alison.com/");
            }
        });

        startUpIndia = findViewById(R.id.StartUpIndia);
        startUpIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.startupindia.gov.in/content/sih/en/reources/l-d-listing.html");
            }
        });

        iibmIndia =findViewById(R.id.IIBMIndia);
        iibmIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.iibmindia.in/");
            }
        });

        udemy = findViewById(R.id.Udemy);
        udemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.udemy.com/");
            }
        });

        prebBytes = findViewById(R.id.PrebBytes);
        prebBytes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://bit.ly/3bZEpR6");
            }
        });

    }
    private void openUrl(final String url) {
        if (url!= null) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    }

}
