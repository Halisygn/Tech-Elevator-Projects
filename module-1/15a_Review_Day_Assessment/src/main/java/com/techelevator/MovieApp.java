package com.techelevator;

import java.util.List;

public class MovieApp {
    private Inventory inventory;
    private Menu menu;
    private String LIST_MOVIES = "1";
    private String SEARCH_HOME_BY_TITLE = "2";
    private String SEARCH_HOME_BY_GENRE = "3";
    private String RETURN_RENTAL = "4";


    public MovieApp() {
        inventory = new Inventory();
        menu = new Menu();
    }

    public static void main(String[] args) throws Exception {
        MovieApp app = new MovieApp();
        app.run();
    }

    public void run() throws Exception {
        while (true) {
            String response = menu.printMainMenu();
            if (response.equals(LIST_MOVIES)) {
                List<Movie> foundMovie = inventory.getMovieList();
                menu.printListOfMovies(foundMovie);
            } else if (response.equals(SEARCH_HOME_BY_TITLE)) {
                menu.printAskMovieTitleAndChoice();
            } else if (response.equals(SEARCH_HOME_BY_GENRE)) {
                String genre;
                while (true) {
                    genre = menu.askUserForGenre();
                    menu.printMoviesByGenre(genre);
                    if (!inventory.moviesListByGender(genre).isEmpty()) {
                        break;
                    }
                }
                menu.printAskMovieTitleAndChoice();
            } else if (response.equals(RETURN_RENTAL)) {
                String rentalDate = menu.askUserForRentalDate();
                menu.printLateFee(rentalDate);

            } else {
                break;
            }
        }
    }
}

