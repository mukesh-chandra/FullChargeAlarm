package com.readytofire.fullchargealarm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.readytofire.fullchargealarm.helper.LocaleManager;
import psquare.FullChargeAlarm.R;

public class lowdlg extends AppCompatActivity {

    /* renamed from: b */
    Button f79b;
    private ProgressBar mProgressBar;
    private int mProgressStatus = 0;
    private TextView mTextViewPercentage;

    /* renamed from: tp */
    MediaPlayer f80tp;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_lw);
        this.f79b = (Button) findViewById(R.id.stop);
        this.mTextViewPercentage = (TextView) findViewById(R.id.btr);
        this.mProgressBar = (ProgressBar) findViewById(R.id.p1);
        this.mTextViewPercentage.setTypeface(Typeface.createFromAsset(getAssets(), "digital.ttf"));
        resetTitles();
        try {
            this.mProgressStatus = Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("key_low_lvl", "20")).intValue();
        } catch (NumberFormatException e) {
            this.mProgressStatus = 20;
        }
        TextView textView = this.mTextViewPercentage;
        StringBuilder sb = new StringBuilder();
        sb.append(BuildConfig.FLAVOR);
        sb.append(this.mProgressStatus);
        sb.append("%");
        textView.setText(sb.toString());
        this.mProgressBar.setProgress(this.mProgressStatus);
        setFinishOnTouchOutside(false);
        alm();
    }

    public void onBackPressed() {
    }

    public void alm() {
        this.f80tp = MediaPlayer.create(getApplicationContext(), R.raw.btlw);
        this.f80tp.start();
        this.f80tp.setLooping(true);
        this.f79b.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                lowdlg.this.f80tp.stop();
                lowdlg.this.stopService(new Intent(lowdlg.this.getApplicationContext(), batterylow.class));
                lowdlg.this.finish();
            }
        });
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
}
