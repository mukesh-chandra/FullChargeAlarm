package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzbg {
    private final List<String> zzaIh;
    private final Object zzaaw;

    private zzbg(Object obj) {
        this.zzaaw = zzbo.zzu(obj);
        this.zzaIh = new ArrayList();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(this.zzaaw.getClass().getSimpleName());
        sb.append('{');
        int size = this.zzaIh.size();
        for (int i = 0; i < size; i++) {
            sb.append((String) this.zzaIh.get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzbg zzg(String str, Object obj) {
        List<String> list = this.zzaIh;
        String str2 = (String) zzbo.zzu(str);
        String valueOf = String.valueOf(String.valueOf(obj));
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length());
        sb.append(str2);
        sb.append("=");
        sb.append(valueOf);
        list.add(sb.toString());
        return this;
    }
}
