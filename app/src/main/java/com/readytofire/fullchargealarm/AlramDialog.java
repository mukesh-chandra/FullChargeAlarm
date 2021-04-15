package com.readytofire.fullchargealarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.readytofire.fullchargealarm.helper.LocaleManager;
import psquare.FullChargeAlarm.R;

public class AlramDialog extends AppCompatActivity {

    /* renamed from: am */
    AudioManager f43am;

    /* renamed from: b */
    Button f44b;

    /* renamed from: df */
    int f45df = 0;
    int fst = 0;
    public BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
        public void onReceive(Context arg0, Intent intent) {
            AlramDialog.this.plugged = intent.getIntExtra("plugged", -1);
            if (AlramDialog.this.plugged != 1 && AlramDialog.this.plugged != 2 && AlramDialog.this.plugged != 4 && AlramDialog.this.fst == 0) {
                try {
                    AlramDialog.this.f43am.setStreamVolume(3, AlramDialog.this.f45df, 0);
                } catch (Exception e) {
                }
                if (AlramDialog.this.vbb.booleanValue() && AlramDialog.this.f47vb.hasVibrator()) {
                    AlramDialog.this.f47vb.cancel();
                }
                try {
                    AlramDialog.this.f46tp.stop();
                } catch (NullPointerException e2) {
                }
                AlramDialog.this.stopService(new Intent(AlramDialog.this.getApplicationContext(), AlarmService.class));
                AlramDialog.this.finish();
            }
        }
    };
    private ProgressBar mProgressBar;
    private int mProgressStatus = 0;
    private TextView mTextViewPercentage;
    int plugged = 0;

    /* renamed from: tp */
    MediaPlayer f46tp;
    Uri uri;
    String usee;

    /* renamed from: vb */
    Vibrator f47vb;
    Boolean vbb;
    private String vol;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_ful);
        this.f44b = (Button) findViewById(R.id.stop);
        this.f43am = (AudioManager) getSystemService("audio");
        this.f47vb = (Vibrator) getSystemService("vibrator");
        this.f45df = this.f43am.getStreamVolume(3);
        this.mTextViewPercentage = (TextView) findViewById(R.id.btr);
        this.mProgressBar = (ProgressBar) findViewById(R.id.p1);
        this.mTextViewPercentage.setTypeface(Typeface.createFromAsset(getAssets(), "digital.ttf"));
        resetTitles();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        try {
            this.mProgressStatus = Integer.valueOf(sharedPref.getString("example_text", "100")).intValue();
        } catch (NumberFormatException e) {
            this.mProgressStatus = 99;
        }
        if (this.mProgressStatus > 100) {
            this.mProgressStatus = 99;
        }
        TextView textView = this.mTextViewPercentage;
        StringBuilder sb = new StringBuilder();
        sb.append(BuildConfig.FLAVOR);
        sb.append(this.mProgressStatus);
        sb.append("%");
        textView.setText(sb.toString());
        this.mProgressBar.setProgress(this.mProgressStatus);
        this.usee = sharedPref.getString("notifications_new_message_ringtone", "none");
        this.vbb = Boolean.valueOf(sharedPref.getBoolean("key_vb", false));
        this.vol = sharedPref.getString("example_list", "1");
        setFinishOnTouchOutside(false);
        alm();
        registerReceiver(this.mBatInfoReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public void onBackPressed() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008e A[Catch:{ Exception -> 0x00b4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void alm() {
        /*
            r9 = this;
            java.lang.String r0 = r9.vol
            java.lang.String r1 = "0"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = 12
            goto L_0x001c
        L_0x000d:
            java.lang.String r0 = r9.vol
            java.lang.String r1 = "1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x001a
            r0 = 15
            goto L_0x001c
        L_0x001a:
            r0 = 8
        L_0x001c:
            r1 = 3
            r2 = 0
            android.media.AudioManager r3 = r9.f43am     // Catch:{ Exception -> 0x0024 }
            r3.setStreamVolume(r1, r0, r2)     // Catch:{ Exception -> 0x0024 }
            goto L_0x0025
        L_0x0024:
            r3 = move-exception
        L_0x0025:
            java.lang.String r3 = r9.usee     // Catch:{ Exception -> 0x00b4 }
            if (r3 == 0) goto L_0x006f
            java.lang.String r3 = r9.usee     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r4 = ""
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x00b4 }
            if (r3 != 0) goto L_0x006f
            java.lang.String r3 = r9.usee     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r4 = "null"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x00b4 }
            if (r3 != 0) goto L_0x006f
            java.lang.String r3 = r9.usee     // Catch:{ Exception -> 0x00b4 }
            int r3 = r3.length()     // Catch:{ Exception -> 0x00b4 }
            if (r3 == 0) goto L_0x006f
            java.lang.String r3 = r9.usee     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r4 = "none"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x00b4 }
            if (r3 != 0) goto L_0x006f
            java.lang.String r3 = r9.usee     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r4 = "Default"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x00b4 }
            if (r3 == 0) goto L_0x005a
            goto L_0x006f
        L_0x005a:
            java.lang.String r3 = r9.usee     // Catch:{ Exception -> 0x00b4 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x00b4 }
            r9.uri = r3     // Catch:{ Exception -> 0x00b4 }
            android.content.Context r3 = r9.getApplicationContext()     // Catch:{ Exception -> 0x00b4 }
            android.net.Uri r4 = r9.uri     // Catch:{ Exception -> 0x00b4 }
            android.media.MediaPlayer r3 = android.media.MediaPlayer.create(r3, r4)     // Catch:{ Exception -> 0x00b4 }
            r9.f46tp = r3     // Catch:{ Exception -> 0x00b4 }
            goto L_0x007b
        L_0x006f:
            android.content.Context r3 = r9.getApplicationContext()     // Catch:{ Exception -> 0x00b4 }
            r4 = 2131689472(0x7f0f0000, float:1.900796E38)
            android.media.MediaPlayer r3 = android.media.MediaPlayer.create(r3, r4)     // Catch:{ Exception -> 0x00b4 }
            r9.f46tp = r3     // Catch:{ Exception -> 0x00b4 }
        L_0x007b:
            android.media.MediaPlayer r3 = r9.f46tp     // Catch:{ Exception -> 0x00b4 }
            r3.start()     // Catch:{ Exception -> 0x00b4 }
            android.media.MediaPlayer r3 = r9.f46tp     // Catch:{ Exception -> 0x00b4 }
            r4 = 1
            r3.setLooping(r4)     // Catch:{ Exception -> 0x00b4 }
            java.lang.Boolean r3 = r9.vbb     // Catch:{ Exception -> 0x00b4 }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x00b4 }
            if (r3 == 0) goto L_0x00b5
            r3 = 8
            long[] r3 = new long[r3]     // Catch:{ Exception -> 0x00b4 }
            r5 = 0
            r3[r2] = r5     // Catch:{ Exception -> 0x00b4 }
            r5 = 5000(0x1388, double:2.4703E-320)
            r3[r4] = r5     // Catch:{ Exception -> 0x00b4 }
            r4 = 2
            r7 = 1000(0x3e8, double:4.94E-321)
            r3[r4] = r7     // Catch:{ Exception -> 0x00b4 }
            r3[r1] = r5     // Catch:{ Exception -> 0x00b4 }
            r1 = 4
            r3[r1] = r7     // Catch:{ Exception -> 0x00b4 }
            r1 = 5
            r3[r1] = r5     // Catch:{ Exception -> 0x00b4 }
            r1 = 6
            r3[r1] = r7     // Catch:{ Exception -> 0x00b4 }
            r1 = 7
            r3[r1] = r5     // Catch:{ Exception -> 0x00b4 }
            r1 = r3
            android.os.Vibrator r3 = r9.f47vb     // Catch:{ Exception -> 0x00b4 }
            r3.vibrate(r1, r2)     // Catch:{ Exception -> 0x00b4 }
            goto L_0x00b5
        L_0x00b4:
            r1 = move-exception
        L_0x00b5:
            android.widget.Button r1 = r9.f44b
            com.readytofire.fullchargealarm.AlramDialog$2 r2 = new com.psquare.FullChargeAlarm.AlramDialog$2
            r2.<init>()
            r1.setOnClickListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.psquare.FullChargeAlarm.AlramDialog.alm():void");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = this.mBatInfoReceiver;
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
            }
        }
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
