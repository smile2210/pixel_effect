package com.example.pixeleffect;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pixeleffect.MultiTouch.MultiTouchListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import yuku.ambilwarna.AmbilWarnaDialog;

import static com.example.pixeleffect.CropActivity.bitmap;

public class SecondActivity extends AppCompatActivity {

    ImageView back, save;
    ImageView selectimage, pixelimage, glareimage;
    LinearLayout threed, effect, color, glare, filter, text, sticker, rotate, flip;
    RecyclerView recyclerView;
    TextView write_text;
    EditText editText;
    CardView text_add, seekbar_view, color_view, style_view, pattern_view,blur_view;
    SeekBar seekBar;
    GridView colorgrid, stylegrid, patterngrid;
    FrameLayout frameLayout;
    int DefaultColor;
    int[] threeimage = new int[]{R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten, R.drawable.eleven, R.drawable.twelve, R.drawable.thrteen,};
    int[] filterimage = new int[]{R.drawable.pixel_01, R.drawable.pixel_02, R.drawable.pixel_03, R.drawable.pixel_04, R.drawable.pixel_05, R.drawable.pixel_06, R.drawable.pixel_2, R.drawable.pixel_3, R.drawable.pixel_4, R.drawable.pixel_6, R.drawable.pixel_7, R.drawable.pixel_8, R.drawable.pixel_9, R.drawable.pixel_13, R.drawable.pixel_14, R.drawable.pixel_15, R.drawable.pixel_16, R.drawable.pixel_17, R.drawable.pixel_18, R.drawable.pixel_19, R.drawable.pixel_20, R.drawable.pixel_21, R.drawable.pixel_22, R.drawable.pixel_23, R.drawable.pixel_24, R.drawable.pixel_25, R.drawable.pixel_26, R.drawable.pixel_27, R.drawable.pixel_28, R.drawable.pixel_31, R.drawable.pixel_32, R.drawable.pixel_33, R.drawable.pixel_34,};
    int[] glareeffet = new int[]{R.drawable.flare_01, R.drawable.flare_02, R.drawable.flare_03, R.drawable.flare_04, R.drawable.flare_05, R.drawable.flare_06,};
    int[] colors = new int[]{R.color.Aqua, R.color.Aquamarine, R.color.black, R.color.CadetBlue, R.color.Chartreuse, R.color.colorAccent, R.color.CornflowerBlue, R.color.Cyan, R.color.DarkCyan, R.color.DarkOliveGreen, R.color.DarkSlateBlue, R.color.DarkSlateGray, R.color.DarkTurquoise, R.color.DeepSkyBlue, R.color.DimGray, R.color.DodgerBlue, R.color.ForestGreen, R.color.Gray, R.color.Green, R.color.Indigo, R.color.LawnGreen, R.color.LightSeaGreen, R.color.LightSlateGray, R.color.Lime, R.color.LimeGreen, R.color.Maroon, R.color.MediumAquamarine, R.color.MediumSeaGreen, R.color.MediumSlateBlue, R.color.MediumSpringGreen, R.color.MediumTurquoise, R.color.MidnightBlue, R.color.Olive, R.color.OliveDrab, R.color.Purple, R.color.RoyalBlue, R.color.SeaGreen, R.color.SlateBlue, R.color.SlateGray, R.color.SpringGreen, R.color.SteelBlue, R.color.Teal, R.color.Turquoise};
    int[] patterns = new int[]{R.drawable.pattern_01, R.drawable.pattern_02, R.drawable.pattern_03, R.drawable.pattern_04, R.drawable.pattern_05, R.drawable.pattern_06, R.drawable.pattern_07, R.drawable.pattern_08, R.drawable.pattern_09, R.drawable.pattern_10,};

