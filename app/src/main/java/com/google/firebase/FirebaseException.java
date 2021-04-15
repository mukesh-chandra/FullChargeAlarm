package com.google.firebase;

import com.google.android.gms.common.internal.zzbo;

public class FirebaseException extends Exception {
    @Deprecated
    protected FirebaseException() {
    }

    public FirebaseException(String str) {
        super(zzbo.zzh(str, "Detail message must not be empty"));
    }

    public FirebaseException(String str, Throwable th) {
        super(zzbo.zzh(str, "Detail message must not be empty"), th);
    }
}
