package ru.chekalinev.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainAct onCreate()");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "MainAct onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "MainAct onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "MainAct onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "MainAct onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "MainAct onDestroy()");
    }
    public void onClickNewActivity(View v){
        editText1 = findViewById(R.id.editTextText1);
        String text = editText1.getText().toString();
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("key", text);
        startActivity(intent);

    }
}