package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class AccountListExample {


    public static void main(String[] args) {

        List<Account> myAccounts = new ArrayList<Account>();

        //create two account objects to put in the list above
        Account savings = new Account();
        savings.setBalance(100);
        savings.setAccountNumber("ABC123");

        Account checkingAccount = new Account();
        checkingAccount.setBalance(50.00);
        checkingAccount.setAccountNumber("DEF456");

        myAccounts.add(savings);
        myAccounts.add(checkingAccount);

        for (Account acct : myAccounts) {
            System.out.println(acct.getAccountNumber());
        }


        // Numbers

        List<Integer> numbers = new ArrayList<Integer>();

        numbers.add(10);
        numbers.add(50);
        numbers.add(100);
        numbers.add(150);

        //regular for loop
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        //enhanced for loop
        for (Integer num : numbers) {
            System.out.println(num);
        }









    }


}
