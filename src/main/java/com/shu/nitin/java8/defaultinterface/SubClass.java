package com.shu.nitin.java8.defaultinterface;

public class SubClass implements BaseIntf1, BaseIntf2 {

    @Override
    public void print() {
        BaseIntf1.super.print();
    }

}
