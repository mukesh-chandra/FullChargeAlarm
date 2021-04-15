package com.readytofire.fullchargealarm;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.preference.PreferenceManager;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat.Builder;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.readytofire.fullchargealarm.helper.LocaleManager;
import java.util.Calendar;
import psquare.FullChargeAlarm.R;

public class AlarmService extends Service {
    public static int level;
    AlarmManager alarmManager;
    Builder builder;

    /* renamed from: ck */
    int f39ck = 0;
    int ckk = 0;
    String crtm;
    String crtmtp;
    long ctm;
    int dhr = 0;
    int dmn = 0;

    /* renamed from: i */
    int f40i = 0;
    int lvpv = 0;
    BroadcastReceiver mBatInfoReceiver;
    NotificationManager notificationmanager;
    PendingIntent pendingIntent;

    /* renamed from: pg */
    int f41pg = 0;

    /* renamed from: tm */
    long f42tm;

    public AlarmService() {
        String str = BuildConfig.FLAVOR;
        this.crtm = str;
        this.crtmtp = str;
        this.alarmManager = null;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        this.mBatInfoReceiver = new BroadcastReceiver() {
            public void onReceive(Context arg0, Intent intent) {
                SharedPreferences pref;
                SharedPreferences pref2 = AlarmService.this.getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(AlarmService.this.getApplicationContext());
                String usernamee = sharedPref.getString("example_text", "100");
                boolean fc = sharedPref.getBoolean("alm_full", true);
                try {
                    AlarmService.this.f41pg = Integer.valueOf(usernamee).intValue();
                } catch (NumberFormatException e) {
                    AlarmService.this.f41pg = 100;
                }
                if (AlarmService.this.f41pg > 100) {
                    AlarmService.this.f41pg = 100;
                }
                AlarmService.level = intent.getIntExtra("level", 0);
                if ((AlarmService.level == AlarmService.this.f41pg && AlarmService.this.f40i == 0 && fc) || (AlarmService.level == AlarmService.this.f41pg + 1 && AlarmService.this.f40i == 0 && fc)) {
                    try {
                        long twsec = System.currentTimeMillis() + 1000;
                        AlarmService.this.alarmManager = (AlarmManager) AlarmService.this.getSystemService(NotificationCompat.CATEGORY_ALARM);
                        AlarmService.this.f40i = 1;
                        Intent myIntent = new Intent(AlarmService.this, AlarmReceiver.class);
                        AlarmService.this.pendingIntent = PendingIntent.getBroadcast(AlarmService.this, 0, myIntent, 0);
                        AlarmService.this.alarmManager.set(0, twsec, AlarmService.this.pendingIntent);
                    } catch (Exception e2) {
                        AlarmService.this.f40i = 0;
                    }
                }
                Calendar c = Calendar.getInstance();
                AlarmService.this.ctm = c.getTimeInMillis();
                String str = ")";
                String str2 = " (";
                String str3 = "time";
                SharedPreferences pref3 = pref2;
                String str4 = " ";
                if (AlarmService.this.f39ck == 0) {
                    AlarmService alarmService = AlarmService.this;
                    alarmService.f42tm = alarmService.ctm;
                    AlarmService.this.lvpv = AlarmService.level;
                    AlarmService.this.f39ck++;
                    if (AlarmService.level == 100) {
                        AlarmService alarmService2 = AlarmService.this;
                        alarmService2.crtm = alarmService2.getString(R.string.noti_fullcharged);
                        pref = pref3;
                        boolean z = fc;
                    } else {
                        pref = pref3;
                        boolean z2 = fc;
                        long tmp = pref.getLong(str3, 0);
                        if (tmp == 0) {
                            AlarmService alarmService3 = AlarmService.this;
                            String str5 = BuildConfig.FLAVOR;
                            alarmService3.crtmtp = str5;
                            alarmService3.crtm = str5;
                            alarmService3.dhr = 0;
                            alarmService3.dmn = 0;
                        } else if (((long) (100 - AlarmService.level)) * tmp < 3600) {
                            AlarmService alarmService4 = AlarmService.this;
                            StringBuilder sb = new StringBuilder();
                            sb.append(AlarmService.this.getString(R.string.noti_charging));
                            sb.append(str2);
                            sb.append((((long) (100 - AlarmService.level)) * tmp) / 60);
                            sb.append(str4);
                            sb.append(AlarmService.this.getString(R.string.noti_minutil));
                            sb.append(str);
                            alarmService4.crtm = sb.toString();
                            AlarmService alarmService5 = AlarmService.this;
                            alarmService5.dhr = 0;
                            alarmService5.dmn = (int) ((((long) (100 - AlarmService.level)) * tmp) / 60);
                        } else {
                            AlarmService alarmService6 = AlarmService.this;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(AlarmService.this.getString(R.string.noti_charging));
                            sb2.append(str2);
                            sb2.append((((long) (100 - AlarmService.level)) * tmp) / 3600);
                            sb2.append(str4);
                            sb2.append(AlarmService.this.getString(R.string.noti_hr));
                            sb2.append(str4);
                            sb2.append(((((long) (100 - AlarmService.level)) * tmp) % 3600) / 60);
                            sb2.append(str4);
                            sb2.append(AlarmService.this.getString(R.string.noti_minutil));
                            sb2.append(str);
                            alarmService6.crtm = sb2.toString();
                            AlarmService.this.dhr = (int) ((((long) (100 - AlarmService.level)) * tmp) / 3600);
                            AlarmService.this.dmn = (int) (((((long) (100 - AlarmService.level)) * tmp) % 3600) / 60);
                        }
                    }
                } else {
                    pref = pref3;
                    boolean z3 = fc;
                }
                if (AlarmService.level == AlarmService.this.lvpv + 1) {
                    AlarmService alarmService7 = AlarmService.this;
                    SharedPreferences sharedPreferences = sharedPref;
                    alarmService7.f42tm = (alarmService7.ctm - AlarmService.this.f42tm) / 1000;
                    if (AlarmService.this.f39ck == 1) {
                        AlarmService.this.f39ck = 2;
                        String str6 = usernamee;
                    } else if (AlarmService.level == 100) {
                        AlarmService alarmService8 = AlarmService.this;
                        alarmService8.crtm = alarmService8.getString(R.string.noti_fullcharged);
                        String str7 = usernamee;
                    } else if (((long) (100 - AlarmService.level)) * AlarmService.this.f42tm < 3600) {
                        AlarmService alarmService9 = AlarmService.this;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(AlarmService.this.getString(R.string.noti_charging));
                        sb3.append(str2);
                        sb3.append((((long) (100 - AlarmService.level)) * AlarmService.this.f42tm) / 60);
                        sb3.append(str4);
                        sb3.append(AlarmService.this.getString(R.string.noti_minutil));
                        sb3.append(str);
                        alarmService9.crtm = sb3.toString();
                        AlarmService alarmService10 = AlarmService.this;
                        alarmService10.dhr = 0;
                        alarmService10.dmn = (int) ((((long) (100 - AlarmService.level)) * AlarmService.this.f42tm) / 60);
                        if (pref.getLong(str3, 0) == 0) {
                            Editor editor = pref.edit();
                            editor.putLong(str3, AlarmService.this.f42tm);
                            editor.apply();
                            String str8 = usernamee;
                        } else {
                            String str9 = usernamee;
                        }
                    } else {
                        AlarmService alarmService11 = AlarmService.this;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(AlarmService.this.getString(R.string.noti_charging));
                        sb4.append(str2);
                        String str10 = usernamee;
                        sb4.append((((long) (100 - AlarmService.level)) * AlarmService.this.f42tm) / 3600);
                        sb4.append(str4);
                        sb4.append(AlarmService.this.getString(R.string.noti_hr));
                        sb4.append(str4);
                        sb4.append(((((long) (100 - AlarmService.level)) * AlarmService.this.f42tm) % 3600) / 60);
                        sb4.append(str4);
                        sb4.append(AlarmService.this.getString(R.string.noti_minutil));
                        sb4.append(str);
                        alarmService11.crtm = sb4.toString();
                        AlarmService.this.dhr = (int) ((((long) (100 - AlarmService.level)) * AlarmService.this.f42tm) / 3600);
                        AlarmService.this.dmn = (int) (((((long) (100 - AlarmService.level)) * AlarmService.this.f42tm) % 3600) / 60);
                        if (pref.getLong(str3, 0) == 0) {
                            Editor editor2 = pref.edit();
                            editor2.putLong(str3, AlarmService.this.f42tm);
                            editor2.apply();
                        }
                    }
                    AlarmService.this.lvpv++;
                    AlarmService alarmService12 = AlarmService.this;
                    alarmService12.f42tm = alarmService12.ctm;
                } else {
                    String str11 = usernamee;
                }
                AlarmService alarmService13 = AlarmService.this;
                alarmService13.sendMessageToActivity(alarmService13.crtm);
                if (AlarmService.this.ckk == 0) {
                    Context context = AlarmService.this.getBaseContext();
                    PendingIntent pIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 134217728);
                    try {
                        Builder contentText = AlarmService.this.builder.setContentText(AlarmService.this.crtm);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(AlarmService.level);
                        sb5.append("% ");
                        sb5.append(AlarmService.this.getString(R.string.noti_charged));
                        contentText.setContentInfo(sb5.toString()).setContentTitle(AlarmService.this.getString(R.string.noti_title)).setSmallIcon(R.drawable.smicn).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher)).setOnlyAlertOnce(true).setContentIntent(pIntent);
                        AlarmService.this.notificationmanager.notify(0, AlarmService.this.builder.build());
                    } catch (Exception e3) {
                    }
                } else {
                    try {
                        Builder contentText2 = AlarmService.this.builder.setContentText(AlarmService.this.crtm);
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(AlarmService.level);
                        sb6.append("% Charged");
                        contentText2.setContentInfo(sb6.toString());
                        AlarmService.this.notificationmanager.notify(0, AlarmService.this.builder.build());
                    } catch (Exception e4) {
                    }
                }
            }
        };
        getApplicationContext().registerReceiver(this.mBatInfoReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        super.onStartCommand(intent, flags, startId);
        return 1;
    }

    /* access modifiers changed from: private */
    public void sendMessageToActivity(String msg) {
        Intent intent = new Intent("intentKey");
        intent.putExtra("key", msg);
        LocalBroadcastManager.getInstance(getBaseContext()).sendBroadcast(intent);
    }

    public void onCreate() {
        super.onCreate();
        this.builder = new Builder(getBaseContext());
        String str = "notification";
        this.notificationmanager = (NotificationManager) getSystemService(str);
        if (VERSION.SDK_INT >= 26) {
            String CHANNEL_ID = "my_channel_01";
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Alarm is Running please do not close App", 3);
            Object systemService = getSystemService(str);
            systemService.getClass();
            ((NotificationManager) systemService).createNotificationChannel(channel);
            startForeground(1, new Builder(this, CHANNEL_ID).setContentTitle("Alarm ON").setSmallIcon(R.drawable.smicn).setAutoCancel(true).setContentText("Closing the app may stop the alarm").build());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        NotificationManager notificationManager = this.notificationmanager;
        if (notificationManager != null) {
            try {
                notificationManager.cancel(0);
            } catch (Exception e) {
            }
        }
        if (this.mBatInfoReceiver != null) {
            getApplicationContext().unregisterReceiver(this.mBatInfoReceiver);
        }
        AlarmManager alarmManager2 = this.alarmManager;
        if (alarmManager2 != null) {
            alarmManager2.cancel(this.pendingIntent);
        }
        if (VERSION.SDK_INT >= 26) {
            stopForeground(true);
            stopSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
    }
}
