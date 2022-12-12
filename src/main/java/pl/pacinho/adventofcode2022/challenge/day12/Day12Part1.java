package pl.pacinho.adventofcode2022.challenge.day12;

import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.challenge.day12.tools.Area;
import pl.pacinho.adventofcode2022.challenge.day12.tools.AreaDijkstry;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;
import java.util.List;

public class Day12Part1 implements CalculateI {


    @Override
    public long calculate(String filePath) {
        Area area = new Area(FileUtils.readTxt(new File(filePath)));
        area.checkPaths();

        return area.getPaths()
                .stream()
                .mapToInt(List::size)
                .min()
                .orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(
                new Day12Part1().calculate("challenges\\day12\\input.txt")
        );
    }
}