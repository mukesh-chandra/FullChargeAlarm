package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender.SendIntentException;
import android.util.Log;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzbo;

public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
    private final Activity mActivity;
    private final int zzaBk;

    protected ResolvingResultCallbacks(Activity activity, int i) {
        this.mActivity = (Activity) zzbo.zzb(activity, (Object) "Activity must not be null");
        this.zzaBk = i;
    }

    public final void onFailure(Status status) {
        if (status.hasResolution()) {
            try {
                status.startResolutionForResult(this.mActivity, this.zzaBk);
            } catch (SendIntentException e) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", e);
                onUnresolvableFailure(new Status(8));
            }
        } else {
            onUnresolvableFailure(status);
        }
    }

    public abstract void onSuccess(R r);

    public abstract void onUnresolvableFailure(Status status);
}
