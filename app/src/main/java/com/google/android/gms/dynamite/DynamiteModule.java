package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DynamiteModule {
    private static Boolean zzaSF;
    private static zzj zzaSG;
    private static zzl zzaSH;
    private static String zzaSI;
    private static final ThreadLocal<zza> zzaSJ = new ThreadLocal<>();
    private static final zzh zzaSK = new zza();
    public static final zzd zzaSL = new zzb();
    private static zzd zzaSM = new zzc();
    public static final zzd zzaSN = new zzd();
    public static final zzd zzaSO = new zze();
    public static final zzd zzaSP = new zzf();
    private final Context zzaSQ;

    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    static class zza {
        public Cursor zzaSR;

        private zza() {
        }

        /* synthetic */ zza(zza zza) {
            this();
        }
    }

    static class zzb implements zzh {
        private final int zzaSS;
        private final int zzaST = 0;

        public zzb(int i, int i2) {
            this.zzaSS = i;
        }

        public final int zzE(Context context, String str) {
            return this.zzaSS;
        }

        public final int zzb(Context context, String str, boolean z) {
            return 0;
        }
    }

    public static class zzc extends Exception {
        private zzc(String str) {
            super(str);
        }

        /* synthetic */ zzc(String str, zza zza) {
            this(str);
        }

        private zzc(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ zzc(String str, Throwable th, zza zza) {
            this(str, th);
        }
    }

    public interface zzd {
        zzi zza(Context context, String str, zzh zzh) throws zzc;
    }

    private DynamiteModule(Context context) {
        this.zzaSQ = (Context) zzbo.zzu(context);
    }

    public static int zzE(Context context, String str) {
        String str2 = "DynamiteModule";
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            String str3 = "com.google.android.gms.dynamite.descriptors.";
            String str4 = "ModuleDescriptor";
            StringBuilder sb = new StringBuilder(str3.length() + 1 + String.valueOf(str).length() + str4.length());
            sb.append(str3);
            sb.append(str);
            sb.append(".");
            sb.append(str4);
            Class loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e(str2, sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w(str2, sb3.toString());
            return 0;
        } catch (Exception e) {
            String str5 = "Failed to load module descriptor class: ";
            String valueOf2 = String.valueOf(e.getMessage());
            Log.e(str2, valueOf2.length() != 0 ? str5.concat(valueOf2) : new String(str5));
            return 0;
        }
    }

    public static int zzF(Context context, String str) {
        return zzb(context, str, false);
    }

    private static DynamiteModule zzG(Context context, String str) {
        String valueOf = String.valueOf(str);
        String str2 = "Selected local version of ";
        Log.i("DynamiteModule", valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static Context zza(Context context, String str, int i, Cursor cursor, zzl zzl) {
        try {
            return (Context) zzn.zzE(zzl.zza(zzn.zzw(context), str, i, zzn.zzw(cursor)));
        } catch (Exception e) {
            String str2 = "Failed to load DynamiteLoader: ";
            String valueOf = String.valueOf(e.toString());
            Log.e("DynamiteModule", valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007c, code lost:
        if (r3.zzaSR != null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0095, code lost:
        if (r3.zzaSR != null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d1, code lost:
        if (r3.zzaSR != null) goto L_0x007e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.dynamite.DynamiteModule zza(android.content.Context r10, com.google.android.gms.dynamite.DynamiteModule.zzd r11, java.lang.String r12) throws com.google.android.gms.dynamite.DynamiteModule.zzc {
        /*
            java.lang.String r0 = ":"
            java.lang.String r1 = "DynamiteModule"
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$zza> r2 = zzaSJ
            java.lang.Object r2 = r2.get()
            com.google.android.gms.dynamite.DynamiteModule$zza r2 = (com.google.android.gms.dynamite.DynamiteModule.zza) r2
            com.google.android.gms.dynamite.DynamiteModule$zza r3 = new com.google.android.gms.dynamite.DynamiteModule$zza
            r4 = 0
            r3.<init>(r4)
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$zza> r5 = zzaSJ
            r5.set(r3)
            com.google.android.gms.dynamite.zzh r5 = zzaSK     // Catch:{ all -> 0x0121 }
            com.google.android.gms.dynamite.zzi r5 = r11.zza(r10, r12, r5)     // Catch:{ all -> 0x0121 }
            int r6 = r5.zzaSU     // Catch:{ all -> 0x0121 }
            int r7 = r5.zzaSV     // Catch:{ all -> 0x0121 }
            java.lang.String r8 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0121 }
            int r8 = r8.length()     // Catch:{ all -> 0x0121 }
            int r8 = r8 + 68
            java.lang.String r9 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0121 }
            int r9 = r9.length()     // Catch:{ all -> 0x0121 }
            int r8 = r8 + r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0121 }
            r9.<init>(r8)     // Catch:{ all -> 0x0121 }
            java.lang.String r8 = "Considering local module "
            r9.append(r8)     // Catch:{ all -> 0x0121 }
            r9.append(r12)     // Catch:{ all -> 0x0121 }
            r9.append(r0)     // Catch:{ all -> 0x0121 }
            r9.append(r6)     // Catch:{ all -> 0x0121 }
            java.lang.String r6 = " and remote module "
            r9.append(r6)     // Catch:{ all -> 0x0121 }
            r9.append(r12)     // Catch:{ all -> 0x0121 }
            r9.append(r0)     // Catch:{ all -> 0x0121 }
            r9.append(r7)     // Catch:{ all -> 0x0121 }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x0121 }
            android.util.Log.i(r1, r0)     // Catch:{ all -> 0x0121 }
            int r0 = r5.zzaSW     // Catch:{ all -> 0x0121 }
            if (r0 == 0) goto L_0x00f7
            int r0 = r5.zzaSW     // Catch:{ all -> 0x0121 }
            r6 = -1
            if (r0 != r6) goto L_0x0069
            int r0 = r5.zzaSU     // Catch:{ all -> 0x0121 }
            if (r0 == 0) goto L_0x00f7
        L_0x0069:
            int r0 = r5.zzaSW     // Catch:{ all -> 0x0121 }
            r7 = 1
            if (r0 != r7) goto L_0x0072
            int r0 = r5.zzaSV     // Catch:{ all -> 0x0121 }
            if (r0 == 0) goto L_0x00f7
        L_0x0072:
            int r0 = r5.zzaSW     // Catch:{ all -> 0x0121 }
            if (r0 != r6) goto L_0x0089
            com.google.android.gms.dynamite.DynamiteModule r10 = zzG(r10, r12)     // Catch:{ all -> 0x0121 }
            android.database.Cursor r11 = r3.zzaSR
            if (r11 == 0) goto L_0x0083
        L_0x007e:
            android.database.Cursor r11 = r3.zzaSR
            r11.close()
        L_0x0083:
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$zza> r11 = zzaSJ
            r11.set(r2)
            return r10
        L_0x0089:
            int r0 = r5.zzaSW     // Catch:{ all -> 0x0121 }
            if (r0 != r7) goto L_0x00dc
            int r0 = r5.zzaSV     // Catch:{ zzc -> 0x0098 }
            com.google.android.gms.dynamite.DynamiteModule r10 = zza(r10, r12, r0)     // Catch:{ zzc -> 0x0098 }
            android.database.Cursor r11 = r3.zzaSR
            if (r11 == 0) goto L_0x0083
            goto L_0x007e
        L_0x0098:
            r0 = move-exception
            java.lang.String r7 = "Failed to load remote module: "
            java.lang.String r8 = r0.getMessage()     // Catch:{ all -> 0x0121 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0121 }
            int r9 = r8.length()     // Catch:{ all -> 0x0121 }
            if (r9 == 0) goto L_0x00ae
            java.lang.String r7 = r7.concat(r8)     // Catch:{ all -> 0x0121 }
            goto L_0x00b4
        L_0x00ae:
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x0121 }
            r8.<init>(r7)     // Catch:{ all -> 0x0121 }
            r7 = r8
        L_0x00b4:
            android.util.Log.w(r1, r7)     // Catch:{ all -> 0x0121 }
            int r1 = r5.zzaSU     // Catch:{ all -> 0x0121 }
            if (r1 == 0) goto L_0x00d4
            com.google.android.gms.dynamite.DynamiteModule$zzb r1 = new com.google.android.gms.dynamite.DynamiteModule$zzb     // Catch:{ all -> 0x0121 }
            int r5 = r5.zzaSU     // Catch:{ all -> 0x0121 }
            r7 = 0
            r1.<init>(r5, r7)     // Catch:{ all -> 0x0121 }
            com.google.android.gms.dynamite.zzi r11 = r11.zza(r10, r12, r1)     // Catch:{ all -> 0x0121 }
            int r11 = r11.zzaSW     // Catch:{ all -> 0x0121 }
            if (r11 != r6) goto L_0x00d4
            com.google.android.gms.dynamite.DynamiteModule r10 = zzG(r10, r12)     // Catch:{ all -> 0x0121 }
            android.database.Cursor r11 = r3.zzaSR
            if (r11 == 0) goto L_0x0083
            goto L_0x007e
        L_0x00d4:
            com.google.android.gms.dynamite.DynamiteModule$zzc r10 = new com.google.android.gms.dynamite.DynamiteModule$zzc     // Catch:{ all -> 0x0121 }
            java.lang.String r11 = "Remote load failed. No local fallback found."
            r10.<init>(r11, r0, r4)     // Catch:{ all -> 0x0121 }
            throw r10     // Catch:{ all -> 0x0121 }
        L_0x00dc:
            com.google.android.gms.dynamite.DynamiteModule$zzc r10 = new com.google.android.gms.dynamite.DynamiteModule$zzc     // Catch:{ all -> 0x0121 }
            int r11 = r5.zzaSW     // Catch:{ all -> 0x0121 }
            r12 = 47
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0121 }
            r0.<init>(r12)     // Catch:{ all -> 0x0121 }
            java.lang.String r12 = "VersionPolicy returned invalid code:"
            r0.append(r12)     // Catch:{ all -> 0x0121 }
            r0.append(r11)     // Catch:{ all -> 0x0121 }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x0121 }
            r10.<init>(r11, r4)     // Catch:{ all -> 0x0121 }
            throw r10     // Catch:{ all -> 0x0121 }
        L_0x00f7:
            com.google.android.gms.dynamite.DynamiteModule$zzc r10 = new com.google.android.gms.dynamite.DynamiteModule$zzc     // Catch:{ all -> 0x0121 }
            int r11 = r5.zzaSU     // Catch:{ all -> 0x0121 }
            int r12 = r5.zzaSV     // Catch:{ all -> 0x0121 }
            r0 = 91
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0121 }
            r1.<init>(r0)     // Catch:{ all -> 0x0121 }
            java.lang.String r0 = "No acceptable module found. Local version is "
            r1.append(r0)     // Catch:{ all -> 0x0121 }
            r1.append(r11)     // Catch:{ all -> 0x0121 }
            java.lang.String r11 = " and remote version is "
            r1.append(r11)     // Catch:{ all -> 0x0121 }
            r1.append(r12)     // Catch:{ all -> 0x0121 }
            java.lang.String r11 = "."
            r1.append(r11)     // Catch:{ all -> 0x0121 }
            java.lang.String r11 = r1.toString()     // Catch:{ all -> 0x0121 }
            r10.<init>(r11, r4)     // Catch:{ all -> 0x0121 }
            throw r10     // Catch:{ all -> 0x0121 }
        L_0x0121:
            r10 = move-exception
            android.database.Cursor r11 = r3.zzaSR
            if (r11 == 0) goto L_0x012b
            android.database.Cursor r11 = r3.zzaSR
            r11.close()
        L_0x012b:
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$zza> r11 = zzaSJ
            r11.set(r2)
            goto L_0x0132
        L_0x0131:
            throw r10
        L_0x0132:
            goto L_0x0131
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$zzd, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    private static DynamiteModule zza(Context context, String str, int i) throws zzc {
        Boolean bool;
        synchronized (DynamiteModule.class) {
            bool = zzaSF;
        }
        if (bool != null) {
            return bool.booleanValue() ? zzc(context, str, i) : zzb(context, str, i);
        }
        throw new zzc("Failed to determine which loading route to use.", (zza) null);
    }

    private static void zza(ClassLoader classLoader) throws zzc {
        zzl zzl;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzl = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzl = queryLocalInterface instanceof zzl ? (zzl) queryLocalInterface : new zzm(iBinder);
            }
            zzaSH = zzl;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new zzc("Failed to instantiate dynamite loader", e, null);
        }
    }

    private static zzj zzaT(Context context) {
        zzj zzj;
        synchronized (DynamiteModule.class) {
            if (zzaSG != null) {
                zzj zzj2 = zzaSG;
                return zzj2;
            } else if (zze.zzoW().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            } else {
                try {
                    IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    if (iBinder == null) {
                        zzj = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                        zzj = queryLocalInterface instanceof zzj ? (zzj) queryLocalInterface : new zzk(iBinder);
                    }
                    if (zzj != null) {
                        zzaSG = zzj;
                        return zzj;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:39|40) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:15|16|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r2.set(null, java.lang.ClassLoader.getSystemClassLoader());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0085, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0035 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x007c */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00be A[SYNTHETIC, Splitter:B:55:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e5  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0050=Splitter:B:22:0x0050, B:17:0x0035=Splitter:B:17:0x0035, B:34:0x0079=Splitter:B:34:0x0079} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzb(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)
            java.lang.Boolean r1 = zzaSF     // Catch:{ all -> 0x00ea }
            if (r1 != 0) goto L_0x00b7
            android.content.Context r1 = r8.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r2 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
            java.lang.Class r1 = r1.loadClass(r2)     // Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
            java.lang.String r2 = "sClassLoader"
            java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
            monitor-enter(r1)     // Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
            r3 = 0
            java.lang.Object r4 = r2.get(r3)     // Catch:{ all -> 0x0087 }
            java.lang.ClassLoader r4 = (java.lang.ClassLoader) r4     // Catch:{ all -> 0x0087 }
            if (r4 == 0) goto L_0x0038
            java.lang.ClassLoader r2 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x0087 }
            if (r4 != r2) goto L_0x0032
        L_0x002f:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0087 }
            goto L_0x0084
        L_0x0032:
            zza(r4)     // Catch:{ zzc -> 0x0035 }
        L_0x0035:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0087 }
            goto L_0x0084
        L_0x0038:
            java.lang.String r4 = "com.google.android.gms"
            android.content.Context r5 = r8.getApplicationContext()     // Catch:{ all -> 0x0087 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x0087 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0087 }
            if (r4 == 0) goto L_0x0050
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x0087 }
            r2.set(r3, r4)     // Catch:{ all -> 0x0087 }
            goto L_0x002f
        L_0x0050:
            int r4 = zzd(r8, r9, r10)     // Catch:{ zzc -> 0x007c }
            java.lang.String r5 = zzaSI     // Catch:{ zzc -> 0x007c }
            if (r5 == 0) goto L_0x0079
            java.lang.String r5 = zzaSI     // Catch:{ zzc -> 0x007c }
            boolean r5 = r5.isEmpty()     // Catch:{ zzc -> 0x007c }
            if (r5 == 0) goto L_0x0061
            goto L_0x0079
        L_0x0061:
            com.google.android.gms.dynamite.zzg r5 = new com.google.android.gms.dynamite.zzg     // Catch:{ zzc -> 0x007c }
            java.lang.String r6 = zzaSI     // Catch:{ zzc -> 0x007c }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ zzc -> 0x007c }
            r5.<init>(r6, r7)     // Catch:{ zzc -> 0x007c }
            zza(r5)     // Catch:{ zzc -> 0x007c }
            r2.set(r3, r5)     // Catch:{ zzc -> 0x007c }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ zzc -> 0x007c }
            zzaSF = r5     // Catch:{ zzc -> 0x007c }
            monitor-exit(r1)     // Catch:{ all -> 0x0087 }
            monitor-exit(r0)     // Catch:{ all -> 0x00ea }
            return r4
        L_0x0079:
            monitor-exit(r1)     // Catch:{ all -> 0x0087 }
            monitor-exit(r0)     // Catch:{ all -> 0x00ea }
            return r4
        L_0x007c:
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x0087 }
            r2.set(r3, r4)     // Catch:{ all -> 0x0087 }
            goto L_0x002f
        L_0x0084:
            monitor-exit(r1)     // Catch:{ all -> 0x0087 }
            r1 = r2
            goto L_0x00b5
        L_0x0087:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0087 }
            throw r2     // Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x008c, NoSuchFieldException -> 0x008a }
        L_0x008a:
            r1 = move-exception
            goto L_0x008f
        L_0x008c:
            r1 = move-exception
            goto L_0x008f
        L_0x008e:
            r1 = move-exception
        L_0x008f:
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00ea }
            java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00ea }
            int r3 = r3.length()     // Catch:{ all -> 0x00ea }
            int r3 = r3 + 30
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r4.<init>(r3)     // Catch:{ all -> 0x00ea }
            java.lang.String r3 = "Failed to load module via V2: "
            r4.append(r3)     // Catch:{ all -> 0x00ea }
            r4.append(r1)     // Catch:{ all -> 0x00ea }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00ea }
            android.util.Log.w(r2, r1)     // Catch:{ all -> 0x00ea }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00ea }
        L_0x00b5:
            zzaSF = r1     // Catch:{ all -> 0x00ea }
        L_0x00b7:
            monitor-exit(r0)     // Catch:{ all -> 0x00ea }
            boolean r0 = r1.booleanValue()
            if (r0 == 0) goto L_0x00e5
            int r8 = zzd(r8, r9, r10)     // Catch:{ zzc -> 0x00c3 }
            return r8
        L_0x00c3:
            r8 = move-exception
            java.lang.String r9 = "Failed to retrieve remote module version: "
            java.lang.String r8 = r8.getMessage()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r10 = r8.length()
            if (r10 == 0) goto L_0x00d9
            java.lang.String r8 = r9.concat(r8)
            goto L_0x00de
        L_0x00d9:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r9)
        L_0x00de:
            java.lang.String r9 = "DynamiteModule"
            android.util.Log.w(r9, r8)
            r8 = 0
            return r8
        L_0x00e5:
            int r8 = zzc(r8, r9, r10)
            return r8
        L_0x00ea:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ea }
            goto L_0x00ee
        L_0x00ed:
            throw r8
        L_0x00ee:
            goto L_0x00ed
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule zzb(Context context, String str, int i) throws zzc {
        String str2 = "Failed to load remote module.";
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        zzj zzaT = zzaT(context);
        if (zzaT != null) {
            try {
                IObjectWrapper zza2 = zzaT.zza(zzn.zzw(context), str, i);
                if (zzn.zzE(zza2) != null) {
                    return new DynamiteModule((Context) zzn.zzE(zza2));
                }
                throw new zzc(str2, (zza) null);
            } catch (RemoteException e) {
                throw new zzc(str2, e, null);
            }
        } else {
            throw new zzc("Failed to create IDynamiteLoader.", (zza) null);
        }
    }

    private static int zzc(Context context, String str, boolean z) {
        zzj zzaT = zzaT(context);
        if (zzaT == null) {
            return 0;
        }
        try {
            return zzaT.zza(zzn.zzw(context), str, z);
        } catch (RemoteException e) {
            String str2 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return 0;
        }
    }

    private static DynamiteModule zzc(Context context, String str, int i) throws zzc {
        zzl zzl;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            zzl = zzaSH;
        }
        if (zzl != null) {
            zza zza2 = (zza) zzaSJ.get();
            if (zza2 == null || zza2.zzaSR == null) {
                throw new zzc("No result cursor", (zza) null);
            }
            Context zza3 = zza(context.getApplicationContext(), str, i, zza2.zzaSR, zzl);
            if (zza3 != null) {
                return new DynamiteModule(zza3);
            }
            throw new zzc("Failed to get module context", (zza) null);
        }
        throw new zzc("DynamiteLoaderV2 was not cached.", (zza) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzd(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.zzc {
        /*
            r0 = 0
            if (r10 == 0) goto L_0x0006
            java.lang.String r10 = "api_force_staging"
            goto L_0x0008
        L_0x0006:
            java.lang.String r10 = "api"
        L_0x0008:
            java.lang.String r1 = "content://com.google.android.gms.chimera/"
            int r2 = r1.length()     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            int r2 = r2 + 1
            int r3 = r10.length()     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            int r2 = r2 + r3
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            int r3 = r3.length()     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            r3.append(r1)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            r3.append(r10)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            java.lang.String r10 = "/"
            r3.append(r10)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            r3.append(r9)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            java.lang.String r9 = r3.toString()     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            android.net.Uri r2 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            if (r8 == 0) goto L_0x007a
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            if (r9 == 0) goto L_0x007a
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            if (r9 <= 0) goto L_0x0074
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch:{ all -> 0x0071 }
            zzaSI = r1     // Catch:{ all -> 0x0071 }
            monitor-exit(r10)     // Catch:{ all -> 0x0071 }
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$zza> r10 = zzaSJ     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            java.lang.Object r10 = r10.get()     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            com.google.android.gms.dynamite.DynamiteModule$zza r10 = (com.google.android.gms.dynamite.DynamiteModule.zza) r10     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            if (r10 == 0) goto L_0x0074
            android.database.Cursor r1 = r10.zzaSR     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            if (r1 != 0) goto L_0x0074
            r10.zzaSR = r8     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            r8 = r0
            goto L_0x0074
        L_0x0071:
            r9 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0071 }
            throw r9     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
        L_0x0074:
            if (r8 == 0) goto L_0x0079
            r8.close()
        L_0x0079:
            return r9
        L_0x007a:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            com.google.android.gms.dynamite.DynamiteModule$zzc r9 = new com.google.android.gms.dynamite.DynamiteModule$zzc     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            throw r9     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
        L_0x0089:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto L_0x00a5
        L_0x008d:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x0096
        L_0x0092:
            r8 = move-exception
            goto L_0x00a5
        L_0x0094:
            r8 = move-exception
            r9 = r0
        L_0x0096:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.zzc     // Catch:{ all -> 0x00a3 }
            if (r10 == 0) goto L_0x009b
            throw r8     // Catch:{ all -> 0x00a3 }
        L_0x009b:
            com.google.android.gms.dynamite.DynamiteModule$zzc r10 = new com.google.android.gms.dynamite.DynamiteModule$zzc     // Catch:{ all -> 0x00a3 }
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch:{ all -> 0x00a3 }
            throw r10     // Catch:{ all -> 0x00a3 }
        L_0x00a3:
            r8 = move-exception
            r0 = r9
        L_0x00a5:
            if (r0 == 0) goto L_0x00aa
            r0.close()
        L_0x00aa:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzd(android.content.Context, java.lang.String, boolean):int");
    }

    public final IBinder zzcV(String str) throws zzc {
        try {
            return (IBinder) this.zzaSQ.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String str2 = "Failed to instantiate module class: ";
            String valueOf = String.valueOf(str);
            throw new zzc(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e, null);
        }
    }

    public final Context zztC() {
        return this.zzaSQ;
    }
}
