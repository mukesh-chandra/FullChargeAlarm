package com.facebook.ads;

import android.content.Context;
import com.facebook.ads.C0466Ad.LoadAdConfig;
import com.facebook.ads.C0466Ad.LoadConfigBuilder;
import com.facebook.ads.FullScreenAd.ShowAdConfig;
import com.facebook.ads.FullScreenAd.ShowConfigBuilder;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

public class RewardedVideoAd implements FullScreenAd {
    public static final int UNSET_VIDEO_DURATION = -1;
    private final RewardedVideoAdApi mRewardedVideoAdApi;

    public interface RewardedVideoAdLoadConfigBuilder extends LoadConfigBuilder {
        RewardedVideoLoadAdConfig build();

        RewardedVideoAdLoadConfigBuilder withAdListener(RewardedVideoAdListener rewardedVideoAdListener);

        RewardedVideoAdLoadConfigBuilder withBid(String str);

        RewardedVideoAdLoadConfigBuilder withFailOnCacheFailureEnabled(boolean z);

        @Deprecated
        RewardedVideoAdLoadConfigBuilder withRVChainEnabled(boolean z);

        RewardedVideoAdLoadConfigBuilder withRewardData(RewardData rewardData);
    }

    public interface RewardedVideoAdShowConfigBuilder extends ShowConfigBuilder {
        RewardedVideoShowAdConfig build();

        RewardedVideoAdShowConfigBuilder withAppOrientation(int i);
    }

    public interface RewardedVideoLoadAdConfig extends LoadAdConfig {
    }

    public interface RewardedVideoShowAdConfig extends ShowAdConfig {
    }

    @Deprecated
    public void enableRVChain(boolean z) {
    }

    public RewardedVideoAd(Context context, String str) {
        this.mRewardedVideoAdApi = DynamicLoaderFactory.makeLoader(context).createRewardedVideoAd(context, str, this);
    }

    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mRewardedVideoAdApi.setExtraHints(extraHints);
    }

    public void loadAd() {
        this.mRewardedVideoAdApi.loadAd();
    }

    public void loadAd(RewardedVideoLoadAdConfig rewardedVideoLoadAdConfig) {
        this.mRewardedVideoAdApi.loadAd(rewardedVideoLoadAdConfig);
    }

    @Deprecated
    public void loadAd(boolean z) {
        this.mRewardedVideoAdApi.loadAd(z);
    }

    @Deprecated
    public void loadAdFromBid(String str) {
        this.mRewardedVideoAdApi.loadAdFromBid(str);
    }

    @Deprecated
    public void loadAdFromBid(String str, boolean z) {
        this.mRewardedVideoAdApi.loadAdFromBid(str, z);
    }

    public boolean isAdInvalidated() {
        return this.mRewardedVideoAdApi.isAdInvalidated();
    }

    public boolean show() {
        return this.mRewardedVideoAdApi.show();
    }

    public boolean show(RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        return this.mRewardedVideoAdApi.show(rewardedVideoShowAdConfig);
    }

    @Deprecated
    public boolean show(int i) {
        return this.mRewardedVideoAdApi.show(i);
    }

    @Deprecated
    public void setAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.mRewardedVideoAdApi.setAdListener(rewardedVideoAdListener);
    }

    public void destroy() {
        this.mRewardedVideoAdApi.destroy();
    }

    public boolean isAdLoaded() {
        return this.mRewardedVideoAdApi.isAdLoaded();
    }

    public String getPlacementId() {
        return this.mRewardedVideoAdApi.getPlacementId();
    }

    @Deprecated
    public void setRewardData(RewardData rewardData) {
        this.mRewardedVideoAdApi.setRewardData(rewardData);
    }

    public int getVideoDuration() {
        return this.mRewardedVideoAdApi.getVideoDuration();
    }

    public RewardedVideoAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mRewardedVideoAdApi.buildLoadAdConfig();
    }

    public RewardedVideoAdShowConfigBuilder buildShowAdConfig() {
        return this.mRewardedVideoAdApi.buildShowAdConfig();
    }
}
