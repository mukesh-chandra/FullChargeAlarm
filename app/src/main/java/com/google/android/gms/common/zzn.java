package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzn implements Creator<zzm> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzb.zzd(parcel);
        String str = null;
        IBinder iBinder = null;
        boolean z = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                str = zzb.zzq(parcel, readInt);
            } else if (i == 2) {
                iBinder = zzb.zzr(parcel, readInt);
            } else if (i != 3) {
                zzb.zzb(parcel, readInt);
            } else {
                z = zzb.zzc(parcel, readInt);
            }
        }
        zzb.zzF(parcel, zzd);
        return new zzm(str, iBinder, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzm[i];
    }
}
