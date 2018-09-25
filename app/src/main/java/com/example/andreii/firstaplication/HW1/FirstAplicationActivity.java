package com.example.andreii.firstaplication.HW1;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.andreii.firstaplication.R;

public class FirstAplicationActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firsraplication);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        final TextView textView1 = findViewById(R.id.textView1);
        final TextView textView2 = findViewById(R.id.textView2);
        textView1.setText(R.string.one);
        textView2.setText(R.string.two);
        textView1.getBackground();
        textView2.getBackground();
        textView1.setBackgroundColor(getResources().getColor(R.color.one));
        textView2.setBackgroundColor(getResources().getColor(R.color.two));

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new Change().changeText(textView1, textView2);
//            }
//        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                new Change().changeText(textView1, textView2);
                new Change().changeBackground(textView1, textView2);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                new Change().changeText(textView1, textView2);
                new Change().changeBackground(textView1, textView2);
            }
        });
    }

    @Override
    public void onClick(View v) {
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        new Change().changeText(textView1, textView2);


    }
}
