package com.example.reaya_project.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.reaya_project.R;
import com.example.reaya_project.StartActivity;

public class AppLogoActivity extends AppCompatActivity {

    // Constant Time Delay (This means 2,5 seconds)
    private final int SPLASH_DELAY = 2500;

    // Fields (Widgets)
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_logo);
        getWindow().setBackgroundDrawable(null);

        // Methods to call
        initializedView();
        animateLogo();
        goToMainActivity();

    }

    private void initializedView() {
        imageView = findViewById(R.id.imageView);

    }

    private void animateLogo() {
        // This Method will animate Logo

        Animation fadingInAnimation = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        fadingInAnimation.setDuration(SPLASH_DELAY);

        imageView.startAnimation(fadingInAnimation);
    }

    private void goToMainActivity() {
        // This methode will take user to main activity when animation is finished
        new Handler().postDelayed(()-> {
            startActivity(new Intent(AppLogoActivity.this, StartActivity.class));
            finish();
        },SPLASH_DELAY);

    }
}