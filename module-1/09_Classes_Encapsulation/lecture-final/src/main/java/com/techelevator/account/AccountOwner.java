package com.techelevator.account;

public class AccountOwner {
    private String firstName;
    private String lastName;
    private int age;
    private boolean isProblem;

    public AccountOwner(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean isProblem() {
        return isProblem;
    }

    public void setProblem(boolean problem) {
        isProblem = problem;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
