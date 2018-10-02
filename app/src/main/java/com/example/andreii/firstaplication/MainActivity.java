package com.example.andreii.firstaplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.andreii.firstaplication.HW1.FirstAplicationActivity;
import com.example.andreii.firstaplication.HW2.SecondActivity;
import com.example.andreii.firstaplication.HW3.ThirdActivity;
import com.example.andreii.firstaplication.HW4.FourthActivity;
import com.example.andreii.firstaplication.HW4.FourthActivityPtTwo;
import com.example.andreii.firstaplication.HW5.FiveActivity;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4_1 = findViewById(R.id.button4_1);
        Button button4_2 = findViewById(R.id.button4_2);
        Button button5 = findViewById(R.id.button5);
        //

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this,FirstAplicationActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animation_one,R.anim.animation_two);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animation_one,R.anim.animation_two);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animation_one,R.anim.animation_two);
            }
        });

        button4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FourthActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animation_one,R.anim.animation_two);
            }
        });
        button4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FourthActivityPtTwo.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animation_one,R.anim.animation_two);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FiveActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animation_one,R.anim.animation_two);
            }
        });


    }
}
