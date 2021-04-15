package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.zzo;

public final class zza extends zzam {
    private int zzaGG;

    public static Account zza(zzal zzal) {
        if (zzal != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzal.getAccount();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zza)) {
            return false;
        }
        Account account = null;
        return account.equals(account);
    }

    public final Account getAccount() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.zzaGG) {
            return null;
        }
        if (zzo.zzf(null, callingUid)) {
            this.zzaGG = callingUid;
            return null;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}
