package com.chhattisgarh.sora_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class District_Select extends AppCompatActivity {
public String[] district  ={
        "Balod",  "Baloda Bazar",  "Balrampur",  "Bametara",  "Bastar",  "Bijapur",  "Bilaspur",  "Dakshin Bastar Dantewada",
        "Dhamtari",  "Durg",  "Gariaband",  "Janjgir Champa",  "Jashpur",
        "Kabeerdham",  "Kondagaon",  "Korba",  "Koriya",  "Mahasamund",
        "Mungeli",  "Narayanpur",  "Raigarh",  "Raipur",  "Rajnandgaon",
        "Sukma",  "Surajpur",  "Surguja",  "Uttar Bastar Kanker",  "Gaurela Pendra Marwahi"
    };
    String temp;
    int valuePicker1;
    private long mLastClickTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district__select);
        final Button submitDistrict = findViewById(R.id.submitDistrict);


        final NumberPicker district_picker = findViewById(R.id.district_picker);

        district_picker.setMinValue(0);
        district_picker.setMaxValue(district.length - 1);

        district_picker.setDisplayedValues(district);
        valuePicker1 = district_picker.getValue();
        temp =district[valuePicker1];

        district_picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                valuePicker1 = district_picker.getValue();
                temp = district[valuePicker1];

            }
        });

    }


    public void submitDistrict(View view) {

        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();



        Context context = getApplicationContext();
        SharedPreferences userDetails = context.getSharedPreferences("userdetails", MODE_PRIVATE);
        SharedPreferences.Editor edit = userDetails.edit();

        String userDistrict = userDetails.getString("userDistrict", "");
        if(userDistrict != temp)
        {
            edit.putString("userDistrict", temp);
            edit.apply();
        }


        Intent intent = new Intent(District_Select.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);


    }
}
