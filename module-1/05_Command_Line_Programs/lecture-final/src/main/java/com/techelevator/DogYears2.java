package com.techelevator;

import java.util.Scanner;

public class DogYears2 {

    // this version will use wrapper classes to convert strings to ints, doubles, etc...

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("HOw old are you human?!");

       String ageAsString = myScanner.nextLine();   //"7"
        System.out.println(ageAsString);

        int age = Integer.parseInt(ageAsString);

        System.out.println(age);
        //double age = Double.parseDouble(ageAsString);


        System.out.println(" You are " + age + " in human years, but in dog years you are " + age * 7);


        System.out.println(" What is your dog's name?");
        String name = myScanner.nextLine();

        System.out.println(name);

    }



}
