package com.techelevator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Inventory {
    private Map<String, Movie> movieInventory = new HashMap<String, Movie>();
    private Date today = new Date();

    public Inventory() {
        loadData();
    }

    public Movie findMovieByTitle(String title) {
        Movie searchMovie = null;
        for (Movie movie : getMovieList()) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                searchMovie = movie;
            }
        }
        return searchMovie;
    }

    public List<Movie> getMovieList() {

        List<Movie> movieList = new ArrayList<>();

        for (String key : movieInventory.keySet()) {
            movieList.add(movieInventory.get(key));
        }
        return movieList;
    }

    public List<Movie> moviesListByGender(String genre) {
        List<Movie> moviesListByGender = new ArrayList<>();
        for (Movie movie : getMovieList()) {
            if (movie.getGenre().equalsIgnoreCase(genre)) {
                moviesListByGender.add(movie);
            }
        }
        return moviesListByGender;
    }

    public double lateFee(String rentalDate) throws Exception, ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(rentalDate);
        long daysLate = (today.getTime() - date.getTime()) / (1000 * 60 * 60 * 24);
        if (daysLate == 0) {
            return 0.00;
        } else if (daysLate == 1) {
            return 1.99;
        } else if (daysLate == 2) {
            return 3.99;
        } else {
            return 19.99;
        }
    }

    public double rentalPrice(Movie movie) {
        double rentalPrice = 0;
        if (movie.isPremium()) {
            rentalPrice += 1;
        }
        if (movie.getFormat().equalsIgnoreCase("VHS")) {
            rentalPrice += 0.99;
        } else if (movie.getFormat().equalsIgnoreCase("DVD")) {
            rentalPrice += 1.99;
        } else {
            rentalPrice += 2.99;
        }
        return rentalPrice;
    }

    public double buyPrice(Movie movie) {
        double buyPrice = 0;
        if (movie.isPremium()) {
            buyPrice += 1;
        }
        if (movie.getFormat().equalsIgnoreCase("VHS")) {
            buyPrice += 3.99;
        } else if (movie.getFormat().equalsIgnoreCase("DVD")) {
            buyPrice += 7.99;
        } else {
            buyPrice += 9.99;
        }
        return buyPrice;
    }

    public void addNewMovie(Movie movie) {
        movieInventory.put(movie.getTitle(), movie);
    }

    private void loadData() {

        Movie harryPotter = new Movie("Harry Potter", "Action", "VHS", true);
        harryPotter.setShortDescription("Harry Potter is a series of seven fantasy novels written " +
                "by British author J. K. Rowling.");

        Movie inception = new Movie("Inception", "Sci-fi", "DVD", false);
        inception.setShortDescription("Dom Cobb (Leonardo DiCaprio) is a thief with the rare ability " +
                "to enter people's dreams and steal their secrets from their subconscious.");

        Movie batman = new Movie("Batman", "Action", "Blu-Ray", true);
        batman.setShortDescription("Batman is a superhero who appears in American comic books published by DC Comics.");

        Movie gravity = new Movie("Gravity", "Sci-fi", "Blu-Ray", false);
        gravity.setShortDescription("Dr. Ryan Stone (Sandra Bullock) is a medical engineer on her first shuttle mission.");

        movieInventory.put(harryPotter.getTitle(), harryPotter);
        movieInventory.put(inception.getTitle(), inception);
        movieInventory.put(batman.getTitle(), batman);
        movieInventory.put(gravity.getTitle(), gravity);
    }
}
