package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.internal.hi */
public class C0484hi {
    private static Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static Uri zzbUa = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static Pattern zzbUb = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static Pattern zzbUc = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    /* access modifiers changed from: private */
    public static final AtomicBoolean zzbUd = new AtomicBoolean();
    private static HashMap<String, String> zzbUe;
    private static HashMap<String, Boolean> zzbUf = new HashMap<>();
    private static HashMap<String, Integer> zzbUg = new HashMap<>();
    private static HashMap<String, Long> zzbUh = new HashMap<>();
    private static HashMap<String, Float> zzbUi = new HashMap<>();
    private static Object zzbUj;
    private static boolean zzbUk;
    private static String[] zzbUl = new String[0];

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        Object zzb = zzb(contentResolver);
        long j2 = 0;
        Long l = (Long) zza(zzbUh, str, (T) Long.valueOf(0));
        if (l != null) {
            return l.longValue();
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza != null) {
            try {
                long parseLong = Long.parseLong(zza);
                l = Long.valueOf(parseLong);
                j2 = parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        HashMap<String, Long> hashMap = zzbUh;
        synchronized (C0484hi.class) {
            if (zzb == zzbUj) {
                hashMap.put(str, l);
                zzbUe.remove(str);
            }
        }
        return j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T zza(java.util.HashMap<java.lang.String, T> r2, java.lang.String r3, T r4) {
        /*
            java.lang.Class<com.google.android.gms.internal.hi> r0 = com.google.android.gms.internal.C0484hi.class
            monitor-enter(r0)
            boolean r1 = r2.containsKey(r3)     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0013
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0016 }
            if (r2 == 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r2 = r4
        L_0x0011:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return r2
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            r2 = 0
            return r2
        L_0x0016:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0484hi.zza(java.util.HashMap, java.lang.String, java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005b, code lost:
        r9 = r9.query(CONTENT_URI, null, null, new java.lang.String[]{r10}, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006b, code lost:
        if (r9 == null) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0071, code lost:
        if (r9.moveToFirst() != false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0074, code lost:
        r11 = r9.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0078, code lost:
        if (r11 == null) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007e, code lost:
        if (r11.equals(null) == false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0080, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0081, code lost:
        zza(r0, r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0084, code lost:
        if (r11 == null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0087, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0088, code lost:
        if (r9 == null) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008a, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008d, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        zza(r0, r10, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0091, code lost:
        if (r9 == null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0093, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0096, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0097, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0098, code lost:
        if (r9 != null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x009a, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x009d, code lost:
        throw r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zza(android.content.ContentResolver r9, java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.Class<com.google.android.gms.internal.hi> r11 = com.google.android.gms.internal.C0484hi.class
            monitor-enter(r11)
            zza(r9)     // Catch:{ all -> 0x009e }
            java.lang.Object r0 = zzbUj     // Catch:{ all -> 0x009e }
            java.util.HashMap<java.lang.String, java.lang.String> r1 = zzbUe     // Catch:{ all -> 0x009e }
            boolean r1 = r1.containsKey(r10)     // Catch:{ all -> 0x009e }
            r2 = 0
            if (r1 == 0) goto L_0x001f
            java.util.HashMap<java.lang.String, java.lang.String> r9 = zzbUe     // Catch:{ all -> 0x009e }
            java.lang.Object r9 = r9.get(r10)     // Catch:{ all -> 0x009e }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x009e }
            if (r9 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r9 = r2
        L_0x001d:
            monitor-exit(r11)     // Catch:{ all -> 0x009e }
            return r9
        L_0x001f:
            java.lang.String[] r1 = zzbUl     // Catch:{ all -> 0x009e }
            int r3 = r1.length     // Catch:{ all -> 0x009e }
            r4 = 0
            r5 = 0
        L_0x0024:
            if (r5 >= r3) goto L_0x005a
            r6 = r1[r5]     // Catch:{ all -> 0x009e }
            boolean r6 = r10.startsWith(r6)     // Catch:{ all -> 0x009e }
            if (r6 == 0) goto L_0x0057
            boolean r0 = zzbUk     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x003a
            java.util.HashMap<java.lang.String, java.lang.String> r0 = zzbUe     // Catch:{ all -> 0x009e }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x0055
        L_0x003a:
            java.lang.String[] r0 = zzbUl     // Catch:{ all -> 0x009e }
            zzc(r9, r0)     // Catch:{ all -> 0x009e }
            java.util.HashMap<java.lang.String, java.lang.String> r9 = zzbUe     // Catch:{ all -> 0x009e }
            boolean r9 = r9.containsKey(r10)     // Catch:{ all -> 0x009e }
            if (r9 == 0) goto L_0x0055
            java.util.HashMap<java.lang.String, java.lang.String> r9 = zzbUe     // Catch:{ all -> 0x009e }
            java.lang.Object r9 = r9.get(r10)     // Catch:{ all -> 0x009e }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x009e }
            if (r9 == 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r9 = r2
        L_0x0053:
            monitor-exit(r11)     // Catch:{ all -> 0x009e }
            return r9
        L_0x0055:
            monitor-exit(r11)     // Catch:{ all -> 0x009e }
            return r2
        L_0x0057:
            int r5 = r5 + 1
            goto L_0x0024
        L_0x005a:
            monitor-exit(r11)     // Catch:{ all -> 0x009e }
            android.net.Uri r11 = CONTENT_URI
            r5 = 0
            r6 = 0
            r1 = 1
            java.lang.String[] r7 = new java.lang.String[r1]
            r7[r4] = r10
            r8 = 0
            r3 = r9
            r4 = r11
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)
            if (r9 == 0) goto L_0x008e
            boolean r11 = r9.moveToFirst()     // Catch:{ all -> 0x0097 }
            if (r11 != 0) goto L_0x0074
            goto L_0x008e
        L_0x0074:
            java.lang.String r11 = r9.getString(r1)     // Catch:{ all -> 0x0097 }
            if (r11 == 0) goto L_0x0081
            boolean r1 = r11.equals(r2)     // Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x0081
            r11 = r2
        L_0x0081:
            zza(r0, r10, r11)     // Catch:{ all -> 0x0097 }
            if (r11 == 0) goto L_0x0087
            goto L_0x0088
        L_0x0087:
            r11 = r2
        L_0x0088:
            if (r9 == 0) goto L_0x008d
            r9.close()
        L_0x008d:
            return r11
        L_0x008e:
            zza(r0, r10, r2)     // Catch:{ all -> 0x0097 }
            if (r9 == 0) goto L_0x0096
            r9.close()
        L_0x0096:
            return r2
        L_0x0097:
            r10 = move-exception
            if (r9 == 0) goto L_0x009d
            r9.close()
        L_0x009d:
            throw r10
        L_0x009e:
            r9 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x009e }
            goto L_0x00a2
        L_0x00a1:
            throw r9
        L_0x00a2:
            goto L_0x00a1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0484hi.zza(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzbUa, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        if (zzbUe == null) {
            zzbUd.set(false);
            zzbUe = new HashMap<>();
            zzbUj = new Object();
            zzbUk = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new C0485hj(null));
            return;
        }
        if (zzbUd.getAndSet(false)) {
            zzbUe.clear();
            zzbUf.clear();
            zzbUg.clear();
            zzbUh.clear();
            zzbUi.clear();
            zzbUj = new Object();
            zzbUk = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (C0484hi.class) {
            if (obj == zzbUj) {
                zzbUe.put(str, str2);
            }
        }
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        synchronized (C0484hi.class) {
            zza(contentResolver);
            obj = zzbUj;
        }
        return obj;
    }

    public static void zzb(ContentResolver contentResolver, String... strArr) {
        String[] strArr2;
        if (strArr.length != 0) {
            synchronized (C0484hi.class) {
                zza(contentResolver);
                HashSet hashSet = new HashSet((((zzbUl.length + strArr.length) << 2) / 3) + 1);
                hashSet.addAll(Arrays.asList(zzbUl));
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    if (hashSet.add(str)) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.isEmpty()) {
                    strArr2 = new String[0];
                } else {
                    zzbUl = (String[]) hashSet.toArray(new String[hashSet.size()]);
                    strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
                }
                if (zzbUk) {
                    if (!zzbUe.isEmpty()) {
                        if (strArr2.length != 0) {
                            zzc(contentResolver, strArr2);
                        }
                    }
                }
                zzc(contentResolver, zzbUl);
            }
        }
    }

    private static void zzc(ContentResolver contentResolver, String[] strArr) {
        zzbUe.putAll(zza(contentResolver, strArr));
        zzbUk = true;
    }
}
