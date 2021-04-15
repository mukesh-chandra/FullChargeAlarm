package com.facebook.ads.internal.api;

import android.graphics.drawable.Drawable;
import android.view.View.OnTouchListener;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdBase.MediaCacheFlag;
import com.facebook.ads.NativeAdBase.NativeAdLoadConfigBuilder;
import com.facebook.ads.NativeAdBase.NativeLoadAdConfig;
import com.facebook.ads.NativeAdListener;

public interface NativeAdBaseApi {
    NativeAdLoadConfigBuilder buildLoadAdConfig(NativeAdBase nativeAdBase);

    void destroy();

    void downloadMedia();

    String getAdBodyText();

    String getAdCallToAction();

    NativeAdImageApi getAdChoicesIcon();

    String getAdChoicesImageUrl();

    String getAdChoicesLinkUrl();

    String getAdChoicesText();

    NativeAdImageApi getAdCoverImage();

    String getAdHeadline();

    NativeAdImageApi getAdIcon();

    String getAdLinkDescription();

    String getAdSocialContext();

    @Deprecated
    NativeAdRatingApi getAdStarRating();

    String getAdTranslation();

    String getAdUntrimmedBodyText();

    String getAdvertiserName();

    float getAspectRatio();

    String getId();

    String getPlacementId();

    Drawable getPreloadedIconViewDrawable();

    String getPromotedTranslation();

    String getSponsoredTranslation();

    boolean hasCallToAction();

    boolean isAdInvalidated();

    boolean isAdLoaded();

    void loadAd();

    @Deprecated
    void loadAd(MediaCacheFlag mediaCacheFlag);

    void loadAd(NativeLoadAdConfig nativeLoadAdConfig);

    @Deprecated
    void loadAdFromBid(String str);

    @Deprecated
    void loadAdFromBid(String str, MediaCacheFlag mediaCacheFlag);

    void onCtaBroadcast();

    void setAdListener(NativeAdListener nativeAdListener, NativeAdBase nativeAdBase);

    void setExtraHints(ExtraHints extraHints);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void unregisterView();
}
