package com.techelevator.bank;

public class JavaGreenBank {

    public static void main(String[] args) {

        JavaGreenBank bank = new JavaGreenBank();
        bank.run();


    }


    private void run()  {

        CreditCard credit = new CreditCard();
        credit.setAccountNumber("123");
        credit.setBalance(100.00);

        double fee = credit.calculateFees();;
        System.out.println(fee);

        CheckingAccount checking = new CheckingAccount();
        checking.setAccountNumber("12345");
        checking.setBalance(200.00);
        double fees = checking.calculateFees();
        System.out.println(fees);

    }

}
