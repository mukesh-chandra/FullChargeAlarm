package com.google.android.gms.internal;

import com.google.android.gms.internal.adj;
import java.io.IOException;
import java.util.List;

public final class adk<M extends adj<M>, T> {
    public final int tag;
    private int type = 11;
    protected final Class<T> zzcjG;
    protected final boolean zzcsp;

    private adk(int i, Class<T> cls, int i2, boolean z) {
        this.zzcjG = cls;
        this.tag = i2;
        this.zzcsp = false;
    }

    public static <M extends adj<M>, T extends adp> adk<M, T> zza(int i, Class<T> cls, long j) {
        return new adk<>(11, cls, (int) j, false);
    }

    private final Object zzb(adg adg) {
        String str = "Error creating instance of class ";
        Class<T> cls = this.zzcjG;
        try {
            int i = this.type;
            if (i == 10) {
                adp adp = (adp) cls.newInstance();
                adg.zza(adp, this.tag >>> 3);
                return adp;
            } else if (i == 11) {
                adp adp2 = (adp) cls.newInstance();
                adg.zza(adp2);
                return adp2;
            } else {
                int i2 = this.type;
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
        } catch (InstantiationException e) {
            String valueOf = String.valueOf(cls);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 33);
            sb2.append(str);
            sb2.append(valueOf);
            throw new IllegalArgumentException(sb2.toString(), e);
        } catch (IllegalAccessException e2) {
            String valueOf2 = String.valueOf(cls);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
            sb3.append(str);
            sb3.append(valueOf2);
            throw new IllegalArgumentException(sb3.toString(), e2);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Error reading extension field", e3);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof adk)) {
            return false;
        }
        adk adk = (adk) obj;
        return this.type == adk.type && this.zzcjG == adk.zzcjG && this.tag == adk.tag;
    }

    public final int hashCode() {
        return (((((this.type + 1147) * 31) + this.zzcjG.hashCode()) * 31) + this.tag) * 31;
    }

    /* access modifiers changed from: 0000 */
    public final T zzX(List<adr> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.zzcjG.cast(zzb(adg.zzH(((adr) list.get(list.size() - 1)).zzbws)));
    }

    /* access modifiers changed from: protected */
    public final void zza(Object obj, adh adh) {
        try {
            adh.zzcu(this.tag);
            int i = this.type;
            if (i == 10) {
                int i2 = this.tag >>> 3;
                ((adp) obj).zza(adh);
                adh.zzt(i2, 4);
            } else if (i == 11) {
                adh.zzb((adp) obj);
            } else {
                int i3 = this.type;
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i3);
                throw new IllegalArgumentException(sb.toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final int zzav(Object obj) {
        int i = this.tag >>> 3;
        int i2 = this.type;
        if (i2 == 10) {
            return (adh.zzct(i) << 1) + ((adp) obj).zzLV();
        } else if (i2 == 11) {
            return adh.zzb(i, (adp) obj);
        } else {
            StringBuilder sb = new StringBuilder(24);
            sb.append("Unknown type ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
