package com.chhattisgarh.sora_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.chhattisgarh.sora_11.Fetch_Data.Bgfetch;
import com.chhattisgarh.sora_11.R;

import java.text.DecimalFormat;


public class State_Wise_Data extends AppCompatActivity {
    DecimalFormat formatter = new DecimalFormat("#,##,###");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_state_wise_data);

        init();

    }
//  ▲ ▼


    public void init() {
       String[][] tableData;
        //default ddata load
        final Bgfetch bgfetch = new Bgfetch();
        String sortBy = getIntent().getStringExtra("sortBy");
        String sortOrder = getIntent().getStringExtra("sortOrder");



           tableData = bgfetch.fetchDataTable(sortBy, sortOrder);
           System.out.println(sortBy);
           System.out.println(sortOrder);



        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);

        TextView tv = new TextView(this);
        tv.setText("S.NO");
        tv.setTextColor(Color.BLACK);
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(20);
        tbrow0.addView(tv);

        TextView tv0 = new TextView(this);
        if(sortBy.equals("state"))
            tv0.setText("State ▼");
        else
            tv0.setText("State");

        tv0.setTextColor(Color.BLACK);
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextSize(20);
        tv0.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        tv0.setPadding(90,0,0,0);
        tv0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(State_Wise_Data.this, "Sorted By: State", Toast.LENGTH_SHORT).show();
               // String sortOrder = getIntent().getStringExtra("sortOrder");
               // if(sortOrder.equals("DESC"))
               // arrangeData("state", "ASC");
               // else if(sortOrder.equals("ASC")){
                    arrangeData("state", "DESC");
               // }

            }
        });
        tbrow0.addView(tv0);

        TextView tv1 = new TextView(this);
        if(sortBy.equals("confirmed"))
             tv1.setText("Confirmed ▼");
        else
            tv1.setText("Confirmed ");
        tv1.setTextColor(Color.rgb(102, 0, 102));
        tv1.setTextSize(20);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(State_Wise_Data.this, "Sorted by: Confirmed", Toast.LENGTH_SHORT).show();
              //  String sortOrder = getIntent().getStringExtra("sortOrder");
               // if(sortOrder.equals("DESC"))
                  //  arrangeData("confirmed", "ASC");
              //  else if(sortOrder.equals("ASC"))
                    arrangeData("confirmed", "DESC");
            }
        });
        tbrow0.addView(tv1);

        TextView tv4 = new TextView(this);
        if(sortBy.equals("active"))
            tv4.setText("  Active ▼ ");
        else
            tv4.setText("  Active ");
        tv4.setTextColor(Color.rgb(3, 0, 255));
        tv4.setTextSize(20);
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(State_Wise_Data.this, "Sorted by: Active", Toast.LENGTH_SHORT).show();

                    arrangeData("active", "DESC");
            }
        });
        tbrow0.addView(tv4);

        TextView tv3 = new TextView(this);
        if(sortBy.equals("recovered"))
            tv3.setText("  Recovered ▼ ");
        else
            tv3.setText("  Recovered ");
        tv3.setTextColor(Color.rgb(0, 100, 0));
        tv3.setTextSize(20);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(State_Wise_Data.this, "Sorted by: Recovered", Toast.LENGTH_SHORT).show();
                    arrangeData("recovered", "DESC");
            }
        });
        tbrow0.addView(tv3);

        TextView tv2 = new TextView(this);
        if(sortBy.equals("death"))
            tv2.setText("  Death ▼ ");
        else
            tv2.setText("  Death ");
        tv2.setTextColor(Color.rgb(255, 0, 0));
        tv2.setTextSize(20);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(State_Wise_Data.this, "Sorted by: Death", Toast.LENGTH_SHORT).show();

                    arrangeData("death", "DESC");
            }
        });
        tbrow0.addView(tv2);


        stk.addView(tbrow0);

        View view = new View(this);
        view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 5));
        view.setBackgroundColor(Color.WHITE);
        stk.addView(view);



        for(int i=0; i<tableData.length; i++) {
            TableRow tableRow2 = new TableRow(this);
            if(i%2 == 0)
                tableRow2.setBackgroundColor(Color.rgb(0, 255, 255)
                );
            else if(i%2 == 1)
                tableRow2.setBackgroundColor(Color.rgb(102, 255, 204)
                );


            //S.no
            TextView TR_SNO = new TextView(this);
            TR_SNO.setText(""+(i+1));
            TR_SNO.setTextColor(Color.BLACK);
            TR_SNO.setGravity(Gravity.CENTER);
            TR_SNO.setTextSize(15);
            tableRow2.addView(TR_SNO);


            //State
            TextView state = new TextView(this);
            state.setText(tableData[i][0]);
            state.setTextColor(Color.BLACK);
            state.setGravity(Gravity.CENTER);
            state.setTextSize(15);
            state.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            state.setPadding(90,0,0,0);
            tableRow2.addView(state);

            //Confirmed
            TextView Confirmed = new TextView(this);
            Confirmed.setText(formatter.format(Integer.parseInt(tableData[i][1])));
            Confirmed.setTextColor(Color.WHITE);
            Confirmed.setGravity(Gravity.CENTER);
            Confirmed.setTextSize(15);
            Confirmed.setTextColor(Color.rgb(102, 0, 102)
            );
            tableRow2.addView(Confirmed);

            //Active
            TextView active = new TextView(this);
            active.setText(formatter.format(Integer.parseInt(tableData[i][4])));
            active.setTextColor(Color.WHITE);
            active.setGravity(Gravity.CENTER);
            active.setTextSize(15);
            active.setTextColor(Color.rgb(3, 0, 255));
            tableRow2.addView(active);

            //Recovered
            TextView recovered = new TextView(this);
            recovered.setText(formatter.format(Integer.parseInt(tableData[i][3])));
            recovered.setTextColor(Color.WHITE);
            recovered.setGravity(Gravity.CENTER);
            recovered.setTextSize(15);
            recovered.setTextColor(Color.rgb(0, 100, 0));
            tableRow2.addView(recovered);

            //Death
            TextView death = new TextView(this);
            death.setText(formatter.format(Integer.parseInt(tableData[i][2])));
            death.setTextColor(Color.WHITE);
            death.setGravity(Gravity.CENTER);
            death.setTextSize(15);
            death.setTextColor(Color.rgb(255, 0, 5));
            tableRow2.addView(death);

            stk.addView(tableRow2);




            View view2 = new View(this);
            view2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 5));
            view2.setBackgroundColor(Color.WHITE);
            stk.addView(view2);
        }
        for(int j =0;j<=30;j++){
            TableRow tableRow2 = new TableRow(this);
            if(j%2 == 0)
                tableRow2.setBackgroundColor(Color.rgb(0, 255, 255));
            else if(j%2 == 1)
                tableRow2.setBackgroundColor(Color.rgb(102, 255, 204));

            TextView TR_SNO = new TextView(this);
            tableRow2.addView(TR_SNO);
            stk.addView(tableRow2);
        }

    }
    public void arrangeData(String sortBy, String sortOrder){
        Intent i = new Intent(State_Wise_Data.this,State_Wise_Data.class);
        i.putExtra("sortBy",sortBy);
        i.putExtra("sortOrder",sortOrder);
        System.out.println("arragneData() called");
        startActivity(i);
        finish();
    }
}

