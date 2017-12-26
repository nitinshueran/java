package com.shu.nit.spring.di.tightcoupling;

public class Payment {

    public void pay(SavingAccount savingAccount) {
        System.out.println("Payment done using account: " + savingAccount.getAccountNo());
    }
}
