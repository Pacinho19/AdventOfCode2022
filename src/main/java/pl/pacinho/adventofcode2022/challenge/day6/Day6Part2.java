package pl.pacinho.adventofcode2022.challenge.day6;

import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.challenge.day6.tools.SequenceChecker;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Day6Part2 implements CalculateI {

    private static final int CHAR_COUNT = 14;

    @Override
    public long calculate(String filePath) {
        List<String> input = Arrays.stream(FileUtils.readAsText(new File(filePath))
                        .split(""))
                .toList();

        return IntStream.rangeClosed(0, input.size() - CHAR_COUNT)
                       .boxed()
                       .filter(i -> SequenceChecker.check(i, input, CHAR_COUNT))
                       .findFirst()
                       .orElse(0)
               + CHAR_COUNT;
    }

    public static void main(String[] args) {
        System.out.println(
                new Day6Part2().calculate("challenges\\day6\\input.txt")
        );
    }
}
