package com.facebook.ads.internal.api;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

public interface AdComponentView {
    void addView(View view);

    void addView(View view, int i);

    void addView(View view, int i, int i2);

    void addView(View view, int i, LayoutParams layoutParams);

    void addView(View view, LayoutParams layoutParams);

    void onWindowFocusChanged(boolean z);

    void setLayoutParams(LayoutParams layoutParams);
}
