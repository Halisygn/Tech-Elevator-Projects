package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyScratchPad {
    public static void main(String[] args) {
        Map<String ,String> stateCodes= new HashMap<String, String>();
        Map<Integer,String> students=new HashMap<Integer, String>();
        stateCodes.put("OH","Ohio");
        stateCodes.put("PA","Pennsylvania");
        stateCodes.put("CA","California");

        String michigan="Michigan";
        stateCodes.put("MI",michigan);
        System.out.println(stateCodes.get("PA"));

        students.put(100,"Amy");
        students.put(200, "Anthony");
        students.put(300,"John");

        Set<Integer> studentKeys=students.keySet();
        //System.out.println(students.get(999).toLowerCase()); it will be null pointer exception
    }
}
