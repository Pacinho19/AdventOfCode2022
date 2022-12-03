package pl.pacinho.adventofcode2022.challenge.day3;

import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.challenge.day3.utils.Duplicates;
import pl.pacinho.adventofcode2022.challenge.day3.utils.PointsCalculator;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;

public class Day3Part1 implements CalculateI {
    @Override
    public long calculate(String filePath) {
        return FileUtils.readTxt(new File(filePath))
                .stream()
                .map(s -> Duplicates.find(s.substring(0, s.length()/2).toCharArray(), s.substring(s.length()/2).toCharArray()))
                .map(PointsCalculator::calculate)
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        System.out.println(
                new Day3Part1().calculate("challenges\\day3\\input.txt")
        );
    }
}