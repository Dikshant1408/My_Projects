package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class LoadingScreen extends AppCompatActivity {

    private TextView appName;
    private ImageView applogo;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        applogo = findViewById(R.id.applogo);
        appName = findViewById(R.id.app_name);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.blacklist);

        appName.setTypeface(typeface);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.myanim);
        appName.setAnimation(anim);
        applogo.setAnimation(anim);

        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(LoadingScreen.this, MainActivity.class);
                startActivity(intent);
                LoadingScreen.this.finish();
            }
        }.start();
    }
}