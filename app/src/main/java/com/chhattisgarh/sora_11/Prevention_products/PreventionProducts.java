package com.chhattisgarh.sora_11.Prevention_products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.chhattisgarh.sora_11.R;
import com.chhattisgarh.sora_11.View_Pager.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class PreventionProducts extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prevention_products);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout3);
        viewPager = (ViewPager) findViewById(R.id.myViewPager3);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter_forAwareness = new  ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter_forAwareness.addFragment(new PP_ENGISH_Fragment(),"English");
        viewPagerAdapter_forAwareness.addFragment(new PP_HINDI_Fragment(),"Hindi");
        viewPager.setAdapter(viewPagerAdapter_forAwareness);
    }

}
