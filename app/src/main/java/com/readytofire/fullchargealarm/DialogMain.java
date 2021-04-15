package com.readytofire.fullchargealarm;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import psquare.FullChargeAlarm.R;

public class DialogMain extends Dialog implements OnClickListener {
    private AppCompatActivity context;

    /* renamed from: d */
    public Dialog f48d;
    private int img;
    private String str1;
    private String str2;

    DialogMain(AppCompatActivity a, int img2, String str12, String str22) {
        super(a);
        this.context = a;
        this.img = img2;
        this.str1 = str12;
        this.str2 = str22;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        setContentView(R.layout.activity_maindlg);
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(Integer.valueOf(R.drawable.hltt));
        ar.add(Integer.valueOf(R.drawable.tm));
        ar.add(Integer.valueOf(R.drawable.tch));
        ar.add(Integer.valueOf(R.drawable.ch));
        ar.add(Integer.valueOf(R.drawable.volt));
        ar.add(Integer.valueOf(R.drawable.mh));
        TextView t2 = (TextView) findViewById(R.id.textView2);
        ImageView i1 = (ImageView) findViewById(R.id.imageView);
        ((TextView) findViewById(R.id.textView)).setText(this.str1);
        t2.setText(this.str2);
        i1.setBackgroundResource(((Integer) ar.get(this.img)).intValue());
    }

    public void onClick(View v) {
        v.getId();
    }
}
