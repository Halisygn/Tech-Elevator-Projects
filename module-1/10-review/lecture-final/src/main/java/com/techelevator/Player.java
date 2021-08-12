package com.techelevator;

public class Player {

    //instance variables
    private String firstName;
    private String lastName;
    private int jerseyNumber;
    private double battingAverage;

    public Player (String firstName, String lastName, int jerseyNumber, double battingAverage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jerseyNumber = jerseyNumber;
        this.battingAverage = battingAverage;
    }

    //derived property (more like a derived method)
    public String getFullName() {
        return this.firstName + " "  + this.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public void setBattingAverage(double battingAverage) {
        this.battingAverage = battingAverage;
    }
}
