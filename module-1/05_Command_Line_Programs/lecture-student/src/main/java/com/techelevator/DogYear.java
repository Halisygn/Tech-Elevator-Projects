package com.techelevator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DogYear {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("How old are you human?!");
        int age = myScanner.nextInt();
        myScanner.nextLine();

        System.out.println("You are " + age);
        System.out.println("What is your dog's name");
        String name = myScanner.nextLine();
        System.out.println(name);
    }
}
