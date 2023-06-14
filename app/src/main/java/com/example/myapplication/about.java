package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class about extends AppCompatActivity {

    private Animation animation = null;
    AnimationDrawable mAnimation;
    ImageView mImageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        mImageView = findViewById(R.id.animation);
        mImageView.setBackgroundResource(R.drawable.animation);
        mAnimation = (AnimationDrawable) mImageView.getBackground();


        Button mStart = findViewById(R.id.start);
        mStart.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                mAnimation.start();
            }
        });
        Button mStop = findViewById(R.id.stop);
        mStop.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                mAnimation.stop();
            }
        });

        this.setTitle("About ideas");
        final Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                about.this.finish();
            }
        });

    }
}

