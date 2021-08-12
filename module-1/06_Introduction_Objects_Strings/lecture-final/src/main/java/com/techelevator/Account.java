package com.techelevator;

public class Account {

    //state (variables)
    private String accountNumber;
    private String accountOwner;
    private double balance;

    //behaviors (methods)
    public double withdraw (double amountToWithDraw) {
        return (this.balance - amountToWithDraw);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double initialBalance) {
        this.balance = initialBalance;
    }

}
