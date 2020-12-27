package com.example.pixeleffect;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class recycler1Adapter extends RecyclerView.Adapter<recycler1Adapter.ThreeHolder> {

    Activity activity;
    int[] threeimage;

    public recycler1Adapter(SecondActivity secondActivity, int[] threeimage) {
        activity = secondActivity;
        this.threeimage = threeimage;
    }

    @NonNull
    @Override
    public ThreeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.threeview,parent,false);
        return new ThreeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ThreeHolder holder, final int position) {

        Glide.with(activity).load(CropActivity.bitmap).into(holder.selectimage);
        Glide.with(activity).load(threeimage[position]).into(holder.imageView1);

        holder.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((SecondActivity)activity).setPixelimage(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return threeimage.length;
    }

    public class ThreeHolder extends RecyclerView.ViewHolder {

        ImageView imageView1,selectimage;
        public ThreeHolder(@NonNull View itemView) {
            super(itemView);
            imageView1 = itemView.findViewById(R.id.imageeffect);
            selectimage = itemView.findViewById(R.id.selectimage1);
        }
    }
}
