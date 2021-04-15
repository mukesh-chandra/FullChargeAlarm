package com.readytofire.fullchargealarm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.readytofire.fullchargealarm.helper.LocaleManager;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private AdView adView;
    Mylist adp;
    Animation animation1;

    /* renamed from: ar */
    ArrayList<Integer> f49ar = new ArrayList<>();
    Editor editor;

    /* renamed from: gv */
    GridView f50gv;

    /* renamed from: jh */
    int f51jh = 0;
    int lbb = 0;

    /* renamed from: lv */
    int f52lv = 0;
    public BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
        public void onReceive(Context arg0, Intent intent) {
            String str;
            String plg;
            Intent intent2 = intent;
            int level = intent2.getIntExtra("level", 0);
            MainActivity mainActivity = MainActivity.this;
            mainActivity.f52lv = level;
            mainActivity.mProgressStatus = level;
            TextView access$100 = MainActivity.this.mTextViewPercentage;
            StringBuilder sb = new StringBuilder();
            String str2 = BuildConfig.FLAVOR;
            sb.append(str2);
            sb.append(MainActivity.this.mProgressStatus);
            sb.append("%");
            access$100.setText(sb.toString());
            MainActivity.this.mProgressBar.setProgress(MainActivity.this.mProgressStatus);
            int temp = intent2.getIntExtra("temperature", 0) / 10;
            double d = (double) temp;
            Double.isNaN(d);
            String frnn = String.format("%.1f", new Object[]{Double.valueOf((d * 1.8d) + 32.0d)});
            int health = intent2.getIntExtra("health", 0);
            MainActivity.this.voltage = intent2.getIntExtra("voltage", 0);
            String technology = intent2.getStringExtra("technology");
            try {
                if (technology.equals(str2)) {
                    technology = "UNKNOWN";
                }
            } catch (NullPointerException e) {
            }
            MainActivity.this.plugged = intent2.getIntExtra("plugged", -1);
            if (health == 1) {
                str = MainActivity.this.getResources().getString(R.string.btr_htl_1);
            } else if (health == 2) {
                str = MainActivity.this.getResources().getString(R.string.btr_htl_2);
            } else if (health == 3) {
                str = MainActivity.this.getResources().getString(R.string.btr_htl_3);
            } else if (health == 4) {
                str = MainActivity.this.getResources().getString(R.string.btr_htl_4);
            } else if (health == 5) {
                str = MainActivity.this.getResources().getString(R.string.btr_htl_5);
            } else if (health == 7) {
                str = MainActivity.this.getResources().getString(R.string.btr_htl_6);
            } else {
                str = MainActivity.this.getResources().getString(R.string.btr_htl_7);
            }
            if (MainActivity.this.plugged == 1) {
                plg = MainActivity.this.getResources().getString(R.string.btr_chrg_ac);
            } else if (MainActivity.this.plugged == 2) {
                plg = MainActivity.this.getResources().getString(R.string.btr_chrg_usb);
            } else if (MainActivity.this.plugged == 4) {
                plg = MainActivity.this.getResources().getString(R.string.btr_chrg_wls);
            } else {
                plg = MainActivity.this.getResources().getString(R.string.btr_chrg_no);
            }
            MainActivity.this.strr.set(0, str);
            ArrayList<String> arrayList = MainActivity.this.strr;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(temp);
            sb2.append("℃ / ");
            sb2.append(frnn);
            sb2.append("°F");
            arrayList.set(1, sb2.toString());
            MainActivity.this.strr.set(2, technology);
            MainActivity.this.strr.set(3, plg);
            ArrayList<String> arrayList2 = MainActivity.this.strr;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(MainActivity.this.voltage);
            sb3.append(" mV");
            arrayList2.set(4, sb3.toString());
            MainActivity.this.adp.notifyDataSetChanged();
            boolean po = MainActivity.this.isMyServiceRunning(AlarmService.class);
            if (MainActivity.this.f51jh == 0) {
                MainActivity mainActivity2 = MainActivity.this;
                mainActivity2.f51jh = 1;
                if ((mainActivity2.plugged == 1 && !po) || (MainActivity.this.plugged == 2 && !po)) {
                    Intent abc = new Intent(MainActivity.this.getApplicationContext(), AlarmService.class);
                    if (VERSION.SDK_INT >= 26) {
                        MainActivity.this.startForegroundService(abc);
                    } else {
                        MainActivity.this.startService(abc);
                    }
                }
            }
            if (!po) {
                MainActivity.this.sts.clearAnimation();
                MainActivity.this.sts.setText(str2);
            }
        }
    };
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            MainActivity.this.sts.setText(intent.getStringExtra("key"));
            if (!MainActivity.this.animation1.hasStarted() || MainActivity.this.animation1.hasEnded()) {
                MainActivity.this.sts.startAnimation(MainActivity.this.animation1);
            }
        }
    };
    private OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new OnNavigationItemSelectedListener() {
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_pm /*2131296414*/:
                    if (Build.BRAND.equalsIgnoreCase("xiaomi")) {
                        try {
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
                            MainActivity.this.startActivityForResult(intent, 2);
                        } catch (Exception e) {
                        }
                    } else if (Build.BRAND.equalsIgnoreCase("Letv")) {
                        Intent intent2 = new Intent();
                        intent2.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity"));
                        MainActivity.this.startActivityForResult(intent2, 2);
                    } else if (Build.BRAND.equalsIgnoreCase("Samsung")) {
                        MainActivity.this.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:psquare.FullChargeAlarm")));
                    } else {
                        MainActivity mainActivity = MainActivity.this;
                        mainActivity.editor = mainActivity.preferences.edit();
                        MainActivity.this.editor.putInt("firstl", 5);
                        MainActivity.this.editor.apply();
                        MainActivity mainActivity2 = MainActivity.this;
                        mainActivity2.startActivity(new Intent(mainActivity2.getApplicationContext(), intro.class));
                    }
                    return true;
                case R.id.navigation_setting /*2131296415*/:
                    MainActivity mainActivity3 = MainActivity.this;
                    mainActivity3.startActivity(new Intent(mainActivity3.getApplicationContext(), SettingsActivity.class));
                    return true;
                case R.id.navigation_stop_alarm /*2131296416*/:
                    boolean run = MainActivity.this.isMyServiceRunning(AlarmService.class);
                    Resources rs = MainActivity.this.getResources();
                    if (run) {
                        Toast.makeText(MainActivity.this.getApplicationContext(), rs.getString(R.string.mn_stp_01), Toast.LENGTH_LONG).show();
                        MainActivity mainActivity4 = MainActivity.this;
                        mainActivity4.stopService(new Intent(mainActivity4.getApplicationContext(), AlarmService.class));
                        MainActivity.this.f53st = 1;
                    } else if (MainActivity.this.f53st == 1) {
                        Toast.makeText(MainActivity.this.getApplicationContext(), rs.getString(R.string.mn_stp_02), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this.getApplicationContext(), rs.getString(R.string.mn_stp_03), Toast.LENGTH_SHORT).show();
                    }
                    return true;
                default:
                    return false;
            }
        }
    };
    /* access modifiers changed from: private */
    public ProgressBar mProgressBar;
    /* access modifiers changed from: private */
    public int mProgressStatus = 0;
    /* access modifiers changed from: private */
    public TextView mTextViewPercentage;
    int plugged;
    SharedPreferences preferences;

    /* renamed from: st */
    int f53st = 0;
    ArrayList<String> strr = new ArrayList<>();
    TextView sts;
    int voltage = 0;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        int pg;
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        this.adView = new AdView((Context) this, "1058058391207014_1061281487551371", AdSize.BANNER_HEIGHT_50);
        ((LinearLayout) findViewById(R.id.banner_container)).addView(this.adView);
        this.adView.loadAd();
        this.preferences = getApplicationContext().getSharedPreferences("MyPref", 0);
        resetTitles();
        String str = "mnafirst";
        if (this.preferences.getInt(str, 0) == 0) {
            this.editor = this.preferences.edit();
            this.editor.putInt(str, 1);
            this.editor.apply();
            if (Build.BRAND.equalsIgnoreCase("xiaomi")) {
                try {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
                    startActivityForResult(intent, 2);
                } catch (Exception e) {
                }
            } else if (Build.BRAND.equalsIgnoreCase("Letv")) {
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity"));
                startActivityForResult(intent2, 2);
            }
        }
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "digital.ttf");
        this.strr.add("Good");
        this.strr.add("36 ℃");
        this.strr.add("Li-ion");
        this.strr.add("Charging");
        this.strr.add("4.1 Volt");
        ArrayList<String> arrayList = this.strr;
        StringBuilder sb = new StringBuilder();
        sb.append(getBatteryCapacity());
        sb.append(" Mah");
        arrayList.add(sb.toString());
        this.f49ar.add(Integer.valueOf(R.drawable.hltt));
        this.f49ar.add(Integer.valueOf(R.drawable.tm));
        this.f49ar.add(Integer.valueOf(R.drawable.tch));
        this.f49ar.add(Integer.valueOf(R.drawable.ch));
        this.f49ar.add(Integer.valueOf(R.drawable.volt));
        this.f49ar.add(Integer.valueOf(R.drawable.mh));
        this.animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.an3);
        this.sts = (TextView) findViewById(R.id.textView2);
        this.mTextViewPercentage = (TextView) findViewById(R.id.tv_percentage);
        this.mProgressBar = (ProgressBar) findViewById(R.id.pb);
        this.mTextViewPercentage.setTypeface(myTypeface);
        registerReceiver(this.mBatInfoReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String str2 = "100";
        String str3 = "example_text";
        try {
            pg = Integer.valueOf(sharedPref.getString(str3, str2)).intValue();
        } catch (NumberFormatException e2) {
            pg = 100;
        }
        if (pg > 100) {
            pg = 100;
            Editor edt = sharedPref.edit();
            edt.putString(str3, str2);
            edt.apply();
        }
        if (!sharedPref.getBoolean("alm_full", true)) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mn_tost_1), Toast.LENGTH_SHORT).show();
        } else {
            Context applicationContext = getApplicationContext();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getResources().getString(R.string.mn_tost_2));
            sb2.append(" ");
            sb2.append(pg);
            sb2.append("%");
            Toast.makeText(applicationContext, sb2.toString(), Toast.LENGTH_LONG).show();
        }
        this.f50gv = (GridView) findViewById(R.id.grd);
        this.adp = new Mylist(getApplicationContext(), this.strr, this.f49ar);
        this.f50gv.setAdapter(this.adp);
        this.f50gv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String str = " ";
                if (position == 0) {
                    MainActivity mainActivity = MainActivity.this;
                    String string = mainActivity.getResources().getString(R.string.mndlg_htl_vls);
                    StringBuilder sb = new StringBuilder();
                    sb.append(MainActivity.this.getResources().getString(R.string.mndlg_htl));
                    sb.append(str);
                    sb.append((String) MainActivity.this.strr.get(0));
                    new DialogMain(mainActivity, position, string, sb.toString()).show();
                } else if (position == 1) {
                    MainActivity mainActivity2 = MainActivity.this;
                    String string2 = mainActivity2.getResources().getString(R.string.mndlg_2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(MainActivity.this.getResources().getString(R.string.mndlg_21));
                    sb2.append(str);
                    sb2.append((String) MainActivity.this.strr.get(1));
                    new DialogMain(mainActivity2, position, string2, sb2.toString()).show();
                } else if (position == 2) {
                    MainActivity mainActivity3 = MainActivity.this;
                    new DialogMain(mainActivity3, position, mainActivity3.getResources().getString(R.string.mndlg_3), MainActivity.this.getResources().getString(R.string.mndlg_31)).show();
                } else if (position == 3) {
                    MainActivity mainActivity4 = MainActivity.this;
                    new DialogMain(mainActivity4, position, mainActivity4.getResources().getString(R.string.mndlg_4), MainActivity.this.getResources().getString(R.string.mndlg_41)).show();
                } else if (position == 4) {
                    String tr = String.format("%.1f", new Object[]{Float.valueOf(((float) MainActivity.this.voltage) / 1000.0f)});
                    MainActivity mainActivity5 = MainActivity.this;
                    String string3 = mainActivity5.getResources().getString(R.string.mndlg_5);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(MainActivity.this.getResources().getString(R.string.mndlg_51));
                    sb3.append(str);
                    sb3.append(tr);
                    sb3.append(" Volt");
                    new DialogMain(mainActivity5, position, string3, sb3.toString()).show();
                } else if (position == 5) {
                    int tl = MainActivity.this.getBatteryCapacity();
                    int pi = (tl / 100) * MainActivity.this.f52lv;
                    MainActivity mainActivity6 = MainActivity.this;
                    String string4 = mainActivity6.getResources().getString(R.string.mndlg_6);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(MainActivity.this.getResources().getString(R.string.mndlg_61));
                    sb4.append(str);
                    sb4.append(pi);
                    sb4.append(" Mah / ");
                    sb4.append(MainActivity.this.getResources().getString(R.string.mndlg_62));
                    sb4.append(str);
                    sb4.append(tl);
                    sb4.append(" MAh");
                    new DialogMain(mainActivity6, position, string4, sb4.toString()).show();
                }
            }
        });
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelected(false);
        navigation.setOnNavigationItemSelectedListener(this.mOnNavigationItemSelectedListener);
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.mMessageReceiver, new IntentFilter("intentKey"));
    }

    /* access modifiers changed from: private */
    public boolean isMyServiceRunning(Class<?> serviceClass) {
        for (RunningServiceInfo service : ((ActivityManager) getSystemService("activity")).getRunningServices(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public int getBatteryCapacity() {
        String str = "com.android.internal.os.PowerProfile";
        Object mPowerProfile_ = null;
        double batteryCapacity = 0.0d;
        String str2 = "com.android.internal.os.PowerProfile";
        try {
            mPowerProfile_ = Class.forName(str).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this});
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            batteryCapacity = ((Double) Class.forName(str).getMethod("getAveragePower", new Class[]{String.class}).invoke(mPowerProfile_, new Object[]{"battery.capacity"})).doubleValue();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return (int) batteryCapacity;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Builder aler;
        switch (item.getItemId()) {
            case R.id.abt /*2131296263*/:
                startActivity(new Intent(getApplicationContext(), about.class));
                break;
            case R.id.fdb /*2131296371*/:
                if (VERSION.SDK_INT >= 21) {
                    aler = new Builder(this, R.style.MyAlertDialogfaq);
                } else {
                    aler = new Builder(this);
                }
                aler.setTitle((CharSequence) getResources().getString(R.string.set_er_hd));
                aler.setIcon((int) R.drawable.ic_err);
                aler.setMessage((CharSequence) getResources().getString(R.string.set_ques));
                aler.setNegativeButton((CharSequence) getResources().getString(R.string.set_er_btn_neg), (OnClickListener) new OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Device Info:");
                        sb.append("\n OS Version: ");
                        sb.append(System.getProperty("os.version"));
                        sb.append("(");
                        sb.append(VERSION.INCREMENTAL);
                        String str = ")";
                        sb.append(str);
                        String deviceInfo = sb.toString();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(deviceInfo);
                        sb2.append("\n OS API Level: ");
                        sb2.append(VERSION.SDK_INT);
                        String deviceInfo2 = sb2.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(deviceInfo2);
                        sb3.append("\n Device: ");
                        sb3.append(Build.DEVICE);
                        String deviceInfo3 = sb3.toString();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(deviceInfo3);
                        sb4.append("\n Model (and Product): ");
                        sb4.append(Build.MODEL);
                        sb4.append(" (");
                        sb4.append(Build.PRODUCT);
                        sb4.append(str);
                        String deviceInfo4 = sb4.toString();
                        Intent emailIntent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "psquare.apps@gmail.com", null));
                        emailIntent.putExtra("android.intent.extra.SUBJECT", "FcA Error Report");
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(deviceInfo4);
                        sb5.append("\n\nPlease Describe Your Issue or Problem Here\n:-");
                        emailIntent.putExtra("android.intent.extra.TEXT", sb5.toString());
                        MainActivity.this.startActivity(Intent.createChooser(emailIntent, "Send email..."));
                    }
                });
                aler.setPositiveButton((CharSequence) getResources().getString(R.string.set_er_btn_pos), (OnClickListener) new OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        arg0.dismiss();
                    }
                });
                aler.show();
                break;
            case R.id.pms /*2131296432*/:
                this.editor = this.preferences.edit();
                this.editor.putInt("firstl", 5);
                this.editor.apply();
                startActivity(new Intent(getApplicationContext(), intro.class));
                break;
            case R.id.sett /*2131296464*/:
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                break;
            case R.id.shrr /*2131296469*/:
                try {
                    Intent i = new Intent("android.intent.action.SEND");
                    i.setType("text/plain");
                    i.putExtra("android.intent.extra.SUBJECT", "My application name");
                    StringBuilder sb = new StringBuilder();
                    sb.append("\n");
                    sb.append(getResources().getString(R.string.shr_txt));
                    String sAux = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(sAux);
                    sb2.append("https://play.google.com/store/apps/details?id=psquare.FullChargeAlarm \n\n");
                    i.putExtra("android.intent.extra.TEXT", sb2.toString());
                    startActivity(Intent.createChooser(i, getResources().getString(R.string.shr_chs)));
                    break;
                } catch (Exception e) {
                    break;
                }
            default:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        try {
            registerReceiver(this.mBatInfoReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
        }
        if (PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("alm_low", false) && !isMyServiceRunning(AlarmService.class) && this.lbb == 0) {
            this.lbb = 1;
            startService(new Intent(getApplicationContext(), batterylow.class));
        }
        this.animation1.start();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        BroadcastReceiver broadcastReceiver = this.mBatInfoReceiver;
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
    }

    private void resetTitles() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            if (info.labelRes != 0) {
                setTitle(info.labelRes);
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void onBackPressed() {
        int i = this.plugged;
        if (i == 1 || i == 2 || i == 4) {
            moveTaskToBack(true);
        } else {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        AdView adView2 = this.adView;
        if (adView2 != null) {
            adView2.destroy();
        }
        super.onDestroy();
    }
}
