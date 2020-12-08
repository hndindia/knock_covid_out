package com.chhattisgarh.sora_11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.chhattisgarh.sora_11.Module.Hospitals_List;
import com.chhattisgarh.sora_11.About.About_main;
import com.chhattisgarh.sora_11.District_Data.DistrictData;

import com.chhattisgarh.sora_11.Fetch_Data.Bgfetch;
import com.chhattisgarh.sora_11.Fetch_Data.UpdateDataInBackground;

import com.chhattisgarh.sora_11.Module.BecomeVolunteer;
import com.chhattisgarh.sora_11.Module.Courses_Module;
import com.chhattisgarh.sora_11.Module.MedicalStores;
import com.chhattisgarh.sora_11.Module.MoreModule;
import com.chhattisgarh.sora_11.Module.NationalCareerServiceActivity;
import com.chhattisgarh.sora_11.Module.OrphanageForm;
import com.chhattisgarh.sora_11.Module.StateDonateActivity;
import com.chhattisgarh.sora_11.Module.travelEpassActivity;
import com.chhattisgarh.sora_11.Splash_And_Story.Splash_animation;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity<userState> extends AppCompatActivity {
    private Toolbar toolbar;
    private RequestQueue mQueue;
    public static Context context;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int version;
    private int nversion;
    private long mLastClickTime = 0;
    public ImageView stateData;
    public ImageView countryData;
    public ImageView imageView;
    public static TextView INDIA_Confirmed;
    public static TextView INDIA_Active;
    public static TextView INDIA_Deaths;
    public static TextView INDIA_Recovered;
    public static TextView WORLD_Confirmed;
    public static TextView WORLD_Active;
    public static TextView WORLD_Deaths;
    public static TextView WORLD_Recovered;
    public static TextView STATE_Confirmed;
    public static TextView STATE_Active;
    public static TextView STATE_Death;
    public static TextView STATE_Recovered;
    private FloatingActionButton mSharedFab;
    private Bgfetch fragfet;
    private ImageView districtData;
    public TextView pmCares;

    //module
    public ImageView mDonate,mHospitals,mGovernmentOrder,mMore;
    public ImageView courses,volunteer,medicalStores;
    public ImageView orphanage,checkSymptoms,counselingPunjab,donateFood;
    public ImageView nationCareerService,msme,mOnlineAppointment,mTravelEpass,mPibFacts,mInterDistrictEpass,mMigrantsServices;
    public ImageView mGOIWebDirectory;
    //District
    public static TextView districtName,district_Confirmed,district_Active,district_Death;



//*******************************************************************************
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startService(new Intent(this, UpdateDataInBackground.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pmCares = findViewById(R.id.Donation);
        pmCares.setMovementMethod(LinkMovementMethod.getInstance());

        //---------------District-----------------------------
        districtName = findViewById(R.id.DistrictName);
        district_Confirmed = findViewById(R.id.DISTRICT_Confirmed);
        district_Active = findViewById(R.id.DISTRICT_Active);
        district_Death = findViewById(R.id.DISTRICT_Death);
        //---------------District-END-----------------------------

        //-------------------Module-----------------------------

        mHospitals = findViewById(R.id.Hospitals);
        mGovernmentOrder =findViewById(R.id.GovernmentOrder);
        mMore = findViewById(R.id.For_More);
        courses = findViewById(R.id.Courses);
        volunteer = findViewById(R.id.Volunteer);
        checkSymptoms = findViewById(R.id.CheckSymptoms);
      //  orphanage = findViewById(R.id.Orphanage);

        mDonate =findViewById(R.id.Donate);
        mDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StateDonateActivity.class));

//                openUrl("http://cmrf.cg.gov.in/");

            }
        });

       mOnlineAppointment = findViewById(R.id.onlineAppointment);
        mOnlineAppointment.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                    openUrl("https://ors.gov.in/index.html");
           }
       });

        mTravelEpass = findViewById(R.id.travel_Epass);
        mTravelEpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, travelEpassActivity.class));
       
            }
        });

        ImageView mLatestcovidUpdate = findViewById(R.id.LatestCovidFeeds);
        mLatestcovidUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://nidm.gov.in/covid19/");
            }
        });

        mInterDistrictEpass = findViewById(R.id.interDistrictEpass);
        mInterDistrictEpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://epass.cgcovid19.in/(X(1)S(utgdctpuem0hdeypokll5z3b))/?AspxAutoDetectCookieSupport=1");
            }
        });

        ImageView mDonateBhim = findViewById(R.id.donate_bhim);
        mDonateBhim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.bhimupi.org.in/donation-digitized-with-bhim-upi");
            }
        });

        mHospitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Hospitals_List.class);
                startActivity(i);
            }
        });

        mGOIWebDirectory = findViewById(R.id.GoI_web_directory);
        mGOIWebDirectory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("http://goidirectory.nic.in/state.php");
            }
        });

        mGovernmentOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("http://gad.cg.gov.in/cgcorona/List_circulars.aspx");
            }
        });

        mMigrantsServices = findViewById(R.id.migrants_services);
        mMigrantsServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("http://cglabour.nic.in/");
            }
        });

        mPibFacts = findViewById(R.id.pib_facts);
        mPibFacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String pibFacts = this.getClass().getSimpleName();
