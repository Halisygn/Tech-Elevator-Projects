package com.techelevator.account;

import java.util.*;

public class JavaGreenBankApp {
    public static void main(String[] args) {
        Account savings = new Account();

        savings.setBalance(100.01);
        savings.setAccountType("Kevin Checking");
        savings.setAccountNumber("06755");
        AccountOwner accountOwner=new AccountOwner("Halis","Yigin",21);
        System.out.println("Saving account balance is " + savings.getBalance());
        savings.setAccountOwner(accountOwner);

        Account checking = new Account();
        checking.setBalance(500.00);
        checking.setAccountType("Buckeye Checking");
        checking.setAccountNumber("05555");
        System.out.println("Checking account balance is " + checking.getBalance());

        List<Account> listOfAccounts=new ArrayList<>();
        listOfAccounts.add(savings);
        listOfAccounts.add(checking);

        for(Account acct:listOfAccounts){
            System.out.println("Account "+acct.getAccountNumber()+", balance "+acct.getBalance());
        }

        Map<String,Account> mapOfAccounts=new HashMap<>();

        AccountOwner accountOwner1=new AccountOwner("Yasin", "Kusan",37);
        System.out.println("Account owner full name is "+accountOwner1.fullName());
        if(accountOwner.isProblem()){
            double fees=savings.calculateMonthlyFees();
            System.out.println("Is Halis problem "+fees);
        }

    }
}
