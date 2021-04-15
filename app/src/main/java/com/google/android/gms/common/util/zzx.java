package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.internal.zzbha;
import com.readytofire.fullchargealarm.BuildConfig;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzx {
    private static final Method zzaJZ = zzsg();
    private static final Method zzaKa = zzsh();
    private static final Method zzaKb = zzsi();
    private static final Method zzaKc = zzsj();
    private static final Method zzaKd = zzsk();

    public static WorkSource zzD(Context context, String str) {
        String str2 = "WorkSourceUtil";
        if (!(context == null || context.getPackageManager() == null)) {
            try {
                ApplicationInfo applicationInfo = zzbha.zzaP(context).getApplicationInfo(str, 0);
                if (applicationInfo != null) {
                    return zze(applicationInfo.uid, str);
                }
                String str3 = "Could not get applicationInfo from package: ";
                String valueOf = String.valueOf(str);
                Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                return null;
            } catch (NameNotFoundException unused) {
                String str4 = "Could not find package: ";
                String valueOf2 = String.valueOf(str);
                Log.e(str2, valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4));
            }
        }
        return null;
    }

    private static int zza(WorkSource workSource) {
        Method method = zzaKb;
        if (method != null) {
            try {
                return ((Integer) method.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    private static String zza(WorkSource workSource, int i) {
        Method method = zzaKd;
        if (method != null) {
            try {
                return (String) method.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return null;
    }

    public static boolean zzaM(Context context) {
        if (context == null || context.getPackageManager() == null) {
            return false;
        }
        return zzbha.zzaP(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0;
    }

    public static List<String> zzb(WorkSource workSource) {
        int zza = workSource == null ? 0 : zza(workSource);
        if (zza == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < zza; i++) {
            String zza2 = zza(workSource, i);
            if (!zzt.zzcL(zza2)) {
                arrayList.add(zza2);
            }
        }
        return arrayList;
    }

    private static WorkSource zze(int i, String str) {
        WorkSource workSource = new WorkSource();
        String str2 = "Unable to assign blame through WorkSource";
        String str3 = "WorkSourceUtil";
        if (zzaKa != null) {
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            try {
                zzaKa.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Exception e) {
                Log.wtf(str3, str2, e);
            }
        } else {
            Method method = zzaJZ;
            if (method != null) {
                method.invoke(workSource, new Object[]{Integer.valueOf(i)});
            }
        }
        return workSource;
    }

    private static Method zzsg() {
        try {
            return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method zzsh() {
        if (zzq.zzsb()) {
            try {
                return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static Method zzsi() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method zzsj() {
        try {
            return WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method zzsk() {
        if (zzq.zzsb()) {
            try {
                return WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
