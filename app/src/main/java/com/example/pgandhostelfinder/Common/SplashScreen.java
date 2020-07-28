package com.example.pgandhostelfinder.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.pgandhostelfinder.R;
import com.example.pgandhostelfinder.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;
    ImageView backgroundimage;
    Animation sideAnim,bottomAnim;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        backgroundimage = findViewById(R.id.background_image);

        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        backgroundimage.setAnimation(sideAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime",true);

                if(isFirstTime){
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime",false);
                    editor.commit();
                    startActivity(new Intent(SplashScreen.this, OnBoarding.class));
                    finish();
                }
                else{
                    startActivity(new Intent(SplashScreen.this, UserDashboard.class));
                    finish();
                }
            }
        },SPLASH_TIMER);
    }
}
