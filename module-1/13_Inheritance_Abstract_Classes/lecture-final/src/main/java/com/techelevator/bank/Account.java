package com.techelevator.bank;

public abstract class Account {

    private String accountNumber;
    double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public  double calculateFees() {
        return this.balance * 0.50;
    }

    public abstract double calculateInterest();

}
