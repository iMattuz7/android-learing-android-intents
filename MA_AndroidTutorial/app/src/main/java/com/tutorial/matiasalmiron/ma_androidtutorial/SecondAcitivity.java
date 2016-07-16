package com.tutorial.matiasalmiron.ma_androidtutorial;


import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SecondAcitivity extends AppCompatActivity  {
    Button activityButton;
    Button startSrv;
    Button stopSrv;
    Button shareSrv;
    EditText shareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_acitivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        activityButton = (Button)findViewById(R.id.activity2Button);
        startSrv = (Button)findViewById(R.id.activity2StartButton);
        stopSrv = (Button)findViewById(R.id.activity2StopButton);
        shareSrv = (Button)findViewById(R.id.activitY2ShareButton);
        shareText = (EditText)findViewById(R.id.shareText);



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
        //probando click desde el xml
        shareSrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClick(v);
            }
        });

    }

    public void myClick(View v){
        String ulrToShare = "http://99percentinvisible.org/episode/the-mind-of-an-architect/";
        Intent intent = new Intent(Intent.ACTION_SEND);
        String s = shareText.getText().toString();
        if(!s.isEmpty()){

            intent.putExtra(Intent.EXTRA_TEXT,s);
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent,"share via..."));
        }else{
            String sharerUrl = "https://www.facebook.com/sharer/sharer.php?u=" + ulrToShare;
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
            startActivity(intent);
        }

    }

    //private Intent intent;


}
