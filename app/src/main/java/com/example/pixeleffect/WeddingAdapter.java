package com.example.pixeleffect;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class WeddingAdapter extends BaseAdapter {
    Activity activity;
    int[] wedding = new int[]{R.drawable.wedding01,R.drawable.wedding02,R.drawable.wedding03,R.drawable.wedding04,R.drawable.wedding05,R.drawable.wedding06,R.drawable.wedding07,R.drawable.wedding08,R.drawable.wedding09,R.drawable.wedding10,R.drawable.wedding11,R.drawable.wedding12,R.drawable.wedding13,R.drawable.wedding14,R.drawable.wedding15,R.drawable.wedding16,R.drawable.wedding17,R.drawable.wedding18,R.drawable.wedding19,R.drawable.wedding20,R.drawable.wedding21,R.drawable.wedding22,};

    public WeddingAdapter(SecondActivity secondActivity) {
        activity = secondActivity;
    }

    @Override
    public int getCount() {
        return wedding.length;
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
        Glide.with(activity).load(wedding[i]).into(imageView);
        return view;
    }
}
