package pl.pacinho.adventofcode2022.challenge.day4;

import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.challenge.day3.utils.Duplicates;
import pl.pacinho.adventofcode2022.challenge.day3.utils.PointsCalculator;
import pl.pacinho.adventofcode2022.challenge.day4.utils.InputUtils;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;
import java.util.List;

public class Day4Part1 implements CalculateI {
    @Override
    public long calculate(String filePath) {
        return FileUtils.readTxt(new File(filePath))
                .stream()
                .map(InputUtils::mapLine)
                .filter(InputUtils::filter)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(
                new Day4Part1().calculate("challenges\\day4\\input.txt")
        );
    }
}