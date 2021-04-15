package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzcqn extends zza {
    public static final Creator<zzcqn> CREATOR = new zzcqt();
    private static byte[][] zzazi = new byte[0][];
    private static zzcqn zzbAc;
    private static final zzcqs zzbAl = new zzcqo();
    private static final zzcqs zzbAm = new zzcqp();
    private static final zzcqs zzbAn = new zzcqq();
    private static final zzcqs zzbAo = new zzcqr();
    private String zzbAd;
    private byte[] zzbAe;
    private byte[][] zzbAf;
    private byte[][] zzbAg;
    private byte[][] zzbAh;
    private byte[][] zzbAi;
    private int[] zzbAj;
    private byte[][] zzbAk;

    /* JADX WARNING: type inference failed for: r0v4, types: [com.google.android.gms.internal.zzcqo, com.google.android.gms.internal.zzcqs] */
    /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.internal.zzcqp, com.google.android.gms.internal.zzcqs] */
    /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.internal.zzcqq, com.google.android.gms.internal.zzcqs] */
    /* JADX WARNING: type inference failed for: r0v7, types: [com.google.android.gms.internal.zzcqr, com.google.android.gms.internal.zzcqs] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v4, types: [com.google.android.gms.internal.zzcqo, com.google.android.gms.internal.zzcqs]
      assigns: [com.google.android.gms.internal.zzcqo]
      uses: [com.google.android.gms.internal.zzcqs]
      mth insns count: 20
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
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    static {
        /*
            com.google.android.gms.internal.zzcqt r0 = new com.google.android.gms.internal.zzcqt
            r0.<init>()
            CREATOR = r0
            r0 = 0
            byte[][] r0 = new byte[r0][]
            zzazi = r0
            com.google.android.gms.internal.zzcqn r0 = new com.google.android.gms.internal.zzcqn
            byte[][] r7 = zzazi
            java.lang.String r2 = ""
            r3 = 0
            r8 = 0
            r9 = 0
            r1 = r0
            r4 = r7
            r5 = r7
            r6 = r7
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            zzbAc = r0
            com.google.android.gms.internal.zzcqo r0 = new com.google.android.gms.internal.zzcqo
            r0.<init>()
            zzbAl = r0
            com.google.android.gms.internal.zzcqp r0 = new com.google.android.gms.internal.zzcqp
            r0.<init>()
            zzbAm = r0
            com.google.android.gms.internal.zzcqq r0 = new com.google.android.gms.internal.zzcqq
            r0.<init>()
            zzbAn = r0
            com.google.android.gms.internal.zzcqr r0 = new com.google.android.gms.internal.zzcqr
            r0.<init>()
            zzbAo = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcqn.<clinit>():void");
    }

    public zzcqn(String str, byte[] bArr, byte[][] bArr2, byte[][] bArr3, byte[][] bArr4, byte[][] bArr5, int[] iArr, byte[][] bArr6) {
        this.zzbAd = str;
        this.zzbAe = bArr;
        this.zzbAf = bArr2;
        this.zzbAg = bArr3;
        this.zzbAh = bArr4;
        this.zzbAi = bArr5;
        this.zzbAj = iArr;
        this.zzbAk = bArr6;
    }

    private static void zza(StringBuilder sb, String str, int[] iArr) {
        String str2;
        sb.append(str);
        sb.append("=");
        if (iArr == null) {
            str2 = "null";
        } else {
            sb.append("(");
            int length = iArr.length;
            int i = 0;
            boolean z = true;
            while (i < length) {
                int i2 = iArr[i];
                if (!z) {
                    sb.append(", ");
                }
                sb.append(i2);
                i++;
                z = false;
            }
            str2 = ")";
        }
        sb.append(str2);
    }

    private static void zza(StringBuilder sb, String str, byte[][] bArr) {
        String str2;
        sb.append(str);
        sb.append("=");
        if (bArr == null) {
            str2 = "null";
        } else {
            sb.append("(");
            int length = bArr.length;
            int i = 0;
            boolean z = true;
            while (i < length) {
                byte[] bArr2 = bArr[i];
                if (!z) {
                    sb.append(", ");
                }
                String str3 = "'";
                sb.append(str3);
                sb.append(Base64.encodeToString(bArr2, 3));
                sb.append(str3);
                i++;
                z = false;
            }
            str2 = ")";
        }
        sb.append(str2);
    }

    private static List<String> zzb(byte[][] bArr) {
        if (bArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte[] encodeToString : bArr) {
            arrayList.add(Base64.encodeToString(encodeToString, 3));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static List<Integer> zzc(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzcqn) {
            zzcqn zzcqn = (zzcqn) obj;
            if (zzcqu.equals(this.zzbAd, zzcqn.zzbAd) && Arrays.equals(this.zzbAe, zzcqn.zzbAe) && zzcqu.equals(zzb(this.zzbAf), zzb(zzcqn.zzbAf)) && zzcqu.equals(zzb(this.zzbAg), zzb(zzcqn.zzbAg)) && zzcqu.equals(zzb(this.zzbAh), zzb(zzcqn.zzbAh)) && zzcqu.equals(zzb(this.zzbAi), zzb(zzcqn.zzbAi)) && zzcqu.equals(zzc(this.zzbAj), zzc(zzcqn.zzbAj)) && zzcqu.equals(zzb(this.zzbAk), zzb(zzcqn.zzbAk))) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ExperimentTokens");
        sb.append("(");
        String str2 = this.zzbAd;
        String str3 = "null";
        String str4 = "'";
        if (str2 == null) {
            str = str3;
        } else {
            StringBuilder sb2 = new StringBuilder(str4.length() + String.valueOf(str2).length() + str4.length());
            sb2.append(str4);
            sb2.append(str2);
            sb2.append(str4);
            str = sb2.toString();
        }
        sb.append(str);
        String str5 = ", ";
        sb.append(str5);
        byte[] bArr = this.zzbAe;
        sb.append("direct");
        sb.append("=");
        if (bArr == null) {
            sb.append(str3);
        } else {
            sb.append(str4);
            sb.append(Base64.encodeToString(bArr, 3));
            sb.append(str4);
        }
        sb.append(str5);
        zza(sb, "GAIA", this.zzbAf);
        sb.append(str5);
        zza(sb, "PSEUDO", this.zzbAg);
        sb.append(str5);
        zza(sb, "ALWAYS", this.zzbAh);
        sb.append(str5);
        zza(sb, "OTHER", this.zzbAi);
        sb.append(str5);
        zza(sb, "weak", this.zzbAj);
        sb.append(str5);
        zza(sb, "directs", this.zzbAk);
        sb.append(")");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 2, this.zzbAd, false);
        zzd.zza(parcel, 3, this.zzbAe, false);
        zzd.zza(parcel, 4, this.zzbAf, false);
        zzd.zza(parcel, 5, this.zzbAg, false);
        zzd.zza(parcel, 6, this.zzbAh, false);
        zzd.zza(parcel, 7, this.zzbAi, false);
        zzd.zza(parcel, 8, this.zzbAj, false);
        zzd.zza(parcel, 9, this.zzbAk, false);
        zzd.zzI(parcel, zze);
    }
}
