package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        int percentGrade = (int) (((double) getEarnedMarks()/getPossibleMarks()) * 100);
        if (percentGrade >= 90) {
            return "A";
        } else if (percentGrade >= 80) {
            return "B";
        } else if (percentGrade >= 70) {
            return "C";
        } else if (percentGrade >= 60) {
            return "D";
        } else return "F";
    }

}
