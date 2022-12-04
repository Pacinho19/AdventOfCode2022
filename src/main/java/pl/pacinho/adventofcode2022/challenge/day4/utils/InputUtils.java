package pl.pacinho.adventofcode2022.challenge.day4.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class InputUtils {
    public static List<List<Integer>> mapLine(String line) {
        return Arrays.stream(line.split(","))
                .map(InputUtils::range)
                .toList();
    }

    private static List<Integer> range(String s) {
        List<Integer> ranges = Arrays.stream(s.split("-"))
                .map(Integer::valueOf)
                .toList();
        return IntStream.rangeClosed(ranges.get(0), ranges.get(1))
                .boxed()
                .toList();
    }

    public static boolean filter(List<List<Integer>> lists) {
        lists = lists.stream()
                .sorted(Comparator.comparing(List::size))
                .toList();
        return checkContainsAll(lists.get(0), lists.get(1));
    }

    private static boolean checkContainsAll(List<Integer> small, List<Integer> big) {
        return big.containsAll(small);
    }

    public static boolean checkOverlaps(List<List<Integer>> lists) {
        return checkContainsAny(lists.get(0), lists.get(1));
    }

    private static boolean checkContainsAny(List<Integer> list1, List<Integer> list2) {
        return list1.stream()
                .anyMatch(list2::contains);
    }
}