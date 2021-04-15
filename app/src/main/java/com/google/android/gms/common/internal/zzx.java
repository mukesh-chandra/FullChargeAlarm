package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;

public final class zzx extends zza {
    public static final Creator<zzx> CREATOR = new zzy();
    private int version;
    Account zzaHA;
    zzc[] zzaHB;
    private int zzaHu;
    private int zzaHv;
    String zzaHw;
    IBinder zzaHx;
    Scope[] zzaHy;
    Bundle zzaHz;

    public zzx(int i) {
        this.version = 3;
        this.zzaHv = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzaHu = i;
    }

    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.accounts.Account] */
    /* JADX WARNING: type inference failed for: r1v3, types: [com.google.android.gms.common.internal.zzal] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.accounts.Account] */
    /* JADX WARNING: type inference failed for: r1v7, types: [com.google.android.gms.common.internal.zzan] */
    /* JADX WARNING: type inference failed for: r1v8, types: [com.google.android.gms.common.internal.zzal] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v1
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.common.internal.zzan, android.accounts.Account, com.google.android.gms.common.internal.zzal]
      uses: [android.accounts.Account, com.google.android.gms.common.internal.zzal]
      mth insns count: 29
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzx(int r1, int r2, int r3, java.lang.String r4, android.os.IBinder r5, com.google.android.gms.common.api.Scope[] r6, android.os.Bundle r7, android.accounts.Account r8, com.google.android.gms.common.zzc[] r9) {
        /*
            r0 = this;
            r0.<init>()
            r0.version = r1
            r0.zzaHu = r2
            r0.zzaHv = r3
            java.lang.String r2 = "com.google.android.gms"
            boolean r3 = r2.equals(r4)
            if (r3 == 0) goto L_0x0014
            r0.zzaHw = r2
            goto L_0x0016
        L_0x0014:
            r0.zzaHw = r4
        L_0x0016:
            r2 = 2
            if (r1 >= r2) goto L_0x0038
            r1 = 0
            if (r5 == 0) goto L_0x0035
            if (r5 != 0) goto L_0x001f
            goto L_0x0031
        L_0x001f:
            java.lang.String r1 = "com.google.android.gms.common.internal.IAccountAccessor"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.common.internal.zzal
            if (r2 == 0) goto L_0x002c
            com.google.android.gms.common.internal.zzal r1 = (com.google.android.gms.common.internal.zzal) r1
            goto L_0x0031
        L_0x002c:
            com.google.android.gms.common.internal.zzan r1 = new com.google.android.gms.common.internal.zzan
            r1.<init>(r5)
        L_0x0031:
            android.accounts.Account r1 = com.google.android.gms.common.internal.zza.zza(r1)
        L_0x0035:
            r0.zzaHA = r1
            goto L_0x003c
        L_0x0038:
            r0.zzaHx = r5
            r0.zzaHA = r8
        L_0x003c:
            r0.zzaHy = r6
            r0.zzaHz = r7
            r0.zzaHB = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzx.<init>(int, int, int, java.lang.String, android.os.IBinder, com.google.android.gms.common.api.Scope[], android.os.Bundle, android.accounts.Account, com.google.android.gms.common.zzc[]):void");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.version);
        zzd.zzc(parcel, 2, this.zzaHu);
        zzd.zzc(parcel, 3, this.zzaHv);
        zzd.zza(parcel, 4, this.zzaHw, false);
        zzd.zza(parcel, 5, this.zzaHx, false);
        zzd.zza(parcel, 6, (T[]) this.zzaHy, i, false);
        zzd.zza(parcel, 7, this.zzaHz, false);
        zzd.zza(parcel, 8, (Parcelable) this.zzaHA, i, false);
        zzd.zza(parcel, 10, (T[]) this.zzaHB, i, false);
        zzd.zzI(parcel, zze);
    }
}
