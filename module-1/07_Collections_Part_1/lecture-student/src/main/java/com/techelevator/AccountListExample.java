package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class AccountListExample {
    public static void main(String[] args) {
        List<Account> myAccounts=new ArrayList<Account>();
        Account savings=new Account();
        savings.setBalance(100);
        savings.setAccountNumber("ABC123");

        Account checkingAccount=new Account();
        checkingAccount.setBalance(50.00);
        checkingAccount.setAccountNumber("DEF456");

        myAccounts.add(savings);
        myAccounts.add(checkingAccount);

        for(Account acct:myAccounts){
            System.out.println(acct.getAccountNumber());
        }

    }
}
