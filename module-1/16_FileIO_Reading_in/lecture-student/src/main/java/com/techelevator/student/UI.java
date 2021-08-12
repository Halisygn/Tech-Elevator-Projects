package com.techelevator.student;

import java.util.Scanner;

public class UI {
    private Scanner scanner;
    public UI(){
        scanner=new Scanner(System.in);
    }
    public String askUserFileName(){
        System.out.println("Please enter a file nam for your student file: ");
        return scanner.nextLine();
    }
}
