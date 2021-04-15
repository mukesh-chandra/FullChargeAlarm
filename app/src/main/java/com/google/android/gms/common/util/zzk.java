package com.google.android.gms.common.util;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

public final class zzk {
    private static IntentFilter zzaJO = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long zzaJP;
    private static float zzaJQ = Float.NaN;

    public static int zzaK(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzaJO);
        int i = 0;
        if (((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0) {
            i = 1;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return ((zzq.zzsd() ? powerManager.isInteractive() : powerManager.isScreenOn() ? 1 : 0) << true) | i;
    }

    public static synchronized float zzaL(Context context) {
        synchronized (zzk.class) {
            if (SystemClock.elapsedRealtime() - zzaJP >= 60000 || Float.isNaN(zzaJQ)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzaJO);
                if (registerReceiver != null) {
                    zzaJQ = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                zzaJP = SystemClock.elapsedRealtime();
                float f = zzaJQ;
                return f;
            }
            float f2 = zzaJQ;
            return f2;
        }
    }
}
