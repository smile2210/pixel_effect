package com.example.pixeleffect;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class glareAdapter extends RecyclerView.Adapter<glareAdapter.GlareHolder>{

    Activity activity;
    int[] glareeffet;

    public glareAdapter(SecondActivity secondActivity, int[] glareeffet) {
        activity = secondActivity;
        this.glareeffet = glareeffet;
    }

    @NonNull
    @Override
    public GlareHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.threeview,parent,false);
        return new GlareHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GlareHolder holder, final int position) {
        Glide.with(activity).load(glareeffet[position]).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((SecondActivity)activity).setGlareimage(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return glareeffet.length;
    }

    public class GlareHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public GlareHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageeffect);
        }
    }
}
