package com.readytofire.fullchargealarm;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.psquare.FullChargeAlarm.helper.LocaleManager;
import psquare.FullChargeAlarm.R;

public class etcdlg extends AppCompatActivity {
    TextView tv1;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        String str = "mn";
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_etcdlg);
        this.tv1 = (TextView) findViewById(R.id.textView5);
        this.tv1.setTypeface(Typeface.createFromAsset(getAssets(), "digital.ttf"));
        try {
            String str2 = "hr";
            String str3 = "0";
            if (getIntent().getExtras().getInt(str, 0) < 10) {
                TextView textView = this.tv1;
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(getIntent().getExtras().getInt(str2));
                sb.append(" : 0");
                sb.append(getIntent().getExtras().getInt(str));
                textView.setText(sb.toString());
            } else {
                TextView textView2 = this.tv1;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(getIntent().getExtras().getInt(str2));
                sb2.append(" : ");
                sb2.append(getIntent().getExtras().getInt(str));
                textView2.setText(sb2.toString());
            }
        } catch (Exception e) {
        }
        resetTitles();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(8000);
                    etcdlg.this.runOnUiThread(new Runnable() {
                        public void run() {
                            etcdlg.this.finish();
                        }
                    });
                } catch (Exception e) {
                }
            }
        }).start();
    }

    public void fns(View v) {
        finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
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
