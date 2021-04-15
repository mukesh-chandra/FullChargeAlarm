package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzl implements Creator<PlaceReport> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzb.zzd(parcel);
        String str = null;
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = zzb.zzg(parcel, readInt);
            } else if (i2 == 2) {
                str = zzb.zzq(parcel, readInt);
            } else if (i2 == 3) {
                str2 = zzb.zzq(parcel, readInt);
            } else if (i2 != 4) {
                zzb.zzb(parcel, readInt);
            } else {
                str3 = zzb.zzq(parcel, readInt);
            }
        }
        zzb.zzF(parcel, zzd);
        return new PlaceReport(i, str, str2, str3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PlaceReport[i];
    }
}
