package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Map2Example {

    public static void main(String[] args) {


        Map<Integer, String> players = new HashMap<Integer, String>();
        players.put(1, "Taos");
        players.put(2, "Hurdle");
        players.put(20, "Richardson");
        players.put(23, "Jordan");
        players.put(32, "Every");


        Scanner scanner = new Scanner(System.in);

        System.out.println("Coach Steve's quick player lookup because he is senile!");
        System.out.println("*******************************************************\n");

        System.out.println("Please enter a jersey number for the player you want to look up:\n");
        String jerseyNumberAsString = scanner.nextLine();

        int jerseyNumber = Integer.parseInt(jerseyNumberAsString);

        if (players.containsKey(jerseyNumber)) {
            System.out.println("The player is: " + players.get(jerseyNumber));
        }
        else {
            System.out.println("Player Not Found! Add the player? Enter Yes or No");
            String answer = scanner.nextLine();
            if (answer.equals("Yes") || answer.equals("Y")) {
                System.out.println("Please enter jersey number: ");
                int number = scanner.nextInt();
                scanner.nextLine();

                System.out.println("PLease enter player name: ");
                String newName = scanner.nextLine();

                // add to player map
                players.put(number, newName);


                //print confirmation message
                System.out.println("You added jersey id: " + number + " whose name is: " + players.get(number));

                //print all team members
                Set<Integer> jerseyNumbers = players.keySet();  // returns a list of all my keys

                for (Integer key : jerseyNumbers) {
                    System.out.println(key + " " + players.get(key));
                }



            }
            else {
                System.out.println("Alrighty Then!");
            }




        }





    }

}
