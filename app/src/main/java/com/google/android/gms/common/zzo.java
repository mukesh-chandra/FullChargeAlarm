package com.google.android.gms.common;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri.Builder;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.C0481R;
import com.google.android.gms.common.internal.zzbd;
import com.google.android.gms.common.util.zzj;
import com.google.android.gms.common.util.zzw;
import com.google.android.gms.internal.zzbha;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class zzo {
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 11020000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    private static boolean zzaAo = false;
    private static boolean zzaAp = false;
    private static boolean zzaAq = false;
    private static boolean zzaAr = false;
    static final AtomicBoolean zzaAs = new AtomicBoolean();
    private static final AtomicBoolean zzaAt = new AtomicBoolean();

    zzo() {
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zze.zzoW().getErrorResolutionPendingIntent(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.getStatusString(i);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(new Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build());
            String next = new Scanner(openInputStream).useDelimiter("\\A").next();
            if (openInputStream != null) {
                openInputStream.close();
            }
            return next;
        } catch (NoSuchElementException unused) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            return null;
        } catch (Exception unused2) {
            return null;
        } catch (Throwable th) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            throw th;
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        String str;
        String str2 = "GooglePlayServicesUtil";
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C0481R.string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e(str2, "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        String str3 = "com.google.android.gms";
        String str4 = " but found ";
        if (!str3.equals(context.getPackageName()) && !zzaAt.get()) {
            int zzaE = zzbd.zzaE(context);
            if (zzaE != 0) {
                int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
                if (zzaE != i) {
                    String str5 = "com.google.android.gms.version";
                    StringBuilder sb = new StringBuilder(str5.length() + 290);
                    sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                    sb.append(i);
                    sb.append(str4);
                    sb.append(zzaE);
                    sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"");
                    sb.append(str5);
                    sb.append("\" android:value=\"@integer/google_play_services_version\" />");
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
        boolean z = !zzj.zzaH(context) && !zzj.zzaJ(context);
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 8256);
            } catch (NameNotFoundException unused2) {
                str = "Google Play Store is missing.";
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo(str3, 64);
            zzp.zzax(context);
            String str6 = "Google Play services signature invalid.";
            if (z) {
                zzg zza = zzp.zza(packageInfo, zzj.zzaAk);
                if (zza == null) {
                    str = "Google Play Store signature invalid.";
                    Log.w(str2, str);
                    return 9;
                }
                if (zzp.zza(packageInfo2, zza) == null) {
                    Log.w(str2, str6);
                    return 9;
                }
            } else if (zzp.zza(packageInfo2, zzj.zzaAk) == null) {
                Log.w(str2, str6);
                return 9;
            }
            if (packageInfo2.versionCode / 1000 < GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000) {
                int i2 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
                int i3 = packageInfo2.versionCode;
                StringBuilder sb2 = new StringBuilder(77);
                sb2.append("Google Play services out of date.  Requires ");
                sb2.append(i2);
                sb2.append(str4);
                sb2.append(i3);
                Log.w(str2, sb2.toString());
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo(str3, 0);
                } catch (NameNotFoundException e) {
                    Log.wtf(str2, "Google Play services missing when getting application info.", e);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException unused3) {
            Log.w(str2, "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    @Deprecated
    public static void zzah(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = zze.zzoW().isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            zze.zzoW();
            Intent zza = zze.zza(context, isGooglePlayServicesAvailable, "e");
            StringBuilder sb = new StringBuilder(57);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(isGooglePlayServicesAvailable);
            Log.e("GooglePlayServicesUtil", sb.toString());
            if (zza == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", zza);
        }
    }

    @Deprecated
    public static void zzat(Context context) {
        if (!zzaAs.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            } catch (SecurityException unused) {
            }
        }
    }

    @Deprecated
    public static int zzau(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    public static boolean zzaw(Context context) {
        if (!zzaAr) {
            try {
                PackageInfo packageInfo = zzbha.zzaP(context).getPackageInfo("com.google.android.gms", 64);
                if (packageInfo != null) {
                    zzp.zzax(context);
                    if (zzp.zza(packageInfo, zzj.zzaAk[1]) != null) {
                        zzaAq = true;
                        zzaAr = true;
                    }
                }
                zzaAq = false;
            } catch (NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
            } catch (Throwable th) {
                zzaAr = true;
                throw th;
            }
            zzaAr = true;
        }
        if (!zzaAq) {
            return !"user".equals(Build.TYPE);
        }
    }

    @Deprecated
    public static boolean zzb(Context context, int i, String str) {
        return zzw.zzb(context, i, str);
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zzy(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean zzf(Context context, int i) {
        return zzw.zzf(context, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean zzy(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "com.google.android.gms"
            boolean r0 = r6.equals(r0)
            boolean r1 = com.google.android.gms.common.util.zzq.zzse()
            r2 = 1
            if (r1 == 0) goto L_0x0034
            android.content.pm.PackageManager r1 = r5.getPackageManager()
            android.content.pm.PackageInstaller r1 = r1.getPackageInstaller()
            java.util.List r1 = r1.getAllSessions()
            java.util.Iterator r1 = r1.iterator()
        L_0x001d:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0034
            java.lang.Object r3 = r1.next()
            android.content.pm.PackageInstaller$SessionInfo r3 = (android.content.pm.PackageInstaller.SessionInfo) r3
            java.lang.String r3 = r3.getAppPackageName()
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x001d
            return r2
        L_0x0034:
            android.content.pm.PackageManager r1 = r5.getPackageManager()
            r3 = 8192(0x2000, float:1.14794E-41)
            r4 = 0
            android.content.pm.ApplicationInfo r6 = r1.getApplicationInfo(r6, r3)     // Catch:{ NameNotFoundException -> 0x0074 }
            if (r0 == 0) goto L_0x0044
            boolean r5 = r6.enabled     // Catch:{ NameNotFoundException -> 0x0074 }
            return r5
        L_0x0044:
            boolean r6 = r6.enabled     // Catch:{ NameNotFoundException -> 0x0074 }
            if (r6 == 0) goto L_0x0074
            boolean r6 = com.google.android.gms.common.util.zzq.zzsb()     // Catch:{ NameNotFoundException -> 0x0074 }
            if (r6 == 0) goto L_0x0070
            java.lang.String r6 = "user"
            java.lang.Object r6 = r5.getSystemService(r6)     // Catch:{ NameNotFoundException -> 0x0074 }
            android.os.UserManager r6 = (android.os.UserManager) r6     // Catch:{ NameNotFoundException -> 0x0074 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ NameNotFoundException -> 0x0074 }
            android.os.Bundle r5 = r6.getApplicationRestrictions(r5)     // Catch:{ NameNotFoundException -> 0x0074 }
            if (r5 == 0) goto L_0x0070
            java.lang.String r6 = "true"
            java.lang.String r0 = "restricted_profile"
            java.lang.String r5 = r5.getString(r0)     // Catch:{ NameNotFoundException -> 0x0074 }
            boolean r5 = r6.equals(r5)     // Catch:{ NameNotFoundException -> 0x0074 }
            if (r5 == 0) goto L_0x0070
            r5 = 1
            goto L_0x0071
        L_0x0070:
            r5 = 0
        L_0x0071:
            if (r5 != 0) goto L_0x0074
            return r2
        L_0x0074:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzo.zzy(android.content.Context, java.lang.String):boolean");
    }
}
