package com.shu.nitin.overriding.e1;

public class Parent {

    private String parentName;

    public Parent() {
    }

    public Parent(String parentName) {
        this.parentName = parentName;
    }

    public void printName() {
        System.out.println("My name is :" + this.parentName);
    }

}
