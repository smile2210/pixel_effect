package com.example.pixeleffect;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class PatternAdapter extends BaseAdapter {
    Activity activity;
    int[] patternList;

    public PatternAdapter(SecondActivity secondActivity, int[] patternList) {
        activity = secondActivity;
        this.patternList = patternList;
    }

    @Override
    public int getCount() {
        return patternList.length;
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
        view = LayoutInflater.from(activity).inflate(R.layout.patternview, viewGroup, false);
        ImageView imageView = view.findViewById(R.id.patternimage);
        imageView.setImageResource(patternList[i]);
        return view;
    }
}
