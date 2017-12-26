package com.shu.nit.overriding.java8.defaultinterface;

public interface BaseIntf2 {

    default void print() {
        System.out.println("Base 2 method");
    }
}
