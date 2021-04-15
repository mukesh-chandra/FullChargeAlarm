package com.readytofire.fullchargealarm;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.readytofire.fullchargealarm.helper.LocaleManager;
import java.util.ArrayList;

public class langAct extends AppCompatActivity {
    /* access modifiers changed from: private */
    public String act = "none";
    ArrayList<String> arr = new ArrayList<>();
    ArrayList<String> arr2 = new ArrayList<>();

    /* renamed from: bt */
    Button f78bt;
    private int def = 0;
    private String deff;
    private RecyclerView myView;

    /* access modifiers changed from: protected */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r17) {
        /*
            r16 = this;
            r0 = r16
            super.onCreate(r17)
            r1 = 2131492896(0x7f0c0020, float:1.8609257E38)
            r0.setContentView(r1)
            r1 = 2131296334(0x7f09004e, float:1.8210582E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.Button r1 = (android.widget.Button) r1
            r0.f78bt = r1
            r1 = 2131296439(0x7f0900b7, float:1.8210795E38)
            android.view.View r1 = r0.findViewById(r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            r0.myView = r1
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r2 = "English"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r2 = "हिन्दी"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r2 = "bahasa Indonesia"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r2 = "Filipino"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r3 = "اردو"
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r3 = "Español"
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r3 = "বাঙালি"
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r3 = "日本語"
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r3 = "Melayu"
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r3 = "فارسی"
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r3 = "عربى"
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r3 = "中文"
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r3 = "français"
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r3 = "русский"
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r3 = "svenska"
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r3 = "ไทย"
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr
            java.lang.String r3 = "Português"
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r3 = ""
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r3 = "Hindi"
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r3 = "Indonesian"
            r1.add(r3)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r2 = "Urdu"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r2 = "Spanish"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r2 = "Bengali"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r2 = "Japanese"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r2 = "Malay"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r2 = "Persian"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r2 = "Arabic"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r2 = "Chinese"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r2 = "French"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r2 = "Russian"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r2 = "Swedish"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r2 = "Thai"
            r1.add(r2)
            java.util.ArrayList<java.lang.String> r1 = r0.arr2
            java.lang.String r2 = "Portuguese"
            r1.add(r2)
            android.content.Intent r1 = r16.getIntent()
            android.os.Bundle r1 = r1.getExtras()
            if (r1 == 0) goto L_0x0124
            android.content.Intent r1 = r16.getIntent()
            java.lang.String r2 = "act"
            java.lang.String r1 = r1.getStringExtra(r2)
            r0.act = r1
            goto L_0x0128
        L_0x0124:
            java.lang.String r1 = "something_else"
            r0.act = r1
        L_0x0128:
            r16.resetTitles()
            android.content.Context r1 = r16.getApplicationContext()
            java.lang.String r1 = com.readytofire.fullchargealarm.helper.LocaleManager.getLanguage(r1)
            r0.deff = r1
            java.lang.String r1 = r0.deff
            int r3 = r1.hashCode()
            r4 = 13
            r5 = 12
            r6 = 11
            r7 = 10
            r8 = 9
            r9 = 8
            r10 = 7
            r11 = 6
            r12 = 5
            r13 = 4
            r14 = 3
            r15 = 2
            r2 = 1
            switch(r3) {
                case 3121: goto L_0x0202;
                case 3148: goto L_0x01f8;
                case 3241: goto L_0x01ee;
                case 3246: goto L_0x01e4;
                case 3259: goto L_0x01d9;
                case 3276: goto L_0x01ce;
                case 3329: goto L_0x01c4;
                case 3365: goto L_0x01ba;
                case 3383: goto L_0x01b0;
                case 3494: goto L_0x01a5;
                case 3588: goto L_0x0199;
                case 3651: goto L_0x018d;
                case 3683: goto L_0x0181;
                case 3700: goto L_0x0175;
                case 3741: goto L_0x016a;
                case 3886: goto L_0x015e;
                case 101385: goto L_0x0153;
                default: goto L_0x0151;
            }
        L_0x0151:
            goto L_0x020d
        L_0x0153:
            java.lang.String r3 = "fil"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 3
            goto L_0x020e
        L_0x015e:
            java.lang.String r3 = "zh"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 11
            goto L_0x020e
        L_0x016a:
            java.lang.String r3 = "ur"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 4
            goto L_0x020e
        L_0x0175:
            java.lang.String r3 = "th"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 15
            goto L_0x020e
        L_0x0181:
            java.lang.String r3 = "sv"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 14
            goto L_0x020e
        L_0x018d:
            java.lang.String r3 = "ru"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 13
            goto L_0x020e
        L_0x0199:
            java.lang.String r3 = "pt"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 16
            goto L_0x020e
        L_0x01a5:
            java.lang.String r3 = "ms"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 8
            goto L_0x020e
        L_0x01b0:
            java.lang.String r3 = "ja"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 7
            goto L_0x020e
        L_0x01ba:
            java.lang.String r3 = "in"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 2
            goto L_0x020e
        L_0x01c4:
            java.lang.String r3 = "hi"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 1
            goto L_0x020e
        L_0x01ce:
            java.lang.String r3 = "fr"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 12
            goto L_0x020e
        L_0x01d9:
            java.lang.String r3 = "fa"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 9
            goto L_0x020e
        L_0x01e4:
            java.lang.String r3 = "es"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 5
            goto L_0x020e
        L_0x01ee:
            java.lang.String r3 = "en"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 0
            goto L_0x020e
        L_0x01f8:
            java.lang.String r3 = "bn"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 6
            goto L_0x020e
        L_0x0202:
            java.lang.String r3 = "ar"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0151
            r1 = 10
            goto L_0x020e
        L_0x020d:
            r1 = -1
        L_0x020e:
            switch(r1) {
                case 0: goto L_0x0248;
                case 1: goto L_0x0245;
                case 2: goto L_0x0242;
                case 3: goto L_0x023f;
                case 4: goto L_0x023c;
                case 5: goto L_0x0239;
                case 6: goto L_0x0236;
                case 7: goto L_0x0233;
                case 8: goto L_0x0230;
                case 9: goto L_0x022d;
                case 10: goto L_0x022a;
                case 11: goto L_0x0227;
                case 12: goto L_0x0224;
                case 13: goto L_0x0221;
                case 14: goto L_0x021c;
                case 15: goto L_0x0217;
                case 16: goto L_0x0212;
                default: goto L_0x0211;
            }
        L_0x0211:
            goto L_0x024c
        L_0x0212:
            r1 = 16
            r0.def = r1
            goto L_0x024c
        L_0x0217:
            r1 = 15
            r0.def = r1
            goto L_0x024c
        L_0x021c:
            r1 = 14
            r0.def = r1
            goto L_0x024c
        L_0x0221:
            r0.def = r4
            goto L_0x024c
        L_0x0224:
            r0.def = r5
            goto L_0x024c
        L_0x0227:
            r0.def = r6
            goto L_0x024c
        L_0x022a:
            r0.def = r7
            goto L_0x024c
        L_0x022d:
            r0.def = r8
            goto L_0x024c
        L_0x0230:
            r0.def = r9
            goto L_0x024c
        L_0x0233:
            r0.def = r10
            goto L_0x024c
        L_0x0236:
            r0.def = r11
            goto L_0x024c
        L_0x0239:
            r0.def = r12
            goto L_0x024c
        L_0x023c:
            r0.def = r13
            goto L_0x024c
        L_0x023f:
            r0.def = r14
            goto L_0x024c
        L_0x0242:
            r0.def = r15
            goto L_0x024c
        L_0x0245:
            r0.def = r2
            goto L_0x024c
        L_0x0248:
            r1 = 0
            r0.def = r1
        L_0x024c:
            android.widget.Button r1 = r0.f78bt
            com.readytofire.fullchargealarm.langAct$1 r3 = new com.psquare.FullChargeAlarm.langAct$1
            r3.<init>()
            r1.setOnClickListener(r3)
            com.psquare.FullChargeAlarm.helper.Recyclev_adp r1 = new com.psquare.FullChargeAlarm.helper.Recyclev_adp
            java.util.ArrayList<java.lang.String> r3 = r0.arr
            java.util.ArrayList<java.lang.String> r4 = r0.arr2
            int r5 = r0.def
            r1.<init>(r3, r4, r5)
            androidx.recyclerview.widget.RecyclerView r3 = r0.myView
            r3.setHasFixedSize(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r0.myView
            r3.setAdapter(r1)
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            r3.<init>(r0)
            r3.setOrientation(r2)
            androidx.recyclerview.widget.RecyclerView r2 = r0.myView
            r2.setLayoutManager(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.psquare.FullChargeAlarm.langAct.onCreate(android.os.Bundle):void");
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

    /* access modifiers changed from: private */
    public boolean setNewLocale(Context c, String language, boolean restartProcess) {
        LocaleManager.setNewLocale(c, language);
        if (restartProcess) {
            System.exit(0);
        }
        return true;
    }

    public void onBackPressed() {
        if (this.act.equals("set")) {
            finish();
            super.onBackPressed();
        }
    }
}
