package com.example.mycalculator;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class Splash_screen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent homeIntent = new Intent(Splash_screen.this,MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        } ,SPLASH_TIME_OUT);

        lottieAnimationView =(LottieAnimationView) findViewById(R.id.lottieAnimationView);
        startCheckAnnimation();
    }

    private void startCheckAnnimation(){
        ValueAnimator animator = ValueAnimator.ofFloat(0f,1f).setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                lottieAnimationView.setProgress((Float)animation.getAnimatedValue());
            }
        });
        if (lottieAnimationView.getProgress() == 0f){
            animator.start();
        } else {
            lottieAnimationView.setProgress(0f);
        }
    }
}
