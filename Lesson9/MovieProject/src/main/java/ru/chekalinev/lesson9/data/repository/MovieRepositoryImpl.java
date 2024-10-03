package ru.chekalinev.lesson9.data.repository;

import android.content.Context;
import android.content.SharedPreferences;

import ru.chekalinev.lesson9.domain.models.Movie;
import ru.chekalinev.lesson9.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {

    private Context context;

    public MovieRepositoryImpl(Context context){
        this.context = context;
    }

    @Override
    public boolean saveMovie(Movie movie) {
        SharedPreferences sharedPref = context.getSharedPreferences("films_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("FAV_FILM", movie.getName());
        editor.apply();

        return true;
    }

    @Override
    public Movie getMovie() {
        SharedPreferences sharedPref = context.getSharedPreferences("films_data", Context.MODE_PRIVATE);
        String filmName = sharedPref.getString("FAV_FILM", "StarWars");

        return new Movie(1, filmName);
    }

}
