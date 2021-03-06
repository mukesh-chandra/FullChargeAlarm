package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzaj;
import com.readytofire.fullchargealarm.BuildConfig;

public final class zzbgb {
    private final String mTag;
    private final zzaj zzaIA;
    private final String zzaIc;
    private final int zzagX;

    private zzbgb(String str, String str2) {
        this.zzaIc = str2;
        this.mTag = str;
        this.zzaIA = new zzaj(str);
        this.zzagX = getLogLevel();
    }

    public zzbgb(String str, String... strArr) {
        this(str, zzb(strArr));
    }

    private final String format(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return this.zzaIc.concat(str);
    }

    private final int getLogLevel() {
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.mTag, i)) {
            i++;
        }
        return i;
    }

    private static String zzb(String... strArr) {
        if (strArr.length == 0) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (String str : strArr) {
            if (sb.length() > 1) {
                sb.append(",");
            }
            sb.append(str);
        }
        sb.append(']');
        sb.append(' ');
        return sb.toString();
    }

    private final boolean zzz(int i) {
        return this.zzagX <= i;
    }

    public final void zza(String str, Throwable th, Object... objArr) {
        Log.wtf(this.mTag, format(str, objArr), th);
    }

    public final void zza(String str, Object... objArr) {
        if (zzz(2)) {
            Log.v(this.mTag, format(str, objArr));
        }
    }

    public final void zzb(String str, Object... objArr) {
        if (zzz(3)) {
            Log.d(this.mTag, format(str, objArr));
        }
    }

    public final void zzd(Throwable th) {
        Log.wtf(this.mTag, th);
    }

    public final void zze(String str, Object... objArr) {
        Log.i(this.mTag, format(str, objArr));
    }

    public final void zzf(String str, Object... objArr) {
        Log.w(this.mTag, format(str, objArr));
    }
}
