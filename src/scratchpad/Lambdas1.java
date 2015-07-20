package scratchpad;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Animal {
    private final String name;
    private final boolean wild;

    public Animal(String name, boolean wild) {
        this.name = name;
        this.wild = wild;
    }

    public String getName() {
        return name;
    }

    public boolean isWild() {
        return wild;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}

/**
 * Created by sai on 20/07/2015.
 */
public class Lambdas1 {

    public static void main(String[] args) {
        System.out.println("Wild Animals (Filtered using Lambda): " + animals().stream().filter(animal -> animal.isWild()).collect(toList()));
        System.out.println("Wild Animals (Filtered using a predicate from a method): " + animals().stream().filter(wildAnimalsOnly()).collect(toList()));
        System.out.println("Wild Animals (Filtered using a method reference): " + animals().stream().filter(Lambdas1::wildAnimals).collect(toList()));

        // Create cow
        Supplier<Animal> cowSupplier = () -> new Animal("cow", false);

        // Create dog
        Supplier<Animal> dogSupplier = () -> new Animal("dog", false);

        // Create rabbit
        Supplier<Animal> rabbitSupplier = () -> new Animal("rabbit", false);

        List<Animal> animals = farmhouse(cowSupplier, dogSupplier, rabbitSupplier);
        System.out.println("Animals in the farmhouse: " + animals);

        // HAndy methods.
        List<Integer> list = IntStream.range(0, 10).boxed().collect(toList());
        System.out.println("List: " + list);
        list.removeIf(n -> n % 2 == 0);
        System.out.println("Original list: " + list);

        System.out.println(LongStream.generate(() -> System.currentTimeMillis()).limit(100).boxed().collect(toList()));
        List<String> l = new ArrayList<>(Arrays.asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));
        String o = l.stream().map(s -> Character.toString(s.charAt(0))).collect(Collectors.joining());
        System.out.println(o);

        l.replaceAll(String::toUpperCase);
        System.out.println(l);


    }

    private static List<Animal> farmhouse(final Supplier<Animal>... animalSuppliers) {
        return Arrays.stream(animalSuppliers).map(animalSupplier -> animalSupplier.get()).collect(toList());
    }

    private static List<Animal> animals() {
        return Arrays.asList(new Animal("cat", false), new Animal("dog", false), new Animal("lion", true), new Animal("hippo", true));
    }

    private static Predicate<Animal> wildAnimalsOnly() {
        return animal -> animal.isWild();
    }

    private static boolean wildAnimals(final Animal animal) {
        return animal.isWild();
    }

    private static Predicate<Integer> numbersGreaterThan(Integer n) {
        // Multiline Lambda with a return statement.
        return x -> {
            boolean flag = x > n;
            return flag;
        };
    }
}
