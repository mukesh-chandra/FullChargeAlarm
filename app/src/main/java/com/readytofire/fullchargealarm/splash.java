package com.readytofire.fullchargealarm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.ads.AudienceNetworkAds;
import com.readytofire.fullchargealarm.helper.GifImageView;
import psquare.FullChargeAlarm.R;

public class splash extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 900;

    /* renamed from: k */
    int f81k = 0;
    SharedPreferences pref;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_splash);
        AudienceNetworkAds.initialize(this);
        this.pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        this.f81k = this.pref.getInt("firstl", 0);
        GifImageView gifImageView = (GifImageView) findViewById(R.id.GifImageView);
        if (getScreenHeight() >= 1794) {
            gifImageView.setGifImageResource(R.drawable.big_ani);
        } else if (getScreenHeight() < 1000) {
            gifImageView.setGifImageResource(R.drawable.low_ani);
        } else {
            gifImageView.setGifImageResource(R.drawable.mid_ani);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent i;
                if (splash.this.f81k == 0) {
                    Editor editor = splash.this.pref.edit();
                    editor.putInt("firstl", 1);
                    editor.apply();
                    i = new Intent(splash.this, langAct.class);
                    i.putExtra("act", "main");
                } else {
                    i = new Intent(splash.this, MainActivity.class);
                }
                splash.this.startActivity(i);
                splash.this.finish();
            }
        }, (long) SPLASH_TIME_OUT);
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
