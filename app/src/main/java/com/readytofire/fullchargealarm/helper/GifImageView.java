package com.readytofire.fullchargealarm.helper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import java.io.InputStream;

public class GifImageView extends View {
    private Context mContext;
    private int mHeight;
    private InputStream mInputStream;
    private Movie mMovie;
    private long mStart;
    private int mWidth;

    public GifImageView(Context context) {
        super(context);
        this.mContext = context;
    }

    public GifImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GifImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        if (attrs.getAttributeName(1).equals("background")) {
            setGifImageResource(Integer.parseInt(attrs.getAttributeValue(1).substring(1)));
        }
    }

    private void init() {
        setFocusable(true);
        this.mMovie = Movie.decodeStream(this.mInputStream);
        this.mWidth = this.mMovie.width();
        this.mHeight = this.mMovie.height();
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        long now = SystemClock.uptimeMillis();
        if (this.mStart == 0) {
            this.mStart = now;
        }
        Movie movie = this.mMovie;
        if (movie != null) {
            int duration = movie.duration();
            if (duration == 0) {
                duration = 1000;
            }
            this.mMovie.setTime((int) ((now - this.mStart) % ((long) duration)));
            this.mMovie.draw(canvas, 0.0f, 0.0f);
            invalidate();
        }
    }

    public void setGifImageResource(int id) {
        this.mInputStream = this.mContext.getResources().openRawResource(id);
        init();
    }
}
