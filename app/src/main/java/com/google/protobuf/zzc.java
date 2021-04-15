package com.google.protobuf;

final class zzc {
    private static Class<?> zzcrO = zzLq();

    private static Class<?> zzLq() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzd zzLr() {
        Class<?> cls = zzcrO;
        if (cls != null) {
            try {
                return (zzd) cls.getMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return zzd.zzcrR;
    }
}
