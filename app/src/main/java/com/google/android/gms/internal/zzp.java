package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

public abstract class zzp<T> implements Comparable<zzp<T>> {
    /* access modifiers changed from: private */
    public final zza zzB;
    private final int zzC;
    private final String zzD;
    private final int zzE;
    private final zzu zzF;
    private Integer zzG;
    private zzs zzH;
    private boolean zzI;
    private boolean zzJ;
    private boolean zzK;
    private boolean zzL;
    private zzx zzM;
    private zzc zzN;

    public zzp(int i, String str, zzu zzu) {
        this.zzB = zza.zzai ? new zza() : null;
        this.zzI = true;
        int i2 = 0;
        this.zzJ = false;
        this.zzK = false;
        this.zzL = false;
        this.zzN = null;
        this.zzC = i;
        this.zzD = str;
        this.zzF = zzu;
        this.zzM = new zzg();
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    i2 = host.hashCode();
                }
            }
        }
        this.zzE = i2;
    }

    public static String zzf() {
        String str = "UTF-8";
        String str2 = "application/x-www-form-urlencoded; charset=";
        return str.length() != 0 ? str2.concat(str) : new String(str2);
    }

    public /* synthetic */ int compareTo(Object obj) {
        zzp zzp = (zzp) obj;
        zzr zzr = zzr.NORMAL;
        zzr zzr2 = zzr.NORMAL;
        return zzr == zzr2 ? this.zzG.intValue() - zzp.zzG.intValue() : zzr2.ordinal() - zzr.ordinal();
    }

    public Map<String, String> getHeaders() throws zza {
        return Collections.emptyMap();
    }

    public final int getMethod() {
        return this.zzC;
    }

    public final String getUrl() {
        return this.zzD;
    }

    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzE));
        String str = "0x";
        String concat = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        String str2 = "[ ] ";
        String valueOf2 = String.valueOf(this.zzD);
        String valueOf3 = String.valueOf(zzr.NORMAL);
        String valueOf4 = String.valueOf(this.zzG);
        StringBuilder sb = new StringBuilder(str2.length() + 3 + String.valueOf(valueOf2).length() + String.valueOf(concat).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append(str2);
        sb.append(valueOf2);
        String str3 = " ";
        sb.append(str3);
        sb.append(concat);
        sb.append(str3);
        sb.append(valueOf3);
        sb.append(str3);
        sb.append(valueOf4);
        return sb.toString();
    }

    public final zzp<?> zza(int i) {
        this.zzG = Integer.valueOf(i);
        return this;
    }

    public final zzp<?> zza(zzc zzc) {
        this.zzN = zzc;
        return this;
    }

    public final zzp<?> zza(zzs zzs) {
        this.zzH = zzs;
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract zzt<T> zza(zzn zzn);

    /* access modifiers changed from: protected */
    public abstract void zza(T t);

    public final void zzb(zzaa zzaa) {
        zzu zzu = this.zzF;
        if (zzu != null) {
            zzu.zzd(zzaa);
        }
    }

    public final void zzb(String str) {
        if (zza.zzai) {
            this.zzB.zza(str, Thread.currentThread().getId());
        }
    }

    public final int zzc() {
        return this.zzE;
    }

    /* access modifiers changed from: 0000 */
    public final void zzc(String str) {
        zzs zzs = this.zzH;
        if (zzs != null) {
            zzs.zzd(this);
        }
        if (zza.zzai) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzq(this, str, id));
            } else {
                this.zzB.zza(str, id);
                this.zzB.zzc(toString());
            }
        }
    }

    public final String zzd() {
        return this.zzD;
    }

    public final zzc zze() {
        return this.zzN;
    }

    public byte[] zzg() throws zza {
        return null;
    }

    public final boolean zzh() {
        return this.zzI;
    }

    public final int zzi() {
        return this.zzM.zza();
    }

    public final zzx zzj() {
        return this.zzM;
    }

    public final void zzk() {
        this.zzK = true;
    }

    public final boolean zzl() {
        return this.zzK;
    }
}
