package pl.pacinho.adventofcode2022.challenge.day12;

import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.challenge.day12.model.PositionDto;
import pl.pacinho.adventofcode2022.challenge.day12.tools.AreaDijkstry;
import pl.pacinho.adventofcode2022.challenge.day12.tools.AreaTools;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Day12Part2 implements CalculateI {

    @Override
    public long calculate(String filePath) {
        PositionDto[][] areaArr = AreaTools.parse(FileUtils.readTxt(new File(filePath)));
        AreaDijkstry area = new AreaDijkstry(areaArr);

        return IntStream.range(0, areaArr.length)
                .boxed()
                .map(row ->
                        IntStream.range(0, areaArr[row].length)
                                .boxed()
                                .filter(col -> areaArr[row][col].sign() == 'a')
                                .map(col -> area.checkPaths(row + "," + col))
                                .toList())
                .flatMap(List::stream)
                .min(Long::compareTo)
                .orElse(0L);
    }

    public static void main(String[] args) {
        System.out.println(
                new Day12Part2().calculate("challenges\\day12\\input.txt")
        );
    }
}
