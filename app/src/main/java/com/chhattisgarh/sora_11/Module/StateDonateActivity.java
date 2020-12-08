package com.chhattisgarh.sora_11.Module;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.chhattisgarh.sora_11.R;

public class StateDonateActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_donate);

        final String[] tableData =  {
                /*0*/"Mizoram",

                /*1*/"Chhattisgarh",

                /*2*/"Kerala",

                /*3*/"Tamil nadu",

                /*4*/"Andhra pradesh",

                /*5*/"Odhisa",

                /*6*/"Maharashtra",

                /*7*/"West bengal",

                //         /*8*/"Delhi",

                /*9*/"Madhya pradesh",

                /*10*/"Gujarat",

                /*11*/"Rajasthan",

                         /*12*/"Goa",

                //         /*13*/"Jharkhand",

                /*14*/"Uttar pradesh",

                /*15*/"Uttara khand",

                /*16*/"Bihar",

                /*17*/"Himachal pradesh",

                /*18*/"Haryana",

                //        /*19*/"Jammu and Kashmir",

                /*20*/"Ladakh",

                /*21*/"Sikkim",

                /*22*/"Arunanchal pradesh",

                /*23*/"Assam",

                /*24*/"Nagaland",

                /*25*/"Meghalaya",

                /*26*/"Tripura",

                /*28*/"Manipur",

                //        /*29*/"Andaman",

                /*30*/"Lakshadweep",

                //       /*31*/"Puducherry",

                /*32*/"punjab",

                /*33*/"Chandigarh",

                /*34*/"Telangana",

                /*35*/"karnataka",

                //     /*36*/"Dadra and Nagar \nHaveli and Daman and Diu",

                /*37*/"HelpAge India",

                /*38*/"Donate to National Defence Fund"
        };

        final String[] stringData = {
                /*0*/"https://mcovid19.mizoram.gov.in/pages/donate",

                /*1*/"http://cmrf.cg.gov.in/",

                /*2*/"https://donation.cmdrf.kerala.gov.in/#donation",

                /*3*/"https://ereceipt.tn.gov.in/cmprf/Cmprf",

                /*4*/"https://apcmrf.ap.gov.in/",

                /*5*/"https://cmrfodisha.gov.in/",

                /*6*/"https://cmrf.maharashtra.gov.in/CMRFCitizen/DonationOnlineForm.action",

                /*7*/"https://wb.gov.in/COVID-19.aspx",

                //     /*8*/"Delhi",

                /*9*/"https://www.mponline.gov.in/Portal/Services/CMRF/RelieffundE.aspx",

                /*10*/"https://iora.gujarat.gov.in/cmrf/",

                /*11*/"http://cmrelief.rajasthan.gov.in/Covid-19.aspx",

               /*12*/"https://www.onlinesbi.com/sbicollect/icollecthome.htm?corpID=1963359",

                //        /*13*/"Jharkhand",

                /*14*/"https://rahat.up.nic.in/upcovidcarefund.aspx",

                /*15*/"https://cmrf.uk.gov.in/",

                /*16*/"http://www.cmrf.bih.nic.in/users/home.aspx",

                /*17*/"http://cmhimachal.nic.in/",

                /*18*/"https://haryanacmoffice.gov.in/donation",

                //         /*19*/"Jammu and Kashmir",

                /*20*/"http://covid.ladakh.gov.in/",

                /*21*/"https://cmdrf.sikkim.gov.in/",

                /*22*/"https://smarthubgovernment.hdfcbank.com/SmartHubGovt/DirectLoadQuickPay.action;jsessionid=rgJ4p3a5yMTwGmJKGDz8k1zY?uniqueSessionIdentifier=036513689937566565180123456789",

                /*23*/"https://cm.assam.gov.in/relieffund.php",

                /*24*/"https://chiefminister.nagaland.gov.in/chief-minister-relief-fund-list-of-donors-with-amount-update-till-december-2019/",

                /*25*/"http://megcmrf.gov.in/index.htm",

                /*26*/"https://cmrf.tripura.gov.in/",

                /*28*/"https://tengbang.in/donate.aspx",

                //         /*29*/"Andaman",

                /*30*/"https://serviceonline.gov.in/renderApplicationForm.do?serviceId=13700001&UUID=a89d05b9-2fe1-4aa3-8344-bd72ca5fbcf5&grievDefined=0&serviceLinkRequired=No&directService=true&userLoggedIn=N&tempId=4854&source=CTZN&OWASP_CSRFTOKEN=2KP1-YT1P-7UVT-B26O-BZVD-BADR-FJ5J-2ZW6",

                //       /*31*/"Puducherry",

                /*32*/"https://cmrf.punjab.gov.in/",

                /*33*/"http://chandigarh.gov.in/pdf/bank-covid19.pdf",

                /*34*/"https://telangana.gov.in/cm-relief-fund",

                /*35*/"https://cmrf.karnataka.gov.in/English/index.html",

                //        /*36*/"Dadra and Nagar \nHaveli and Daman and Diu",

                /*37*/"https://www.helpageindia.org/",

                /*38*/"https://ndf.gov.in/#:~:text=Online%20Contributions%20%2F%20Donations%20to%20National,number%20of%20NDF%20is%20XXXXXX009F"

        };


        tableLayout = findViewById(R.id.tableMainId);

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
                        openUrl(stringData[finalI]);
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
    private void openUrl(final String url) {
        if (url!= null) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    }
}