package com.example.andreii.firstaplication.HW8;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.example.andreii.firstaplication.R;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class EightMainActivity extends Activity {
    private static final String TARGET = "myLog";
    TextView text;
    TextView text1;

    @Override
    protected void onResume() {
        super.onResume();
        workWithObservable();

    }

    @Override
    protected void onStart() {
        super.onStart();
        workWithObservable();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_main);
        Log.d(TARGET, "start");

        //   text = findViewById(R.id.textViewEvent_eightHW);
        text1 = findViewById(R.id.textViewInt_eightHW);


     //}




    }
    public void workWithObservable(){
        Observable.interval(1000,TimeUnit.MILLISECONDS).
                map(Long::intValue)
                .filter(l->l%2==0)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer i) {
                Log.d(TARGET,"on next"+i);
                ((TextView)findViewById(R.id.textViewInt_eightHW)).setText(i.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
