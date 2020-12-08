package com.chhattisgarh.sora_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ViewProfile extends AppCompatActivity {
public TextView userName,userEmail,userPhone,userCountry,userProfessionalInfo,userOrganizationInfo;
public TextView communicationLanguage;
public TextView securityPhoneNumber,securityChangePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        //-------------------Contact---------------------------------
        userName = findViewById(R.id.User_Name);
        userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox();
            }
        });

        userEmail = findViewById(R.id.User_Email);
        userEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox();
            }
        });

        userPhone = findViewById(R.id.User_Phone);
        userPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox();
            }
        });

        userCountry = findViewById(R.id.User_Country);
        userCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox();
            }
        });

        communicationLanguage = findViewById(R.id.Communication_Language);
        communicationLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox();
            }
        });

        userProfessionalInfo = findViewById(R.id.User_ProfessionalInfo);
        userProfessionalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox();
            }
        });

        userOrganizationInfo = findViewById(R.id.User_OrganizationInfo);
        userOrganizationInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox();
            }
        });

        //---------------------------------------------------------------------------


        //--------------------------Security and privacy----------------------------
        securityPhoneNumber = findViewById(R.id.Security_Phone_Number);
        securityPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent
            }
        });


        securityChangePass = findViewById(R.id.Security_Change_Password);
        securityChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent
            }
        });


        //--------------------------------------------------------------------------

    }

    private void dialogBox() {

            if(userName.isPressed()) {
                Toast.makeText(this, "I am username", Toast.LENGTH_SHORT).show();
            }else if(userEmail.isPressed()){
                Toast.makeText(this, "I am Email", Toast.LENGTH_SHORT).show();
            }else if(userPhone.isPressed()){
                Toast.makeText(this, "I am Email", Toast.LENGTH_SHORT).show();
            }else if(userCountry.isPressed()){
                Toast.makeText(this, "I am Email", Toast.LENGTH_SHORT).show();
            }else if(communicationLanguage.isPressed()){
                Toast.makeText(this, "I am Email", Toast.LENGTH_SHORT).show();
            }



    }


}
