package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        String numString = scanner.nextLine();
        int num = Integer.parseInt(numString);
        int first = 0;
        int second = 1;
        int sum = 1;
        Integer[] arrayOfSums = new Integer[num];
        System.out.print(first);

        do {
            System.out.print(", " + sum);
            sum = first + second;
            first = second;
            second = sum;
        }
        while (sum <= num);
    }

}