//                Intent i = new Intent(MainActivity.this,web_main.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                i.putExtra("pibFacts",pibFacts);
//                startActivity(i);
                openUrl("https://pib.gov.in/factcheck.aspx");
            }
        });



        mMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent i =  new Intent(MainActivity.this, MoreModule.class);
              startActivity(i);
            }
        });

        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Courses_Module.class));
            }
        });

        volunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openUrl("https://self4society.mygov.in/");
                //webview
            }
        });


        checkSymptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String checker = this.getClass().getSimpleName();
                Intent i = new Intent(MainActivity.this,web_main.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("checker",checker);
                startActivity(i);

                //startActivity(new Intent(MainActivity.this, TestCheckSymptoms.class));
            }
        });

//        orphanage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, OrphanageForm.class));
//            }
//        });

        medicalStores = findViewById(R.id.Medical_Stores);
        medicalStores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MedicalStores.class));
            }
        });


        counselingPunjab = findViewById(R.id.CounselingKarnataka);
        counselingPunjab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.onlinecounselling4u.com/");

            }
        });

        donateFood = findViewById(R.id.DonateFood);
        donateFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String donateFood= this.getClass().getSimpleName();
                Intent i = new Intent(MainActivity.this,web_main.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("donateFood",donateFood);
                startActivity(i);
            }
        });


        nationCareerService =findViewById(R.id.NCS_id);
        nationCareerService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NationalCareerServiceActivity.class));
            }
        });

        msme = findViewById(R.id.MSME);
        msme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://champions.gov.in/MyMsme/grievance/Entermenu.aspx");
            }
        });
        //-------------------Module-End-----------------------------

        districtData = findViewById(R.id.district_data);
        districtData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                SharedPreferences userDetails = context.getSharedPreferences("userdetails", MODE_PRIVATE);
                String userState = userDetails.getString("userState", "");

                Intent intent = new Intent(MainActivity.this, DistrictData.class);
                intent.putExtra("sortBy","confirmed");
                intent.putExtra("sortOrder","DESC");
                intent.putExtra("state",userState);
                startActivity(intent);
            }
        });

        context = MainActivity.this;
        newasync naw = new newasync();
        naw.execute();

//*******************************************************************************
        INDIA_Active = findViewById(R.id.INDIA_Active);
        INDIA_Confirmed =findViewById(R.id.INDIA_Confirmed);
        INDIA_Deaths = findViewById(R.id.INDIA_Deaths);
        //INDIA_Recovered =findViewById(R.id.INDIA_Recovered);

        WORLD_Active = findViewById(R.id.WORLD_Active);
        WORLD_Confirmed =findViewById(R.id.WORLD_Confirmed);
        WORLD_Deaths = findViewById(R.id.WORLD_Death);
       // WORLD_Recovered =findViewById(R.id.WORLD_Recovered);

        STATE_Active = findViewById(R.id.STATE_Active);
        STATE_Death = findViewById(R.id.STATE_Death);
        //STATE_Recovered = findViewById(R.id.STATE_Recovered);

         STATE_Confirmed = findViewById(R.id.STATE_Confirmed);

        stateData = findViewById(R.id.State_Data);
        stateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                Intent intent = new Intent(MainActivity.this, State_Wise_Data.class);
                intent.putExtra("sortBy","confirmed");
                intent.putExtra("sortOrder","DESC");

                startActivity(intent);
            }
        });



        //Country Data
