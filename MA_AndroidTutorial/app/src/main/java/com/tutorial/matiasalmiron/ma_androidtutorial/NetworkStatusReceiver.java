package com.tutorial.matiasalmiron.ma_androidtutorial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by matiasalmiron on 7/17/16.
 */

public class NetworkStatusReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Network status change",Toast.LENGTH_SHORT).show();

        Bundle extras = intent.getExtras();

        boolean noNetwork = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
        if(extras!=null){
            String networkInfoString = ConnectivityManager.EXTRA_OTHER_NETWORK_INFO;
            NetworkInfo netInfo = (NetworkInfo) extras.get(networkInfoString);
            if(netInfo!=null && netInfo.getState() == NetworkInfo.State.CONNECTED){
                //Tengo conexion y se que tipo de conexion tengo
                Toast.makeText(context,"Network " + netInfo.getTypeName() + " is connected",Toast.LENGTH_SHORT).show();
            }else if (noNetwork){
                Toast.makeText(context,"Network not connected",Toast.LENGTH_SHORT).show();
            }
        }

    }
}
