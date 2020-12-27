package com.example.pixeleffect;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class PartyAdapter extends BaseAdapter {
    Activity activity;
    int[] party = new int[]{R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b6,R.drawable.b7,R.drawable.b8,R.drawable.b9,R.drawable.b10,R.drawable.b12,R.drawable.b14,R.drawable.b15,R.drawable.b16,R.drawable.b17,R.drawable.b18,R.drawable.b19,R.drawable.b20,};

    public PartyAdapter(SecondActivity secondActivity) {
        activity = secondActivity;
    }

    @Override
    public int getCount() {
        return party.length;
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
        Glide.with(activity).load(party[i]).into(imageView);
        return view;
    }
}
