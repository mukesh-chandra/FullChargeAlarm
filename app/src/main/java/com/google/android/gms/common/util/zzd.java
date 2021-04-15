package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.internal.zzbha;

public final class zzd {
    public static int zzA(Context context, String str) {
        PackageInfo zzB = zzB(context, str);
        if (zzB == null || zzB.applicationInfo == null) {
            return -1;
        }
        Bundle bundle = zzB.applicationInfo.metaData;
        if (bundle == null) {
            return -1;
        }
        return bundle.getInt("com.google.android.gms.version", -1);
    }

    private static PackageInfo zzB(Context context, String str) {
        try {
            return zzbha.zzaP(context).getPackageInfo(str, 128);
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean zzC(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            if ((zzbha.zzaP(context).getApplicationInfo(str, 0).flags & 2097152) != 0) {
                return true;
            }
        } catch (NameNotFoundException unused) {
        }
        return false;
    }
}
