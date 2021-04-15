package com.readytofire.fullchargealarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import androidx.legacy.content.WakefulBroadcastReceiver;

public class AlarmReceiver extends WakefulBroadcastReceiver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    WakeLock wakeLock;

    public void onReceive(Context context, Intent intent) {
        this.wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(268435482, "TAG");
        this.wakeLock.acquire(600000);
        Intent in = new Intent(context, AlramDialog.class);
        in.addFlags(268435456);
        context.startActivity(in);
        this.wakeLock.release();
    }
}