//        countryData = findViewById(R.id.Country_Data);
//        countryData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (SystemClock.elapsedRealtime() - mLastClickTime < 5000){
//                    return;
//                }
//                mLastClickTime = SystemClock.elapsedRealtime();
//                Intent intent = new Intent(MainActivity.this, Country_Wise_Data.class);
//                intent.putExtra("sortBy","confirmed");
//                intent.putExtra("sortOrder","DESC");
//                startActivity(intent);
//            }
//        });


        SharedPreferences userDetails = context.getSharedPreferences("userdetails", MODE_PRIVATE);
        //SharedPreferences.Editor edit = userDetails.edit();
        String userState = userDetails.getString("userState", "");
        String userDistrict = userDetails.getString("userDistrict", "");
        Bgfetch bg = new Bgfetch();


        //load values
        bg.statsfetchDistrict(userDistrict);
        bg.statsfetchState(userState);

        fragfet = new Bgfetch();


        fragfet.statsfetch();

        //*************State Image and state name**********************

//        imageView =findViewById(R.id.State_India);
//
//        switch (userState){
//
//            case "Maharashtra":
//                imageView.setImageResource(R.drawable.state_2);
//                break;
//
//            case "Delhi":
//                imageView.setImageResource(R.drawable.state_3);
//                break;
//
//            case "Tamil Nadu":
//                imageView.setImageResource(R.drawable.state_4);
//                break;
//
//            case "Rajasthan":
//                imageView.setImageResource(R.drawable.state_5);
//                break;
//
//            case "Madhya Pradesh":
//                imageView.setImageResource(R.drawable.state_6);
//                break;
//
//            case "Telangana":
//                imageView.setImageResource(R.drawable.state_7);
//                break;
//
//            case "Gujarat":
//                imageView.setImageResource(R.drawable.state_8);
//                break;
//
//            case "Uttar Pradesh":
//                imageView.setImageResource(R.drawable.state_9);
//                break;
//
//
//            case "Andhra Pradesh":
//                imageView.setImageResource(R.drawable.state_10);
//                break;
//
//
//            case "Kerala":
//                imageView.setImageResource(R.drawable.state_11);
//                break;
//
//
//            case "Jammu and Kashmir":
//                imageView.setImageResource(R.drawable.state_12);
//                break;
//
//
//            case "Karnataka":
//                imageView.setImageResource(R.drawable.state_13);
//                break;
//
//            case "Haryana":
//                imageView.setImageResource(R.drawable.state_14);
//                break;
//
//            case "West Bengal":
//                imageView.setImageResource(R.drawable.state_15);
//                break;
//
//            case "Punjab":
//                imageView.setImageResource(R.drawable.state_16);
//                break;
//
//            case "Bihar":
//                imageView.setImageResource(R.drawable.state_17);
//                break;
//
//            case "Odisha":
//                imageView.setImageResource(R.drawable.state_18);
//                break;
//
//
//            case "Uttarakhand":
//                imageView.setImageResource(R.drawable.state_19);
//                break;
//
//
//            case "Himachal Pradesh":
//                imageView.setImageResource(R.drawable.state_20);
//                break;
//
//
//            case "Chhattisgarh":
//                imageView.setImageResource(R.drawable.state_21);
//                break;
//
//
//            case "Assam":
//                imageView.setImageResource(R.drawable.state_22);
//                break;
//
//            case "Jharkhand":
//                imageView.setImageResource(R.drawable.state_23);
//                break;
//
//            case "Chandigarh":
//                imageView.setImageResource(R.drawable.state_24);
//                break;
//
//            case "Ladakh":
//                imageView.setImageResource(R.drawable.state_25);
//                break;
//
//
//            case "Andaman and Nicobar Islands":
//                imageView.setImageResource(R.drawable.state_26);
//                break;
//
//            case "Goa":
//                imageView.setImageResource(R.drawable.state_27);
//                break;
//
//
//            case "Puducherry":
//                imageView.setImageResource(R.drawable.state_28);
//                break;
//
//
//            case "Manipur":
//                imageView.setImageResource(R.drawable.state_29);
//                break;
//
//
//            case "Tripura":
//                imageView.setImageResource(R.drawable.state_30);
//                break;
//
//
//            case "Mizoram":
//                imageView.setImageResource(R.drawable.state_31);
//                break;
//
//            case "Arunachal Pradesh":
//                imageView.setImageResource(R.drawable.state_32);
//                break;
//
//            case "Dadra and Nagar Haveli":
//                imageView.setImageResource(R.drawable.state_33);
//                break;
//
//
//
//            case "Nagaland":
//                imageView.setImageResource(R.drawable.state_34);
//                break;
//
//
//            case "Meghalaya":
//                imageView.setImageResource(R.drawable.state_35);
//                break;
//
//            case "Daman and Diu":
//                imageView.setImageResource(R.drawable.state_36);
//                break;
//
//            case "Lakshadweep":
//                imageView.setImageResource(R.drawable.state_37);
//                break;
//
//            case "Sikkim":
//                imageView.setImageResource(R.drawable.state_38);
//                break;
//
//            default:
//                break;
//
//        }
//
//
//
//
//        LinearLayout linearLayout = findViewById(R.id.state_name_layout);
//        LinearLayout helperLayout = new LinearLayout(this);
//
//        TextView State_Name = new TextView(this);
//        State_Name.setText(userState);
//        State_Name.setTextSize(20);

