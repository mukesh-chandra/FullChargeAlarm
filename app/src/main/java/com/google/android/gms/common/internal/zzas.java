package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;

public abstract class zzas extends zzee implements zzar {
    public zzas() {
        attachInterface(this, "com.google.android.gms.common.internal.ICertData");
    }

    public static zzar zzI(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return queryLocalInterface instanceof zzar ? (zzar) queryLocalInterface : new zzat(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            IObjectWrapper zzoY = zzoY();
            parcel2.writeNoException();
            zzef.zza(parcel2, (IInterface) zzoY);
        } else if (i != 2) {
            return false;
        } else {
            int zzoZ = zzoZ();
            parcel2.writeNoException();
            parcel2.writeInt(zzoZ);
        }
        return true;
    }
}
