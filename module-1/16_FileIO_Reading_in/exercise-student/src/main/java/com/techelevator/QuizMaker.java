package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class QuizMaker {
    Scanner scanner = new Scanner(System.in);
    Map<String, Integer> questions = new HashMap<>();//Question and correct answer
    int correctAnswers; //number of correct answers
    Map<String, List<String>> choices = new HashMap<>(); //Question and choices
    private Scanner fileScanner;

    public static void main(String[] args) {
        QuizMaker app = new QuizMaker();
        app.run();
    }

    public void run() {
        try {
            readFile();
            askQuestion();
            System.out.println("You got " + correctAnswers + " answer(s) correct out of the " + questions.size() + " questions asked.\n");
        } catch (FileNotFoundException e) {
            System.out.println("File cannot found!");
        }
    }

    public void readFile() throws FileNotFoundException {
        System.out.println("What is the fully qualified name of the file that should be searched?");
        File file = new File(scanner.nextLine());
        fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            int answer = 0;
            List<String> questionChoices = new ArrayList<>();
            String eachLine = fileScanner.nextLine();
            String[] questionAndAnswers = eachLine.split("\\|");
            for (int i = 1; i < questionAndAnswers.length; i++) {
                if (questionAndAnswers[i].endsWith("*")) {
                    questionChoices.add(questionAndAnswers[i].substring(0, questionAndAnswers[i].length() - 1));
                    answer = i;
                } else {
                    questionChoices.add(questionAndAnswers[i]);
                }
                questions.put(questionAndAnswers[0], answer);
            }
            choices.put(questionAndAnswers[0], questionChoices);
        }
    }

    public void askQuestion() {
        Set<String> keys = questions.keySet();
        for (String key : keys) {
            System.out.println(key);
            System.out.println("1. " + choices.get(key).get(0));
            System.out.println("2. " + choices.get(key).get(1));
            System.out.println("3. " + choices.get(key).get(2));
            System.out.println("4. " + choices.get(key).get(3));

            System.out.print("Your answer: ");
            if (scanner.nextLine().equals(String.valueOf(questions.get(key)))) {
                correctAnswers += 1;
                System.out.println("RIGHT!");
            } else {
                System.out.println("WRONG!");
            }
        }
    }
}