//        helperLayout.addView(State_Name);
//        linearLayout.addView(helperLayout);
//*************************State Image and state name-END*******************************




//*********************************************************************************************************************************************************
       String url = "https://script.google.com/macros/s/AKfycbzLySFwJNojgOyaJb9JvcY0lSafNRjSIBimSPJ3d_PeMFAtNldV/exec?id=19DI7iAoSOHlN466WoVb2aoVY2x1mu5_k3ha7cjIY4ec&sheet=Sheet1";
        version=1;
        mQueue = Volley.newRequestQueue(Splash_animation.context);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray=response.getJSONArray("records");
                                JSONObject jsonObject = jsonArray.getJSONObject(0);
                                nversion = Integer.parseInt(jsonObject.getString("Version"));
                                if(nversion>version)
                                {
                                    final String link = jsonObject.getString("link");
                                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                                    builder.setMessage("Do You Want to update now");
                                    builder.setTitle(Html.fromHtml("<font color='#000000'>UPDATE AVAILABLE</font>"));
                                    System.out.println(nversion);
                                    builder.setPositiveButton(Html.fromHtml("<font color='#000000'>Yes</font>"), new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            openUrl(link);
                                        }
                                    });
                                    builder.setNegativeButton(Html.fromHtml("<font color='#000000'>No</font>"), new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                                    AlertDialog alertDialog=builder.create();
                                    alertDialog.show();
                                }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);

