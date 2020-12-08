package com.chhattisgarh.sora_11.Splash_And_Story;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;

import com.chhattisgarh.sora_11.District_Select;
import com.chhattisgarh.sora_11.LoginActivity_Firebase;
import com.chhattisgarh.sora_11.MainActivity;
import com.chhattisgarh.sora_11.R;

public class sliderAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    sliderAdapter(Context context){
        this.context = context;
    }
    private int[] slide_images = {
            R.drawable.story_1,
            R.drawable.story_2,
            R.drawable.story_3,
            R.drawable.story_4,
            R.drawable.story_5,
            R.drawable.story_6,
            R.drawable.story_7,
            R.drawable.story_8,
            R.drawable.story_8,
    };

    @Override
    public int getCount() {
        return slide_images.length;

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == (RelativeLayout) object;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ServiceCast")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        assert layoutInflater != null;
        View view = layoutInflater.inflate(R.layout.slide_layout,container, false);

        ImageView slidImageView = view.findViewById(R.id.slide_image);


        slidImageView.setImageResource((slide_images[position]));
        if(position == (slide_images.length -1)) {
            Intent intent = new Intent(context, District_Select.class)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);

    }
}
