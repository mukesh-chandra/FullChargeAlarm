package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.internal.zzbha;

public class zzp {
    private static zzp zzaAu;
    private final Context mContext;

    private zzp(Context context) {
        this.mContext = context.getApplicationContext();
    }

    static zzg zza(PackageInfo packageInfo, zzg... zzgArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzh zzh = new zzh(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzgArr.length; i++) {
            if (zzgArr[i].equals(zzh)) {
                return zzgArr[i];
            }
        }
        return null;
    }

    private static boolean zza(PackageInfo packageInfo, boolean z) {
        zzg zzg;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                zzg = zza(packageInfo, zzj.zzaAk);
            } else {
                zzg = zza(packageInfo, zzj.zzaAk[0]);
            }
            if (zzg != null) {
                return true;
            }
        }
        return false;
    }

    public static zzp zzax(Context context) {
        zzbo.zzu(context);
        synchronized (zzp.class) {
            if (zzaAu == null) {
                zzf.zzav(context);
                zzaAu = new zzp(context);
            }
        }
        return zzaAu;
    }

    private static boolean zzb(PackageInfo packageInfo, boolean z) {
        String str = "GoogleSignatureVerifier";
        if (packageInfo.signatures.length != 1) {
            Log.w(str, "Package has more than one signature.");
            return false;
        }
        zzh zzh = new zzh(packageInfo.signatures[0].toByteArray());
        String str2 = packageInfo.packageName;
        boolean zzb = z ? zzf.zzb(str2, zzh) : zzf.zza(str2, zzh);
        if (!zzb) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("Cert not in list. atk=");
            sb.append(z);
            Log.d(str, sb.toString());
        }
        return zzb;
    }

    private final boolean zzct(String str) {
        try {
            PackageInfo packageInfo = zzbha.zzaP(this.mContext).getPackageInfo(str, 64);
            if (packageInfo == null) {
                return false;
            }
            if (zzo.zzaw(this.mContext)) {
                return zzb(packageInfo, true);
            }
            boolean zzb = zzb(packageInfo, false);
            if (!zzb && zzb(packageInfo, true)) {
                Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
            }
            return zzb;
        } catch (NameNotFoundException unused) {
            return false;
        }
    }

    @Deprecated
    public final boolean zza(PackageManager packageManager, int i) {
        String[] packagesForUid = zzbha.zzaP(this.mContext).getPackagesForUid(i);
        if (!(packagesForUid == null || packagesForUid.length == 0)) {
            for (String zzct : packagesForUid) {
                if (zzct(zzct)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Deprecated
    public final boolean zza(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo != null) {
            if (zza(packageInfo, false)) {
                return true;
            }
            if (zza(packageInfo, true)) {
                if (zzo.zzaw(this.mContext)) {
                    return true;
                }
                Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
            }
        }
        return false;
    }
}
