package com.chhattisgarh.sora_11.Select_State;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;

import com.chhattisgarh.sora_11.MainActivity;
import com.chhattisgarh.sora_11.R;

public class Select_State extends AppCompatActivity  {

    String temp;
    private long mLastClickTime = 0;
    ImageView imageView ;
    Button button;
    String[] listArray = {
            "search\uD83D\uDD0D",//0
            "Maharashtra",//1
            "Delhi",//2
            "Tamil Nadu",//3
            "Rajasthan",//4
            "Madhya Pradesh",//5
            "Telangana",//6
            "Gujarat",//7
            "Uttar Pradesh",//8
            "Andhra Pradesh",//9
            "Kerala",//10
            "Jammu and Kashmir",//11
            "Karnataka",//12
            "Haryana",//13
            "West Bengal",//14
            "Punjab",//15
            "Bihar",
            "Odisha",
            "Uttarakhand",
            "Himachal Pradesh",
            "Chhattisgarh",
            "Assam",
            "Jharkhand",
            "Chandigarh",
            "Ladakh",
            "Andaman and Nicobar Islands",
            "Goa",
            "Puducherry",
            "Manipur",
            "Tripura",
            "Mizoram",
            "Arunachal Pradesh",
            "Dadra and Nagar Haveli",
            "Nagaland",
            "Meghalaya",
            "Daman and Diu",
            "Lakshadweep",
            "Sikkim",
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__state);

        imageView = findViewById(R.id.INDIA_STATE);
       // imageView.setImageResource(R.drawable.ss_state_0);
        button = findViewById(R.id.submit);

        MainActivity.context = Select_State.this;
        //new Cofetch().execute();

        //new Cofetch().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        final NumberPicker statePicker = findViewById(R.id.state_picker);

            statePicker.setMinValue(0);
            statePicker.setMaxValue(listArray.length - 1);
            statePicker.setDisplayedValues(listArray);


        statePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                int valuePicker1 = statePicker.getValue();
                temp = listArray[valuePicker1];

                if(valuePicker1 == 0) {
                    button.animate().alpha(0);
                    button.setClickable(false);
                }
                else {
                    button.animate().alpha(1);
                    button.setClickable(true);
                }

