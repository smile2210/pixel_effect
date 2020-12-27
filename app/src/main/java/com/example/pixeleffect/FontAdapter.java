package com.example.pixeleffect;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FontAdapter extends BaseAdapter {
    Activity activity;

    public FontAdapter(SecondActivity secondActivity) {
        activity = secondActivity;
    }

    @Override
    public int getCount() {
        return 19;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(activity).inflate(R.layout.fontstyle, viewGroup, false);
        TextView textView = view.findViewById(R.id.fontstext);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((SecondActivity)activity).Typeface(i);
            }
        });

        if (i == 0) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font1.ttf"));
        } else if (i == 1) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font2.ttf"));
        } else if (i == 2) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font3.ttf"));
        } else if (i == 3) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font4.TTF"));
        } else if (i == 4) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font5.ttf"));
        } else if (i == 5) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font6.TTF"));
        } else if (i == 6) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font7.ttf"));
        } else if (i == 7) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font8.ttf"));
        } else if (i == 8) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font9.ttf"));
        } else if (i == 9) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font10.TTF"));
        } else if (i == 10) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font11.ttf"));
        } else if (i == 11) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font12.ttf"));
        } else if (i == 12) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font14.TTF"));
        } else if (i == 13) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font16.TTF"));
        } else if (i == 14) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font17.ttf"));
        } else if (i == 15) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font18.ttf"));
        } else if (i == 16) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font19.ttf"));
        } else if (i == 17) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font20.ttf"));
        } else if (i == 18) {
            textView.setTypeface(Typeface.createFromAsset(activity.getAssets(), "font/font21.ttf"));
        }
        return view;

    }
}
