package com.techelevator;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    Scanner scanner;
    Inventory inventory = new Inventory();

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public String printMainMenu() {
        System.out.println("Welcome to Rental Movie");
        System.out.println("----------------------------");
        System.out.println("1. List all movies");
        System.out.println("2. Search for a movie by title");
        System.out.println("3. Search for a movie by genre");
        System.out.println("4. Return a movie");
        System.out.println("5. Exit");
        System.out.println();
        System.out.println("Please select your choice (number only)");
        String userChoice = scanner.nextLine();
        return userChoice;
    }

    public String askUserForRentalDate() {
        System.out.println("Please enter the rental date as \"dd/MM/yyyy\": ");
        return scanner.nextLine();
    }

    public void printLateFee(String rentalDate) throws Exception {
        try{
        double fee=inventory.lateFee(rentalDate);
            System.out.println("Your rental late fee is= " +fee);
        }
        catch(ParseException parseException){
            System.out.println("Date is not valid.");
        }
    }

    public String askUserForTitle() {
        System.out.println("Please enter the movie title you are looking for: ");
        return scanner.nextLine();
    }

    public void printGenreList() {
        Set<String> genreSet = new HashSet<>();
        for (Movie movie : inventory.getMovieList()) {
            genreSet.add(movie.getGenre());
        }
        System.out.println("Genres\n------------------");
        for (String genre : genreSet) {
            System.out.println(genre);
        }
    }

    public String askUserForGenre() {
        printGenreList();
        System.out.println("Please enter the genre you are looking for: ");
        return scanner.nextLine();
    }

    public void askRentalOrBuy(Movie movie) {
        System.out.println("1. Buy");
        System.out.println("2. Rent");
        System.out.println("3. Main Menu");

        System.out.println("Please select your choice (number only)");
        String answer = scanner.nextLine();
        if (answer.equals("1")) {
            System.out.println(movie.getTitle() + " buy price is $" + inventory.buyPrice(movie));
        } else if (answer.equals("2")) {
            System.out.println(movie.getTitle() + " rental price is $" + inventory.rentalPrice(movie));
        } else {
        }
    }

    public void printListOfMovies(List<Movie> movieList) {
        for (Movie movie : movieList) {
            printMovie(movie);
        }
    }

    public void printMovie(Movie movie) {

        System.out.println("Movie Title: " + movie.getTitle());

        System.out.println(String.format("%-25s %s", "Genre: ", movie.getGenre()));
        System.out.println(String.format("%-25s %s", "Format: ", movie.getFormat()));
        System.out.println(String.format("%-25s %s", "Description: ", movie.getShortDescription()));

        System.out.println("*********** *** *** ***  ************\n");
    }

    public void printError(String message) {
        System.out.println("Error: " + message);
    }

    public void printMoviesByGenre(String genre) {
        List<Movie> genreList = inventory.moviesListByGender(genre);
        if (genreList.isEmpty()) {
            printError("Genre is not found.");
        } else {
            System.out.println(genre + " Movies");
            System.out.println("-----------------");
            for (Movie movie : genreList) {
                System.out.println(movie.getTitle());
            }
        }
    }

    public void printAskMovieTitleAndChoice() {
        String title = askUserForTitle();
        Movie movie = inventory.findMovieByTitle(title);
        if (movie != null) {
            printMovie(movie);
            askRentalOrBuy(movie);
        } else {
            printError("Movie is not found");
        }
    }
}
