package com.example.andreii.firstaplication.HW5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andreii.firstaplication.R;

public class FiveActivity extends Activity {

    private BroadcastReceiver wiFiconnect;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);


        wiFiconnect = new BroadcastReceiver() {
            TextView textViewwifi = findViewById(R.id.textViewWiFiconect);

            @Override
            public void onReceive(Context context, Intent intent) {
                if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
                    boolean noConnect = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
                    if (noConnect) {
                        textViewwifi.setText("No Connection WIFI");
                        textViewwifi.setTextColor(Color.RED);
                    } else {
                        textViewwifi.setText("Connection WIFI");
                        textViewwifi.setTextColor(Color.GREEN);
                    }
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(wiFiconnect, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(wiFiconnect);
    }
}
