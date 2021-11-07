package ru.netology.MovieManager;

import ru.netology.domain.MovieGuide.MovieGuide;

public class MovieManager {
    private MovieGuide[] items = new MovieGuide[0];
    private int movieNumbers = 10;

    public MovieManager() {
    }

    public MovieManager(int movieNumbers) {
        if (movieNumbers >= 10 || movieNumbers < 0) {
            movieNumbers = 10;
        } else {
            this.movieNumbers = movieNumbers;
        }
    }

    public int getMovieNumbers() {
        return movieNumbers;
    }

    public MovieGuide[] getItems() {
        return items;
    }

    public void add(MovieGuide newMovieGuide) {
        MovieGuide[] tmp = new MovieGuide[items.length + 1];

        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newMovieGuide;
        items = tmp;
    }

    public MovieGuide[] getLastFilms() {
        int resultLength;
        if (getMovieNumbers() >= items.length) {
            resultLength = items.length;
        } else {
            resultLength = getMovieNumbers();
        }
        MovieGuide[] result = new MovieGuide[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
