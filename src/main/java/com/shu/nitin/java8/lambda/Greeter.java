package com.shu.nitin.java8.lambda;

import java.io.EOFException;
import java.util.Arrays;
import java.util.List;

public class Greeter {

    public static void main(String[] args) throws Exception {
        int i = 0;
        Greeting ooGreeting = new OOGreeting();
        ooGreeting.greet();

        Greeting inlineGreeting = new Greeting() {

            @Override
            public void greet() {
                System.out.println("Inline greeting");
            }
        };

        inlineGreeting.greet();

        Greeting lambdaGreeting = () -> System.out.println("Lambda Greeting");
        lambdaGreeting.greet();

        print(lambdaGreeting);

        print(() -> System.out.println("Inline lambda greeting"));

        List<String> names = Arrays.asList("Nitin", "Nikki");
        names.forEach(name -> {

        });
        throwException(name -> {
            System.out.println(name);
            throw new EOFException();
        });

    }

    private static void print(Greeting lambdaGreeting) {
        lambdaGreeting.greet();
    }

    private static void throwException(ThrowCheckedExceptionFromLambda tException) throws Exception {
        tException.throwCheckedException("Nitin");
    }

}
