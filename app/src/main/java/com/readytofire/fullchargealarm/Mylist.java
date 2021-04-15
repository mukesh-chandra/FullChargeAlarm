package com.readytofire.fullchargealarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import psquare.FullChargeAlarm.R;

public class Mylist extends BaseAdapter {

    /* renamed from: c */
    Context f54c;

    /* renamed from: i1 */
    ArrayList<Integer> f55i1 = new ArrayList<>();
    LayoutInflater inflater;

    /* renamed from: s1 */
    ArrayList<String> f56s1 = new ArrayList<>();

    public Mylist(Context c, ArrayList<String> s1, ArrayList<Integer> i1) {
        this.f56s1 = s1;
        this.f55i1 = i1;
        this.inflater = (LayoutInflater) c.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.f56s1.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = this.inflater.inflate(R.layout.cell, null);
        ImageView iv1 = (ImageView) itemView.findViewById(R.id.imgView);
        ((TextView) itemView.findViewById(R.id.texView)).setText(((String) this.f56s1.get(position)).toString());
        try {
            iv1.setImageResource(((Integer) this.f55i1.get(position)).intValue());
        } catch (Exception e) {
        }
        return itemView;
    }
}
