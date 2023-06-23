package com.example.changingwallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnChangeWallpaper;
    boolean running = false;
    int[] imagesArray = new int[]{
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10,
            R.drawable.img11,
    };
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChangeWallpaper = (Button) findViewById(R.id.febtnChangeWallpaper);
        btnChangeWallpaper.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (!running) {
            new Timer().schedule(new MyTimer(), 0, 10000);
            running = true;
            btnChangeWallpaper.setEnabled(false);
        }
    }

    class MyTimer extends TimerTask {
        public void run() {
        try{
                WallpaperManager wm = WallpaperManager.getInstance(getBaseContext());

                Random random = new Random();
                i = random.nextInt(11);
//                if(i==0) i=1;
//                else if(i==1) i=2;
//                else if(i==2) i=3;
//                else if(i==3) i=4;
//                else if(i==4) i=5;
//                else if(i==5) i=6;
//                else if(i==6) i=7;
//                else if(i==7) i=8;
//                else if(i==8) i=9;
//                else if(i==9) i=10;
//                else if(i==10) i=0;

                wm.setBitmap(BitmapFactory.decodeResource(getResources(),imagesArray[i]));
            }catch(Exception e){

        }
        }
    }
}