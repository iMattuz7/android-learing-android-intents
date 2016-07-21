package com.tutorial.matiasalmiron.ma_androidtutorial;


import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.Locale;


public class SecondAcitivity extends AppCompatActivity {
    Button videoButton;
    EditText editTxt;
    TextToSpeech ttobj;
    Button speachButton;
    EditText speachTxt;
    private final int SPEAK = 1;
    private final int VAL_DATA =2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_acitivity);
        videoButton = (Button)findViewById(R.id.activity2Button);
        editTxt = (EditText) findViewById(R.id.speachText);
        speachButton = (Button)findViewById(R.id.textSpeachButton);
        speachTxt = (EditText) findViewById(R.id.talkText);

        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hablame...");
                i.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,1);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                startActivityForResult(i,SPEAK);
            }
        });
        speachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
                startActivityForResult(i,VAL_DATA);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SPEAK && resultCode == RESULT_OK){
            ArrayList<String> results;
            results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if(results != null)
                editTxt.setText(results.toString());
        }
        if(requestCode ==VAL_DATA){
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {

                ttobj = new TextToSpeech(this,
                        new TextToSpeech.OnInitListener() {
                            public void onInit(int status) {
                                if (status == TextToSpeech.SUCCESS) {
                                    ttobj.setLanguage(Locale.US);
                                    ttobj.setSpeechRate(1.1f);
                                    ttobj.speak("Hello Matias, Say your favourite band", TextToSpeech.QUEUE_FLUSH, null);
                                }
                            } });
            }else{
                Intent install = new Intent(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(install);
            }


        }

    }
}
