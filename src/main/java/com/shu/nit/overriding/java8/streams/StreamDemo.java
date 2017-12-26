package com.shu.nit.overriding.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.shu.nit.overriding.java8.lambda.e1.Person;

public class StreamDemo {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Nitin", "Shueran", 28), new Person("Akshia", "Shueran", 28),
                new Person("Nitesh", "Shueran", 25));
        System.out.println(people.stream().findFirst());
        System.out.println(people.stream().allMatch(person -> person.getfName().startsWith("N")));
        System.out.println(people.stream().anyMatch(person -> person.getfName().startsWith("N")));
        System.out.println(people.stream().count());
        people.stream().filter(person -> person.getfName().startsWith("N")).collect(Collectors.toList())
                .forEach(person -> System.out.println(person.getfName()));
        people.stream().map(person -> person.getfName()).filter(name -> name.startsWith("N"))
                .collect(Collectors.toList()).forEach(str -> System.out.println(str));

    }

}
