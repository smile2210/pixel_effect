package com.example.pixeleffect;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class HeartAdapter extends BaseAdapter {
    Activity activity;
    int[] heart = new int[]{R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,R.drawable.s11,R.drawable.s12,R.drawable.s13,R.drawable.s14,R.drawable.s15,R.drawable.s16,R.drawable.s17,R.drawable.s18,R.drawable.s19,R.drawable.s20,};

    public HeartAdapter(SecondActivity secondActivity) {
        activity = secondActivity;
    }

    @Override
    public int getCount() {
        return heart.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(activity).inflate(R.layout.sticker_view,viewGroup,false);

        ImageView imageView = view.findViewById(R.id.stickerpic);
        Glide.with(activity).load(heart[i]).into(imageView);
        return view;
    }
}
