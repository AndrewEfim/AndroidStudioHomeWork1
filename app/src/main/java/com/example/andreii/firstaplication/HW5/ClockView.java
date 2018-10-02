package com.example.andreii.firstaplication.HW5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.andreii.firstaplication.R;

import java.util.Calendar;

public class ClockView extends View {
    public ClockView(Context context) {
        super(context);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @SuppressLint("ResourceAsColor")
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float radius = Math.min(getWidth(), getHeight()) / 2;
        float radiusTwo = Math.min(getWidth(), getHeight() / 35);
        Paint paintcircle = new Paint();
        Paint paintcircleTwo = new Paint();
        paintcircle.setColor(Color.BLACK);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paintcircle);


        Paint paintline = new Paint();
        paintline.setColor(Color.WHITE);
        paintline.setStrokeWidth(10);

        Paint paintlineMainOclok = new Paint();
        paintlineMainOclok.setColor(Color.WHITE);
        paintlineMainOclok.setStrokeWidth(30);

        Paint painHourLine = new Paint();
        painHourLine.setColor(Color.WHITE);
        painHourLine.setStrokeWidth(10);
        Paint piantSecondLine = new Paint();
        piantSecondLine.setColor(Color.RED);
        piantSecondLine.setStrokeWidth(3);
        Paint paintText = new Paint();
        paintText.setColor(Color.RED);


        float xEdge = getHeight() - radius / 6;
        float xLine = getWidth() / 2;
        float yStartLine = xEdge * 0.9f;
        float yEndLine = xEdge * 1.0f;

        canvas.save();
        float stepOne = 360 / 12;
        float stepTwo = 360 / 4;
        float stepThree = 360 / 60;

        for (int i = 0; i < 12; i++) {

            canvas.drawLine(xLine, yStartLine, xLine, yEndLine, paintline);
            canvas.rotate(stepOne, getWidth() / 2, getHeight() / 2);

        }
        for (int i = 0; i < 4; i++) {

            canvas.drawLine(xLine, yStartLine, xLine, yEndLine, paintlineMainOclok);
            canvas.rotate(stepTwo, getWidth() / 2, getHeight() / 2);

        }
        canvas.restore();

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        canvas.save();
        canvas.rotate(stepOne * hour + stepOne / 60 * minute, getWidth() / 2, getHeight() / 2);
        canvas.drawLine(getWidth() / 2, getHeight() / 2, getWidth() / 2, getHeight() / 2 - radius / 3, painHourLine);
        canvas.restore();
        canvas.save();
        canvas.rotate(stepThree * minute, getWidth() / 2, getHeight() / 2);
        canvas.drawLine(getWidth() / 2, getHeight() / 2, getWidth() / 2, getHeight() / 2 - radius / 2, painHourLine);
        canvas.restore();
        canvas.save();
        canvas.rotate(stepThree * second, getWidth() / 2, getHeight() / 2);
        canvas.drawLine(getWidth() / 2, getHeight() / 2, getWidth() / 2, getHeight() / 2 - (radius - 10), piantSecondLine);
        canvas.restore();


        invalidate();

        paintText.setTextAlign(Paint.Align.CENTER);
        paintText.setTextSize(40);
        canvas.drawText("12", getWidth() * 0.5f, getHeight() * 0.07f, paintText);
        canvas.drawText("3", getWidth() * 0.95f, getHeight() * 0.525f, paintText);
        canvas.drawText("6", getWidth() * 0.5f, getHeight() * 0.98f, paintText);
        canvas.drawText("9", getWidth() * 0.05f, getHeight() * 0.525f, paintText);
        paintcircleTwo.setColor(Color.RED);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radiusTwo, paintcircleTwo);


    }


}
