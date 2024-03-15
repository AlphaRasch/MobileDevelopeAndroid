package ru.chekalinev.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    private EditText TextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String test = "MIREA";
        String test2 = test + "best";
        Log.d(TAG, "Мой код выполняется");
        ShowResult("onCreate()");
    }

    @Override
    protected  void onStart(){
        super.onStart();
        ShowResult("onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        ShowResult("onRestoreInstanceState()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        ShowResult("onRestart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        ShowResult("onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        ShowResult("onPause()");
    }

    @Override
    protected  void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        ShowResult("onSaveInstanceState()");
    }

    @Override
    protected  void onStop(){
        super.onStop();
        ShowResult("onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ShowResult("onDestroy()");
    }

    @Override
    protected void onPostCreate(Bundle saveInstanceState){
        super.onPostCreate(saveInstanceState);
        ShowResult("onPostCreate()");
    }

    @Override
    public void onAttachedToWindow(){
        super.onAttachedToWindow();
        ShowResult("onAttachedToWindow()");
    }

    @Override
    public void onDetachedFromWindow(){
        super.onDetachedFromWindow();
        ShowResult("onDetachedFromWindow()");
    }
    private  void ShowResult(String method_name){
        TextActivity = findViewById(R.id.TextActivity);
        TextActivity.setText(method_name);
        Log.d(TAG, method_name);
    }
}