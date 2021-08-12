package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter in a series of decimal values (separated by spaces): ");
        String enteredDecimalsString = scanner.nextLine();

        String[] arrayOfDecimalsStr = enteredDecimalsString.split(" ");

        for (int i = 0; i < arrayOfDecimalsStr.length; i++) {
            String binaryString = "";
            int enteredDecimalsInt = Integer.parseInt(arrayOfDecimalsStr[i]);

            while (enteredDecimalsInt >= 1) {
                String reminderOfNumStr = String.valueOf(enteredDecimalsInt % 2);
                enteredDecimalsInt = enteredDecimalsInt / 2;
                reminderOfNumStr += binaryString;
                binaryString = reminderOfNumStr;
            }
            System.out.println(arrayOfDecimalsStr[i] + " in" + " binary is " + binaryString);
        }
    }
}


