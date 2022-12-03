package pl.pacinho.adventofcode2022.challenge.day3.utils;

import java.util.List;

public class Duplicates {
    public static char find(char[] one, char[] two) {
        List<Character> characters = ArrayUtils.toList(two);
        return ArrayUtils.toList(one)
                .stream()
                .filter(ch -> findLetter(characters, ch))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Not found"));
    }

    public static char findFromLists(List<String> list) {
        List<Character> one = ArrayUtils.toList(list.get(0).toCharArray());
        List<List<Character>> two = List.of(
                ArrayUtils.toList(list.get(1).toCharArray()),
                ArrayUtils.toList(list.get(2).toCharArray())
        );

        return one.stream()
                .filter(ch -> filterLists(ch, two))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Not found"));
    }

    private static boolean filterLists(Character ch, List<List<Character>> two) {
        return two.stream()
                .allMatch(l -> findLetter(l, ch));
    }

    private static boolean findLetter(List<Character> l, Character ch) {
        return l.stream()
                .anyMatch(c -> c==ch);
    }
}