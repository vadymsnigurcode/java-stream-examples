package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("classical with collection");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3");
        Stream<String> streamFromCollection = collection.stream().filter(a->a.contains("a2"));

        streamFromCollection.forEach(System.out::println);

        System.out.println("Создание стрима из значений");
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
        //streamFromValues.forEach(x -> System.out.println(x));

        StringBuilder result = streamFromValues.collect(StringBuilder::new, (x, y) -> x.append(y),
                (a, b) -> a.append(",").append(b));
        System.out.println(result);

        System.out.println("3. Создание стрима из массива");
        String[] array = {"a1","a2","a3"};
        Stream<String> streamFromArrays = Arrays.stream(array);
        streamFromArrays.forEach(System.out::println);

        System.out.println("4. Создание стрима из файла (каждая строка в файле будет отдельным элементом в стриме)");
        Stream<String> streamFromFiles = Files.lines(Paths.get("file.txt"));
        streamFromFiles.forEach(System.out::println);

        System.out.println("5. Создание стрима из строки");
        IntStream streamFromString = "123".chars();
        streamFromString.forEach(System.out::println);

        System.out.println("6. С помощью Stream.builder");
        Stream stringBuilderStream = Stream.builder().add("a1").add("a2").add("a3").build();
        stringBuilderStream.forEach(System.out::println);

        System.out.println("7. Создание параллельного стрима");
        Stream<String> paralellStream = collection.parallelStream();
        paralellStream.forEach(System.out::println);


//        System.out.println("8. Создание бесконечных стрима с помощью Stream.iterate");
//        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 1);
//        streamFromIterate.forEach(System.out::println);

//        System.out.println("9. Создание бесконечных стрима с помощью Stream.generate");
//        Stream<String> streamFromGenerate = Stream.generate(() -> "a1");
//        streamFromGenerate.forEach(System.out::println);

    }
}
