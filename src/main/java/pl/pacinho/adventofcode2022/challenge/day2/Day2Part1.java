package pl.pacinho.adventofcode2022.challenge.day2;

import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.challenge.day2.model.mapper.GameMapper;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;

public class Day2Part1 implements CalculateI {
    @Override
    public long calculate(String filePath) {
        return FileUtils.readTxt(new File(filePath))
                .stream()
                .map(s -> GameMapper.parse(s).calculatePoints())
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        System.out.println(
                new Day2Part1().calculate("challenges\\day2\\input.txt")
        );
    }
}
