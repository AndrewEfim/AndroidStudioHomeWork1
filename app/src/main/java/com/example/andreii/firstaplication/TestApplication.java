package com.example.andreii.firstaplication;

import com.squareup.leakcanary.LeakCanary;

public class TestApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
