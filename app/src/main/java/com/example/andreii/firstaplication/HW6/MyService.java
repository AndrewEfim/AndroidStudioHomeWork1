package com.example.andreii.firstaplication.HW6;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.widget.TextView;
import android.widget.Toast;

public class MyService extends Service {

    private BroadcastReceiver wiFiconnect;
    TextView textView;
    private final IBinder myBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        wiFiOnOff();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(WIFI,intentFilter);
        return super.onStartCommand(intent, flags, startId);
    }


    void wiFiOnOff() {
        WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        boolean wifiEnabled = wifiManager.isWifiEnabled();
        if (wifiEnabled) {
            wifiManager.setWifiEnabled(false);


        } else if (!wifiEnabled) {
            wifiManager.setWifiEnabled(true);


        }
    }

    BroadcastReceiver WIFI = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
                boolean noConnect = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
                if (noConnect) {
                    Toast.makeText(getApplicationContext(), "No Connection WIFI", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "WIFI Connect !", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
