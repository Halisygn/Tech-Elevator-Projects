package com.techelevator;

public class MyScratchPad {

    public static void main(String[] args) {
        MyScratchPad scratchpad = new MyScratchPad();
        boolean isAdult = scratchpad.isAdult(14);
        if (isAdult) {
            System.out.println("I am an adult");
        } else {
            System.out.println("I am a child");
        }
        int result = scratchpad.addTwoNumbers(2, 2);
        System.out.println(result);
        result = scratchpad.addTwoNumbers(5, 7);
        System.out.println(result);

        int result2 = scratchpad.multiplyTwoNumbers(3, 5);
        System.out.println(result2);

        double double1 = 1.3;
        double double2 = 2.4;
        if (double1 == double2) {
            System.out.println("They are equal!");
        } else {
            System.out.println("They are not equal");
        }

        //Test string for equality
        String name = "Halis";
        String name1 = "John";
        if (name.equals(name1)) {
            System.out.println(name + " is equal to " + name1);
        } else {
            System.out.println("Strings are not equal.");
        }
    }

    /*
    add two values
     */
    private int addTwoNumbers(int x, int y) {
        return x + y;
    }

    // multiply two values
    private int multiplyTwoNumbers(int x, int y) {
        return x * y;
    }

    private boolean isAdult(int age) {
        if (age >= 18) {
            return true;
        }
        return false;
    }


}
