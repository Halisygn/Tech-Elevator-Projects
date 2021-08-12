package com.techelevator.student;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

    private UI ui = new UI();

    public static void main(String[] args) {
        StudentApp app = new StudentApp();
        app.run();
    }

    private void run() {


        String fileName = ui.askUserForFileName();
        StudentFileReader reader = new StudentFileReader(fileName);
        List<Student> myStudentList = null;


        try {
            myStudentList = reader.loadStudents();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (StacysException ex) {
            ex.printStackTrace();
        }


        for (Student student: myStudentList) {
            System.out.println(student.toString());
        }


    }


}
