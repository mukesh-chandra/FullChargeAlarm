package com.google.protobuf;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zze {
    private static final Logger logger = Logger.getLogger(zze.class.getName());
    private static final boolean zzcrM = zzLw();
    private static final long zzcrN = ((long) (zzcrM ? zzcrY.zzcsd.arrayBaseOffset(byte[].class) : -1));
    private static final Unsafe zzcrT = zzLv();
    private static final Class<?> zzcrU = zzhP("libcore.io.Memory");
    private static final boolean zzcrV = (zzhP("org.robolectric.Robolectric") != null);
    private static final boolean zzcrW = zzg(Long.TYPE);
    private static final boolean zzcrX = zzg(Integer.TYPE);
    private static final zzd zzcrY;
    private static final boolean zzcrZ = zzLy();
    private static final boolean zzcsa = zzLx();
    private static final long zzcsb;
    private static final boolean zzcsc;

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static abstract class zzd {
        Unsafe zzcsd;

        zzd(Unsafe unsafe) {
            this.zzcsd = unsafe;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0099, code lost:
        if (r0 != null) goto L_0x00a4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf  */
    static {
        /*
            java.lang.Class<com.google.protobuf.zze> r0 = com.google.protobuf.zze.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            logger = r0
            sun.misc.Unsafe r0 = zzLv()
            zzcrT = r0
            java.lang.String r0 = "libcore.io.Memory"
            java.lang.Class r0 = zzhP(r0)
            zzcrU = r0
            java.lang.String r0 = "org.robolectric.Robolectric"
            java.lang.Class r0 = zzhP(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            zzcrV = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = zzg(r0)
            zzcrW = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = zzg(r0)
            zzcrX = r0
            sun.misc.Unsafe r0 = zzcrT
            r3 = 0
            if (r0 != 0) goto L_0x003f
            goto L_0x0064
        L_0x003f:
            boolean r0 = zzLz()
            if (r0 == 0) goto L_0x005d
            boolean r0 = zzcrW
            if (r0 == 0) goto L_0x0051
            com.google.protobuf.zze$zzb r3 = new com.google.protobuf.zze$zzb
            sun.misc.Unsafe r0 = zzcrT
            r3.<init>(r0)
            goto L_0x0064
        L_0x0051:
            boolean r0 = zzcrX
            if (r0 == 0) goto L_0x0064
            com.google.protobuf.zze$zza r3 = new com.google.protobuf.zze$zza
            sun.misc.Unsafe r0 = zzcrT
            r3.<init>(r0)
            goto L_0x0064
        L_0x005d:
            com.google.protobuf.zze$zzc r3 = new com.google.protobuf.zze$zzc
            sun.misc.Unsafe r0 = zzcrT
            r3.<init>(r0)
        L_0x0064:
            zzcrY = r3
            boolean r0 = zzLy()
            zzcrZ = r0
            boolean r0 = zzLw()
            zzcrM = r0
            boolean r0 = zzLx()
            zzcsa = r0
            boolean r0 = zzcrM
            if (r0 == 0) goto L_0x0087
            com.google.protobuf.zze$zzd r0 = zzcrY
            java.lang.Class<byte[]> r3 = byte[].class
            sun.misc.Unsafe r0 = r0.zzcsd
            int r0 = r0.arrayBaseOffset(r3)
            goto L_0x0088
        L_0x0087:
            r0 = -1
        L_0x0088:
            long r3 = (long) r0
            zzcrN = r3
            boolean r0 = zzLz()
            if (r0 == 0) goto L_0x009c
            java.lang.Class<java.nio.Buffer> r0 = java.nio.Buffer.class
            java.lang.String r3 = "effectiveDirectAddress"
            java.lang.reflect.Field r0 = zza(r0, r3)
            if (r0 == 0) goto L_0x009c
            goto L_0x00a4
        L_0x009c:
            java.lang.Class<java.nio.Buffer> r0 = java.nio.Buffer.class
            java.lang.String r3 = "address"
            java.lang.reflect.Field r0 = zza(r0, r3)
        L_0x00a4:
            if (r0 == 0) goto L_0x00b2
            com.google.protobuf.zze$zzd r3 = zzcrY
            if (r3 != 0) goto L_0x00ab
            goto L_0x00b2
        L_0x00ab:
            sun.misc.Unsafe r3 = r3.zzcsd
            long r3 = r3.objectFieldOffset(r0)
            goto L_0x00b4
        L_0x00b2:
            r3 = -1
        L_0x00b4:
            zzcsb = r3
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r3 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r3) goto L_0x00bf
            goto L_0x00c0
        L_0x00bf:
            r1 = 0
        L_0x00c0:
            zzcsc = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.zze.<clinit>():void");
    }

    private zze() {
    }

    static boolean zzLt() {
        return zzcrM;
    }

    static long zzLu() {
        return zzcrN;
    }

    private static Unsafe zzLv() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzf());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzLw() {
        Unsafe unsafe = zzcrT;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzLz()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzLx() {
        Unsafe unsafe = zzcrT;
        if (unsafe == null) {
            return false;
        }
        try {
            unsafe.getClass().getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable unused) {
            logger.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeCopyMemory", "copyMemory is missing from platform - proto runtime falling back to safer methods.");
            return false;
        }
    }

    private static boolean zzLy() {
        String str = "getLong";
        Unsafe unsafe = zzcrT;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod(str, new Class[]{Object.class, Long.TYPE});
            if (zzLz()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod(str, new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzLz() {
        return zzcrU != null && !zzcrV;
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzg(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzLz()) {
            return false;
        }
        try {
            Class<?> cls3 = zzcrU;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static <T> Class<T> zzhP(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
