package pl.pacinho.adventofcode2022.challenge.day11.tools;

import java.util.function.BiFunction;

public class OperationDefinition {
    public static final BiFunction<Long, Long, Long> MULTIPLY = (value1, value2) -> value1 * value2;
    public static final BiFunction<Long, Long, Long> ADD = Long::sum;
}