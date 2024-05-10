package ru.chekalinev.mireaproject.lesson8;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.chekalinev.mireaproject.R;
import ru.chekalinev.mireaproject.databinding.FragmentMapBinding;


public class MapFragment extends Fragment {
    private FragmentMapBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMapBinding.inflate(inflater, container, false);

        setButtons();

        return binding.getRoot();
    }

    private void setButtons() {
        binding.buttonShowStromynkaCorpus.setOnClickListener(v -> startMapActivity(
                "МИРЭА Корпус на Стромынке",
                "Москва, улица Стромынка, 20",
                55.794137, 37.701500));
        binding.buttonShowMainCorpus.setOnClickListener(v -> startMapActivity(
                "МИРЭА Главный корпус",
                "Москва, просп. Вернадского, 78",
                55.670010, 37.480426));
        binding.buttonShowTheByk.setOnClickListener(v -> startMapActivity(
                "Мирэа Корпус на Фрунзе",
                "Москва, Малая Пироговская улица, 1с5",
                55.731582, 37.574840));

        binding.buttonShowParkGorkogo.setOnClickListener(v -> startMapActivity(
                "МИРЭА корпус на Вернадского, 86" ,
                "Москва, просп. Вернадского, 86",
                55.661892, 37.477624));
    }

    private void startMapActivity(String title, String description, double latitude, double longitude) {
        Intent intent = new Intent(getActivity(), MapActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("description", description);
        intent.putExtra("latitude", latitude);
        intent.putExtra("longitude", longitude);
        startActivity(intent);
    }
}