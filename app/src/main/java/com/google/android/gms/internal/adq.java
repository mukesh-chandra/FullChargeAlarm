package com.google.android.gms.internal;

import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.readytofire.fullchargealarm.BuildConfig;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class adq {
    private static void zza(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException, InvocationTargetException {
        Field[] fields;
        if (obj != null) {
            if (obj instanceof adp) {
                int length = stringBuffer.length();
                if (str != null) {
                    stringBuffer2.append(stringBuffer);
                    stringBuffer2.append(zzhR(str));
                    stringBuffer2.append(" <\n");
                    stringBuffer.append("  ");
                }
                Class cls = obj.getClass();
                for (Field field : cls.getFields()) {
                    int modifiers = field.getModifiers();
                    String name = field.getName();
                    if (!"cachedSize".equals(name) && (modifiers & 1) == 1 && (modifiers & 8) != 8) {
                        String str2 = "_";
                        if (!name.startsWith(str2) && !name.endsWith(str2)) {
                            Class type = field.getType();
                            Object obj2 = field.get(obj);
                            if (!type.isArray() || type.getComponentType() == Byte.TYPE) {
                                zza(name, obj2, stringBuffer, stringBuffer2);
                            } else {
                                int length2 = obj2 == null ? 0 : Array.getLength(obj2);
                                for (int i = 0; i < length2; i++) {
                                    zza(name, Array.get(obj2, i), stringBuffer, stringBuffer2);
                                }
                            }
                        }
                    }
                }
                for (Method name2 : cls.getMethods()) {
                    String name3 = name2.getName();
                    if (name3.startsWith("set")) {
                        String substring = name3.substring(3);
                        String str3 = "has";
                        try {
                            String valueOf = String.valueOf(substring);
                            if (((Boolean) cls.getMethod(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                                String str4 = "get";
                                String valueOf2 = String.valueOf(substring);
                                zza(substring, cls.getMethod(valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4), new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
                            }
                        } catch (NoSuchMethodException unused) {
                        }
                    }
                }
                if (str != null) {
                    stringBuffer.setLength(length);
                    stringBuffer2.append(stringBuffer);
                    stringBuffer2.append(">\n");
                }
                return;
            }
            String zzhR = zzhR(str);
            stringBuffer2.append(stringBuffer);
            stringBuffer2.append(zzhR);
            stringBuffer2.append(": ");
            if (obj instanceof String) {
                String str5 = (String) obj;
                if (!str5.startsWith("http") && str5.length() > 200) {
                    str5 = String.valueOf(str5.substring(0, Callback.DEFAULT_DRAG_ANIMATION_DURATION)).concat("[...]");
                }
                String zzcK = zzcK(str5);
                String str6 = "\"";
                stringBuffer2.append(str6);
                stringBuffer2.append(zzcK);
                stringBuffer2.append(str6);
            } else if (obj instanceof byte[]) {
                zza((byte[]) obj, stringBuffer2);
            } else {
                stringBuffer2.append(obj);
            }
            stringBuffer2.append("\n");
        }
    }

    private static void zza(byte[] bArr, StringBuffer stringBuffer) {
        if (bArr == null) {
            stringBuffer.append("\"\"");
            return;
        }
        stringBuffer.append('\"');
        for (byte b : bArr) {
            byte b2 = b & 255;
            if (b2 == 92 || b2 == 34) {
                stringBuffer.append('\\');
            } else if (b2 < 32 || b2 >= Byte.MAX_VALUE) {
                stringBuffer.append(String.format("\\%03o", new Object[]{Integer.valueOf(b2)}));
            }
            stringBuffer.append((char) b2);
        }
        stringBuffer.append('\"');
    }

    private static String zzcK(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                sb.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static <T extends adp> String zzd(T t) {
        String str = "Error printing proto: ";
        if (t == null) {
            return BuildConfig.FLAVOR;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            zza(null, t, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e) {
            String valueOf = String.valueOf(e.getMessage());
            return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        } catch (InvocationTargetException e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            return valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str);
        }
    }

    private static String zzhR(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (i != 0) {
                if (Character.isUpperCase(charAt)) {
                    stringBuffer.append('_');
                }
                stringBuffer.append(charAt);
            }
            charAt = Character.toLowerCase(charAt);
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }
}
