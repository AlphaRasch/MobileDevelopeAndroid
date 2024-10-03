package ru.chekalinev.fortravelers.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.chekalinev.fortravelers.R;
import ru.chekalinev.fortravelers.data.repository.LandmarkRepositoryImpl;
import ru.chekalinev.fortravelers.data.repository.UserRepositoryImpl;
import ru.chekalinev.fortravelers.domain.repository.LandmarkRepository;
import ru.chekalinev.fortravelers.domain.repository.UserRepository;
import ru.chekalinev.fortravelers.domain.usecases.GetLandmarksUseCase;
import ru.chekalinev.fortravelers.domain.usecases.SignInUseCase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextLogin = findViewById(R.id.editTextLogin);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonSignIn = findViewById(R.id.buttonSignIn);
        Button buttonGetLandmarks = findViewById(R.id.buttonGetLandmarks);
        Button buttonReset = findViewById(R.id.buttonReset);
        TextView textViewResult = findViewById(R.id.textViewResult);
        TextView  textViewLandmarks = findViewById(R.id.textView2);

        UserRepository userRepository = new UserRepositoryImpl();
        LandmarkRepository landmarkRepository = new LandmarkRepositoryImpl();

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean result = new SignInUseCase(userRepository).
                        execute(editTextLogin.getText().toString(),
                                editTextPassword.getText().toString());
                textViewResult.setText(result.toString());
            }
        });

        buttonGetLandmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewLandmarks.setText(new GetLandmarksUseCase(landmarkRepository).execute());
            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewLandmarks.setText("");
            }
        });
    }
}