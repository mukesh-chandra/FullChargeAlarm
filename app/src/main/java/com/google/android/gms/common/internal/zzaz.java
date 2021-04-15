package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;

public abstract class zzaz extends zzee implements zzay {
    public static zzay zzJ(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        return queryLocalInterface instanceof zzay ? (zzay) queryLocalInterface : new zzba(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        IObjectWrapper iObjectWrapper;
        boolean z;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            iObjectWrapper = zzrF();
        } else if (i != 2) {
            if (i == 3) {
                z = zze(parcel.readString(), zza.zzM(parcel.readStrongBinder()));
            } else if (i == 4) {
                z = zzf(parcel.readString(), zza.zzM(parcel.readStrongBinder()));
            } else if (i != 5) {
                return false;
            } else {
                z = zza((zzm) zzef.zza(parcel, zzm.CREATOR), zza.zzM(parcel.readStrongBinder()));
            }
            parcel2.writeNoException();
            zzef.zza(parcel2, z);
            return true;
        } else {
            iObjectWrapper = zzrG();
        }
        parcel2.writeNoException();
        zzef.zza(parcel2, (IInterface) iObjectWrapper);
        return true;
    }
}
