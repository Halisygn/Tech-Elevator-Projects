package com.techelevator;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class ScratchPad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Please enter the amount of the bill:");
//        String amountOfBill = scanner.nextLine();
//        Double amountOfBillDouble = Double.parseDouble(amountOfBill);
//
//        System.out.print("Please enter the amount tendered:");
//        String amountTendered = scanner.nextLine();
//        Double amountTenderedDouble = Double.parseDouble(amountTendered);
//
//        System.out.println("The change required is " + (amountTenderedDouble - amountOfBillDouble));
        System.out.print("Enter a series of Earth weights (space-separated): ");
        String inputWeightsStr = scanner.nextLine();
        String[] arrayOfWeightsStr = inputWeightsStr.split(" ");
        Integer[] arrayOfWeightsInt = new Integer[arrayOfWeightsStr.length];

        for (int i = 0; i < arrayOfWeightsStr.length; i++) {
            arrayOfWeightsInt[i] = Integer.parseInt(arrayOfWeightsStr[i]);
            System.out.println(arrayOfWeightsInt[i] + " lbs.on Earth, is " + (int) (arrayOfWeightsInt[i] * 0.378) + " lbs.on Mars.");
        }
    }
}
