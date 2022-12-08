package pl.pacinho.adventofcode2022.challenge.day8;

import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.challenge.day8.tools.TheForest;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;
import java.util.List;
import java.util.stream.IntStream;

public class Day8Part1 implements CalculateI {
    @Override
    public long calculate(String filePath) {
        Integer[][] forest = TheForest.parseForest(
                FileUtils.readTxt(new File(filePath))
        );

        return IntStream.range(0, forest.length)
                .boxed()
                .map(i -> IntStream.range(0, forest[i].length)
                        .boxed()
                        .map(j -> checkTreeVisibility(forest, i, j))
                        .toList()
                )
                .flatMap(List::stream)
                .filter(Boolean::booleanValue)
                .count();
    }

    private boolean checkTreeVisibility(Integer[][] forest, Integer i, Integer j) {
        if (i == 0 || j == 0) return true; //first row, col
        if (i == forest.length - 1) return true; //last row
        if (j == forest[i].length - 1) return true; //last col

        return TheForest.getLinearNeighbor(forest, i, j)
                .stream()
                .anyMatch(ngh -> checkLine(ngh, forest[i][j]));
    }

    private boolean checkLine(List<Integer> ngh, Integer selfHeight) {
        return ngh.stream()
                .allMatch(nghHeight -> nghHeight < selfHeight);
    }


    public static void main(String[] args) {
        System.out.println(
                new Day8Part1().calculate("challenges\\day8\\input.txt")
        );
    }
}