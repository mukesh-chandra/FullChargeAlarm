package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzb implements Creator<ConnectionResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
            } else if (i3 == 2) {
                i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
            } else if (i3 == 3) {
                pendingIntent = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, PendingIntent.CREATOR);
            } else if (i3 != 4) {
                com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
            } else {
                str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzF(parcel, zzd);
        return new ConnectionResult(i, i2, pendingIntent, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ConnectionResult[i];
    }
}
