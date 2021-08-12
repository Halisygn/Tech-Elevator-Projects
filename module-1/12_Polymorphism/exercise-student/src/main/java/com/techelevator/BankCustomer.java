package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer implements Accountable {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();

    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }
    public Accountable[] getAccounts() {
        return accounts.toArray(new Accountable[accounts.size()]);
    }

    public boolean isVip() {
        if (getBalance() >= 25000) {
            return true;
        }
        return false;
    }

    @Override
    public int getBalance() {
        int balance = 0;
        for (Accountable account : accounts) {
            balance += account.getBalance();
        }
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
