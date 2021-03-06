package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzi extends zzg {
    private static final WeakReference<byte[]> zzaAj = new WeakReference<>(null);
    private WeakReference<byte[]> zzaAi = zzaAj;

    zzi(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: 0000 */
    public final byte[] getBytes() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.zzaAi.get();
            if (bArr == null) {
                bArr = zzpa();
                this.zzaAi = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public abstract byte[] zzpa();
}
