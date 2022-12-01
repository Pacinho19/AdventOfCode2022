package pl.pacinho.adventofcode2022.challenge.day1;

import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;
import java.util.Arrays;

public class Day1Part1 implements CalculateI {
    @Override
    public long calculate(String filePath) {
        return Arrays.stream(FileUtils.readAsText(new File(filePath)).split("\\n\\n"))
                .map(CaloriesCalculator::calculate)
                .max(Long::compareTo)
                .orElseThrow(() -> new IllegalStateException("Max exception!"));
    }

    public static void main(String[] args) {
        System.out.println(
                new Day1Part1().calculate("challenges\\day1\\input.txt")
        );
    }
}