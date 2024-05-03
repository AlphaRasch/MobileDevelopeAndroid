package ru.chekalinev.mireaproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import java.util.Calendar;

import ru.chekalinev.mireaproject.databinding.FragmentWorkerBinding;

public class WorkerFragment extends Fragment {
    private FragmentWorkerBinding binding;

    public WorkerFragment(){

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWorkerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                binding.textView4.setText(String.format("Current datetime: %d.%d.%d %d:%d",
                        calendar.get(Calendar.DAY_OF_MONTH),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE)));
                String datetimeString = binding.textView4.getText().toString();
                WorkRequest uploadWorkRequest =
                        new OneTimeWorkRequest.Builder(MediaWorker.class)
                                .setInputData(new Data.Builder().putString("datetime", datetimeString).build())
                                .build();
                WorkManager
                        .getInstance()
                        .enqueue(uploadWorkRequest);
                Constraints constraints	=	new	Constraints.Builder()
                        .setRequiredNetworkType(NetworkType.UNMETERED)
                        .setRequiresCharging(true)
                        .build();
                uploadWorkRequest = new OneTimeWorkRequest.Builder(MediaWorker.class)
                        .setInputData(new Data.Builder().putString("datetime", datetimeString).build())
                        .setConstraints(constraints)
                        .build();
                Log.d("worker", "load");
            }
        });

        return root;
    }


}
