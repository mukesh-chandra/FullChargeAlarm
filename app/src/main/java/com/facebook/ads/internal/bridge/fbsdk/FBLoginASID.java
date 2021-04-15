package com.facebook.ads.internal.bridge.fbsdk;

public class FBLoginASID {
    public static String getFBLoginASID() {
        String str = "com.facebook.AccessToken";
        try {
            Object invoke = Class.forName(str).getDeclaredMethod("getCurrentAccessToken", new Class[0]).invoke(null, new Object[0]);
            if (invoke != null) {
                return (String) Class.forName(str).getDeclaredMethod("getUserId", new Class[0]).invoke(invoke, new Object[0]);
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
