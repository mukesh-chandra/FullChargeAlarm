package com.google.android.gms.internal;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.zzbo;

public final class zzbdr {
    private final Object zzaEF;

    public zzbdr(Activity activity) {
        zzbo.zzb(activity, (Object) "Activity must not be null");
        this.zzaEF = activity;
    }

    public final boolean zzqC() {
        return this.zzaEF instanceof FragmentActivity;
    }

    public final Activity zzqD() {
        return (Activity) this.zzaEF;
    }

    public final FragmentActivity zzqE() {
        return (FragmentActivity) this.zzaEF;
    }
}
