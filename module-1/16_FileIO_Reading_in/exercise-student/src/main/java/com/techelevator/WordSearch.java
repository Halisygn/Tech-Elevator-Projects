package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {
    private Scanner scanner;
    private String word;
    private String isSensitive;
    private File file;
    Scanner fileScanner;

    public static void main(String[] args) {
        WordSearch app = new WordSearch();
        app.run();
    }

    public void run() {
        boolean fileExist = false;
        while(!fileExist) {
            try {
                scanner = new Scanner(System.in);
                System.out.println("What is the fully qualified name of the file that should be searched?");
                file = new File(scanner.nextLine());
                fileScanner = new Scanner(file);

                System.out.println("What is the search word you are looking for?");
                word = scanner.nextLine();

                System.out.println("Should the search be case sensitive? (Y\\\\N)");
                isSensitive = scanner.nextLine();

                if (isSensitive.equalsIgnoreCase("Y")) {
                    caseSensitiveSearch_LineNumbers();
                } else if (isSensitive.equalsIgnoreCase("N")) {
                    caseInsensitiveSearch_LineNumbers();
                }
                fileExist = true;
            } catch (FileNotFoundException e) {
                System.out.println("File cannot find!");
            }
        }
    }

    public void caseSensitiveSearch_LineNumbers() {
        int lineNumber = 0;
        while (fileScanner.hasNextLine()) {
            String record = fileScanner.nextLine();
            lineNumber += 1;
            if (record.contains(word)) {
                System.out.println(lineNumber + ") " + record);
            }
        }
    }

    public void caseInsensitiveSearch_LineNumbers() {
        int lineNumber = 0;
        while (fileScanner.hasNextLine()) {
            String record = fileScanner.nextLine();
            lineNumber += 1;
            if (record.toLowerCase().contains(word.toLowerCase())) {
                System.out.println(lineNumber + ") " + record);
            }
        }
    }
}
