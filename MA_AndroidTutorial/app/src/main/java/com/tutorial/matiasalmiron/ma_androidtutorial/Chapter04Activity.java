package com.tutorial.matiasalmiron.ma_androidtutorial;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Chapter04Activity extends AppCompatActivity {
private final int BLUETOOTH_RESULT_OK = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter04);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //register receiver
        registerReceiver(new BluetoothStateReceiver(),new IntentFilter(
                BluetoothAdapter.ACTION_STATE_CHANGED));

        String enableBlueTooth = BluetoothAdapter.ACTION_REQUEST_ENABLE;
        Intent i = new Intent(enableBlueTooth);
        startActivityForResult(i,BLUETOOTH_RESULT_OK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==RESULT_OK){
            if(resultCode==BLUETOOTH_RESULT_OK){
                Toast.makeText(this,"bluetooth activo",Toast.LENGTH_SHORT).show();
            }

        }else if(requestCode==RESULT_CANCELED){
            Toast.makeText(this,"bluetooth no funca",Toast.LENGTH_SHORT).show();
        }
    }
}
