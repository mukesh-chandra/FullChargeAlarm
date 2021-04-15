package com.facebook.ads.internal.api;

import android.content.res.Configuration;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdView.AdViewLoadConfig;
import com.facebook.ads.AdView.AdViewLoadConfigBuilder;
import com.facebook.ads.C0466Ad;
import com.facebook.ads.ExtraHints;

public interface AdViewApi extends AdViewParentApi, C0466Ad {
    AdViewLoadConfigBuilder buildLoadAdConfig();

    void loadAd(AdViewLoadConfig adViewLoadConfig);

    void onConfigurationChanged(Configuration configuration);

    void setAdListener(AdListener adListener);

    @Deprecated
    void setExtraHints(ExtraHints extraHints);
}
