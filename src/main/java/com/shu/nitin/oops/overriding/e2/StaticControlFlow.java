package com.shu.nitin.overriding.e2;

public class StaticControlFlow {

    private static int i = 10;

    static {
        System.out.println("First static block");
        method1();
    }

    public static void main(String[] args) {
        System.out.println("Main method");
        System.out.println("i: " + i);
        System.out.println("j: " + j);

    }

    private static void method1() {
        System.out.println("Inside method 1");
        System.out.println("i: " + i);
        System.out.println("j: " + j);
    }

    static {
        System.out.println("Second static block");
    }
    private static int j = 11;
}
