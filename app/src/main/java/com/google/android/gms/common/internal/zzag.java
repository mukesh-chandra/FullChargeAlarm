package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import androidx.core.p003os.EnvironmentCompat;
import com.google.android.gms.common.stats.zza;
import java.util.HashMap;

final class zzag extends zzae implements Callback {
    /* access modifiers changed from: private */
    public final Context mApplicationContext;
    /* access modifiers changed from: private */
    public final Handler mHandler;
    /* access modifiers changed from: private */
    public final HashMap<zzaf, zzah> zzaHP = new HashMap<>();
    /* access modifiers changed from: private */
    public final zza zzaHQ;
    private final long zzaHR;
    /* access modifiers changed from: private */
    public final long zzaHS;

    zzag(Context context) {
        this.mApplicationContext = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzaHQ = zza.zzrU();
        this.zzaHR = 5000;
        this.zzaHS = 300000;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.zzaHP) {
                zzaf zzaf = (zzaf) message.obj;
                zzah zzah = (zzah) this.zzaHP.get(zzaf);
                if (zzah != null && zzah.zzrC()) {
                    if (zzah.isBound()) {
                        zzah.zzcC("GmsClientSupervisor");
                    }
                    this.zzaHP.remove(zzaf);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.zzaHP) {
                zzaf zzaf2 = (zzaf) message.obj;
                zzah zzah2 = (zzah) this.zzaHP.get(zzaf2);
                if (zzah2 != null && zzah2.getState() == 3) {
                    String valueOf = String.valueOf(zzaf2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.wtf("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName componentName = zzah2.getComponentName();
                    if (componentName == null) {
                        componentName = zzaf2.getComponentName();
                    }
                    if (componentName == null) {
                        componentName = new ComponentName(zzaf2.getPackage(), EnvironmentCompat.MEDIA_UNKNOWN);
                    }
                    zzah2.onServiceDisconnected(componentName);
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzaf zzaf, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzbo.zzb(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzaHP) {
            zzah zzah = (zzah) this.zzaHP.get(zzaf);
            if (zzah == null) {
                zzah = new zzah(this, zzaf);
                zzah.zza(serviceConnection, str);
                zzah.zzcB(str);
                this.zzaHP.put(zzaf, zzah);
            } else {
                this.mHandler.removeMessages(0, zzaf);
                if (!zzah.zza(serviceConnection)) {
                    zzah.zza(serviceConnection, str);
                    int state = zzah.getState();
                    if (state == 1) {
                        serviceConnection.onServiceConnected(zzah.getComponentName(), zzah.getBinder());
                    } else if (state == 2) {
                        zzah.zzcB(str);
                    }
                } else {
                    String valueOf = String.valueOf(zzaf);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            isBound = zzah.isBound();
        }
        return isBound;
    }

    /* access modifiers changed from: protected */
    public final void zzb(zzaf zzaf, ServiceConnection serviceConnection, String str) {
        zzbo.zzb(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzaHP) {
            zzah zzah = (zzah) this.zzaHP.get(zzaf);
            if (zzah == null) {
                String valueOf = String.valueOf(zzaf);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (zzah.zza(serviceConnection)) {
                zzah.zzb(serviceConnection, str);
                if (zzah.zzrC()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zzaf), this.zzaHR);
                }
            } else {
                String valueOf2 = String.valueOf(zzaf);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }
}
