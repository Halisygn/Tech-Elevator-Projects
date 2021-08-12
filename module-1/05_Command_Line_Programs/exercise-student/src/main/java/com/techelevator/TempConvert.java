package com.techelevator;

import java.util.Scanner;

//	Please enter the temperature: 58
//	Is the temperature in (C)elsius, or (F)ahrenheit? F
//  58F is 14C.
public class TempConvert {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Please enter the temperature: ");
        String temperature = myScanner.nextLine();
        int temp = Integer.parseInt(temperature);
        System.out.print("Is the temperature in (C)elsius, or (F)ahrenheit?");
        String tempType = myScanner.nextLine();
        if (tempType.equalsIgnoreCase("F") || tempType.equalsIgnoreCase("Fahrenheit")) {
            System.out.println(temp + "F is " + (int) ((temp - 32) / 1.8) + "C.");
        } else {
            System.out.println(temp + "C is " + (int) ((temp * 1.8) + 32) + "F.");
        }
    }
}
