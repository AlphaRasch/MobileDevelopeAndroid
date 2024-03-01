package ru.chekalinev.buttonclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvOut;
    private Button btnWhoAmI;
    private Button btnItIsNotMe;
    private CheckBox changeCheckBox;
    private String WhoAmI = "Мой номер по списку № 28";
    private  String ItIsNotMe = "Это не я сделал";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOut = findViewById(R.id.tvOut);
        btnWhoAmI = findViewById(R.id.btnWhoAmI);
        btnItIsNotMe = findViewById(R.id.btnItIsNotMe);
        changeCheckBox = findViewById(R.id.whoIs);
        View.OnClickListener oclBtnWhoAmI = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOut.setText(WhoAmI);
                changeCheckBox.setText(WhoAmI);
                changeCheckBox.setChecked(true);
            }
        };

        btnWhoAmI.setOnClickListener(oclBtnWhoAmI);

//        View.OnClickListener oclBtnItIsNotMe = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvOut.setText("Это не я сделал");
//            }
//        };
//        btnItIsNotMe.setOnClickListener(oclBtnItIsNotMe);
    }

    public void onMyButtonClick(View view) {
        //Toast.makeText(this, "Это не я сделал", Toast.LENGTH_SHORT).show();
        tvOut.setText(ItIsNotMe);
        changeCheckBox.setText(ItIsNotMe);
        changeCheckBox.setChecked(false);
    }
}