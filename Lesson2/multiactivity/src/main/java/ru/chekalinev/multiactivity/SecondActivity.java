package ru.chekalinev.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textView1;
    private String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String text = (String) getIntent().getSerializableExtra("key");
        textView1 = findViewById(R.id.textView1);
        textView1.setText(text);
        Log.d(TAG, "SecondAct onCreate()");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "SecondAct onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "SecondAct onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "SecondAct onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "SecondAct onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "SecondAct onDestroy()");
    }

}