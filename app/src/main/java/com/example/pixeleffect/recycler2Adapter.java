package com.example.pixeleffect;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class recycler2Adapter extends RecyclerView.Adapter<recycler2Adapter.Efectholder> {

    Activity activity;


    public recycler2Adapter(SecondActivity secondActivity) {
        activity = secondActivity;
    }

    @NonNull
    @Override
    public Efectholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.threeview,parent,false);
        return new Efectholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Efectholder holder, final int position) {

        Glide.with(activity).load(CropActivity.bitmap).into(holder.imageView);

        switch (position){

            case 0:
                Effects.applyEffectNone(holder.imageView);
                break;
            case 1:
                Effects.applyEffect1(holder.imageView);
                break;
            case 2:
                Effects.applyEffect2(holder.imageView);
                break;
            case 3:
                Effects.applyEffect3(holder.imageView);
                break;
            case 4:
                Effects.applyEffect4(holder.imageView);
                break;
            case 5:
                Effects.applyEffect5(holder.imageView);
                break;
            case 6:
                Effects.applyEffect6(holder.imageView);
                break;
            case 7:
                Effects.applyEffect7(holder.imageView);
                break;
            case 8:
                Effects.applyEffect8(holder.imageView);
                break;
            case 9:
                Effects.applyEffect9(holder.imageView);
                break;
            case 10:
                Effects.applyEffect10(holder.imageView);
                break;
            case 11:
                Effects.applyEffect11(holder.imageView);
                break;
            case 12:
                Effects.applyEffect12(holder.imageView);
                break;
            case 13:
                Effects.applyEffect13(holder.imageView);
                break;
            case 14:
                Effects.applyEffect14(holder.imageView);
                break;
            case 15:
                Effects.applyEffect15(holder.imageView);
                break;
            case 16:
                Effects.applyEffect16(holder.imageView);
                break;
            case 17:
                Effects.applyEffect17(holder.imageView);
                break;
            case 18:
                Effects.applyEffect18(holder.imageView);
                break;
            case 19:
                Effects.applyEffect9(holder.imageView);
                break;
            case 20:
                Effects.applyEffect20(holder.imageView);
                break;
            case 21:
                Effects.applyEffect21(holder.imageView);
                break;
            case 22:
                Effects.applyEffect22(holder.imageView);
                break;

        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((SecondActivity)activity).Effects(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 23;
    }

    public class Efectholder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public Efectholder(@NonNull View itemView) {
            super(itemView);
                imageView = itemView.findViewById(R.id.imageeffect);
        }
    }
}
