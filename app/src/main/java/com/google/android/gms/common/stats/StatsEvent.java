package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public abstract class StatsEvent extends zza implements ReflectedParcelable {
    public abstract int getEventType();

    public abstract long getTimeMillis();

    public String toString() {
        long timeMillis = getTimeMillis();
        int eventType = getEventType();
        long zzrV = zzrV();
        String valueOf = String.valueOf(zzrW());
        String str = "\t";
        StringBuilder sb = new StringBuilder(str.length() + 51 + str.length() + String.valueOf(valueOf).length());
        sb.append(timeMillis);
        sb.append(str);
        sb.append(eventType);
        sb.append(str);
        sb.append(zzrV);
        sb.append(valueOf);
        return sb.toString();
    }

    public abstract long zzrV();

    public abstract String zzrW();
}
