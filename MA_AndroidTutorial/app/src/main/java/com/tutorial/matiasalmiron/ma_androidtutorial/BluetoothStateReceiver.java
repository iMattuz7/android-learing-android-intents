package com.tutorial.matiasalmiron.ma_androidtutorial;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by matiasalmiron on 7/17/16.
 */

public class BluetoothStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String stateExtra = BluetoothAdapter.EXTRA_STATE;
        int state = intent.getIntExtra(stateExtra,-1);
        //int previousState = intent.getIntExtra(prevStateExtra,-1);

        String statusText = "";
        if(state == BluetoothAdapter.STATE_TURNING_ON){
            statusText = "Turning On Bluetooth";
        }
        else if (state == BluetoothAdapter.STATE_ON)
            statusText = "Bluetooth on";
        else if (state == BluetoothAdapter.STATE_TURNING_OFF)
            statusText = "Bluetooth apagandose";
        else if (state == BluetoothAdapter.STATE_OFF)
            statusText = "Bluetooth off";
        Toast.makeText(context,statusText,Toast.LENGTH_SHORT).show();

    }
}
