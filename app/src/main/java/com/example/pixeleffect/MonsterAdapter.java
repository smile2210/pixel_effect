package com.example.pixeleffect;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MonsterAdapter extends BaseAdapter {
    Activity activity;
    int[] monster = new int[]{R.drawable.monster_01,R.drawable.monster_02,R.drawable.monster_03,R.drawable.monster_04,R.drawable.monster_05,R.drawable.monster_06,R.drawable.monster_07,R.drawable.monster_08,R.drawable.monster_09,R.drawable.monster_10,R.drawable.monster_11,R.drawable.monster_12,R.drawable.monster_13,R.drawable.monster_14,R.drawable.monster_15,R.drawable.monster_16,R.drawable.monster_17,R.drawable.monster_18,R.drawable.monster_19,R.drawable.monster_20,R.drawable.monster_21,R.drawable.monster_22,R.drawable.monster_23,R.drawable.monster_24,R.drawable.monster_25,};
    public MonsterAdapter(SecondActivity secondActivity) {
        activity = secondActivity;
    }

    @Override
    public int getCount() {
        return monster.length;
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
        Glide.with(activity).load(monster[i]).into(imageView);
        return view;
    }
}
