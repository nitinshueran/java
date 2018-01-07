package com.shu.nitin.java8.lambda.e1;

import java.util.Arrays;
import java.util.List;

public class Unit1Excersise {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Nitin", "Shueran", 28), new Person("Akshia", "Shueran", 28),
                new Person("Nitesh", "Shueran", 25));

        // Sort list by Lname
        for (Person p : people) {
            p.setfName("Updated name");
            System.out.println(p.getfName());
        }
        people.forEach(person -> {
            person.setfName("Updated name");
            System.out.println(person.getfName());
        });
    }

}
