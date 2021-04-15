package com.facebook.ads;

import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.facebook.ads.C0466Ad.LoadAdConfig;
import com.facebook.ads.C0466Ad.LoadConfigBuilder;
import com.facebook.ads.internal.api.InstreamVideoAdViewApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

public class InstreamVideoAdView extends RelativeLayout implements C0466Ad {
    private final InstreamVideoAdViewApi mInstreamVideoAdViewApi;

    public interface InstreamVideoLoadAdConfig extends LoadAdConfig {
    }

    public interface InstreamVideoLoadConfigBuilder extends LoadConfigBuilder {
        InstreamVideoLoadAdConfig build();

        InstreamVideoLoadConfigBuilder withAdListener(InstreamVideoAdListener instreamVideoAdListener);

        InstreamVideoLoadConfigBuilder withBid(String str);
    }

    public InstreamVideoAdView(Context context, Bundle bundle) {
        super(context);
        this.mInstreamVideoAdViewApi = DynamicLoaderFactory.makeLoader(context).createInstreamVideoAdViewApi(this, context, bundle);
    }

    public InstreamVideoAdView(Context context, String str, AdSize adSize) {
        super(context);
        this.mInstreamVideoAdViewApi = DynamicLoaderFactory.makeLoader(context).createInstreamVideoAdViewApi(this, context, str, adSize);
    }

    public void loadAd() {
        this.mInstreamVideoAdViewApi.loadAd();
    }

    public void loadAd(InstreamVideoLoadAdConfig instreamVideoLoadAdConfig) {
        this.mInstreamVideoAdViewApi.loadAd(instreamVideoLoadAdConfig);
    }

    @Deprecated
    public void loadAdFromBid(String str) {
        this.mInstreamVideoAdViewApi.loadAdFromBid(str);
    }

    public boolean isAdInvalidated() {
        return this.mInstreamVideoAdViewApi.isAdInvalidated();
    }

    public boolean show() {
        return this.mInstreamVideoAdViewApi.show();
    }

    @Deprecated
    public void setAdListener(InstreamVideoAdListener instreamVideoAdListener) {
        this.mInstreamVideoAdViewApi.setAdListener(instreamVideoAdListener);
    }

    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mInstreamVideoAdViewApi.setExtraHints(extraHints);
    }

    public void destroy() {
        this.mInstreamVideoAdViewApi.destroy();
    }

    public boolean isAdLoaded() {
        return this.mInstreamVideoAdViewApi.isAdLoaded();
    }

    public String getPlacementId() {
        return this.mInstreamVideoAdViewApi.getPlacementId();
    }

    public Bundle getSaveInstanceState() {
        return this.mInstreamVideoAdViewApi.getSaveInstanceState();
    }

    public InstreamVideoLoadConfigBuilder buildLoadAdConfig() {
        return this.mInstreamVideoAdViewApi.buildLoadAdConfig();
    }
}
