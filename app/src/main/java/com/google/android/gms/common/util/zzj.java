package com.google.android.gms.common.util;

import android.content.Context;

public final class zzj {
    private static Boolean zzaJJ;
    private static Boolean zzaJK;
    private static Boolean zzaJL;
    private static Boolean zzaJM;
    private static Boolean zzaJN;

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        if (zzaJK.booleanValue() != false) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(android.content.res.Resources r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.Boolean r1 = zzaJJ
            if (r1 != 0) goto L_0x0045
            android.content.res.Configuration r1 = r4.getConfiguration()
            int r1 = r1.screenLayout
            r1 = r1 & 15
            r2 = 3
            r3 = 1
            if (r1 <= r2) goto L_0x0016
            r1 = 1
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            if (r1 != 0) goto L_0x003e
            java.lang.Boolean r1 = zzaJK
            if (r1 != 0) goto L_0x0036
            android.content.res.Configuration r4 = r4.getConfiguration()
            int r1 = r4.screenLayout
            r1 = r1 & 15
            if (r1 > r2) goto L_0x002f
            int r4 = r4.smallestScreenWidthDp
            r1 = 600(0x258, float:8.41E-43)
            if (r4 < r1) goto L_0x002f
            r4 = 1
            goto L_0x0030
        L_0x002f:
            r4 = 0
        L_0x0030:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            zzaJK = r4
        L_0x0036:
            java.lang.Boolean r4 = zzaJK
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x003f
        L_0x003e:
            r0 = 1
        L_0x003f:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            zzaJJ = r4
        L_0x0045:
            java.lang.Boolean r4 = zzaJJ
            boolean r4 = r4.booleanValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.zzj.zza(android.content.res.Resources):boolean");
    }

    public static boolean zzaG(Context context) {
        if (zzaJL == null) {
            zzaJL = Boolean.valueOf(zzq.zzsd() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return zzaJL.booleanValue();
    }

    public static boolean zzaH(Context context) {
        return (!zzq.isAtLeastN() || zzaI(context)) && zzaG(context);
    }

    public static boolean zzaI(Context context) {
        if (zzaJM == null) {
            zzaJM = Boolean.valueOf(zzq.zzse() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zzaJM.booleanValue();
    }

    public static boolean zzaJ(Context context) {
        if (zzaJN == null) {
            zzaJN = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return zzaJN.booleanValue();
    }
}
