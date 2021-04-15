package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class zzbgv implements Executor {
    private final Handler mHandler;

    public zzbgv(Looper looper) {
        this.mHandler = new Handler(looper);
    }

    public final void execute(Runnable runnable) {
        this.mHandler.post(runnable);
    }
}
