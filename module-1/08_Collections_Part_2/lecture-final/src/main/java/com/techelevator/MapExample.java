package com.techelevator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class MapExample {

    public static void main(String[] args) {

        Map<String, String> stateCodes = new HashMap<String, String>();
        Map<Integer, String> students = new HashMap<Integer, String>();


        stateCodes.put("OH", "Ohio");
        stateCodes.put("PA", "Pennsylvania");
        stateCodes.put("CA", "California");

        System.out.println(stateCodes.get("PA"));

        String m = "michigan";
        stateCodes.put("MI", m);


        //students
        students.put(100, "Amy");
        students.put(200, "Anthony");
        students.put(300, "John");
        students.put(400, "John");

        System.out.println(students.get(100));


        if (students.get(9999) != null) {

            System.out.println(students.get(9999).toLowerCase());
        }
        else {
            students.put(9999, "MALIKA");
            System.out.println("9999 was not found! So let's add it!");
        }

        if (students.containsKey(9999)) {
            System.out.println(students.get(9999).toLowerCase());
        }
        else {
            System.out.println("9999 was not found!");
        }


         Set<Integer> studentKeys = students.keySet();

         for (Integer key : studentKeys) {
             System.out.println("The key was" + key + " for the value of " + students.get(key));

             if (students.get(key).equals("John")) {
                 students.put(key, "Yasin");
             }
         }



    }


}
