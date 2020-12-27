package com.example.pixeleffect;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ColorsAdapter extends BaseAdapter {
    Activity activity;
    int[] colors ;

    public ColorsAdapter(SecondActivity secondActivity, int[] colors) {

        activity = secondActivity;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return colors.length;
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

        view = LayoutInflater.from(activity).inflate(R.layout.threeview,viewGroup,false);
        ImageView imageView = view.findViewById(R.id.imageeffect);

        imageView.setImageResource(colors[i]);
        return view;
    }
}
