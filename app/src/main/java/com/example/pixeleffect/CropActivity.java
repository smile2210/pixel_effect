package com.example.pixeleffect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.theartofdev.edmodo.cropper.CropImageView;

public class CropActivity extends AppCompatActivity {

    ImageView back,save;
    CropImageView selectimage;

    public static Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);
        back = findViewById(R.id.back);
        save = findViewById(R.id.save);
        selectimage = findViewById(R.id.selectimage);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        selectimage.setImageUriAsync(MainActivity.uri);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bitmap = selectimage.getCroppedImage();
                startActivity(new Intent(CropActivity.this,SecondActivity.class));

            }
        });
    }
}