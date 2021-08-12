package com.techelevator;

public class LoopExample {

    public static void main(String[] args) {



//        for (int i = 0; i <= 100; i++) {
//
//            if ( i % 2 == 1) {
//                System.out.println(i + " is an odd number");
//            }
//
//
//        }

//        for (int i = 0; i <= 100; i++) {
//
//            System.out.println(i);
//            if ( i  == 50) {
//                System.out.println("We found 50!");
//                break;
//            }
//
//
//        }

//
//        for (int i =100; i > 0; i = i-5) {
//
//            if ( i % 3 == 0) {
//                System.out.println(i + " is evenly divisible by 3");
//            }
//
//
//        }


//
//       for (int i = 0; i <= 25; i++) {
//           System.out.println(i);
//       }
//








        String[] names = new String[10];

        names[9] = "Sydney";
        names[0] = "Katy";
        names[3] = "Mark";
        names[4] = "Rumeysa";


//        for (int j = 0; j < names.length; j++ ) {
//            if (names[j] != null) {
//                System.out.println(names[j]);
//            }
//
//        }
        for (int j = 0; j < names.length; j++ ) {
            if (names[j] != null && names[j].equals("Katy")) {
                System.out.println(names[j]);
            }

        }

        double[] averages = new double[3];

//        for (int i = 0; i < averages.length; i ++ ) {
//            averages[i] = -1;
//        }


        averages[0] = 23.00;
        averages[1] = 100.0;
        averages[2] = 65.0;

        for (int i = 0; i < averages.length; i++) {

            if (averages[i] == 100) {
                System.out.println(averages[i]);
            }

        }





    }
}
