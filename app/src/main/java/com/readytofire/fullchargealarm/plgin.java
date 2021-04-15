package com.readytofire.fullchargealarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;

public class plgin extends BroadcastReceiver {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public void onReceive(Context context, Intent intent) {
        boolean lb = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("alm_low", false);
        String str = "android.intent.action.BATTERY_CHANGED";
        new IntentFilter(str);
        if (intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED")) {
            try {
                Intent i = new Intent(context, AlarmService.class);
                i.setFlags(268435456);
                if (VERSION.SDK_INT >= 26) {
                    context.startForegroundService(i);
                } else {
                    context.startService(i);
                }
            } catch (Exception e) {
            }
            if (lb) {
                try {
                    context.stopService(new Intent(context, batterylow.class));
                } catch (Exception e2) {
                }
            }
        } else {
            try {
                context.stopService(new Intent(context, AlarmService.class));
            } catch (Exception e3) {
            }
            if (lb) {
                try {
                    Intent y = new Intent(context, batterylow.class);
                    y.setFlags(268435456);
                    if (VERSION.SDK_INT >= 26) {
                        context.startForegroundService(y);
                    } else {
                        context.startService(y);
                    }
                } catch (Exception e4) {
                }
            }
        }
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            int plugged = context.registerReceiver(null, new IntentFilter(str)).getIntExtra("plugged", -1);
            if (plugged == 1 || plugged == 2) {
                try {
                    Intent i2 = new Intent(context, AlarmService.class);
                    i2.setFlags(268435456);
                    if (VERSION.SDK_INT >= 26) {
                        context.startForegroundService(i2);
                    } else {
                        context.startService(i2);
                    }
                } catch (Exception e5) {
                }
            } else if (lb) {
                try {
                    Intent y2 = new Intent(context, batterylow.class);
                    y2.setFlags(268435456);
                    if (VERSION.SDK_INT >= 26) {
                        context.startForegroundService(y2);
                    } else {
                        context.startService(y2);
                    }
                } catch (Exception e6) {
                }
            }
        }
    }
}
