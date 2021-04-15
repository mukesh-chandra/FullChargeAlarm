package com.google.android.gms.ads.identifier;

import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

final class zza extends Thread {
    private /* synthetic */ String zzsD;

    zza(AdvertisingIdClient advertisingIdClient, String str) {
        this.zzsD = str;
    }

    public final void run() {
        String valueOf;
        StringBuilder sb;
        String str;
        HttpURLConnection httpURLConnection;
        String str2 = ". ";
        String str3 = "HttpUrlPinger";
        new zzb();
        String str4 = this.zzsD;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str4).openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str4).length() + 65);
                sb2.append("Received non-success response code ");
                sb2.append(responseCode);
                sb2.append(" from pinging URL: ");
                sb2.append(str4);
                Log.w(str3, sb2.toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            valueOf = String.valueOf(e.getMessage());
            sb = new StringBuilder(String.valueOf(str4).length() + 32 + String.valueOf(valueOf).length());
            str = "Error while parsing ping URL: ";
            r3 = e;
            sb.append(str);
            sb.append(str4);
            sb.append(str2);
            sb.append(valueOf);
            Log.w(str3, sb.toString(), r3);
        } catch (IOException | RuntimeException e2) {
            valueOf = String.valueOf(e2.getMessage());
            sb = new StringBuilder(String.valueOf(str4).length() + 27 + String.valueOf(valueOf).length());
            str = "Error while pinging URL: ";
            r3 = e2;
            sb.append(str);
            sb.append(str4);
            sb.append(str2);
            sb.append(valueOf);
            Log.w(str3, sb.toString(), r3);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
