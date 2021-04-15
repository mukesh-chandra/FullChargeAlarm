package com.facebook.ads.internal.api;

import android.os.Bundle;
import com.facebook.ads.C0466Ad;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.InstreamVideoAdListener;
import com.facebook.ads.InstreamVideoAdView.InstreamVideoLoadAdConfig;
import com.facebook.ads.InstreamVideoAdView.InstreamVideoLoadConfigBuilder;

public interface InstreamVideoAdViewApi extends C0466Ad {
    InstreamVideoLoadConfigBuilder buildLoadAdConfig();

    void destroy();

    String getPlacementId();

    Bundle getSaveInstanceState();

    boolean isAdInvalidated();

    boolean isAdLoaded();

    void loadAd();

    void loadAd(InstreamVideoLoadAdConfig instreamVideoLoadAdConfig);

    @Deprecated
    void loadAdFromBid(String str);

    void setAdListener(InstreamVideoAdListener instreamVideoAdListener);

    @Deprecated
    void setExtraHints(ExtraHints extraHints);

    void setIsAdLoaded(boolean z);

    boolean show();
}
