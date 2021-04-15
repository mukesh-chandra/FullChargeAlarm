package com.readytofire.fullchargealarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.preference.PreferenceManager;
import androidx.core.app.NotificationCompat;

public class batterylow extends Service {
    AlarmManager alarmManager;

    /* renamed from: i */
    int f74i = 0;

    /* renamed from: lb */
    public int f75lb;
    public int level;
    private BroadcastReceiver mBr;
    PendingIntent pendingIntent;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            this.f75lb = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("key_low_lvl", "20"));
        } catch (NumberFormatException e) {
            this.f75lb = 20;
        }
        this.mBr = new BroadcastReceiver() {
            public void onReceive(Context arg0, Intent intent) {
                batterylow.this.level = intent.getIntExtra("level", 0);
                if (batterylow.this.level == batterylow.this.f75lb && batterylow.this.f74i == 0) {
                    try {
                        long twsec = System.currentTimeMillis() + 1000;
                        batterylow.this.alarmManager = (AlarmManager) batterylow.this.getSystemService(NotificationCompat.CATEGORY_ALARM);
                        batterylow.this.f74i = 1;
                        Intent myIntent = new Intent(batterylow.this, BatlowRec.class);
                        batterylow.this.pendingIntent = PendingIntent.getBroadcast(batterylow.this, 0, myIntent, 0);
                        batterylow.this.alarmManager.set(0, twsec, batterylow.this.pendingIntent);
                    } catch (Exception e) {
                        batterylow.this.f74i = 0;
                    }
                }
            }
        };
        getApplicationContext().registerReceiver(this.mBr, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return super.onStartCommand(intent, flags, startId);
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.mBr != null) {
            getApplicationContext().unregisterReceiver(this.mBr);
        }
        AlarmManager alarmManager2 = this.alarmManager;
        if (alarmManager2 != null) {
            alarmManager2.cancel(this.pendingIntent);
        }
    }
}
