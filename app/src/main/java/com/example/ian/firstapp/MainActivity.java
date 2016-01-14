package com.example.ian.firstapp;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    AnimationDrawable dogAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.mus_dogsong);
        mp.setLooping(true);

        ImageButton dogImage = (ImageButton) findViewById(R.id.dogImage);
        dogImage.setBackgroundResource(R.drawable.dogwag);
        dogAnimation = (AnimationDrawable) dogImage.getBackground();
    }

    public void dogButtonClick(View view) {
        if (mp.isPlaying()) {
            mp.pause();
        } else {
            mp.start();
        }

        if (dogAnimation.isRunning()) {
            dogAnimation.stop();
        } else {
            dogAnimation.start();
        }
    }

    public void musicSelect(View view) {
        if (mp.isPlaying()) {
            mp.stop();
        }

        if (dogAnimation.isRunning()) {
            dogAnimation.stop();
        }

        if (view.getId() == R.id.musicButton1) {
            mp = MediaPlayer.create(this, R.raw.mus_dogsong);
        } else if (view.getId() == R.id.musicButton2) {
            mp = MediaPlayer.create(this, R.raw.tne);
        }
    }
}
