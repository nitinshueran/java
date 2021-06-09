package com.shu.nitin.overriding.e1;

public class Base extends Parent {

    private String childName;

    public Base() {
    }

    public Base(String childName) {
        this.childName = childName;
    }

    public void printName() {
        System.out.println("My name is :" + this.childName);
    }
}
