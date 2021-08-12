package com.techelevator;

public class MyScrachPad {
    public static void main(String[] args) {
        int[] scores=new int[18];

        scores[1]=90;
        scores[0]=80;
        scores[17]=99;

        int a = scores[1];
        System.out.println(a);
        System.out.println(scores[17]);

        scores[17]=100;
        System.out.println(scores[17]);

        String[] names = new String[50];

        names[9]="Sydney";
        names[0]="Katy";
        names[3]="Mark";
        names[4]="Rumeysa";
        names[5]="Halis";

        int namesArraySize= names.length;
        System.out.println(namesArraySize);
        System.out.println(names[names.length-1]);

        System.out.println(scores[scores.length-1]);

    }




}
