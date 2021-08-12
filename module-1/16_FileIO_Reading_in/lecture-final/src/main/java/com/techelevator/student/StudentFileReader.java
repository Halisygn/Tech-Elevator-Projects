package com.techelevator.student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentFileReader {

    //private String fileName;   -- not needed since we are converting to a File anyways
    private Scanner scanner;
    private File studentFile;

    public StudentFileReader(String fileName) {
        //this.fileName = fileName    -- not needed
        studentFile = new File(fileName);    // new File("dummy.txt")
    }

    public List<Student>  loadStudents() throws FileNotFoundException, StacysException{

        List<Student> students = new ArrayList<>();

        //read students from file


            scanner = new Scanner(studentFile);

            while (scanner.hasNextLine()) {

                String record = scanner.nextLine();
                String[] fields = record.split(",");

                // public Student(String firstName, String lastName, int age)
                Student student = new Student(fields[0], fields[1], Integer.parseInt(fields[2]));
                students.add(student);

                if (fields[0].equalsIgnoreCase("Homer")) {
                    throw new StacysException("Doh!");
                }

            }


        return students;

    }



}
