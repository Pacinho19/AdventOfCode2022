package pl.pacinho.adventofcode2022.challenge.day12;

import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.challenge.day12.tools.Area;
import pl.pacinho.adventofcode2022.challenge.day12.tools.AreaDijkstry;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;

public class Day12Part1Dijkstry implements CalculateI {

    @Override
    public long calculate(String filePath) {
        return new AreaDijkstry(FileUtils.readTxt(new File(filePath)))
                .checkPaths();
    }

    public static void main(String[] args) {
        System.out.println(
                new Day12Part1Dijkstry().calculate("challenges\\day12\\input.txt")
        );
    }
}