package ru.chekalinev.mireaproject.lesson5;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.chekalinev.mireaproject.R;
import ru.chekalinev.mireaproject.databinding.FragmentSensorBinding;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SensorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SensorFragment extends Fragment implements SensorEventListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TextView textUp;
    private TextView textLeft;
    private TextView textRight;
    private TextView textDown;

    private FragmentSensorBinding binding;

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SensorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SensorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SensorFragment newInstance(String param1, String param2) {
        SensorFragment fragment = new SensorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        sensorManager =
                (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = sensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onResume(){
        super.onResume();
        sensorManager.registerListener(this, accelerometerSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float rotate1 = event.values[0];
            float rotate2 = event.values[1];
            if(rotate1>= -4f && rotate1<=4f){
                textUp.setText("Это север!");
                textLeft.setText("Пустота");
                textRight.setText("Пустота");
                textDown.setText("Пустота");
            }
            else if(rotate1>=6f && rotate1<=9.9f){
                textRight.setText("Это север!");
                textUp.setText("Пустота");
                textLeft.setText("Пустота");
                textDown.setText("Пустота");
            }
            else if(rotate1<=-6f && rotate1>=-10f){
                textLeft.setText("Это север!");
                textUp.setText("Пустота");
                textRight.setText("Пустота");
                textDown.setText("Пустота");

            }
            else if(rotate1 >=-4f && rotate1 <=5f){
                textLeft.setText("Пустота");
                textUp.setText("Пустота");
                textRight.setText("Пустота");
                textDown.setText("Это север!");
            }
            else{
                textLeft.setText("Пустота");
                textUp.setText("Пустота");
                textRight.setText("Пустота");
                textDown.setText("Пустота");
            }

            //textUp.setText(rotate1 + " | " + rotate2);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSensorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        textUp = binding.textUp;
        textLeft = binding.textLeft;
        textRight = binding.textRight;
        textDown = binding.textDown;
        return root;
    }
}