package com.techelevator;

public class ArrayExample {




    public static void main(String[] args) {

        int score = 10;

        int[] scores = new int[18];

        scores[1] = 90;
        scores[0] = 80;
        scores[17] = 99;

        int a = scores[1];
        System.out.println(a); // print 90

        System.out.println(scores[17]);  // print 99


        scores[17] = 100;
        System.out.println(scores[17]);  // print 100





        String[] names = new String[50];

        names[9] = "Sydney";
        names[0] = "Katy";
        names[3] = "Mark";
        names[4] = "Rumeysa";

        String newStudent = "Bart";

        names[12] = newStudent;
        String nameAt300 = names[12];




        double[] averages = new double[200];
        long[] bigNumbers = new long[20];



        int namesArraySize = names.length;
        System.out.println(namesArraySize);

        System.out.println(names[names.length - 1]);   // names[49]

        System.out.println(scores[scores.length - 1]); // scores[17]


        int i = 5;
        i ++ ;        // i = i + 1

        i --;    // i = i -1;

        int n = 1;

        if (i > 0)  {

            System.out.println(i);
        }
        else {

        }

        System.out.println(n);


    }



}