    private Shader shader;
    private Bitmap bitmap1;
    private Bitmap textBitmap;
    private static Bitmap b;
    private static Canvas c;
    public static CustomTextView cCurrentView;
    ArrayList<View> mViews = new ArrayList<>();
    private int flag;
    private Bitmap finalEditedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        selectimage = findViewById(R.id.selectimage);
        back = findViewById(R.id.back);
        save = findViewById(R.id.save);
        threed = findViewById(R.id.threed);
        effect = findViewById(R.id.effect);
        color = findViewById(R.id.color);
        glare = findViewById(R.id.glare);
        filter = findViewById(R.id.filter);
        text = findViewById(R.id.text);
        sticker = findViewById(R.id.sticker);
        rotate = findViewById(R.id.rotate);
        flip = findViewById(R.id.flip);
        recyclerView = findViewById(R.id.recycler1);
        pixelimage = findViewById(R.id.pixelimage);
        glareimage = findViewById(R.id.glareimage);
        frameLayout = findViewById(R.id.framelayout);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, MainActivity.class));
            }
        });

        selectimage.setImageBitmap(bitmap);

        glareimage.setOnTouchListener(new MultiTouchListener());


        threed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView.LayoutManager manager = new LinearLayoutManager(SecondActivity.this, LinearLayoutManager.HORIZONTAL, false);
                recycler1Adapter adapter = new recycler1Adapter(SecondActivity.this, threeimage);

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(manager);
            }
        });

        effect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView.LayoutManager manager = new LinearLayoutManager(SecondActivity.this, LinearLayoutManager.HORIZONTAL, false);
                recycler3Adapter adapter3 = new recycler3Adapter(SecondActivity.this, filterimage);

                recyclerView.setAdapter(adapter3);
                recyclerView.setLayoutManager(manager);
            }
        });

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView.LayoutManager manager = new LinearLayoutManager(SecondActivity.this, LinearLayoutManager.HORIZONTAL, false);
                recycler2Adapter adapter2 = new recycler2Adapter(SecondActivity.this);

                recyclerView.setAdapter(adapter2);
                recyclerView.setLayoutManager(manager);
            }
        });

        DefaultColor = pixelimage.getSolidColor();
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenColorPickerDialog(false);
            }
        });

        glare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView.LayoutManager manager = new LinearLayoutManager(SecondActivity.this, LinearLayoutManager.HORIZONTAL, false);
                glareAdapter adapter4 = new glareAdapter(SecondActivity.this, glareeffet);

                recyclerView.setAdapter(adapter4);
                recyclerView.setLayoutManager(manager);
            }
        });

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectimage.setRotation(selectimage.getRotation() + 90);
            }
        });

        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectimage.setRotationY(selectimage.getRotationY() + 180);
            }
        });

        sticker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(SecondActivity.this, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                dialog.setContentView(R.layout.sticke_dioluge);

                ImageView android = dialog.findViewById(R.id.dismiss);
                android.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });


                final GridView stickergrid = dialog.findViewById(R.id.stickergrid);

                final ImageView animal = dialog.findViewById(R.id.animal);
                animal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AnimalAdapter adapter = new AnimalAdapter(SecondActivity.this);
                        stickergrid.setAdapter(adapter);
                    }
                });

                ImageView monster = dialog.findViewById(R.id.monster);
                monster.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MonsterAdapter adapter2 = new MonsterAdapter(SecondActivity.this);
                        stickergrid.setAdapter(adapter2);
                    }
                });

                ImageView love = dialog.findViewById(R.id.love);
                love.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LoveAdapter adapter3 = new LoveAdapter(SecondActivity.this);
                        stickergrid.setAdapter(adapter3);
                    }
                });

                ImageView wedding = dialog.findViewById(R.id.wedding);
                wedding.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        WeddingAdapter adapter4 = new WeddingAdapter(SecondActivity.this);
                        stickergrid.setAdapter(adapter4);
                    }
                });

                ImageView heart = dialog.findViewById(R.id.heart);
                heart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        HeartAdapter adapter5 = new HeartAdapter(SecondActivity.this);
                        stickergrid.setAdapter(adapter5);
                    }
                });

                ImageView party = dialog.findViewById(R.id.party);
                party.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PartyAdapter adapter6 = new PartyAdapter(SecondActivity.this);
                        stickergrid.setAdapter(adapter6);
                    }
                });

                dialog.show();
            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog txtdialog = new Dialog(SecondActivity.this, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                txtdialog.setContentView(R.layout.text_dialog);

                ImageView android = txtdialog.findViewById(R.id.dismiss);
                android.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txtdialog.dismiss();
                    }
                });

                LinearLayout addtext = txtdialog.findViewById(R.id.addtext);
                write_text = txtdialog.findViewById(R.id.write_text);
                editText = txtdialog.findViewById(R.id.edittext);
                text_add = txtdialog.findViewById(R.id.text_add);
                final Animation animation = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.animation);
                text_add.setAnimation(animation);

                addtext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (text_add.getVisibility() == View.GONE) {

                            text_add.setVisibility(View.VISIBLE);

                        } else {

                            text_add.setVisibility(View.GONE);
                        }
                    }
                });

                ImageButton donetxt = text_add.findViewById(R.id.donetxt);
                donetxt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        text_add.setVisibility(View.GONE);
                        String edit = editText.getText().toString();
                        write_text.setText(edit);
                    }
                });

                LinearLayout size = txtdialog.findViewById(R.id.size);
                seekbar_view = txtdialog.findViewById(R.id.seekbar_view);
                seekBar = txtdialog.findViewById(R.id.seekbar);
                seekbar_view.setAnimation(animation);
                size.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (seekbar_view.getVisibility() == View.GONE) {

                            seekbar_view.setVisibility(View.VISIBLE);
                        } else {
                            seekbar_view.setVisibility(View.GONE);
                        }
                    }
                });

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        write_text.setTextSize(i);
                    }

                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                        seekBar.setMin(20);

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        seekBar.setMax(250);

                    }
                });

                LinearLayout textcolor = txtdialog.findViewById(R.id.textcolor);
                color_view = txtdialog.findViewById(R.id.color_view);
                colorgrid = txtdialog.findViewById(R.id.colorgrid);
                color_view.setAnimation(animation);
                textcolor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (color_view.getVisibility() == View.GONE) {

                            color_view.setVisibility(View.VISIBLE);
                        } else {

                            color_view.setVisibility(View.GONE);
                        }
                    }
                });

                ColorsAdapter adapter = new ColorsAdapter(SecondActivity.this, colors);
                colorgrid.setAdapter(adapter);
                colorgrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        write_text.setTextColor(getColor(colors[i]));
                    }
                });

                LinearLayout text_style = txtdialog.findViewById(R.id.textstyle);
                style_view = txtdialog.findViewById(R.id.style_view);
                stylegrid = txtdialog.findViewById(R.id.stylegrid);
                style_view.setAnimation(animation);
                text_style.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (style_view.getVisibility() == View.GONE) {

                            style_view.setVisibility(View.VISIBLE);
                        } else {

                            style_view.setVisibility(View.GONE);
                        }
                    }
                });

                FontAdapter fontAdapter = new FontAdapter(SecondActivity.this);
                stylegrid.setAdapter(fontAdapter);


                LinearLayout pattern = txtdialog.findViewById(R.id.pattern);
                pattern_view = txtdialog.findViewById(R.id.pattern_view);
                patterngrid = txtdialog.findViewById(R.id.patterngrid);
                pattern.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (pattern_view.getVisibility() == View.GONE) {

                            pattern_view.setVisibility(View.VISIBLE);
                        } else {
                            pattern_view.setVisibility(View.GONE);
                        }
                    }
                });

                PatternAdapter patternAdapter = new PatternAdapter(SecondActivity.this, patterns);
                patterngrid.setAdapter(patternAdapter);
                patterngrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                       setPatterns(i);
                    }
                });

                LinearLayout blur = txtdialog.findViewById(R.id.blur);
                blur_view = txtdialog.findViewById(R.id.blur_view);
                RadioGroup radioGroup = txtdialog.findViewById(R.id.radiogroup);
                blur.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (blur_view.getVisibility() == View.GONE) {

                            blur_view.setVisibility(View.VISIBLE);
                        } else {
                            blur_view.setVisibility(View.GONE);
                        }
                    }
                });

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if (i == R.id.noblure) {
                            write_text.setText(editText.getText().toString());
                            write_text.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                            write_text.getPaint().setMaskFilter(null);
                            flag = 0;
                        }
                        if (i == R.id.innerblure){
                            write_text.setText(editText.getText().toString());
                            write_text.getPaint().setMaskFilter(new BlurMaskFilter(10,BlurMaskFilter.Blur.INNER));
                            flag = 1;
                        }if (i == R.id.normalblure){
                            write_text.setText(editText.getText().toString());
                            write_text.getPaint().setMaskFilter(new BlurMaskFilter(10,BlurMaskFilter.Blur.NORMAL));
                            flag = 2;
                        }if (i == R.id.outerblure){
                            write_text.setText(editText.getText().toString());
                            write_text.getPaint().setMaskFilter(new BlurMaskFilter(10,BlurMaskFilter.Blur.OUTER));
                            flag = 3;
                        }if (i == R.id.solidblure){
                            write_text.setText(editText.getText().toString());
                            write_text.getPaint().setMaskFilter(new BlurMaskFilter(10,BlurMaskFilter.Blur.SOLID));
                            flag = 4;
                        }
                    }
                });

                ImageView done = txtdialog.findViewById(R.id.done);
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        ImageView imageView1 = new ImageView(SecondActivity.this);
                        write_text.buildDrawingCache();
                        Bitmap bitmap = write_text.getDrawingCache();
                        imageView1.setImageBitmap(bitmap);
                        textBitmap = loadBitmapFromView(imageView1);
                        textBitmap = CropBitmapTransparency(textBitmap);

