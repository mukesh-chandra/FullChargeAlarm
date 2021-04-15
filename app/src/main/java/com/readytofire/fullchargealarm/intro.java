package com.readytofire.fullchargealarm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.readytofire.fullchargealarm.helper.LocaleManager;
import psquare.FullChargeAlarm.R;

public class intro extends AppCompatActivity {
    /* access modifiers changed from: private */
    public Button btnNext;
    /* access modifiers changed from: private */
    public Button btnSkip;
    private TextView[] dots;
    private LinearLayout dotsLayout;

    /* renamed from: k */
    int f77k = 0;
    /* access modifiers changed from: private */
    public int[] layouts;
    private MyViewPagerAdapter myViewPagerAdapter;
    SharedPreferences pref;
    /* access modifiers changed from: private */
    public ViewPager viewPager;
    OnPageChangeListener viewPagerPageChangeListener = new OnPageChangeListener() {
        public void onPageSelected(int position) {
            intro.this.addBottomDots(position);
            if (position == intro.this.layouts.length - 1) {
                intro.this.btnNext.setText(intro.this.getString(R.string.start));
                intro.this.btnSkip.setVisibility(8);
                return;
            }
            intro.this.btnNext.setText(intro.this.getString(R.string.next));
            intro.this.btnSkip.setVisibility(0);
        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        public void onPageScrollStateChanged(int arg0) {
        }
    };

    public class MyViewPagerAdapter extends PagerAdapter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private LayoutInflater layoutInflater;

        static {
            Class<intro> cls = intro.class;
        }

        public MyViewPagerAdapter() {
        }

        public Object instantiateItem(ViewGroup container, int position) {
            this.layoutInflater = (LayoutInflater) intro.this.getSystemService("layout_inflater");
            View view = this.layoutInflater.inflate(intro.this.layouts[position], container, false);
            try {
                container.addView(view);
            } catch (Exception e) {
            }
            return view;
        }

        public int getCount() {
            return intro.this.layouts.length;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        Editor editor = this.pref.edit();
        String str = "firstl";
        this.f77k = this.pref.getInt(str, 0);
        if (this.f77k == 5) {
            editor.putInt(str, 1);
            editor.apply();
        }
        if (VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(1280);
        }
        setContentView((int) R.layout.activity_intro);
        this.viewPager = (ViewPager) findViewById(R.id.view_pager);
        this.dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        this.btnSkip = (Button) findViewById(R.id.btn_skip);
        this.btnNext = (Button) findViewById(R.id.btn_next);
        this.layouts = new int[]{R.layout.welcome_slide1, R.layout.welcome_slide2};
        addBottomDots(0);
        changeStatusBarColor();
        this.myViewPagerAdapter = new MyViewPagerAdapter();
        this.viewPager.setAdapter(this.myViewPagerAdapter);
        this.viewPager.addOnPageChangeListener(this.viewPagerPageChangeListener);
        this.btnSkip.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (intro.this.f77k == 5) {
                    intro.this.finish();
                } else {
                    intro.this.launchHomeScreen();
                }
            }
        });
        this.btnNext.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                int current = intro.this.getItem(1);
                if (current < intro.this.layouts.length) {
                    intro.this.viewPager.setCurrentItem(current);
                } else if (intro.this.f77k == 5) {
                    intro.this.finish();
                } else {
                    intro.this.launchHomeScreen();
                }
            }
        });
        resetTitles();
    }

    /* access modifiers changed from: private */
    public void addBottomDots(int currentPage) {
        TextView[] textViewArr;
        this.dots = new TextView[this.layouts.length];
        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);
        this.dotsLayout.removeAllViews();
        int i = 0;
        while (true) {
            textViewArr = this.dots;
            if (i >= textViewArr.length) {
                break;
            }
            textViewArr[i] = new TextView(this);
            this.dots[i].setText(Html.fromHtml("&#8226;"));
            this.dots[i].setTextSize(35.0f);
            this.dots[i].setTextColor(colorsActive[currentPage]);
            this.dotsLayout.addView(this.dots[i]);
            i++;
        }
        if (textViewArr.length > 0) {
            textViewArr[currentPage].setTextColor(colorsInactive[currentPage]);
        }
    }

    /* access modifiers changed from: private */
    public int getItem(int i) {
        return this.viewPager.getCurrentItem() + i;
    }

    /* access modifiers changed from: private */
    public void launchHomeScreen() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void changeStatusBarColor() {
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
    }

    private void resetTitles() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), 128);
            if (info.labelRes != 0) {
                setTitle(info.labelRes);
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
