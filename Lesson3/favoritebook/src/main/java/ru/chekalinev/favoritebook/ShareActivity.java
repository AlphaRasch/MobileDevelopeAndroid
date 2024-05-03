package ru.chekalinev.favoritebook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        Bundle extras = getIntent().getExtras();
        text = findViewById(R.id.editTextText);
        if (extras != null) {
            TextView ageView = findViewById(R.id.textView);
            String university = extras.getString(MainActivity.KEY);
            ageView.setText(String.format("Мой любимая книга: %s", university));
            text.setText(university);
        }
    }

    public void onClickSendBook(View view){
        Intent data = new Intent();
        data.putExtra(MainActivity.USER_MESSAGE, "Название Вашей " +
                "любимой книги: "+text.getText().toString());
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}