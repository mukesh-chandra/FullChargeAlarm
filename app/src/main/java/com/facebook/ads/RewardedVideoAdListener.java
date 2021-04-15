package com.facebook.ads;

public interface RewardedVideoAdListener extends AdListener {
    void onLoggingImpression(C0466Ad ad);

    void onRewardedVideoClosed();

    void onRewardedVideoCompleted();
}
