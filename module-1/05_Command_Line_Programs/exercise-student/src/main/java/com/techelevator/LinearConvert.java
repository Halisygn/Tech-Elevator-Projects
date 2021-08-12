package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Please enter the length: ");
        String scanner = myScanner.nextLine();
        int measure = Integer.parseInt(scanner);
        System.out.print("Is the measurement in (m)eter, or (f)eet? ");
        String measureType = myScanner.nextLine();
        if (measureType.equalsIgnoreCase("m") || measureType.equalsIgnoreCase("Meter")) {
            System.out.println(measure + "m is " + (int) (measure * 3.2808399) + "f.");
        } else {
            System.out.println(measure + "f is " + (int) (measure * 0.3048) + "m.");
        }
    }

}
