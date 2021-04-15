package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

public final class zzm implements zzj {
    private /* synthetic */ zzd zzaHe;

    public zzm(zzd zzd) {
        this.zzaHe = zzd;
    }

    public final void zzf(ConnectionResult connectionResult) {
        if (connectionResult.isSuccess()) {
            zzd zzd = this.zzaHe;
            zzd.zza((zzal) null, zzd.zzrh());
            return;
        }
        if (this.zzaHe.zzaGW != null) {
            this.zzaHe.zzaGW.onConnectionFailed(connectionResult);
        }
    }
}
