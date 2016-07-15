package com.tutorial.matiasalmiron.ma_androidtutorial;


import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class SecondAcitivity extends AppCompatActivity  {
    Button activityButton;
    Button startSrv;
    Button stopSrv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_acitivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        activityButton = (Button)findViewById(R.id.activity2Button);
        startSrv = (Button)findViewById(R.id.activity2StartButton);
        stopSrv = (Button)findViewById(R.id.activity2StopButton);
        //startService.setOnClickListener(SecondAcitivity.this);
        //stopService.setOnClickListener(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //event click
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        startSrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondAcitivity.this,myService.class);
                startService(intent);
            }
        });

        stopSrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondAcitivity.this,myService.class);
                stopService(intent);
            }
        });




    }

    //private Intent intent;


}