//                        ((InputMethodManager) SecondActivity.this.getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(write_text.getWindowToken(),0);
                        final CustomTextView stickerTextView = new CustomTextView(SecondActivity.this);
                        stickerTextView.setBitmap(textBitmap);
                        FrameLayout.LayoutParams lp1 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER);
                        frameLayout.addView(stickerTextView,lp1);
                        setCurrentEdit(stickerTextView);
                        stickerTextView.setOperationListener(new CustomTextView.OperationListener() {
                            @Override
                            public void onDeleteClick() {
                                mViews.remove(stickerTextView);
                                frameLayout.removeView(stickerTextView);
                            }

                            @Override
                            public void onEdit(CustomTextView CustomTextView) {
                                cCurrentView.setInEdit(false);
                                cCurrentView = CustomTextView;
                                cCurrentView.setInEdit(true);
                            }

                            @Override
                            public void onTop(CustomTextView CustomTextView) {
                                cCurrentView.setInEdit(true);

                            }
                        });
                        txtdialog.dismiss();
                    }
                });


                txtdialog.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveImage(getMainFrameBitmap(frameLayout));
                Toast.makeText(SecondActivity.this, "Saved Sucessfully", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void saveImage(Bitmap finalEditedImage) {
        Log.v("TAG", "saveImageInCache is called");
        Bitmap bitmap;
        OutputStream output;

        bitmap = finalEditedImage;

        File filepath = Environment.getExternalStorageDirectory();

        // Create a new folder in SD Card
        File dir = new File(filepath.getAbsolutePath() + "/" + "Pixcel Effect");
        dir.mkdirs();

        String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()).toString();

        String FileName = ts + ".jpg";
        File file = new File(dir, FileName);
        file.renameTo(file);
        String _uri = "file://" + filepath.getAbsolutePath() + "/" + "Pixcel Effect" + "/" + FileName;
        //for share image
        String _uri2 = filepath.getAbsolutePath() + "/" + "Pixcel Effect" + "/" + FileName;
        String _url = _uri2;//used in share image

//        Intent intent=new Intent(ImageEditActivity.this,ShareImageActivity.class);
//        startActivity(intent);

        Log.d("cache uri=", _uri);
        MediaScannerConnection.scanFile(this, new String[]{_url}, null, new MediaScannerConnection.OnScanCompletedListener() {
            public void onScanCompleted(String path, Uri uri) {
                Log.i("ExternalStorage", "Scanned " + path + ":");
                Log.i("ExternalStorage", "-> uri=" + uri);
            }
        });
        try {
            output = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, output);
            output.flush();
            output.close();


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    private Bitmap getMainFrameBitmap(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        return bitmap;
    }

    private void setCurrentEdit(CustomTextView stickerTextView) {
        if (cCurrentView != null){
            cCurrentView.setInEdit(false);
        }
        cCurrentView = stickerTextView;
        stickerTextView.setInEdit(true);
    }

    Bitmap CropBitmapTransparency(Bitmap sourceBitmap) {
        int minX = sourceBitmap.getWidth();
        int minY = sourceBitmap.getHeight();
        int maxX = -1;
        int maxY = -1;
        for (int y=0;y<sourceBitmap.getHeight();y++){
            for (int x=0;x<sourceBitmap.getWidth();x++){
                int alpha = (sourceBitmap.getPixel(x,y) >> 24) & 255;
                if(alpha>0){
                    if (x<minX)
                        minX = x;
                    if (x>maxX)
                        maxX = x;
                    if (y<minY)
                        minY = y;
                    if (y>maxY)
                        maxY = y;
                }
            }
        }
        if ((maxX < minX) || (maxY < minY))
            return null;

        return Bitmap.createBitmap(sourceBitmap,minX,minY,(maxX - minX) + 1,(maxY - minY) + 1);
    }

    private Bitmap loadBitmapFromView(View v) {
        if (v.getMeasuredHeight() <=0){
            v.measure(-2,-2);
            b = Bitmap.createBitmap(v.getMeasuredWidth(),v.getMeasuredHeight(),Bitmap.Config.ARGB_8888);
            c=new Canvas(b);
            v.layout(0,0,v.getMeasuredWidth(),v.getMeasuredHeight());
            v.draw(c);
            return b;
        }
        b = Bitmap.createBitmap(v.getWidth(),v.getHeight(),Bitmap.Config.ARGB_8888);
        c=new Canvas(b);
        v.layout(v.getLeft(),v.getTop(),v.getRight(),v.getBottom());
        v.draw(c);
        return b;
    }

    private void OpenColorPickerDialog(boolean AlphaSupport) {
        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(SecondActivity.this, DefaultColor, AlphaSupport, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onOk(AmbilWarnaDialog ambilWarnaDialog, int color) {

                DefaultColor = color;
                pixelimage.setColorFilter(color);


            }

            @Override
            public void onCancel(AmbilWarnaDialog ambilWarnaDialog) {
            }
        });
        ambilWarnaDialog.show();

    }

    public void Effects(int position) {

        switch (position) {

            case 0:
                Effects.applyEffectNone(selectimage);
                break;
            case 1:
                Effects.applyEffect1(selectimage);
                break;
            case 2:
                Effects.applyEffect2(selectimage);
                break;
            case 3:
                Effects.applyEffect3(selectimage);
                break;
            case 4:
                Effects.applyEffect4(selectimage);
                break;
            case 5:
                Effects.applyEffect5(selectimage);
                break;
            case 6:
                Effects.applyEffect6(selectimage);
                break;
            case 7:
                Effects.applyEffect7(selectimage);
                break;
            case 8:
                Effects.applyEffect8(selectimage);
                break;
            case 9:
                Effects.applyEffect9(selectimage);
                break;
            case 10:
                Effects.applyEffect10(selectimage);
                break;
            case 11:
                Effects.applyEffect11(selectimage);
                break;
            case 12:
                Effects.applyEffect12(selectimage);
                break;
            case 13:
                Effects.applyEffect13(selectimage);
                break;
            case 14:
                Effects.applyEffect14(selectimage);
                break;
            case 15:
                Effects.applyEffect15(selectimage);
                break;
            case 16:
                Effects.applyEffect16(selectimage);
                break;
            case 17:
                Effects.applyEffect17(selectimage);
                break;
            case 18:
                Effects.applyEffect18(selectimage);
                break;
            case 19:
                Effects.applyEffect9(selectimage);
                break;
            case 20:
                Effects.applyEffect20(selectimage);
                break;
            case 21:
                Effects.applyEffect21(selectimage);
                break;
            case 22:
                Effects.applyEffect22(selectimage);
                break;

        }
    }

    public void setPixelimage(int position) {
        pixelimage.setImageResource(threeimage[position]);
    }

    public void Pixelimage(int position) {
        pixelimage.setImageResource(filterimage[position]);
    }

    public void setGlareimage(int position) {
        glareimage.setImageResource(glareeffet[position]);
    }

    public void Typeface(int i) {
        switch (i) {
            case 0:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font1.ttf"));
                break;
            case 1:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font2.ttf"));
                break;
            case 2:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font3.ttf"));
                break;
            case 3:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font4.TTF"));
                break;
            case 4:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font5.ttf"));
                break;
            case 5:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font6.TTF"));
                break;
            case 6:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font7.ttf"));
                break;
            case 7:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font8.ttf"));
                break;
            case 8:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font9.ttf"));
                break;
            case 9:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font10.TTF"));
                break;
            case 10:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font11.ttf"));
                break;
            case 11:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font12.ttf"));
                break;
            case 12:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font14.TTF"));
                break;
            case 13:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font16.TTF"));
                break;
            case 14:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font17.ttf"));
                break;
            case 15:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font18.ttf"));
                break;
            case 16:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font19.ttf"));
                break;
            case 17:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font20.ttf"));
                break;
            case 18:
                write_text.setTypeface(Typeface.createFromAsset(SecondActivity.this.getAssets(), "font/font21.ttf"));
                break;
        }
    }

    public void setPatterns(int i) {
        switch (i) {

            case 0:
                bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_01);
                shader = new BitmapShader(bitmap1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                write_text.setText(editText.getText().toString());
                write_text.getPaint().setShader(shader);
                break;
            case 1:
                bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_02);
                shader = new BitmapShader(bitmap1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                write_text.setText(editText.getText().toString());
                write_text.getPaint().setShader(shader);
                break;
            case 2:
                bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_03);
                shader = new BitmapShader(bitmap1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                write_text.setText(editText.getText().toString());
                write_text.getPaint().setShader(shader);
                break;
            case 3:
                bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_04);
                shader = new BitmapShader(bitmap1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                write_text.setText(editText.getText().toString());
                write_text.getPaint().setShader(shader);
                break;
            case 4:
                bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_05);
                shader = new BitmapShader(bitmap1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                write_text.setText(editText.getText().toString());
                write_text.getPaint().setShader(shader);
                break;
            case 5:
                bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_06);
                shader = new BitmapShader(bitmap1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                write_text.setText(editText.getText().toString());
                write_text.getPaint().setShader(shader);
                break;
            case 6:
                bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_07);
                shader = new BitmapShader(bitmap1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                write_text.setText(editText.getText().toString());
                write_text.getPaint().setShader(shader);
                break;
            case 7:
                bitmap1  = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_08);
                shader = new BitmapShader(bitmap1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                write_text.setText(editText.getText().toString());
                write_text.getPaint().setShader(shader);
                break;
            case 8:
                bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_09);
                shader = new BitmapShader(bitmap1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                write_text.setText(editText.getText().toString());
                write_text.getPaint().setShader(shader);
                break;
            case 9:
                bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.pattern_10);
                shader = new BitmapShader(bitmap1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                write_text.setText(editText.getText().toString());
                write_text.getPaint().setShader(shader);
                break;
        }
    }


}