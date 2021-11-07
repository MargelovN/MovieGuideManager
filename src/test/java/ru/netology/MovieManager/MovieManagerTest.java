package ru.netology.MovieManager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieGuide.MovieGuide;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
    private MovieGuide first = new MovieGuide(1, "Bloodshot");
    private MovieGuide second = new MovieGuide(2, "Onward");
    private MovieGuide third = new MovieGuide(3, "Belgrad Hotel");
    private MovieGuide fourth = new MovieGuide(4, "the Gentlemen");
    private MovieGuide fifth = new MovieGuide(5, "Invisible Man");
    private MovieGuide sixth = new MovieGuide(6, "Trolls. World Tour");
    private MovieGuide seventh = new MovieGuide(7, "Number One");
    private MovieGuide eighth = new MovieGuide(8, "Harry Potter and the Sorcerer's Stone)");
    private MovieGuide ninth = new MovieGuide(9, "Harry Potter and the Chamber of Secrets");
    private MovieGuide tenth = new MovieGuide(10, "Harry Potter and the Prisoner of Azkaban");
    private MovieGuide eleventh = new MovieGuide(11, "Harry Potter and the Goblet of Fire");

    private void addFilm() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
    }

    @Test
    public void shouldGetLastEmptyManager() {
        MovieManager manager = new MovieManager();

        MovieGuide[] expected = new MovieGuide[0];
        MovieGuide[] actual = manager.getLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsAboveMovieNumbers() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        int expected = 1;
        int actual = manager.getLastFilms().length;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsInEmptyManager() {
        MovieManager manager = new MovieManager(6);
        MovieGuide[] expected = new MovieGuide[0];
        MovieGuide[] actual = manager.getLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsInEmptyManagerAboveMovieNumbers() {
        MovieManager manager = new MovieManager(14);
        MovieGuide[] expected = new MovieGuide[0];
        MovieGuide[] actual = manager.getLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastOneFilm() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        MovieGuide[] expected = new MovieGuide[]{first};
        MovieGuide[] actual = manager.getLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastOneFilmInMovieNumbers() {
        MovieManager manager = new MovieManager(8);
        manager.add(first);
        MovieGuide[] expected = new MovieGuide[]{first};
        MovieGuide[] actual = manager.getLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastOneFilmOverMovieNumbers() {
        MovieManager manager = new MovieManager(19);
        manager.add(first);
        MovieGuide[] expected = new MovieGuide[]{first};
        MovieGuide[] actual = manager.getLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddFilms() {
        addFilm();
        int expected = 10;
        int actual = manager.getItems().length - 1;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsAccordingToMovieNumbers() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        MovieGuide[] expected = new MovieGuide[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        MovieGuide[] actual = manager.getLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsMoreMovieNumbers() {
        addFilm();
        MovieGuide[] expected = new MovieGuide[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        MovieGuide[] actual = manager.getLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsWithMovieNumbers() {
        MovieManager manager = new MovieManager(3);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        MovieGuide[] expected = new MovieGuide[]{tenth, ninth, eighth};
        MovieGuide[] actual = manager.getLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsOverMovieNumbers() {
        MovieManager manager = new MovieManager(11);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        MovieGuide[] expected = new MovieGuide[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        MovieGuide[] actual = manager.getLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsWithZeroParameters() {
        MovieManager manager = new MovieManager(0);
        addFilm();
        MovieGuide[] expected = new MovieGuide[0];
        MovieGuide[] actual = manager.getLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsWithNegativeParameters() {
        MovieManager manager = new MovieManager(-2);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        MovieGuide[] expected = new MovieGuide[]{fifth, fourth, third, second, first};
        MovieGuide[] actual = manager.getLastFilms();

        assertArrayEquals(expected, actual);
    }
}