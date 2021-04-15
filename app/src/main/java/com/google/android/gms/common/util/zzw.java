package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.zzp;
import com.google.android.gms.internal.zzbha;

public final class zzw {
    public static boolean zzb(Context context, int i, String str) {
        return zzbha.zzaP(context).zzf(i, str);
    }

    public static boolean zzf(Context context, int i) {
        String str = "com.google.android.gms";
        if (!zzb(context, i, str)) {
            return false;
        }
        try {
            return zzp.zzax(context).zza(context.getPackageManager(), context.getPackageManager().getPackageInfo(str, 64));
        } catch (NameNotFoundException unused) {
            String str2 = "UidVerifier";
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }
}
