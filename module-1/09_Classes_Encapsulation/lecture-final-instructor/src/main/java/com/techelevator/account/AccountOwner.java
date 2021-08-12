package com.techelevator.account;

public class AccountOwner {

    private String firstName;
    private String lastName;
    private int age;
    private boolean isProblemCustomer;

    public AccountOwner() {

    }

    public AccountOwner(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isProblemCustomer() {
        return isProblemCustomer;
    }

    public void setProblemCustomer(boolean problemCustomer) {
        isProblemCustomer = problemCustomer;
    }
}