    //                switch (temp){
//                    case "--Select state--":
//                        imageView.setImageResource(R.drawable.ss_state_0);
//                        break;
//
//                    case "Maharashtra":
//                        imageView.setImageResource(R.drawable.ss_state_1);
//                        break;
//
//                    case "Delhi":
//                        imageView.setImageResource(R.drawable.ss_state_2);
//                        break;
//
//                    case "Tamil Nadu":
//                        imageView.setImageResource(R.drawable.ss_state_3);
//                        break;
//
//                    case "Rajasthan":
//                        imageView.setImageResource(R.drawable.ss_state_4);
//                        break;
//
//                    case "Madhya Pradesh":
//                        imageView.setImageResource(R.drawable.ss_state_5);
//                        break;
//
//                    case "Telangana":
//                        imageView.setImageResource(R.drawable.ss_state_6);
//                        break;
//
//                    case "Gujarat":
//                        imageView.setImageResource(R.drawable.ss_state_7);
//                        break;
//
//                    case "Uttar Pradesh":
//                        imageView.setImageResource(R.drawable.ss_state_8);
//                        break;
//
//
//                    case "Andhra Pradesh":
//                        imageView.setImageResource(R.drawable.ss_state_9);
//                        break;
//
//
//                    case "Kerala":
//                        imageView.setImageResource(R.drawable.ss_state_10);
//                        break;
//
//
//                    case "Jammu and Kashmir":
//                        imageView.setImageResource(R.drawable.ss_state_11);
//                        break;
//
//
//                    case "Karnataka":
//                        imageView.setImageResource(R.drawable.ss_state_12);
//                        break;
//
//                    case "Haryana":
//                        imageView.setImageResource(R.drawable.ss_state_13);
//                        break;
//
//                    case "West Bengal":
//                        imageView.setImageResource(R.drawable.ss_state_14);
//                        break;
//
//                    case "Punjab":
//                        imageView.setImageResource(R.drawable.ss_state_15);
//                        break;
//
//                    case "Bihar":
//                        imageView.setImageResource(R.drawable.ss_state_16);
//                        break;
//
//                    case "Odisha":
//                        imageView.setImageResource(R.drawable.ss_state_17);
//                        break;
//
//
//                    case "Uttarakhand":
//                        imageView.setImageResource(R.drawable.ss_state_18);
//                        break;
//
//
//                    case "Himachal Pradesh":
//                        imageView.setImageResource(R.drawable.ss_state_19);
//                        break;
//
//
//                    case "Chhattisgarh":
//                        imageView.setImageResource(R.drawable.ss_state_20);
//                        break;
//
//
//                    case "Assam":
//                        imageView.setImageResource(R.drawable.ss_state_21);
//                        break;
//
//                    case "Jharkhand":
//                        imageView.setImageResource(R.drawable.ss_state_22);
//                        break;
//
//                    case "Chandigarh":
//                        imageView.setImageResource(R.drawable.ss_state_23);
//                        break;
////*************************************************************************************************************************************************
//                    case "Ladakh":
//                        imageView.setImageResource(R.drawable.ss_state_24);
//                        break;
////**********************************************************************************************************************************************
//
//                    case "Andaman and Nicobar Islands":
//                        imageView.setImageResource(R.drawable.ss_state_25);
//                        break;
//
//                    case "Goa":
//                        imageView.setImageResource(R.drawable.ss_state_26);
//                        break;
//
//
//                    case "Puducherry":
//                        imageView.setImageResource(R.drawable.ss_state_27);
//                        break;
//
//
//                    case "Manipur":
//                        imageView.setImageResource(R.drawable.ss_state_28);
//                        break;
//
//
//                    case "Tripura":
//                        imageView.setImageResource(R.drawable.ss_state_29);
//                        break;
//
//
//                    case "Mizoram":
//                        imageView.setImageResource(R.drawable.ss_state_30);
//                        break;
//
//                    case "Arunachal Pradesh":
//                        imageView.setImageResource(R.drawable.ss_state_31);
//                        break;
//
//                    case "Dadra and Nagar Haveli":
//                        imageView.setImageResource(R.drawable.ss_state_32);
//                        break;
//
//                    case "Nagaland":
//                        imageView.setImageResource(R.drawable.ss_state_33);
//                        break;
//
//
//                    case "Meghalaya":
//                        imageView.setImageResource(R.drawable.ss_state_34);
//                        break;
//
//                    case "Daman and Diu":
//                        imageView.setImageResource(R.drawable.ss_state_35);
//                        break;
//
//                    case "Lakshadweep":
//                        imageView.setImageResource(R.drawable.ss_state_36);
//                        break;
//
//                    case "Sikkim":
//                        imageView.setImageResource(R.drawable.ss_state_37);
//                        break;
//
//                    default:
//                        break;
//
//
//                }
            }
        });


        //*************************country*******************************
//        final NumberPicker countryPicker = findViewById(R.id.country_picker);
//        countryPicker.setMinValue(0);
//        countryPicker.setMaxValue(listCountry.length - 1);
//        countryPicker.setDisplayedValues(listCountry);
//
//
//
//        countryPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
//                int valuePicker1 = countryPicker.getValue();
//                //Log.d("picker value", valuePicker1 + "");
//                Toast.makeText(Select_State.this, "Picker : "+listCountry[valuePicker1], Toast.LENGTH_SHORT).show();
//                //temp = countryPicker[valuePicker1];
//            }
//        });
        //***********************************************************

    }


    public void submit(View view) {



        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();

        Context context = getApplicationContext();
        SharedPreferences userDetails = context.getSharedPreferences("userdetails", MODE_PRIVATE);
        SharedPreferences.Editor edit = userDetails.edit();

        String userState = userDetails.getString("userState", "");
         if(userState != temp)
        {
            edit.putString("userState", temp);
            edit.apply();
        }





            Intent intent = new Intent(Select_State.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

    }


}
