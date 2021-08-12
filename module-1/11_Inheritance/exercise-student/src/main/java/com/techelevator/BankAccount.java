package com.techelevator;

public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private int balance;

    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int deposit(int amountToDeposit) {
        return this.balance += amountToDeposit;
    }

    public int withdraw(int amountToWithdraw) {
        return this.balance -= amountToWithdraw;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
}
// This part is BigDecimal solution.
/*
package com.techelevator;

import java.math.BigDecimal;

public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private BigDecimal balance;

    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, String accountNumber, BigDecimal balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public BigDecimal deposit(BigDecimal amountToDeposit) {
        return this.balance =balance.add(amountToDeposit);
    }

    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        return this.balance = balance.subtract(amountToWithdraw);
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}*/
