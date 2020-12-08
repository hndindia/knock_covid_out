package com.chhattisgarh.sora_11.Splash_And_Story;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.chhattisgarh.sora_11.R;

public class Story_main extends AppCompatActivity {
    public ViewPager mSliderViewPager;
    public sliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_main);
        Context context = getApplicationContext();
        SharedPreferences userDetails = context.getSharedPreferences("userdetails", MODE_PRIVATE);
        SharedPreferences.Editor edit = userDetails.edit();
        //default value punjab
        edit.putString("userState", "Chhattisgarh");
        edit.apply();
        edit.putString("username","");
        edit.apply();
        edit.putString("usermobile","");
        edit.apply();
        edit.putBoolean("notLogged", true);
        edit.apply();

        mSliderViewPager = (ViewPager) findViewById(R.id.ViewPage);
        sliderAdapter = new sliderAdapter(this);
        mSliderViewPager.setAdapter(sliderAdapter);
    }
}
