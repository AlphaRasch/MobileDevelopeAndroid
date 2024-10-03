package ru.chekalinev.lesson9.domain.repository;

import ru.chekalinev.lesson9.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}
