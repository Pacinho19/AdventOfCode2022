package pl.pacinho.adventofcode2022.challenge.day11;

import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.challenge.day11.model.MonkeyDto;
import pl.pacinho.adventofcode2022.challenge.day11.tools.MonkeyParser;
import pl.pacinho.adventofcode2022.challenge.day11.tools.Monkeys;
import pl.pacinho.adventofcode2022.challenge.day11.tools.OperationDefinition;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.stream.IntStream;

import static pl.pacinho.adventofcode2022.challenge.day11.tools.Monkeys.monkeys;

public class Day11Part1 implements CalculateI {

    private static final int ROUND_COUNT = 20;

    @Override
    public long calculate(String filePath) {
        FileUtils.readTxt(new File(filePath))
                .stream()
                .forEach(MonkeyParser::parse);

        IntStream.range(0, ROUND_COUNT)
                .boxed()
                .forEach(i -> Monkeys.monkeys.forEach(
                        MonkeyDto::go
                ));

        return Monkeys.monkeys.stream()
                .map(MonkeyDto::getCheckingCount)
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .reduce(1L, (a, b) -> a * b);
    }

    public static void main(String[] args) {
        System.out.println(
                new Day11Part1().calculate("challenges\\day11\\input.txt")
        );
    }
}