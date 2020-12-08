package com.chhattisgarh.sora_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Myth_Buster extends AppCompatActivity {
public TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myth__buster);

        textView =  findViewById(R.id.WHO_MB);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
