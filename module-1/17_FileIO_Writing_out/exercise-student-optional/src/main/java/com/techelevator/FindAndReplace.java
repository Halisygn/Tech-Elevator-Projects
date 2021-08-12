package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Scanner fileScanner;
        String message = null;

        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine().trim();
        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();
        System.out.println("What is the source file?");
        String path = userInput.nextLine();
        File f = new File(path);

        if (!f.exists()) {
            System.out.println(f.getAbsolutePath() + " does not exist.");
            System.exit(1);
        }

        System.out.println("What is the destination file?");
        String newFilePath = userInput.nextLine();
        File newFile = new File(newFilePath);
        if (!newFile.exists()) {
            System.out.println("Could not create directory.");
            System.exit(1);
        }
        try {
            PrintWriter writer = new PrintWriter(newFile);
            fileScanner = new Scanner(f);
            while (fileScanner.hasNextLine()) {
                String record = fileScanner.nextLine();
                message = record.replaceAll(searchWord, replacementWord);
                writer.println(message);
                writer.flush();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
