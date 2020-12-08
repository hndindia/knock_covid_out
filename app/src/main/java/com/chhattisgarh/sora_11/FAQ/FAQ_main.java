package com.chhattisgarh.sora_11.FAQ;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chhattisgarh.sora_11.R;

public class FAQ_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_a_q_main);


    }


    public void FOR_MORE_FAQ(View view) {

        Intent i = new Intent(FAQ_main.this, FOR_MORE_FAQ.class);
        startActivity(i);

    }





}