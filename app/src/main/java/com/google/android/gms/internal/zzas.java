package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import java.io.File;

public final class zzas {
    public static zzs zza(Context context, zzan zzan) {
        String str;
        File file = new File(context.getCacheDir(), "volley");
        try {
            String packageName = context.getPackageName();
            int i = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
            StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 12);
            sb.append(packageName);
            sb.append("/");
            sb.append(i);
            str = sb.toString();
        } catch (NameNotFoundException unused) {
            str = "volley/0";
        }
        zzs zzs = new zzs(new zzag(file), new zzad(VERSION.SDK_INT >= 9 ? new zzao() : new zzak(AndroidHttpClient.newInstance(str))));
        zzs.start();
        return zzs;
    }
}
