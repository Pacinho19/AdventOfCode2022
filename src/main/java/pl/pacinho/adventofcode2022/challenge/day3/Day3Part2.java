package pl.pacinho.adventofcode2022.challenge.day3;

import org.apache.commons.collections4.ListUtils;
import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.challenge.day3.utils.Duplicates;
import pl.pacinho.adventofcode2022.challenge.day3.utils.PointsCalculator;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;

public class Day3Part2 implements CalculateI {
    @Override
    public long calculate(String filePath) {
        return ListUtils.partition(FileUtils.readTxt(new File(filePath)), 3)
                .stream()
                .map(Duplicates::findFromLists)
                .map(PointsCalculator::calculate)
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        System.out.println(
                new Day3Part2().calculate("challenges\\day3\\input.txt")
        );
    }
}