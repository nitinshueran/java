package com.shu.nit.overriding.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

import com.shu.nit.overriding.java8.lambda.excersise1.Person;

public class SpliteratorDemo {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Nitin", "Shueran", 28), new Person("Akshia", "Shueran", 28),
                new Person("Nitesh", "Shueran", 25));
        Spliterator<Person> peopleItr = people.spliterator();
        // peopleItr.tryAdvance(person -> System.out.println(person.getfName()));
        // peopleItr.forEachRemaining(person -> System.out.println(person.getfName()));
        Spliterator<Person> people1Itr = peopleItr.trySplit();
        peopleItr.forEachRemaining(person -> System.out.println(person.getfName()));
        people1Itr.forEachRemaining(person -> System.out.println(person.getfName()));

    }
}
