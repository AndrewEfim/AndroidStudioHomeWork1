package com.example.andreii.firstaplication.HW4;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class MyViewHomeWorkFourth extends View {

    float koeficient = 3.6f;

    float numb[] = {5, 5, 10};
    float sum = numb[0] + numb[1] + numb[2];
    float proc1 = (numb[0] / sum) * 100;
    float proc2 = (numb[1] / sum) * 100;
    float proc3 = (numb[2] / sum) * 100;
    float ug1 = proc1 * koeficient;
    float ug2 = proc2 * koeficient;
    float ug3 = proc3 * koeficient;


    public MyViewHomeWorkFourth(Context context) {
        super(context);
    }

    public MyViewHomeWorkFourth(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewHomeWorkFourth(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyViewHomeWorkFourth(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paintarc1 = new Paint();
        paintarc1.setColor(Color.GREEN);
        Paint paintarc2 = new Paint();
        paintarc2.setColor(Color.RED);
        Paint paintarc3 = new Paint();
        paintarc3.setColor(Color.BLUE);
        Paint paintarc4 = new Paint();
        paintarc4.setColor(Color.WHITE);

        RectF rectf = new RectF();
        rectf.left = getWidth() * 0.1f;
        rectf.top = getHeight() * 0.1f;
        rectf.right = getWidth() - rectf.left;
        rectf.bottom = getHeight() - rectf.top;


        canvas.drawArc(rectf, 0, ug1, true, paintarc1);
        canvas.drawArc(rectf, ug1, ug2, true, paintarc2);
        canvas.drawArc(rectf, ug2 + ug1, ug3, true, paintarc3);

        paintarc4.setTextAlign(Paint.Align.CENTER);
        paintarc4.setTextSize(60);
        canvas.drawText(String.valueOf(proc1), getWidth() * 0.7f, getHeight() * 0.65f, paintarc4);
        canvas.drawText(String.valueOf(proc2), getWidth() * 0.3f, getHeight() * 0.6f, paintarc4);
        canvas.drawText(String.valueOf(proc3), getWidth() * 0.5f, getHeight() * 0.4f, paintarc4);


    }
}
