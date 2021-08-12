package com.techelevator;

import java.util.Scanner;

public class AreWeThereYet {


    public static void main(String[] args) {


        //create a new scanner
        Scanner scanner = new Scanner(System.in);

        boolean notThere = true;

        while (notThere) {

            System.out.println("Are we there yet? Enter (Y)es or (N)o\n");
            String answer = scanner.nextLine();


            if (answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("Y")) {
                System.out.println("Cowabunga!");
                notThere = false;
            } else {
                System.out.println("Eat my shorts!");
            }

        }

        System.out.println("We are there, exiting");


    }



}
