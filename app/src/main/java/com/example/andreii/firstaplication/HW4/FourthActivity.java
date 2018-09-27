package com.example.andreii.firstaplication.HW4;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.example.andreii.firstaplication.R;

public class FourthActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        ImageView imageViewanimation = findViewById(R.id.imageView4A);
        imageViewanimation.setBackgroundResource(R.drawable.animation_owl);

        AnimationDrawable animationDrawable = (AnimationDrawable) imageViewanimation.getBackground();
        animationDrawable.start();
    }
}
