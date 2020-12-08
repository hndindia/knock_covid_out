package com.chhattisgarh.sora_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class Contact_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        TextView textViewInsta =(TextView) findViewById(R.id.insta);
        textViewInsta.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textViewFb =(TextView) findViewById(R.id.FB);
        textViewFb.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textViewTw =(TextView) findViewById(R.id.Twitter);
        textViewTw.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textViewLn =(TextView) findViewById(R.id.LN);
        textViewLn.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void sendMail(View view){

        String[] TO_EMAILS = {"HNDINDIA20@gmail.com"};
        Intent intent =new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL,TO_EMAILS);
        // intent.putExtra(Intent.EXTRA_SUBJECT,"this is your subject");
        // intent.putExtra(Intent.EXTRA_TEXT,"this is your body");
        startActivity(Intent.createChooser(intent,"choose an application"));

    }

}


