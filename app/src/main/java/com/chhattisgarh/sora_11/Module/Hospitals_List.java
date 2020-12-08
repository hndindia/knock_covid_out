package com.chhattisgarh.sora_11.Module;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.chhattisgarh.sora_11.R;

import java.text.DecimalFormat;

public class Hospitals_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_hospitals__list);

        init();

        TextView cgLinks = findViewById(R.id.cg_links);
        cgLinks.setMovementMethod(LinkMovementMethod.getInstance());


    }
//  ▲ ▼

    public void init() {
        final String[][] tableData = {
                   {"Aiims raipur","077125 72240"},
                   {"Br ambedkar hospital raipur","07712890113"},
                   {"Medical clg ambikapur","07774204006"},
                   {"Medical clg rajnandgaon","07744224201"},
                   {"Medical clg jagdalpur","07782292878"},
                   {"Medical clg raigarh ","07762220742"},
                   {"District hospital bilaspur","08309977063"},
        };

        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);

        TextView tv = new TextView(this);
        tv.setText("S.NO");
        tv.setTextColor(Color.BLACK);
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(20);
        tbrow0.addView(tv);

        TextView tv0 = new TextView(this);
        tv0.setText("Hospital Name");
        tv0.setTextColor(Color.BLACK);
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        tv0.setPadding(100,0,0,0);
        tv0.setTextSize(20);
        tbrow0.addView(tv0);

        TextView tv2 = new TextView(this);
        tv2.setText("Phone No");
        tv2.setTextColor(Color.rgb(3, 0, 255));
        tv2.setTextSize(20);
        tv2.setPadding(100,0,0,0);
        tbrow0.addView(tv2);

        stk.addView(tbrow0);

        View view = new View(this);
        view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 5));
        view.setBackgroundColor(Color.WHITE);
        stk.addView(view);

        for(int i=0; i<tableData.length; i++) {
            TableRow tableRow2 = new TableRow(this);
            if(i%2 == 0)
                tableRow2.setBackgroundColor(Color.rgb(0, 255, 255));
            else if(i%2 == 1)
                tableRow2.setBackgroundColor(Color.rgb(102, 255, 204));

            //S.no
            TextView TR_SNO = new TextView(this);
            TR_SNO.setText(""+(i+1));
            TR_SNO.setTextColor(Color.BLACK);
            TR_SNO.setGravity(Gravity.CENTER);
            TR_SNO.setTextSize(15);
            tableRow2.addView(TR_SNO);

            //HospitalName
            TextView HospitalName = new TextView(this);
            HospitalName.setText(tableData[i][0]);
            HospitalName.setTextColor(Color.BLACK);
            HospitalName.setGravity(Gravity.CENTER);
            HospitalName.setPadding(100,0,0,0);
            HospitalName.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            HospitalName.setTextSize(15);
            final int finalI1 = i;
            HospitalName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    googleMap(tableData[finalI1][0]);
                }
            });
            tableRow2.addView(HospitalName);

            //Phoneno
            TextView Phoneno = new TextView(this);
            Phoneno.setText(tableData[i][1]);
            Phoneno.setGravity(Gravity.CENTER);
            Phoneno.setPadding(100,0,0,0);
            Phoneno.setTextSize(15);
            final int finalI = i;
            Phoneno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    call(tableData[finalI][1]);
                }
            });
            Phoneno.setTextColor(Color.rgb(3, 0, 255));
            tableRow2.addView(Phoneno);

            stk.addView(tableRow2);
            View view2 = new View(this);
            view2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 5));
            view2.setBackgroundColor(Color.WHITE);
            stk.addView(view2);
        }

    }

    public void call(String phone){
       Intent mIntent=new Intent(Intent.ACTION_DIAL);
       mIntent.setData(Uri.parse("tel:"+ phone));
          if(mIntent.resolveActivity(getPackageManager()) !=null){
              startActivity(mIntent);
          }else Toast.makeText(Hospitals_List.this, "Emergency", Toast.LENGTH_SHORT).show();
    }

    public void googleMap(String address){
        Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }


}
