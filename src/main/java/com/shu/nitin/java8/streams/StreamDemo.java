package com.shu.nitin.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.shu.nitin.java8.lambda.e1.Person;

public class StreamDemo {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Nitin", "Shueran", 28), new Person("Akshia", "Shueran", 28),
                new Person("Nitesh", "Shueran", 25));
        System.out.println(people.stream().findFirst());
        System.out.println(people.stream().allMatch(person -> person.getfName().startsWith("N")));
        System.out.println(people.stream().anyMatch(person -> person.getfName().startsWith("N")));
        System.out.println(people.stream().count());
        people.stream().filter(person -> person.getfName().startsWith("N")).collect(Collectors.toList())
                .forEach(person -> System.out.print(person.getfName()+" "));
        System.out.println();
        people.stream().map(person -> person.getfName()).filter(name -> name.startsWith("N"))
                .collect(Collectors.toList()).forEach(str -> System.out.print(str+" "));
        System.out.println();
        long count = people.stream().filter(p -> p.getAge() > 25 && p.getAge() < 50).count();
        System.out.println(count);

    }

}
