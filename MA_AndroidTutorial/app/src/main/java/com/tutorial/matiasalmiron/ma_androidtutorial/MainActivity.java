package com.tutorial.matiasalmiron.ma_androidtutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1;
    EditText edit2;
    EditText edit3;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Toast.makeText(MainActivity.this, "onCreate", Toast.LENGTH_LONG).show();
//       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        button = (Button) findViewById(R.id.Activity1Button);
        edit1 = (EditText)findViewById(R.id.edittext1);
        edit2 = (EditText)findViewById(R.id.edittext1);
        edit3 = (EditText)findViewById(R.id.edittext1);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String txtToTransfer1 = edit1.getText().toString();
                final String txtToTransfer2 = edit2.getText().toString();
                final String txtToTransfer3 = edit3.getText().toString();
                Intent myIntent = new Intent(MainActivity.this, SecondAcitivity.class);
                Bundle myBundle = new Bundle();
                myBundle.putString("Value4",txtToTransfer1);
                myIntent.putExtra("VALUE1",txtToTransfer1);
                myIntent.putExtra("VALUE2",txtToTransfer2);
                myIntent.putExtra("VALUE3",txtToTransfer3);
                myIntent.putExtras(myBundle);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(MainActivity.this,"onStart",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(MainActivity.this,"onResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(MainActivity.this,"onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(MainActivity.this,"onStop",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "onDestroy", Toast.LENGTH_LONG).show();
    }
}
