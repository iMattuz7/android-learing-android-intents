package com.tutorial.matiasalmiron.ma_androidtutorial;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;


public class SecondAcitivity extends AppCompatActivity {
    Button videoButton;
    VideoView videoView;
    private final int TAKE_VIDEO = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_acitivity);
        videoButton = (Button)findViewById(R.id.activity2Button);
        videoView = (VideoView) findViewById(R.id.videoView);

        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                i.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
                startActivityForResult(i,TAKE_VIDEO);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==TAKE_VIDEO){
            if(resultCode == RESULT_OK) {
                Uri videoUri = data.getData();
                videoView.setVideoURI(videoUri);
                videoView.start();
            }
        }
    }
}
