package com.techelevator;

import java.util.Scanner;

public class DogYears {


    // this version will read in ints (and remind you to enter nextLine to EAT the newline character

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("HOw old are you human?!");

        int age = myScanner.nextInt();   // if you use nextInt or nextLong, don't forget to remove the newline character
        myScanner.nextLine();  // This is the KEY


        System.out.println(" You are " + age + " in human years, but in dog years you are " + age * 7);


         System.out.println(" What is your dog's name?");
         String name = myScanner.nextLine();

         System.out.println(name);

    }
}
