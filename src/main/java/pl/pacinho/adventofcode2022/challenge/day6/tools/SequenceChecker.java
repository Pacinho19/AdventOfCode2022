package pl.pacinho.adventofcode2022.challenge.day6.tools;

import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class SequenceChecker {
    public static boolean check(Integer i, List<String> input, int charCount) {
        return new HashSet<>(getListCharacters(i, input, charCount))
                       .size() == charCount;
    }

    private static List<String> getListCharacters(Integer i, List<String> input, int charCount) {
        return IntStream.range(i, i+charCount)
                .boxed()
                .map(input::get)
                .toList();
    }
}
