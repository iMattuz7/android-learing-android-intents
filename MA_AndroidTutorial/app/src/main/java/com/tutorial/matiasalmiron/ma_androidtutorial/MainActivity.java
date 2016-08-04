package com.tutorial.matiasalmiron.ma_androidtutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
        final Person myPerson = new Person();





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String txtToTransfer1 = edit1.getText().toString();
                final String txtToTransfer2 = edit2.getText().toString();
                final String txtToTransfer3 = edit3.getText().toString();
                myPerson.setName(txtToTransfer1);
                myPerson.setAddress(txtToTransfer2);
                Intent myIntent = new Intent(MainActivity.this, SecondAcitivity.class);
                myIntent.putExtra("NEW_PERSON",myPerson);

                startActivity(myIntent);
            }
        });
    }

    private void serializeObject(){
        Person p = new Person();
        p.setAddress("asdasd");
        p.setName("qweqwe");
        try{
            FileOutputStream fs = new FileOutputStream("/tmp/person_data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fs);
            out.writeObject(p);
            out.close();
            fs.close();

        }catch (Exception e){

        }
    }

    private Person deserializeObject(){
        Person p = null;
        try{
            FileInputStream fis = new FileInputStream("/tmp/person_data.ser");
            ObjectInputStream in = new ObjectInputStream(fis);
            p = (Person)in.readObject();
            in.close();
            fis.close();
        }catch (Exception e){

        }
        return p;
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
