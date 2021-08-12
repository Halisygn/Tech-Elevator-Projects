package com.techelevator;

class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int newAmountToWithdraw = 0;
        if (getBalance() < amountToWithdraw) {
            newAmountToWithdraw = 0;
        } else if (getBalance() - amountToWithdraw < 150) {
            newAmountToWithdraw = amountToWithdraw + 2;
        } else {
            newAmountToWithdraw = amountToWithdraw;
        }
        return super.withdraw(newAmountToWithdraw);
    }
}
// This part is BigDecimal solution.
/*
package com.techelevator;

import java.math.BigDecimal;

class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, BigDecimal balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        BigDecimal newAmountToWithdraw;
        if (getBalance().compareTo(amountToWithdraw)==-1) {
            newAmountToWithdraw = new BigDecimal("0");
        } else if (getBalance().subtract(amountToWithdraw).compareTo(new BigDecimal("150"))==-1) {
            newAmountToWithdraw = amountToWithdraw.add(new BigDecimal("2"));
        } else {
            newAmountToWithdraw = amountToWithdraw;
        }
        return super.withdraw(newAmountToWithdraw);
    }
}
*/
