package com.techelevator;

public class ScratchPad {

    public static void main(String[] args) {

        ScratchPad scratch = new ScratchPad();

        boolean adult = scratch.isAdult(4);


        if (adult) {
            System.out.println("I am an adult");
        } else {
            System.out.println("I am a child");
        }

        int result = scratch.addTwoNumbers(2, 2);
        System.out.println(result);
        result = scratch.addTwoNumbers(4, 6);
        System.out.println(result);
        result = scratch.addTwoNumbers(4, 2);
        System.out.println(result);



        int result2 = scratch.multiplyTwoNumbers(3, 5);
        System.out.println(result2);

        double double1 = 3.3;
        double double2 = 3.4;

        if (double1 == double2) {
            System.out.println("They are equal");
        } else {
            System.out.println("They are not equal");
        }

        //example test string for equality
        String name = "Steve";
        String name2 = "John";

        if (name.equals(name2)) {
            System.out.println(name + " is equal to " + name2);

        }

        long num1 = 1234;
        long num2 = 4567;

        //test that num1 is in range of 1000 - 4000
        if (num1 >= 1000 && num1 <= 4000) {
            //number is in range
        }
        else {
            //number is not in range
        }

//        boolean done = false;
//
//        while (!done) {
//            //do something
//        }


    }

    /*
       Add two integers together
     */
    private int addTwoNumbers(int x, int y) {
        return x + y;
    }

    private int multiplyTwoNumbers(int x, int y) {
        return x * y;
    }

    private boolean isAdult(int age) {

        if (age >=18 && age != 21) {
            return true;
        }

        return false;
    }


}
