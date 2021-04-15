package com.google.android.gms.internal;

public final class adl implements Cloneable {
    private static final adm zzcsq = new adm();
    private int mSize;
    private boolean zzcsr;
    private int[] zzcss;
    private adm[] zzcst;

    adl() {
        this(10);
    }

    private adl(int i) {
        this.zzcsr = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzcss = new int[idealIntArraySize];
        this.zzcst = new adm[idealIntArraySize];
        this.mSize = 0;
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    private final int zzcz(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzcss[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ -1;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        adl adl = new adl(i);
        System.arraycopy(this.zzcss, 0, adl.zzcss, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            adm[] admArr = this.zzcst;
            if (admArr[i2] != null) {
                adl.zzcst[i2] = (adm) admArr[i2].clone();
            }
        }
        adl.mSize = i;
        return adl;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof adl)) {
            return false;
        }
        adl adl = (adl) obj;
        int i = this.mSize;
        if (i != adl.mSize) {
            return false;
        }
        int[] iArr = this.zzcss;
        int[] iArr2 = adl.zzcss;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            } else if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            adm[] admArr = this.zzcst;
            adm[] admArr2 = adl.zzcst;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!admArr[i4].equals(admArr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzcss[i2]) * 31) + this.zzcst[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    /* access modifiers changed from: 0000 */
    public final int size() {
        return this.mSize;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(int i, adm adm) {
        int zzcz = zzcz(i);
        if (zzcz >= 0) {
            this.zzcst[zzcz] = adm;
            return;
        }
        int i2 = zzcz ^ -1;
        if (i2 < this.mSize) {
            adm[] admArr = this.zzcst;
            if (admArr[i2] == zzcsq) {
                this.zzcss[i2] = i;
                admArr[i2] = adm;
                return;
            }
        }
        int i3 = this.mSize;
        if (i3 >= this.zzcss.length) {
            int idealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            adm[] admArr2 = new adm[idealIntArraySize];
            int[] iArr2 = this.zzcss;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            adm[] admArr3 = this.zzcst;
            System.arraycopy(admArr3, 0, admArr2, 0, admArr3.length);
            this.zzcss = iArr;
            this.zzcst = admArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.zzcss;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            adm[] admArr4 = this.zzcst;
            System.arraycopy(admArr4, i2, admArr4, i5, this.mSize - i2);
        }
        this.zzcss[i2] = i;
        this.zzcst[i2] = adm;
        this.mSize++;
    }

    /* access modifiers changed from: 0000 */
    public final adm zzcx(int i) {
        int zzcz = zzcz(i);
        if (zzcz >= 0) {
            adm[] admArr = this.zzcst;
            if (admArr[zzcz] != zzcsq) {
                return admArr[zzcz];
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final adm zzcy(int i) {
        return this.zzcst[i];
    }
}
