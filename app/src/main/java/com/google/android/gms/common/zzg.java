package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzar;
import com.google.android.gms.common.internal.zzas;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.util.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class zzg extends zzas {
    private int zzaAg;

    protected zzg(byte[] bArr) {
        if (bArr.length != 25) {
            int length = bArr.length;
            boolean z = false;
            String valueOf = String.valueOf(zzl.zza(bArr, 0, bArr.length, false));
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 51);
            sb.append("Cert hash data has incorrect length (");
            sb.append(length);
            sb.append("):\n");
            sb.append(valueOf);
            Log.wtf("GoogleCertificates", sb.toString(), new Exception());
            bArr = Arrays.copyOfRange(bArr, 0, 25);
            if (bArr.length == 25) {
                z = true;
            }
            int length2 = bArr.length;
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append("cert hash data has incorrect length. length=");
            sb2.append(length2);
            zzbo.zzb(z, (Object) sb2.toString());
        }
        this.zzaAg = Arrays.hashCode(bArr);
    }

    protected static byte[] zzcs(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzar)) {
            try {
                zzar zzar = (zzar) obj;
                if (zzar.zzoZ() != hashCode()) {
                    return false;
                }
                IObjectWrapper zzoY = zzar.zzoY();
                if (zzoY == null) {
                    return false;
                }
                return Arrays.equals(getBytes(), (byte[]) zzn.zzE(zzoY));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public abstract byte[] getBytes();

    public int hashCode() {
        return this.zzaAg;
    }

    public final IObjectWrapper zzoY() {
        return zzn.zzw(getBytes());
    }

    public final int zzoZ() {
        return hashCode();
    }
}
