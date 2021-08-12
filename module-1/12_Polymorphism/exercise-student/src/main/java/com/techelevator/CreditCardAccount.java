package com.techelevator;

public class CreditCardAccount implements Accountable {
    private int debt;
    private String accountHolder;
    private String accountNumber;

    public CreditCardAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }
    public int pay(int amountToPay){
        return debt-=amountToPay;
    }
    public int charge(int amountToCharge){
        return debt+=amountToCharge;
    }

    public int getDebt() {
        return debt;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public int getBalance() {
        return -debt;
    }
}
