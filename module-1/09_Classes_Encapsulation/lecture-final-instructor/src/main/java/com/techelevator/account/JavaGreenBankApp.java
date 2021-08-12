package com.techelevator.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaGreenBankApp {

    public static void main(String[] args) {


       Account savings = new Account();
       savings.setBalance(100.01);

       AccountOwner accountOwner = new AccountOwner("Kevin", "Teos", 21);
       accountOwner.setProblemCustomer(true);
       savings.setAccountOwner(accountOwner);

       savings.setAccountType("Gold Star Savings");
       savings.setAccountNumber("02888888");
       System.out.println("Savings account balance is: " + savings.getBalance());

       Account checking = new Account();
       checking.setBalance(500.00);
       checking.setAccountType("Buckeye Checking");
       checking.setAccountNumber("055555");

       System.out.println("Checking account balance is: " + checking.getBalance());

       List<Account> listOfAccounts = new ArrayList<Account>();
       listOfAccounts.add(savings);
       listOfAccounts.add(checking);

       for (Account acct : listOfAccounts) {
           System.out.println("Account: " + acct.getAccountNumber() + ", balance " + acct.getBalance());
       }

       Map<String, Account> mapOfAccounts = new HashMap<String, Account>();

       mapOfAccounts.put(savings.getAccountNumber(), savings);
       mapOfAccounts.put(checking.getAccountNumber(), checking);

       System.out.println(mapOfAccounts.size() + " is the size of our map");


       if (savings.getAccountOwner().isProblemCustomer()) {
           double fees = savings.calculateMonthlyFees();
           System.out.println("Kevin's Fees = " + fees);
       }

       Calculator calc = new Calculator();
        calc.add(2,3);



    }




}
