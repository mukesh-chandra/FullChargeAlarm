package com.readytofire.fullchargealarm.helper;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import java.util.Locale;

public class LocaleManager {
    public static final String LANGUAGE_Arabic = "ar";
    public static final String LANGUAGE_Bengali = "bn";
    public static final String LANGUAGE_Chinese = "zh";
    public static final String LANGUAGE_ENGLISH = "en";
    public static final String LANGUAGE_Filipino = "fil";
    public static final String LANGUAGE_French = "fr";
    public static final String LANGUAGE_HINDI = "hi";
    public static final String LANGUAGE_Indonesian = "in";
    public static final String LANGUAGE_Japanese = "ja";
    private static final String LANGUAGE_KEY = "language_key";
    public static final String LANGUAGE_Malay = "ms";
    public static final String LANGUAGE_Persian = "fa";
    public static final String LANGUAGE_Portuguese = "pt";
    public static final String LANGUAGE_Russion = "ru";
    public static final String LANGUAGE_SPANISH = "es";
    public static final String LANGUAGE_Swedish = "sv";
    public static final String LANGUAGE_Thai = "th";
    public static final String LANGUAGE_Urdu = "ur";

    public static Context setLocale(Context c) {
        return updateResources(c, getLanguage(c));
    }

    public static Context setNewLocale(Context c, String language) {
        persistLanguage(c, language);
        return updateResources(c, language);
    }

    public static String getLanguage(Context c) {
        return PreferenceManager.getDefaultSharedPreferences(c).getString(LANGUAGE_KEY, LANGUAGE_ENGLISH);
    }

    private static void persistLanguage(Context c, String language) {
        PreferenceManager.getDefaultSharedPreferences(c).edit().putString(LANGUAGE_KEY, language).commit();
    }

    private static Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        if (VERSION.SDK_INT >= 17) {
            config.setLocale(locale);
            return context.createConfigurationContext(config);
        }
        config.locale = locale;
        res.updateConfiguration(config, res.getDisplayMetrics());
        return context;
    }

    public static Locale getLocale(Resources res) {
        Configuration config = res.getConfiguration();
        return VERSION.SDK_INT >= 24 ? config.getLocales().get(0) : config.locale;
    }
}
