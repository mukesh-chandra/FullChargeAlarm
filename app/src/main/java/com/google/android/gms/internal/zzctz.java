package com.google.android.gms.internal;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.common.util.zzx;

public final class zzctz {
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private static String zzbCW = "*gcore*:";
    private final Context mContext;
    private final String zzaJp;
    private final String zzaJr;
    private final WakeLock zzbCX;
    private WorkSource zzbCY;
    private final int zzbCZ;
    private final String zzbDa;
    private boolean zzbDb;
    private int zzbDc;
    private int zzbDd;

    public zzctz(Context context, int i, String str) {
        this(context, 1, str, null, context == null ? null : context.getPackageName());
    }

    private zzctz(Context context, int i, String str, String str2, String str3) {
        this(context, 1, str, null, str3, null);
    }

    private zzctz(Context context, int i, String str, String str2, String str3, String str4) {
        this.zzbDb = true;
        zzbo.zzh(str, "Wake lock name can NOT be empty");
        this.zzbCZ = i;
        this.zzbDa = null;
        this.zzaJr = null;
        this.mContext = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(zzbCW);
            String valueOf2 = String.valueOf(str);
            this.zzaJp = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            this.zzaJp = str;
        }
        this.zzbCX = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zzx.zzaM(this.mContext)) {
            if (zzt.zzcL(str3)) {
                str3 = context.getPackageName();
            }
            this.zzbCY = zzx.zzD(context, str3);
            WorkSource workSource = this.zzbCY;
            if (workSource != null && zzx.zzaM(this.mContext)) {
                WorkSource workSource2 = this.zzbCY;
                if (workSource2 != null) {
                    workSource2.add(workSource);
                } else {
                    this.zzbCY = workSource;
                }
                try {
                    this.zzbCX.setWorkSource(this.zzbCY);
                } catch (IllegalArgumentException e) {
                    Log.wtf(TAG, e.toString());
                }
            }
        }
    }

    private final boolean zzeV(String str) {
        String str2 = null;
        return !TextUtils.isEmpty(str2) && !str2.equals(this.zzbDa);
    }

    private final String zzi(String str, boolean z) {
        if (!this.zzbDb) {
            return this.zzbDa;
        }
        if (z) {
            return null;
        }
        return this.zzbDa;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r10.zzbDd == 0) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r12 == false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void acquire(long r11) {
        /*
            r10 = this;
            r11 = 0
            boolean r12 = r10.zzeV(r11)
            java.lang.String r4 = r10.zzi(r11, r12)
            monitor-enter(r10)
            boolean r11 = r10.zzbDb     // Catch:{ all -> 0x004b }
            if (r11 == 0) goto L_0x0018
            int r11 = r10.zzbDc     // Catch:{ all -> 0x004b }
            int r0 = r11 + 1
            r10.zzbDc = r0     // Catch:{ all -> 0x004b }
            if (r11 == 0) goto L_0x0020
            if (r12 != 0) goto L_0x0020
        L_0x0018:
            boolean r11 = r10.zzbDb     // Catch:{ all -> 0x004b }
            if (r11 != 0) goto L_0x0042
            int r11 = r10.zzbDd     // Catch:{ all -> 0x004b }
            if (r11 != 0) goto L_0x0042
        L_0x0020:
            com.google.android.gms.common.stats.zze.zzrX()     // Catch:{ all -> 0x004b }
            android.content.Context r0 = r10.mContext     // Catch:{ all -> 0x004b }
            android.os.PowerManager$WakeLock r11 = r10.zzbCX     // Catch:{ all -> 0x004b }
            java.lang.String r1 = com.google.android.gms.common.stats.zzc.zza(r11, r4)     // Catch:{ all -> 0x004b }
            r2 = 7
            java.lang.String r3 = r10.zzaJp     // Catch:{ all -> 0x004b }
            r5 = 0
            int r6 = r10.zzbCZ     // Catch:{ all -> 0x004b }
            android.os.WorkSource r11 = r10.zzbCY     // Catch:{ all -> 0x004b }
            java.util.List r7 = com.google.android.gms.common.util.zzx.zzb(r11)     // Catch:{ all -> 0x004b }
            r8 = 1000(0x3e8, double:4.94E-321)
            com.google.android.gms.common.stats.zze.zza(r0, r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x004b }
            int r11 = r10.zzbDd     // Catch:{ all -> 0x004b }
            int r11 = r11 + 1
            r10.zzbDd = r11     // Catch:{ all -> 0x004b }
        L_0x0042:
            monitor-exit(r10)     // Catch:{ all -> 0x004b }
            android.os.PowerManager$WakeLock r11 = r10.zzbCX
            r0 = 1000(0x3e8, double:4.94E-321)
            r11.acquire(r0)
            return
        L_0x004b:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x004b }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzctz.acquire(long):void");
    }

    public final boolean isHeld() {
        return this.zzbCX.isHeld();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r11.zzbDd == 1) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r1 == false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void release() {
        /*
            r11 = this;
            r0 = 0
            boolean r1 = r11.zzeV(r0)
            java.lang.String r6 = r11.zzi(r0, r1)
            monitor-enter(r11)
            boolean r0 = r11.zzbDb     // Catch:{ all -> 0x0047 }
            r10 = 1
            if (r0 == 0) goto L_0x0018
            int r0 = r11.zzbDc     // Catch:{ all -> 0x0047 }
            int r0 = r0 - r10
            r11.zzbDc = r0     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0020
            if (r1 != 0) goto L_0x0020
        L_0x0018:
            boolean r0 = r11.zzbDb     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0040
            int r0 = r11.zzbDd     // Catch:{ all -> 0x0047 }
            if (r0 != r10) goto L_0x0040
        L_0x0020:
            com.google.android.gms.common.stats.zze.zzrX()     // Catch:{ all -> 0x0047 }
            android.content.Context r2 = r11.mContext     // Catch:{ all -> 0x0047 }
            android.os.PowerManager$WakeLock r0 = r11.zzbCX     // Catch:{ all -> 0x0047 }
            java.lang.String r3 = com.google.android.gms.common.stats.zzc.zza(r0, r6)     // Catch:{ all -> 0x0047 }
            r4 = 8
            java.lang.String r5 = r11.zzaJp     // Catch:{ all -> 0x0047 }
            r7 = 0
            int r8 = r11.zzbCZ     // Catch:{ all -> 0x0047 }
            android.os.WorkSource r0 = r11.zzbCY     // Catch:{ all -> 0x0047 }
            java.util.List r9 = com.google.android.gms.common.util.zzx.zzb(r0)     // Catch:{ all -> 0x0047 }
            com.google.android.gms.common.stats.zze.zza(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0047 }
            int r0 = r11.zzbDd     // Catch:{ all -> 0x0047 }
            int r0 = r0 - r10
            r11.zzbDd = r0     // Catch:{ all -> 0x0047 }
        L_0x0040:
            monitor-exit(r11)     // Catch:{ all -> 0x0047 }
            android.os.PowerManager$WakeLock r0 = r11.zzbCX
            r0.release()
            return
        L_0x0047:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0047 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzctz.release():void");
    }

    public final void setReferenceCounted(boolean z) {
        this.zzbCX.setReferenceCounted(false);
        this.zzbDb = false;
    }
}
