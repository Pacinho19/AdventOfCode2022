package pl.pacinho.adventofcode2022.challenge.day1;

import java.util.Arrays;

public class CaloriesCalculator {
    public static long calculate(String s) {
        return Arrays.stream(s.split("\n"))
                .map(Long::parseLong)
                .reduce(0L,Long::sum);
    }
}