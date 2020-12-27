package com.example.pixeleffect;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class AnimalAdapter extends BaseAdapter {

    Activity activity;
    int[] animal = new int[]{R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a12,R.drawable.a14,R.drawable.a15,R.drawable.a16,R.drawable.a17,R.drawable.a18,R.drawable.a19,R.drawable.a20,R.drawable.a21,R.drawable.a22,R.drawable.a24,R.drawable.a25,R.drawable.a26,R.drawable.a28,R.drawable.a29,R.drawable.a30,R.drawable.a32,R.drawable.a34,R.drawable.a35,R.drawable.a36,};

    public AnimalAdapter(SecondActivity secondActivity) {
        activity = secondActivity;
    }

    @Override
    public int getCount() {
        return animal.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(activity).inflate(R.layout.sticker_view,parent,false);

        final ImageView imageView = convertView.findViewById(R.id.stickerpic);
        Glide.with(activity).load(animal[position]).into(imageView);

        return convertView;
    }
}
