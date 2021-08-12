package com.techelevator;

public class StringExamples {

    public static void main(String[] args) {

        String phrase = "The Biggie Dog chased the little cat!";


        // charAt
        char first = phrase.charAt(0);
        char last = phrase.charAt(phrase.length() - 1);

        String lowercase = phrase.toLowerCase();
        System.out.println(lowercase);

        String newPhrase = phrase.concat(" some other text");

        System.out.println(phrase + " some other text");

        if (phrase.contains("Dog")) {
            System.out.println("contains dog!");
        }
        else {
            System.out.println("not found!");
        }

        if (phrase.endsWith("cat!")) {
            System.out.println("ends with cat!");
        }

      int indexOfD = phrase.indexOf('D');
        System.out.println(indexOfD);

        int indexofCat = phrase.indexOf("cat!");
        System.out.println(indexofCat);

        String newPhrase2 = phrase.replace('a', 'b');

        System.out.println(phrase);

        System.out.println(newPhrase2.substring(4));


        System.out.println(newPhrase.substring(15, 21));






    }
}
