package com.shu.nitin.java8;

public class Test {
    public static void main(String[] args) {
        Print p = (int a, int b) -> System.out.println(a + b);
        p.add(10, 20);
    }

    interface Print {
        void add(int a, int b);
    }
}
