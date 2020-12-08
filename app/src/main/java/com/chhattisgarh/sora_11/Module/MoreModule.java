package com.chhattisgarh.sora_11.Module;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import com.chhattisgarh.sora_11.Myth_Buster;
import com.chhattisgarh.sora_11.Prevention_products.PreventionProducts;
import com.chhattisgarh.sora_11.R;
import com.chhattisgarh.sora_11.Symptom_Precaution;
import com.chhattisgarh.sora_11.UsefulLinks;
import com.chhattisgarh.sora_11.web_main;

public class MoreModule extends AppCompatActivity {
private long mLastClickTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_module);
    }

    public void checkSymptom(View view) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();
        startActivity(new Intent(MoreModule.this, Symptom_Precaution.class));
    }


    public void mythBuster(View view) {

        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();
        startActivity(new Intent(MoreModule.this, Myth_Buster.class));
    }


    public void preventionProduct(View view) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();
        startActivity(new Intent(MoreModule.this, PreventionProducts.class));
    }


    public void usefulLinks(View view) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();
        startActivity(new Intent(MoreModule.this, UsefulLinks.class));
    }


    public void ShareIdea(View view) {
        String ShareIdea= this.getClass().getSimpleName();
        Intent i = new Intent(MoreModule.this, web_main.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.putExtra("ShareIdea",ShareIdea);
        startActivity(i);

    }


    public void QuizOnCovid(View view) {
        String QuizOnCovid= this.getClass().getSimpleName();
        Intent i = new Intent(MoreModule.this, web_main.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.putExtra("QuizOnCovid",QuizOnCovid);
        startActivity(i);
    }

    public void TakeAPledge(View view) {
        String TakeAPledge= this.getClass().getSimpleName();
        Intent i = new Intent(MoreModule.this, web_main.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.putExtra("TakeAPledge",TakeAPledge);
        startActivity(i);
    }

    public void usefulTwitterHandles(View view) {
        Intent i = new Intent(MoreModule.this,TwitterHandels.class);
        startActivity(i);
    }

//    public void PIBFactsCheck(View view) {
//        openUrl("https://factcheck.pib.gov.in/");
//    }









    private void openUrl(final String url) {
        if (url!= null) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    }
}
