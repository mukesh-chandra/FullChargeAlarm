package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

public final class zzc extends RuntimeException {
    public zzc(String str, Parcel parcel) {
        int dataPosition = parcel.dataPosition();
        int dataSize = parcel.dataSize();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 41);
        sb.append(str);
        sb.append(" Parcel: pos=");
        sb.append(dataPosition);
        sb.append(" size=");
        sb.append(dataSize);
        super(sb.toString());
    }
}
