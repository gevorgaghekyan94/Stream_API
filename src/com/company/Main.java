package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {

//        1 - Convert elements of a  collection to upper case.
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "My", "Name", "Is", "John", "Doe");
        List<String> listInUpperCase = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(listInUpperCase);

//        2 - Filter collection so that only elements with less than 4 characters are returned.
        List<String> newList = list.stream()
                .filter((each) -> each.length() <= 3)
                .collect(Collectors.toList());
        System.out.println(newList);

//        3 - Flatten multidimensional collection
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = collection.stream()
                .flatMap(each -> each.stream())
                .collect(Collectors.toList());
        System.out.println(expected);

//        4 -Get oldest person from the collection
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("Anna", 5, "Serbian");
        Person person2 = new Person("Sara", 25, "British");
        Person person3 = new Person("Viktor", 58, "Russian");
        Person person4 = new Person("Eva", 14, "Serbian");
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        System.out.println("Oldest person: " + personList.stream()
                .max((p1, p2) -> p1.getAge() - p2.getAge())
                .get());

//        5 - Sum all elements of a numeric collection
        List<Integer> numbers = asList(2, 3, 4, 5, 6);
        int sumOf = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of elements: " + sumOf);

//        6 - Get names of all kids (under age of 18)
        List<Person> kidsList = personList.stream()
                .filter(each -> each.getAge() < 18)
                .collect(Collectors.toList());
        System.out.println(kidsList);

//        7 Partition adults and kids
        Map<Boolean, List<Person>> partitionedList = personList.stream()
                .collect(Collectors.partitioningBy(each -> each.getAge() > 18));
        System.out.println(partitionedList.get(true));
        System.out.println(partitionedList.get(false));

//        8 - Group people by nationality
        Map<String, List<Person>> groupedList = personList.stream()
                .collect(Collectors.groupingBy(each -> each.getNationality()));
        System.out.println("Serbian: " + groupedList.get("Serbian"));
        System.out.println("British: " + groupedList.get("British"));
        System.out.println("Russian: " + groupedList.get("Russian"));

//        9 - Return people names separated by comma
        String collect = personList.stream()
                .map(each -> each.getName())
                .collect(Collectors.joining(","));
        System.out.println(collect);

    }
}
