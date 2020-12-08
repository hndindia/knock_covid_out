package com.chhattisgarh.sora_11.Module;

import androidx.appcompat.app.AlertDialog;
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

public class travelEpassActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_epass);


        final String[] tableData =  {
               /*0*/"Mizoram",

                /*1*/"Chhattisgarh",

                /*2*/"Kerala",

                /*3*/"Tamil nadu",

                /*4*/"Andhra pradesh",

                /*5*/"Odhisa",

                /*6*/"Maharashtra",

                /*7*/"West bengal",

                /*8*/"Delhi",

                /*9*/"Madhya pradesh",

                /*10*/"Gujarat",

                /*11*/"Rajasthan",

                /*12*/"Goa",

                /*13*/"Jharkhand",

                /*14*/"Uttar pradesh",

                /*15*/"Uttara khand",

                /*16*/"Bihar",

                /*17*/"Himachal pradesh",

                /*18*/"Haryana",

                /*19*/"Jammu and Kashmir",

                /*20*/"Ladakh",

                /*21*/"Sikkim",

                /*22*/"Arunanchal pradesh",

                /*23*/"Assam",

                /*24*/"Nagaland",

                /*25*/"Meghalaya",

                /*26*/"Tripura",

                /*28*/"Manipur",

                /*29*/"Andaman",

                /*30*/"Lakshadweep",

                /*31*/"Puducherry",

                /*32*/"punjab",

                /*33*/"Chandigarh",

                /*34*/"Telangana",

                /*35*/"karnataka",

                /*36*/"Dadra and Nagar \nHaveli and Daman and Diu",
        };
        final String[] stringData = {
                /*0*/"",

                /*1*/ "https://raipur.gov.in/cg-covid-19-epass/",

               /*2*/ "https://covid19jagratha.kerala.nic.in/home/addDomestic",

                /*3*/ "https://tnepass.tnega.org/#/user/pass",

                /*4*/ "https://www.spandana.ap.gov.in/",

                /*5*/ "https://covid19.odisha.gov.in/",

                /*6*/ "https://covid19.mhpolice.in/",

                /*7*/ "https://coronapass.kolkatapolice.org/",

                /*8*/ "https://epass.jantasamvad.org/epass/relief/english/",

                /*9*/ "https://mapit.gov.in/covid-19/",

                /*10*/ "https://www.digitalgujarat.gov.in/Citizen/ServiceDescription.aspx",

                /*11*/"https://sso.rajasthan.gov.in/signin",

                /*12*/"https://goaonline.gov.in/covid-19",

                /*13*/"https://ranchi.nic.in/e-pass/",

                /*14*/"http://jansunwai.up.nic.in/?language=en_US",

                /*15*/"http://dsclservices.org.in/apply.php",

                /*16*/"https://covid19.bihar.gov.in/",

                /*17*/"https://covid19epass.hp.gov.in/",

                /*18*/"https://edisha.gov.in/eForms/MigrantService",

                /*19*/"http://jkmonitoring.nic.in/residentstojammu.aspx",

                /*20*/"https://leh.nic.in/epass/",

                /*21*/"https://serviceonline.gov.in/viewServiceApplicationForm.do?serviceId=13640004&tempId=4843&templStatus=243&state=11&backButtonUrl=viewAllServiceList.html&OWASP_CSRFTOKEN=XKZ7-0MMZ-G71F-WDBA-61PX-AA5H-K72V-M15G",

                /*22*/"https://eservice.arunachal.gov.in/",

                /*23*/"https://eservices.assam.gov.in/login.do?",

                /*24*/"https://www.iamstranded.nagaland.gov.in/",

                /*25*/"https://megedistrict.gov.in/",

                /*26*/"https://covid19.tripura.gov.in/",

                /*28*/"https://tengbang.in/",

                /*29*/"https://southandaman.nic.in/whos-who/",

                /*30*/"https://lakshadweep.gov.in/service-category/pass-and-permits/",

                /*31*/"https://epass.py.gov.in/",

                /*32*/"http://covidhelp.punjab.gov.in/",

                /*33*/"http://admser.chd.nic.in/dpc/",

                /*34*/"https://policeportal.tspolice.gov.in/",

                /*35*/"https://sevasindhu.karnataka.gov.in/Sevasindhu/English",

                /*36*/"https://dmcgov.in/form/",

        };

        tableLayout = findViewById(R.id.tableMain);

        TableRow tableRowHeading =new TableRow(this);
        tableRowHeading.setGravity(Gravity.CENTER);

        TextView snoHeading = new TextView(this);
        snoHeading.setText("S.No");
        snoHeading.setTextColor(Color.BLACK);
        snoHeading.setGravity(Gravity.CENTER);
        snoHeading.setTextSize(20);
        //snoHeading.setPadding(50,0,0,0);
        tableRowHeading.addView(snoHeading);

        TextView stateNameHeading = new TextView(this);
        stateNameHeading.setText("States");
        stateNameHeading.setTextColor(Color.BLACK);
        stateNameHeading.setGravity(Gravity.CENTER);
        stateNameHeading.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        stateNameHeading.setPadding(100,0,0,0);
        stateNameHeading.setTextSize(20);
        tableRowHeading.addView(stateNameHeading);

        TextView clickMeHeading = new TextView(this);
        clickMeHeading.setText("Links");
        clickMeHeading.setTextColor(Color.BLACK);
        clickMeHeading.setGravity(Gravity.CENTER);
        clickMeHeading.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        clickMeHeading.setPadding(100,0,50,0);
        clickMeHeading.setTextSize(20);
        tableRowHeading.addView(clickMeHeading);

        tableLayout.addView(tableRowHeading);

        View view = new View(this);
        view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 5));
        view.setBackgroundColor(Color.WHITE);
        tableLayout.addView(view);

        for(int i=0; i<tableData.length; i++) {
            TableRow tableRow2 = new TableRow(this);
            tableRow2.setGravity(Gravity.CENTER);
            if (i % 2 == 0)
                tableRow2.setBackgroundColor(Color.rgb(0, 255, 255));
            else if (i % 2 == 1)
                tableRow2.setBackgroundColor(Color.rgb(102, 255, 204));

            //Sno
            TextView TR_SNO = new TextView(this);
            TR_SNO.setText(""+(i+1));
            TR_SNO.setTextColor(Color.BLACK);
            TR_SNO.setGravity(Gravity.CENTER);
            TR_SNO.setTextSize(15);

            tableRow2.addView(TR_SNO);

            //State name
            TextView stateName = new TextView(this);
            stateName.setText(tableData[i]);
            stateName.setTextColor(Color.BLACK);
            stateName.setGravity(Gravity.CENTER);
            stateName.setPadding(100,0,0,0);
            stateName.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            stateName.setTextSize(15);
            tableRow2.addView(stateName);

            //Click me
            TextView clickMe = new TextView(this);
            clickMe.setText("Click Me");
            clickMe.setTextColor(Color.rgb(0,0,205));
            clickMe.setGravity(Gravity.CENTER);
            clickMe.setPadding(100,0,0,0);
            clickMe.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            clickMe.setTextSize(15);
            final int finalI = i;
            clickMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(tableData[finalI].equals("Mizoram")){
                        openDialogBox();
                    }else {
                        openUrl(stringData[finalI]);
                    }
                }
            });
            tableRow2.addView(clickMe);

            tableLayout.addView(tableRow2);

            View view2 = new View(this);
            view2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 5));
            view2.setBackgroundColor(Color.WHITE);
            tableLayout.addView(view2);

        }
    }

    private void openDialogBox() {
            builder = new AlertDialog.Builder(this);

            View v = getLayoutInflater().inflate(R.layout.links_dialogbox,null);

            TextView link1 = v.findViewById(R.id.link_1);
            link1.setMovementMethod(LinkMovementMethod.getInstance());

            TextView link2 = v.findViewById(R.id.link_2);
            link2.setMovementMethod(LinkMovementMethod.getInstance());

            TextView link3 = v.findViewById(R.id.link_3);
            link3.setMovementMethod(LinkMovementMethod.getInstance());

            TextView link4 = v.findViewById(R.id.link_4);
            link4.setMovementMethod(LinkMovementMethod.getInstance());

            builder.setView(v);
            alertDialog = builder.create();
            alertDialog.show();

    }

    private void openUrl(final String url) {
        if (url!= null) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    }
}