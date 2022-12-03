package pl.pacinho.adventofcode2022.challenge.day3.utils;

import java.util.List;
import java.util.stream.IntStream;

public class ArrayUtils {

    public static List<Character> toList(char[] array) {
        return IntStream
                .range(0, array.length)
                .mapToObj(i -> array[i])
                .toList();
    }
}