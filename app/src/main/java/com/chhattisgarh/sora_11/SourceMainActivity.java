package com.chhattisgarh.sora_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class SourceMainActivity extends AppCompatActivity {

    private TextView sources1,sources2,sources3,sources4,sources5,sources6,sources7,sources8,sources9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_main);

        sources1 = findViewById(R.id.sources_link_1);
        sources1.setMovementMethod(LinkMovementMethod.getInstance());

        sources2 = findViewById(R.id.sources_link_2);
        sources2.setMovementMethod(LinkMovementMethod.getInstance());

        sources3 = findViewById(R.id.sources_link_3);
        sources3.setMovementMethod(LinkMovementMethod.getInstance());

        sources4 = findViewById(R.id.sources_link_4);
        sources4.setMovementMethod(LinkMovementMethod.getInstance());

        sources5 = findViewById(R.id.sources_link_5);
        sources5.setMovementMethod(LinkMovementMethod.getInstance());

        sources6 = findViewById(R.id.sources_link_6);
        sources6.setMovementMethod(LinkMovementMethod.getInstance());

        sources7 = findViewById(R.id.sources_link_7);
        sources7.setMovementMethod(LinkMovementMethod.getInstance());

        sources8 = findViewById(R.id.sources_link_8);
        sources8.setMovementMethod(LinkMovementMethod.getInstance());

        sources9 = findViewById(R.id.sources_link_9);
        sources9.setMovementMethod(LinkMovementMethod.getInstance());

    }
}