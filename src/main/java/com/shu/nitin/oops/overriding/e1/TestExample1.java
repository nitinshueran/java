package com.shu.nitin.overriding.e1;

public class TestExample1 {

    public static void main(String[] args) {
        Parent p = new Parent("Parent");
        p.printName();

        Parent p1 = new Base("Child");
        p1.printName();
    }

}
