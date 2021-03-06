package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.collection.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class zzbdu extends Fragment implements zzbdt {
    private static WeakHashMap<Activity, WeakReference<zzbdu>> zzaEH = new WeakHashMap<>();
    /* access modifiers changed from: private */
    public int zzLe = 0;
    private Map<String, zzbds> zzaEI = new ArrayMap();
    /* access modifiers changed from: private */
    public Bundle zzaEJ;

    public static zzbdu zzo(Activity activity) {
        String str = "LifecycleFragmentImpl";
        WeakReference weakReference = (WeakReference) zzaEH.get(activity);
        if (weakReference != null) {
            zzbdu zzbdu = (zzbdu) weakReference.get();
            if (zzbdu != null) {
                return zzbdu;
            }
        }
        try {
            zzbdu zzbdu2 = (zzbdu) activity.getFragmentManager().findFragmentByTag(str);
            if (zzbdu2 == null || zzbdu2.isRemoving()) {
                zzbdu2 = new zzbdu();
                activity.getFragmentManager().beginTransaction().add(zzbdu2, str).commitAllowingStateLoss();
            }
            zzaEH.put(activity, new WeakReference(zzbdu2));
            return zzbdu2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (zzbds dump : this.zzaEI.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (zzbds onActivityResult : this.zzaEI.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzLe = 1;
        this.zzaEJ = bundle;
        for (Entry entry : this.zzaEI.entrySet()) {
            ((zzbds) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.zzLe = 5;
        for (zzbds onDestroy : this.zzaEI.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void onResume() {
        super.onResume();
        this.zzLe = 3;
        for (zzbds onResume : this.zzaEI.values()) {
            onResume.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.zzaEI.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((zzbds) entry.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.zzLe = 2;
        for (zzbds onStart : this.zzaEI.values()) {
            onStart.onStart();
        }
    }

    public final void onStop() {
        super.onStop();
        this.zzLe = 4;
        for (zzbds onStop : this.zzaEI.values()) {
            onStop.onStop();
        }
    }

    public final <T extends zzbds> T zza(String str, Class<T> cls) {
        return (zzbds) cls.cast(this.zzaEI.get(str));
    }

    public final void zza(String str, zzbds zzbds) {
        if (!this.zzaEI.containsKey(str)) {
            this.zzaEI.put(str, zzbds);
            if (this.zzLe > 0) {
                new Handler(Looper.getMainLooper()).post(new zzbdv(this, zzbds, str));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final Activity zzqF() {
        return getActivity();
    }
}
