package pl.pacinho.adventofcode2022.challenge.day11.tools;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class ItemsParser {
    public static ArrayDeque<Long> parse(String line) {
        return new ArrayDeque<>(
                getItemsAsList(line)
        );
    }

    private static List<Long> getItemsAsList(String line) {
        return Arrays.stream(line.replace("Starting items: ", "")
                        .split(","))
                .map(s -> Long.valueOf(s.trim()))
                .toList();
    }
}