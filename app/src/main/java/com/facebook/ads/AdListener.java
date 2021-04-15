package com.facebook.ads;

public interface AdListener {
    void onAdClicked(C0466Ad ad);

    void onAdLoaded(C0466Ad ad);

    void onError(C0466Ad ad, AdError adError);

    void onLoggingImpression(C0466Ad ad);
}
