package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class second {

    public static void main(String[] args) {
        // Step  2: Creating a list of Person objects
        List<Person> people = Arrays.asList(
                new Person("Alex",  70,  30),
                new Person("Bob",  80,  40),
                new Person("Charlie",  65,  25),
                new Person("Diana",  75,  35)
        );

        // Step  3: Performing operations on the list
        // Sorted by the second letter of the name in reverse order
        List<Person> sortedBySecondLetter = people.stream()
                .sorted(Comparator.comparing(p -> p.getName().charAt(1), Comparator.reverseOrder()))
                .collect(Collectors.toList());

        // Filtered by weight greater than  60
        List<Person> filteredByWeight = people.stream()
                .filter(p -> p.getWeight() >  60)
                .collect(Collectors.toList());

        // Sorted by age
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());

        // Calculating the product of all ages
        int productOfAges = people.stream()
                .mapToInt(Person::getAge)
                .reduce(1, (a, b) -> a * b);

        // Step  4: Outputting the results
        System.out.println("Sorted by second letter in reverse order:");
        sortedBySecondLetter.forEach(System.out::println);

        System.out.println("\nFiltered by weight >  60:");
        filteredByWeight.forEach(System.out::println);

        System.out.println("\nSorted by age:");
        sortedByAge.forEach(System.out::println);

        System.out.println("\nProduct of all ages: " + productOfAges);
    }


}
