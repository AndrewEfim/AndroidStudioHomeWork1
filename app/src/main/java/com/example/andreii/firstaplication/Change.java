package com.example.andreii.firstaplication;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

public class Change {


    public void changeText(TextView textView1, TextView textView2) {
        if (textView1.getText() != (textView2.getText())) {
            CharSequence tdop = textView1.getText();
            textView1.setText(textView2.getText());
            textView2.setText(tdop);

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void changeBackground(TextView textView1, TextView textView2) {
        if (textView2.getBackground() != textView1.getBackground()) {
            Drawable color = textView1.getBackground();
            textView1.setBackground(textView2.getBackground());
            textView2.setBackground(color);
        }
    }
}
