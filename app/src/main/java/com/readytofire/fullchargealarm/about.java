package com.readytofire.fullchargealarm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.readytofire.fullchargealarm.helper.LocaleManager;
import psquare.FullChargeAlarm.R;

public class about extends AppCompatActivity {
    private TextView kids;

    /* renamed from: td */
    private TextView f72td;

    /* renamed from: tv */
    private TextView f73tv;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_about);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        } catch (NullPointerException e) {
        }
        this.f73tv = (TextView) findViewById(R.id.textView7);
        this.f72td = (TextView) findViewById(R.id.textView9);
        this.kids = (TextView) findViewById(R.id.textView6);
        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            TextView textView = this.f73tv;
            StringBuilder sb = new StringBuilder();
            sb.append("Version ");
            sb.append(pInfo.versionName);
            textView.setText(sb.toString());
        } catch (NameNotFoundException e2) {
            e2.printStackTrace();
        }
        resetTitles();
        this.f72td.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                about.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.psquare.texttovoice")));
            }
        });
        this.kids.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                about.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.psquare.FullChargeAlarm.lite")));
            }
        });
    }

    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
    }

    private void resetTitles() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), 128);
            if (info.labelRes != 0) {
                setTitle(info.labelRes);
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
