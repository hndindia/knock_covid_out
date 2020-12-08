package com.chhattisgarh.sora_11.Main_Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chhattisgarh.sora_11.Symptom_Precaution;
import com.chhattisgarh.sora_11.Myth_Buster;
import com.chhattisgarh.sora_11.Prevention_products.PreventionProducts;
import com.chhattisgarh.sora_11.R;
import com.chhattisgarh.sora_11.UsefulLinks;

/**
 * A simple {@link Fragment} subclass.
 */
public class moreFragment extends Fragment{
private Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
private long mLastClickTime = 0;


    public moreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_more, container, false);

       //******************************************************************************************
        //*************For contact for help***********

//        b1= view.findViewById(R.id.ContactForHeld);
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
//                    return;
//                }
//                mLastClickTime = SystemClock.elapsedRealtime();
//                startActivity(new Intent(getActivity(), ContactForHelp.class));
//
//            }
//        });

        //************For check symptom***************

        b2= view.findViewById(R.id.CheckSymptom);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                startActivity(new Intent(getActivity(), Symptom_Precaution.class));
            }
        });



        //*********For general awareness***************

//        b4= view.findViewById(R.id.GeneralAwareness);
//        b4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
//                    return;
//                }
//                mLastClickTime = SystemClock.elapsedRealtime();
//                startActivity(new Intent(getActivity(), GeneralAwareness.class));
//            }
//        });

        //*******For prevention product*******
        b5= view.findViewById(R.id.PreventionProduct);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                startActivity(new Intent(getActivity(), PreventionProducts.class));
            }
        });

        //*********For useful links*******
        b6= view.findViewById(R.id.UsefulLinks);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                startActivity(new Intent(getActivity(), UsefulLinks.class));
            }
        });
        //********For corona hospitals********

//        b7= view.findViewById(R.id.coronaHospitals);
//        b7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
//                    return;
//                }
//                mLastClickTime = SystemClock.elapsedRealtime();
//                startActivity(new Intent(getActivity(), Corona_Hospitals.class));
//            }
//        });


        //**************For Myth busters****************
        b8= view.findViewById(R.id.Myth_busters);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                startActivity(new Intent(getActivity(), Myth_Buster.class));
            }
        });

            //**************Donate State************

//        b9= view.findViewById(R.id.DONATION_STATE);
//        b9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
//                    return;
//                }
//                mLastClickTime = SystemClock.elapsedRealtime();
//                startActivity(new Intent(getActivity(), Donation_state.class));
//            }
//        });

        return view;
    }

}
