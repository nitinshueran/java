package com.shu.nitin.java8.lambda;

public class Greeter {

    public static void main(String[] args) {
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
    }

    private static void print(Greeting lambdaGreeting) {
        lambdaGreeting.greet();
    }

}
