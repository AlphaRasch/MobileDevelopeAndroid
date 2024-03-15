package ru.chekalinev.dialog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.SearchView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private String _showTextInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowDialog(View view) {
        MyDialogFragment dialogFragment = new MyDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }

    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\" !", Toast.LENGTH_LONG).show();
    }

    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\" !", Toast.LENGTH_LONG).show();
    }

    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\" !", Toast.LENGTH_LONG).show();
    }
    public void onClickTimeDialog(View view){
        MyTimeDialogFragment timePicker = new MyTimeDialogFragment(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker1, int hourOfDay, int minute) {
                Snackbar.make(view, hourOfDay+":"+minute, Snackbar.LENGTH_LONG).show();
            }
        }, 16, 30, true);
        timePicker.show();
        Snackbar snackbar = Snackbar.make(view, "time opened", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void onClickDateDialog(View view){
        MyDateDialogFragment datePicker = new MyDateDialogFragment(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker1, int year, int month, int dayOfMonth) {
                Snackbar.make(view, dayOfMonth+"."+month+"."+year, Snackbar.LENGTH_LONG).show();
            }
        }, 2024, 3, 9);
        datePicker.show();
        Snackbar.make(view, "date opened", Snackbar.LENGTH_LONG).show();
    }

    public void onClickProgressDialog(View view){
        MyProgressDialogFragment progressDialog = new MyProgressDialogFragment(this);
        progressDialog.setTitle("Progress Dialog");
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }
}