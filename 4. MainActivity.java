package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button start;
    WallpaperManager wpm;
    Timer timer;
    Drawable drawable;
    int prev=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.Change);
        timer=new Timer();
        wpm= WallpaperManager.getInstance(this);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change();
            }
        });
    }
    public void change(){
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                if (prev==1){
                    drawable=getResources().getDrawable(R.drawable.img1);
                    prev=2;
                }else if (prev==2){
                    drawable=getResources().getDrawable(R.drawable.img1);
                    prev=3;
                }else if (prev==3){
                    drawable=getResources().getDrawable(R.drawable.img1);
                    prev=4;
                }else if (prev==4){
                    drawable=getResources().getDrawable(R.drawable.img1);
                    prev=5;
                }else if (prev==5){
                    drawable=getResources().getDrawable(R.drawable.img1);
                    prev=1;
                }
                Bitmap Wallpaper=((BitmapDrawable)drawable).getBitmap();
                try{
                    wpm.setBitmap(Wallpaper);
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        },0,5000);
    }
}
