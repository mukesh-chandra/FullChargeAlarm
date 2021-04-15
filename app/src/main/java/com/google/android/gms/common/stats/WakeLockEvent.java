package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.readytofire.fullchargealarm.BuildConfig;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Creator<WakeLockEvent> CREATOR = new zzd();
    private final long mTimeout;
    private final long zzaJn;
    private int zzaJo;
    private final String zzaJp;
    private final String zzaJq;
    private final String zzaJr;
    private final int zzaJs;
    private final List<String> zzaJt;
    private final String zzaJu;
    private final long zzaJv;
    private int zzaJw;
    private final String zzaJx;
    private final float zzaJy;
    private long zzaJz;
    private int zzaku;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.zzaku = i;
        this.zzaJn = j;
        this.zzaJo = i2;
        this.zzaJp = str;
        this.zzaJq = str3;
        this.zzaJr = str5;
        this.zzaJs = i3;
        this.zzaJz = -1;
        this.zzaJt = list;
        this.zzaJu = str2;
        this.zzaJv = j2;
        this.zzaJw = i4;
        this.zzaJx = str4;
        this.zzaJy = f;
        this.mTimeout = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    public final int getEventType() {
        return this.zzaJo;
    }

    public final long getTimeMillis() {
        return this.zzaJn;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        zzd.zza(parcel, 2, this.zzaJn);
        zzd.zza(parcel, 4, this.zzaJp, false);
        zzd.zzc(parcel, 5, this.zzaJs);
        zzd.zzb(parcel, 6, this.zzaJt, false);
        zzd.zza(parcel, 8, this.zzaJv);
        zzd.zza(parcel, 10, this.zzaJq, false);
        zzd.zzc(parcel, 11, this.zzaJo);
        zzd.zza(parcel, 12, this.zzaJu, false);
        zzd.zza(parcel, 13, this.zzaJx, false);
        zzd.zzc(parcel, 14, this.zzaJw);
        zzd.zza(parcel, 15, this.zzaJy);
        zzd.zza(parcel, 16, this.mTimeout);
        zzd.zza(parcel, 17, this.zzaJr, false);
        zzd.zzI(parcel, zze);
    }

    public final long zzrV() {
        return this.zzaJz;
    }

    public final String zzrW() {
        String valueOf = String.valueOf(this.zzaJp);
        int i = this.zzaJs;
        List<String> list = this.zzaJt;
        String str = BuildConfig.FLAVOR;
        String join = list == null ? str : TextUtils.join(",", list);
        int i2 = this.zzaJw;
        String str2 = this.zzaJq;
        if (str2 == null) {
            str2 = str;
        }
        String str3 = this.zzaJx;
        if (str3 == null) {
            str3 = str;
        }
        float f = this.zzaJy;
        String str4 = this.zzaJr;
        if (str4 != null) {
            str = str4;
        }
        String str5 = "\t";
        StringBuilder sb = new StringBuilder(str5.length() + 37 + String.valueOf(valueOf).length() + str5.length() + str5.length() + String.valueOf(join).length() + str5.length() + str5.length() + String.valueOf(str2).length() + str5.length() + String.valueOf(str3).length() + str5.length() + str5.length() + String.valueOf(str).length());
        sb.append(str5);
        sb.append(valueOf);
        sb.append(str5);
        sb.append(i);
        sb.append(str5);
        sb.append(join);
        sb.append(str5);
        sb.append(i2);
        sb.append(str5);
        sb.append(str2);
        sb.append(str5);
        sb.append(str3);
        sb.append(str5);
        sb.append(f);
        sb.append(str5);
        sb.append(str);
        return sb.toString();
    }
}
