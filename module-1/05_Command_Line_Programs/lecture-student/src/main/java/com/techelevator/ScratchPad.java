package com.techelevator;

import java.util.Scanner;

public class ScratchPad {
    public static void main(String[] args) {
//        Scanner scanner=new Scanner((System.in));
//        boolean notThere=true;
//        while (notThere){
//            System.out.println("Are we there yet? Enter Y(es) or N(o)");
//            String answer=scanner.nextLine();
//            if(answer.equalsIgnoreCase("Yes")||answer.equalsIgnoreCase("Y")){
//                System.out.println("Cowabunga");
//                notThere=false;
//            }else{
//                System.out.println("Eat my shorts!");
//            }
//        }
        Integer[] arrayNumbers = new Integer[]{5, 859485, 5859};
        for (int i = 0; i < arrayNumbers.length; i++) {
            String binaryString = "";
            do {
                arrayNumbers[i] = arrayNumbers[i] / 2;
                String binaryValue = String.valueOf(arrayNumbers[i] % 2);
                binaryValue += binaryString;
                binaryString = binaryValue;
            }
            while (arrayNumbers[i] / 2 >= 1);


            System.out.println(arrayNumbers[i] + " in" + " binary is " + binaryString);
        }
    }
}
