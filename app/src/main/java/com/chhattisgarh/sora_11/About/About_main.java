package com.chhattisgarh.sora_11.About;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.chhattisgarh.sora_11.R;

public class About_main extends AppCompatActivity {



private TextView textView,textView2;


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_main);


        textView = (TextView) findViewById(R.id.Terms_Condition);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(About_main.this,Terms_And_Conditions.class);
                i.putExtra("TermsAndCondition","");
                startActivity(i);

            }
        });
        textView2 = (TextView) findViewById(R.id.TermsOfUse);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(About_main.this,Terms_Of_Uses.class);
                i.putExtra("TermsOfUses","");
                startActivity(i);

            }
        });

    }





}