//*****************************************************************************************************************************************************************



        //*******************Floating button***********************************
        final FloatingActionButton mFab =(FloatingActionButton) findViewById(R.id.fab);
        final FloatingActionButton mcrowdcall =(FloatingActionButton) findViewById(R.id.fab2);
        final FloatingActionButton mCallButton =(FloatingActionButton) findViewById(R.id.fab3);
        final FloatingActionButton mcallhelp =(FloatingActionButton)findViewById(R.id.fab4);
        final FloatingActionButton mwhats1 =(FloatingActionButton)findViewById(R.id.fab5);
        final FloatingActionButton mwhats2 =(FloatingActionButton)findViewById(R.id.fab6);


        final LinearLayout mcallLayout=(LinearLayout) findViewById(R.id.callLayout);
        final LinearLayout mcrowdLayout =(LinearLayout)findViewById(R.id.crowdlayout);
        final LinearLayout mhelpLayout=(LinearLayout)findViewById(R.id.callhelp);
        final LinearLayout mwhatsapp1=(LinearLayout)findViewById(R.id.whatsapp1);
        final LinearLayout mwhatsapp2=(LinearLayout)findViewById(R.id.whatsapp2);

        final Animation mShowButton = AnimationUtils.loadAnimation(MainActivity.this,R.anim.show_button);
        final Animation mHideButton = AnimationUtils.loadAnimation(MainActivity.this,R.anim.hide_button);
        final Animation mShowLayout = AnimationUtils.loadAnimation(MainActivity.this,R.anim.show_layout);
        final Animation mHideLayout = AnimationUtils.loadAnimation(MainActivity.this,R.anim.hide_layout);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mcallLayout.getVisibility()==View.VISIBLE && mcrowdLayout.getVisibility() ==View.VISIBLE && mhelpLayout.getVisibility() ==View.VISIBLE&& mwhatsapp1.getVisibility() ==View.VISIBLE&& mwhatsapp2.getVisibility() ==View.VISIBLE)
                { mcallLayout.setVisibility(View.GONE);
                    mcrowdLayout.setVisibility(View.GONE);
                    mcallLayout.setVisibility(View.GONE);
                    mwhatsapp1.setVisibility(View.GONE);
                    mwhatsapp2.setVisibility(View.GONE);
                    mcallLayout.startAnimation(mHideLayout);
                    mcrowdLayout.startAnimation(mHideLayout);
                    mhelpLayout.startAnimation(mHideLayout);
                    mwhatsapp1.startAnimation(mHideLayout);
                    mwhatsapp2.startAnimation(mHideLayout);
                    mFab.startAnimation(mHideButton);

                    mcrowdcall.setClickable(false);
                    mCallButton.setClickable(false);
                    mcallhelp.setClickable(false);
                    mwhats1.setClickable(false);
                    mwhats2.setClickable(false);
                }else{
                    mcallLayout.setVisibility(View.VISIBLE);
                    mcrowdLayout.setVisibility(View.VISIBLE);
                    mhelpLayout.setVisibility(View.VISIBLE);
                    mwhatsapp1.setVisibility(View.VISIBLE);
                    mwhatsapp2.setVisibility(View.VISIBLE);
                    mcallLayout.startAnimation(mShowLayout);
                    mcrowdLayout.startAnimation(mShowLayout);
                    mhelpLayout.startAnimation(mShowLayout);
                    mwhatsapp1.startAnimation(mShowLayout);
                    mwhatsapp2.startAnimation(mShowLayout);
                    mFab.startAnimation(mShowButton);

                    mcrowdcall.setClickable(true);
                    mCallButton.setClickable(true);
                    mcallhelp.setClickable(true);
                    mwhats1.setClickable(true);
                    mwhats2.setClickable(true);
                }


            }
        });
        mCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mcallLayout.setVisibility(View.GONE);
                mcrowdLayout.setVisibility(View.GONE);
                mcallLayout.setVisibility(View.GONE);
                mwhatsapp1.setVisibility(View.GONE);
                mwhatsapp2.setVisibility(View.GONE);
                mcallLayout.startAnimation(mHideLayout);
                mcrowdLayout.startAnimation(mHideLayout);
                mhelpLayout.startAnimation(mHideLayout);
                mwhatsapp1.startAnimation(mHideLayout);
                mwhatsapp2.startAnimation(mHideLayout);

                String phone ="104";
                Intent mIntent=new Intent(Intent.ACTION_DIAL);
                mIntent.setData(Uri.parse("tel:"+ phone));
                if(mIntent.resolveActivity(getPackageManager()) !=null){
                    startActivity(mIntent);
                }else Toast.makeText(MainActivity.this, "Emergency", Toast.LENGTH_SHORT).show();

            }
        });

        mcrowdcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mcallLayout.setVisibility(View.GONE);
                mcrowdLayout.setVisibility(View.GONE);
                mcallLayout.setVisibility(View.GONE);
                mwhatsapp1.setVisibility(View.GONE);
                mwhatsapp2.setVisibility(View.GONE);
                mcallLayout.startAnimation(mHideLayout);
                mcrowdLayout.startAnimation(mHideLayout);
                mhelpLayout.startAnimation(mHideLayout);
                mwhatsapp1.startAnimation(mHideLayout);
                mwhatsapp2.startAnimation(mHideLayout);

                String[] TO_EMAILS = {"ncov2019@gov.in"};

                Intent intent =new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL,TO_EMAILS);
                // intent.putExtra(Intent.EXTRA_SUBJECT,"this is your subject");
                //intent.putExtra(Intent.EXTRA_TEXT,"this is your body");

                startActivity(Intent.createChooser(intent,"choose an application"));

            }
        });
        mcallhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                mcallLayout.setVisibility(View.GONE);
                mcrowdLayout.setVisibility(View.GONE);
                mcallLayout.setVisibility(View.GONE);
                mwhatsapp1.setVisibility(View.GONE);
                mwhatsapp2.setVisibility(View.GONE);
                mcallLayout.startAnimation(mHideLayout);
                mcrowdLayout.startAnimation(mHideLayout);
                mhelpLayout.startAnimation(mHideLayout);
                mwhatsapp1.startAnimation(mHideLayout);
                mwhatsapp2.startAnimation(mHideLayout);

                String phone ="07712235091";
                Intent mIntent=new Intent(Intent.ACTION_DIAL);
                mIntent.setData(Uri.parse("tel:"+ phone));
                if(mIntent.resolveActivity(getPackageManager()) !=null){
                    startActivity(mIntent);
                }else Toast.makeText(MainActivity.this, "Emergency", Toast.LENGTH_SHORT).show();

            }
        });

        mwhats1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mcallLayout.setVisibility(View.GONE);
                mcrowdLayout.setVisibility(View.GONE);
                mcallLayout.setVisibility(View.GONE);
                mwhatsapp1.setVisibility(View.GONE);
                mwhatsapp2.setVisibility(View.GONE);
                mcallLayout.startAnimation(mHideLayout);
                mcrowdLayout.startAnimation(mHideLayout);
                mhelpLayout.startAnimation(mHideLayout);
                mwhatsapp1.startAnimation(mHideLayout);
                mwhatsapp2.startAnimation(mHideLayout);

                String number = "41798931892";
                String url = "https://api.whatsapp.com/send?phone="+ number ;
                Intent A = new Intent(Intent.ACTION_VIEW);
                A.setData(Uri.parse(url));
