package com.example.pixeleffect;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class LoveAdapter extends BaseAdapter {
    Activity activity;
    int[] love = new int[]{R.drawable.l7,R.drawable.l8,R.drawable.l9,R.drawable.l10,R.drawable.l11,R.drawable.l12,R.drawable.l13,R.drawable.l14,R.drawable.l15,R.drawable.l16,R.drawable.l17,R.drawable.l18,R.drawable.l19,R.drawable.l20,R.drawable.l21,R.drawable.l22,R.drawable.l23,R.drawable.l24,R.drawable.l25,R.drawable.l26,R.drawable.l27,R.drawable.l28,R.drawable.l35,R.drawable.l36,R.drawable.l37,R.drawable.l38,R.drawable.l39,R.drawable.l40,R.drawable.l42,R.drawable.cm_sticker_10,R.drawable.cm_sticker_11,R.drawable.cm_sticker_12,R.drawable.cm_sticker_13,R.drawable.cm_sticker_14,R.drawable.cm_sticker_15,R.drawable.cm_sticker_16,R.drawable.cm_sticker_17,R.drawable.cm_sticker_18,R.drawable.cm_sticker_19,R.drawable.cm_sticker_20,R.drawable.cm_sticker_21,};

    public LoveAdapter(SecondActivity secondActivity) {
        activity = secondActivity;
    }

    @Override
    public int getCount() {
        return love.length;
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
        Glide.with(activity).load(love[i]).into(imageView);
        return view;
    }
}
