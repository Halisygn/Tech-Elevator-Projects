package com.techelevator;

public class Movie {
    private String title;
    private String genre;
    private String format;
    private boolean isPremium;
    private String shortDescription;

    public Movie(String title, String genre, String format,boolean isPremium) {
        this.title = title;
        this.genre = genre;
        this.format = format;
        this.isPremium=isPremium;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