//                A.putExtra(Intent.EXTRA_TEXT,"Hi");
//                A.setType("text/plain");
                startActivity(A);




            }
        });
        mwhats2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mcallLayout.setVisibility(View.GONE);
                mcrowdLayout.setVisibility(View.GONE);
                mcallLayout.setVisibility(View.GONE);
                mwhatsapp1.setVisibility(View.GONE);
                mwhatsapp2.setVisibility(View.GONE);
                mcallLayout.startAnimation(mHideLayout);
                mcrowdLayout.startAnimation(mHideLayout);
                mhelpLayout.startAnimation(mHideLayout);
                mwhatsapp1.startAnimation(mHideLayout);
                mwhatsapp2.startAnimation(mHideLayout);

                String number = "41225017341";
                String url = "https://api.whatsapp.com/send?phone="+ number ;
                Intent A = new Intent(Intent.ACTION_VIEW);
                A.setData(Uri.parse(url));

                startActivity(A);


            }
        });


        //*********************************************************************


        toolbar = (Toolbar) findViewById(R.id.myToolbar);
     //   tabLayout = (TabLayout) findViewById(R.id.tablayout);
    //    viewPager = (ViewPager) findViewById(R.id.myViewPager);

        setSupportActionBar(toolbar);

        //setupViewPager(viewPager);

      //  tabLayout.setupWithViewPager(viewPager);


    }





    //**************************for menu***********************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

//            case R.id.Languages:
//                    showChangeLanguageDialog();
//                return true;

            case R.id.share:

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "app link here";//put the link of instead of "app link here"
                sharingIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(sharingIntent,"Share using"));
                return true;

