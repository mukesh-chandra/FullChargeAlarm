package com.facebook.ads;

import com.facebook.ads.C0466Ad.LoadConfigBuilder;

public interface FullScreenAd extends C0466Ad {

    public interface ShowAdConfig {
    }

    public interface ShowConfigBuilder {
        ShowAdConfig build();
    }

    LoadConfigBuilder buildLoadAdConfig();

    ShowConfigBuilder buildShowAdConfig();

    boolean show();
}
