package com.readytofire.fullchargealarm.helper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import psquare.FullChargeAlarm.R;

public class Recyclev_adp extends Adapter<MyViewHolder> {
    public static int poss = 0;
    public static boolean press = false;
    private ArrayList<String> arr;
    private ArrayList<String> myValues;
    /* access modifiers changed from: private */
    public int selectedPosition = 0;

    public static class MyViewHolder extends ViewHolder {

        /* renamed from: iv */
        ImageView f76iv;
        /* access modifiers changed from: private */
        public TextView myTextV2;
        /* access modifiers changed from: private */
        public TextView myTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.myTextView = (TextView) itemView.findViewById(R.id.tv1);
            this.myTextV2 = (TextView) itemView.findViewById(R.id.tv2);
            this.f76iv = (ImageView) itemView.findViewById(R.id.imageView2);
        }
    }

    public Recyclev_adp(ArrayList<String> myValues2, ArrayList<String> arr2, int df) {
        this.myValues = myValues2;
        this.arr = arr2;
        this.selectedPosition = df;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false));
    }

    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.myTextView.setText((CharSequence) this.myValues.get(position));
        holder.myTextV2.setText((CharSequence) this.arr.get(position));
        if (this.selectedPosition == position) {
            holder.f76iv.setImageResource(R.drawable.ic_check_aptm);
            holder.myTextView.setTypeface(null, 1);
            holder.myTextV2.setTypeface(null, 1);
        } else {
            holder.myTextView.setTypeface(null, 0);
            holder.f76iv.setImageResource(R.drawable.ic_check);
            holder.myTextV2.setTypeface(null, 0);
        }
        holder.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Recyclev_adp.this.selectedPosition = position;
                Recyclev_adp.this.notifyDataSetChanged();
                Recyclev_adp.press = true;
                Recyclev_adp.poss = position;
            }
        });
    }

    public int getItemCount() {
        return this.myValues.size();
    }
}
