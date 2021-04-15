package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class adm implements Cloneable {
    private Object value;
    private adk<?, ?> zzcsu;
    private List<adr> zzcsv = new ArrayList();

    adm() {
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzn()];
        zza(adh.zzI(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzLP */
    public adm clone() {
        Object clone;
        adm adm = new adm();
        try {
            adm.zzcsu = this.zzcsu;
            if (this.zzcsv == null) {
                adm.zzcsv = null;
            } else {
                adm.zzcsv.addAll(this.zzcsv);
            }
            if (this.value != null) {
                if (this.value instanceof adp) {
                    clone = (adp) ((adp) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    clone = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length][];
                        adm.value = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        clone = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        clone = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        clone = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        clone = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        clone = ((double[]) this.value).clone();
                    } else if (this.value instanceof adp[]) {
                        adp[] adpArr = (adp[]) this.value;
                        adp[] adpArr2 = new adp[adpArr.length];
                        adm.value = adpArr2;
                        while (i < adpArr.length) {
                            adpArr2[i] = (adp) adpArr[i].clone();
                            i++;
                        }
                    }
                }
                adm.value = clone;
            }
            return adm;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof adm)) {
            return false;
        }
        adm adm = (adm) obj;
        if (this.value == null || adm.value == null) {
            List<adr> list = this.zzcsv;
            if (list != null) {
                List<adr> list2 = adm.zzcsv;
                if (list2 != null) {
                    return list.equals(list2);
                }
            }
            try {
                return Arrays.equals(toByteArray(), adm.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            adk<?, ?> adk = this.zzcsu;
            if (adk != adm.zzcsu) {
                return false;
            }
            if (!adk.zzcjG.isArray()) {
                return this.value.equals(adm.value);
            }
            Object obj2 = this.value;
            return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) adm.value) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) adm.value) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) adm.value) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) adm.value) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) adm.value) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) adm.value) : Arrays.deepEquals((Object[]) obj2, (Object[]) adm.value);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(adh adh) throws IOException {
        Object obj = this.value;
        if (obj != null) {
            this.zzcsu.zza(obj, adh);
            return;
        }
        for (adr adr : this.zzcsv) {
            adh.zzcu(adr.tag);
            adh.zzK(adr.zzbws);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(adr adr) {
        this.zzcsv.add(adr);
    }

    /* access modifiers changed from: 0000 */
    public final <T> T zzb(adk<?, T> adk) {
        if (this.value == null) {
            this.zzcsu = adk;
            this.value = adk.zzX(this.zzcsv);
            this.zzcsv = null;
        } else if (!this.zzcsu.equals(adk)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.value;
    }

    /* access modifiers changed from: 0000 */
    public final int zzn() {
        Object obj = this.value;
        if (obj != null) {
            return this.zzcsu.zzav(obj);
        }
        int i = 0;
        for (adr adr : this.zzcsv) {
            i += adh.zzcv(adr.tag) + 0 + adr.zzbws.length;
        }
        return i;
    }
}
