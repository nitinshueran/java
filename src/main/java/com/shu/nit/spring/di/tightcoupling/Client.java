package com.shu.nit.spring.di.tightcoupling;

public class Client {

    public static void main(String[] args) {
        Payment payment = new Payment();
        SavingAccount savingAccount = new SavingAccount(1547015068);
        payment.pay(savingAccount);
    }

}
