package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.zze;
import com.google.android.gms.common.zzo;
import com.google.android.gms.internal.zzfd;
import com.google.android.gms.internal.zzfe;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    private final Context mContext;
    private Object zzsA;
    private zza zzsB;
    private long zzsC;
    private com.google.android.gms.common.zza zzsx;
    private zzfd zzsy;
    private boolean zzsz;

    public static final class Info {
        private final String zzsI;
        private final boolean zzsJ;

        public Info(String str, boolean z) {
            this.zzsI = str;
            this.zzsJ = z;
        }

        public final String getId() {
            return this.zzsI;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzsJ;
        }

        public final String toString() {
            String str = this.zzsI;
            boolean z = this.zzsJ;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzsE;
        private long zzsF;
        CountDownLatch zzsG = new CountDownLatch(1);
        boolean zzsH = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzsE = new WeakReference<>(advertisingIdClient);
            this.zzsF = j;
            start();
        }

        private final void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzsE.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzsH = true;
            }
        }

        public final void run() {
            try {
                if (!this.zzsG.await(this.zzsF, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException unused) {
                disconnect();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000, false);
    }

    public AdvertisingIdClient(Context context, long j, boolean z) {
        this.zzsA = new Object();
        zzbo.zzu(context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
        }
        this.mContext = context;
        this.zzsz = false;
        this.zzsC = j;
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        boolean z;
        AdvertisingIdClient advertisingIdClient;
        float f = 0.0f;
        try {
            Context remoteContext = zzo.getRemoteContext(context);
            if (remoteContext != null) {
                SharedPreferences sharedPreferences = remoteContext.getSharedPreferences("google_ads_flags", 0);
                z = sharedPreferences.getBoolean("gads:ad_id_app_context:enabled", false);
                try {
                    f = sharedPreferences.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
                } catch (Exception e) {
                    e = e;
                    Log.w("AdvertisingIdClient", "Error while reading from SharedPreferences ", e);
                    advertisingIdClient = new AdvertisingIdClient(context, -1, z);
                    advertisingIdClient.start(false);
                    Info info = advertisingIdClient.getInfo();
                    advertisingIdClient.zza(info, z, f, null);
                    return info;
                }
            } else {
                z = false;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
            Log.w("AdvertisingIdClient", "Error while reading from SharedPreferences ", e);
            advertisingIdClient = new AdvertisingIdClient(context, -1, z);
            advertisingIdClient.start(false);
            Info info2 = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info2, z, f, null);
            return info2;
        }
        advertisingIdClient = new AdvertisingIdClient(context, -1, z);
        try {
            advertisingIdClient.start(false);
            Info info22 = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info22, z, f, null);
            return info22;
        } catch (Throwable th) {
            advertisingIdClient.zza(null, z, f, th);
            return null;
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private final void start(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzbo.zzcG("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzsz) {
                finish();
            }
            this.zzsx = zzd(this.mContext);
            this.zzsy = zza(this.mContext, this.zzsx);
            this.zzsz = true;
            if (z) {
                zzaj();
            }
        }
    }

    private static zzfd zza(Context context, com.google.android.gms.common.zza zza2) throws IOException {
        try {
            return zzfe.zzc(zza2.zza(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private final void zza(Info info, boolean z, float f, Throwable th) {
        if (Math.random() <= ((double) f)) {
            Bundle bundle = new Bundle();
            String str = "1";
            String str2 = "0";
            bundle.putString("app_context", z ? str : str2);
            if (info != null) {
                if (!info.isLimitAdTrackingEnabled()) {
                    str = str2;
                }
                bundle.putString("limit_ad_tracking", str);
            }
            if (!(info == null || info.getId() == null)) {
                bundle.putString("ad_id_size", Integer.toString(info.getId().length()));
            }
            if (th != null) {
                bundle.putString("error", th.getClass().getName());
            }
            Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
            for (String str3 : bundle.keySet()) {
                buildUpon.appendQueryParameter(str3, bundle.getString(str3));
            }
            new zza(this, buildUpon.build().toString()).start();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|(3:5|6|7)|8|9|(1:11)|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0013 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzaj() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.zzsA
            monitor-enter(r0)
            com.google.android.gms.ads.identifier.AdvertisingIdClient$zza r1 = r6.zzsB     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0013
            com.google.android.gms.ads.identifier.AdvertisingIdClient$zza r1 = r6.zzsB     // Catch:{ all -> 0x0026 }
            java.util.concurrent.CountDownLatch r1 = r1.zzsG     // Catch:{ all -> 0x0026 }
            r1.countDown()     // Catch:{ all -> 0x0026 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$zza r1 = r6.zzsB     // Catch:{ InterruptedException -> 0x0013 }
            r1.join()     // Catch:{ InterruptedException -> 0x0013 }
        L_0x0013:
            long r1 = r6.zzsC     // Catch:{ all -> 0x0026 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0024
            com.google.android.gms.ads.identifier.AdvertisingIdClient$zza r1 = new com.google.android.gms.ads.identifier.AdvertisingIdClient$zza     // Catch:{ all -> 0x0026 }
            long r2 = r6.zzsC     // Catch:{ all -> 0x0026 }
            r1.<init>(r6, r2)     // Catch:{ all -> 0x0026 }
            r6.zzsB = r1     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return
        L_0x0026:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zzaj():void");
    }

    private static com.google.android.gms.common.zza zzd(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(zzo.GOOGLE_PLAY_STORE_PACKAGE, 0);
            int isGooglePlayServicesAvailable = zze.zzoW().isGooglePlayServicesAvailable(context);
            if (isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2) {
                com.google.android.gms.common.zza zza2 = new com.google.android.gms.common.zza();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    if (com.google.android.gms.common.stats.zza.zzrU().zza(context, intent, zza2, 1)) {
                        return zza2;
                    }
                    throw new IOException("Connection failure");
                } catch (Throwable th) {
                    throw new IOException(th);
                }
            } else {
                throw new IOException("Google Play services not available");
            }
        } catch (NameNotFoundException unused) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
            r3 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.zzbo.zzcG(r0)
            monitor-enter(r3)
            android.content.Context r0 = r3.mContext     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.common.zza r0 = r3.zzsx     // Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r3.zzsz     // Catch:{ IllegalArgumentException -> 0x0027, all -> 0x001e }
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.common.stats.zza.zzrU()     // Catch:{ IllegalArgumentException -> 0x0027, all -> 0x001e }
            android.content.Context r0 = r3.mContext     // Catch:{ IllegalArgumentException -> 0x0027, all -> 0x001e }
            com.google.android.gms.common.zza r1 = r3.zzsx     // Catch:{ IllegalArgumentException -> 0x0027, all -> 0x001e }
            r0.unbindService(r1)     // Catch:{ IllegalArgumentException -> 0x0027, all -> 0x001e }
            goto L_0x002d
        L_0x001e:
            r0 = move-exception
            java.lang.String r1 = "AdvertisingIdClient"
            java.lang.String r2 = "AdvertisingIdClient unbindService failed."
        L_0x0023:
            android.util.Log.i(r1, r2, r0)     // Catch:{ all -> 0x0039 }
            goto L_0x002d
        L_0x0027:
            r0 = move-exception
            java.lang.String r1 = "AdvertisingIdClient"
            java.lang.String r2 = "AdvertisingIdClient unbindService failed."
            goto L_0x0023
        L_0x002d:
            r0 = 0
            r3.zzsz = r0     // Catch:{ all -> 0x0039 }
            r0 = 0
            r3.zzsy = r0     // Catch:{ all -> 0x0039 }
            r3.zzsx = r0     // Catch:{ all -> 0x0039 }
            monitor-exit(r3)     // Catch:{ all -> 0x0039 }
            return
        L_0x0037:
            monitor-exit(r3)     // Catch:{ all -> 0x0039 }
            return
        L_0x0039:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x003c:
            throw r0
        L_0x003d:
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() throws IOException {
        Info info;
        zzbo.zzcG("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzsz) {
                synchronized (this.zzsA) {
                    if (this.zzsB == null || !this.zzsB.zzsH) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    start(false);
                    if (!this.zzsz) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzbo.zzu(this.zzsx);
            zzbo.zzu(this.zzsy);
            info = new Info(this.zzsy.getId(), this.zzsy.zzb(true));
        }
        zzaj();
        return info;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        start(true);
    }
}
