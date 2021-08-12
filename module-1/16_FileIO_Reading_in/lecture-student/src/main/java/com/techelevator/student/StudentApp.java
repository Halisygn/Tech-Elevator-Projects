package com.techelevator.student;

import java.util.List;

public class StudentApp {
    UI ui = new UI();

    public static void main(String[] args) {
        StudentApp app=new StudentApp();
        app.run();
    }

    private void run() {
        StudentFileReader reader=new StudentFileReader(ui.askUserFileName());
        List<Student> myStudentList=reader.loadStudents();
        for (Student student: myStudentList){
            System.out.println(student.toString());
        }



    }
}