//            case R.id.FAQ:
//                Intent intent1 = new Intent(MainActivity.this, FAQ_main.class);
//                startActivity(intent1);
//                return true;

            case R.id.feedBack:
                openUrl("https://forms.gle/LkrF7ptwSjeRN2719");
                return true;

            case R.id.about:
                Intent intent3 = new Intent(MainActivity.this, About_main.class);
                startActivity(intent3);
                return true;

            case R.id.contactUs:
                Intent intent4 = new Intent(MainActivity.this,Contact_us.class);
                startActivity(intent4);
                return true;

            case R.id.Sources:
                Intent intent5 = new Intent(MainActivity.this, SourceMainActivity.class);
                startActivity(intent5);
                return true;

//            case R.id.Reselect_state:
//                Intent intent6 = new Intent(MainActivity.this, Select_State.class);
//                startActivity(intent6);
//
            case R.id.Reselect_district:
                Intent intent6 = new Intent(MainActivity.this,District_Select.class);
                startActivity(intent6);
                return true;

//            case R.id.sendCrashReport:
//                try{
//                    throw(new Exception(("New Exception here")));
//                } catch(Exception e){
//                    StringWriter sw = new StringWriter();
//                    e.printStackTrace(new PrintWriter(sw));
//                    String exceptionAsString = sw.toString();
//                    appendLog(exceptionAsString);
//                }
//                SendLogcatMail();
//                return true;


//            case R.id.yourProfile:
//                startActivity(new Intent(MainActivity.this,ViewProfile.class));


//            case R.id.LogOut:
//                FirebaseAuth.getInstance().signOut();
//                Intent i = new Intent(getApplicationContext(),LoginActivity_Firebase.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(i);
//                finish();
//

            default:
                return super.onOptionsItemSelected(item);
        }


    }

    public void appendLog(String text)
    {
        File logFile = new File(MainActivity.context.getFilesDir(), "mydir");
        if (!logFile.exists())
        {
            try
            {
                logFile.createNewFile();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(logFile);
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
            writer.append(text);
            writer.append("-------------------------------\n");
            writer.close();
            fileOutputStream.close();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void SendLogcatMail(){

        // save logcat in file
        File outputFile = new File(Environment.getExternalStorageDirectory(),
                "logcat.txt");
        try {
            Runtime.getRuntime().exec(
                    "logcat -f " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //send file using email
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        // Set type to "email"
        emailIntent.setType("vnd.android.cursor.dir/email");
        String to[] = {"hndindia20@gmail.com"};
        emailIntent .putExtra(Intent.EXTRA_EMAIL, to);
        // the attachment
        emailIntent .putExtra(Intent.EXTRA_STREAM, outputFile.getAbsolutePath());
        // the mail subject
        emailIntent .putExtra(Intent.EXTRA_SUBJECT, "Subject");
        startActivity(Intent.createChooser(emailIntent , "Send email..."));
    }



    //***********************************menu end*****************************************

    private void openUrl(final String url) {
        if (url!= null) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    }
    public class newasync extends AsyncTask<Void,Void,Void>
    {
        final String[] textQuote = {""};
     //   final LinearLayout linearLayout = findViewById(R.id.linear);
        final TextView quotes = new TextView(context);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            String url = "https://script.google.com/macros/s/AKfycbzLySFwJNojgOyaJb9JvcY0lSafNRjSIBimSPJ3d_PeMFAtNldV/exec?id=19DI7iAoSOHlN466WoVb2aoVY2x1mu5_k3ha7cjIY4ec&sheet=Sheet9";

            mQueue = Volley.newRequestQueue(context);

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONArray jsonArray=response.getJSONArray("records");


                                for(int i=0;i<jsonArray.length();i++){
                                    JSONObject jo = jsonArray.getJSONObject(i);
                                    String news = jo.getString("description");
                                    String date = jo.getString("date");
                                    textQuote[0] = textQuote[0] +news+"- "+date;

                                }

                                    quotes.setText(textQuote[0]);
                                    quotes.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
                                    //linearLayout.addView(quotes);

                            }catch (JSONException e){
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });
            mQueue.add(request);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

}
