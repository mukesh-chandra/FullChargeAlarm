package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.google.android.gms.internal.hj */
final class C0485hj extends ContentObserver {
    C0485hj(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        C0484hi.zzbUd.set(true);
    }
}
