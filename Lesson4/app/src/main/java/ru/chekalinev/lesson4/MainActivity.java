package ru.chekalinev.lesson4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import ru.chekalinev.lesson4.databinding.ActivityMainBinding;
import ru.chekalinev.lesson4.databinding.FragmentAudioPlayerBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentAudioPlayerBinding audioPlayerBinding;
    @Override
    protected void onCreate(Bundle	savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        audioPlayerBinding = FragmentAudioPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.editTextMirea.setText("Мой номер по списку №28");
        binding.textViewMirea.setText("РТУ МИРЭА");
        binding.buttonMirea.setOnClickListener(new	View.OnClickListener()	{
            @Override
            public	void onClick(View v)	{
                Log.d(MainActivity.class.getSimpleName(),"onClickListener");
                binding.audioplayer.addView(audioPlayerBinding.getRoot());
            }
        });
    }

}