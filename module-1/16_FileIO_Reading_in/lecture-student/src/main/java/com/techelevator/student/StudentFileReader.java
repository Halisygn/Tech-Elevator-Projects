package com.techelevator.student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentFileReader {
    private Scanner scanner;
    private File studentFile;

    public StudentFileReader(String fileName) {
        studentFile = new File(fileName);
    }

    public List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        try {
            scanner = new Scanner(studentFile);
            while (scanner.hasNext()) {
                String record = scanner.nextLine();
                String[] fields = record.split(",");
                Student student = new Student(fields[0], fields[1], Integer.parseInt(fields[2]));
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }
}
