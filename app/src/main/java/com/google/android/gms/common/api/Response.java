package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

public class Response<T extends Result> {
    private T zzaBj;

    public Response() {
    }

    protected Response(T t) {
        this.zzaBj = t;
    }

    /* access modifiers changed from: protected */
    public T getResult() {
        return this.zzaBj;
    }

    public void setResult(T t) {
        this.zzaBj = t;
    }
}
