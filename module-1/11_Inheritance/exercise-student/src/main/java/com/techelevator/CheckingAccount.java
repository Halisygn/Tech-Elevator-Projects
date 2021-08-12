package com.techelevator;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountHolderName, String accountName) {
        super(accountHolderName, accountName);
    }

    public CheckingAccount(String accountHolderName, String accountName, int balance) {
        super(accountHolderName, accountName, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int newAmountToWithdraw=0;
        if (getBalance() < 0 && getBalance() - amountToWithdraw > -100) {
            newAmountToWithdraw=amountToWithdraw + 10;
        } else if (getBalance() < 0 && getBalance() - amountToWithdraw < -100) {
            newAmountToWithdraw=0;
        } else {
            newAmountToWithdraw=amountToWithdraw;
        }
        return super.withdraw(newAmountToWithdraw);
    }
}
// This part is BigDecimal solution.
/*
package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountHolderName, String accountName) {
        super(accountHolderName, accountName);
    }

    public CheckingAccount(String accountHolderName, String accountName, BigDecimal balance) {
        super(accountHolderName, accountName, balance);
    }

    @Override
    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        BigDecimal newAmountToWithdraw;
        if (getBalance().compareTo(new BigDecimal("0"))==-1&&
                getBalance().subtract(amountToWithdraw).compareTo(new BigDecimal("-100")) ==1) {
            newAmountToWithdraw=amountToWithdraw.add(new BigDecimal("10"));
        } else if (getBalance().subtract(amountToWithdraw).compareTo(new BigDecimal("-100"))==-1) {
            newAmountToWithdraw=new BigDecimal("0");
        } else {
            newAmountToWithdraw=amountToWithdraw;
        }
        return super.withdraw(newAmountToWithdraw);
    }
}
 */

