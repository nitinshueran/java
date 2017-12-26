package com.shu.nit.spring.di.tightcoupling;

public class SavingAccount {

    private double accountNo;

    public SavingAccount(double accountNo) {
        super();
        this.accountNo = accountNo;
    }

    public double getAccountNo() {
        return accountNo;
    }

}
