package com.techelevator.account;

public class Account {

    private static final int DEFAULT_FEE = 50;
    //instance variables (aka member variables, aka class variables)
    private String accountNumber;
    private String accountType;
    private String CUSTOM_ERROR_MESSAGE = "ACCOUNT ERROR!";
    private AccountOwner accountOwner;
    private double balance;

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public AccountOwner getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(AccountOwner accountOwner) {
        this.accountOwner = accountOwner;
    }


    public double calculateMonthlyFees() {
        return this.balance / 2;
    }
}
