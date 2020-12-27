package com.example.pixeleffect;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class recycler3Adapter extends RecyclerView.Adapter<recycler3Adapter.FilterHolder> {

    Activity activity;
    int[] filterimage;

    public recycler3Adapter(SecondActivity secondActivity, int[] filterimage) {
        activity = secondActivity;
        this.filterimage = filterimage;
    }

    @NonNull
    @Override
    public FilterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.threeview,parent,false);
        return new FilterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterHolder holder, final int position) {

        Glide.with(activity).load(CropActivity.bitmap).into(holder.selectimage);
        Glide.with(activity).load(filterimage[position]).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((SecondActivity)activity).Pixelimage(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filterimage.length;
    }

    public  class FilterHolder extends RecyclerView.ViewHolder {
        ImageView imageView,selectimage;
        public FilterHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageeffect);
            selectimage = itemView.findViewById(R.id.selectimage1);
        }
    }
}
