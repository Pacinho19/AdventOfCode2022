package pl.pacinho.adventofcode2022.challenge.day8;

import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.challenge.day8.tools.TheForest;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Day8Part2 implements CalculateI {

    @Override
    public long calculate(String filePath) {
        Integer[][] forest = TheForest.parseForest(
                FileUtils.readTxt(new File(filePath))
        );

        return IntStream.range(0, forest.length)
                .boxed()
                .map(i -> IntStream.range(0, forest[i].length)
                        .boxed()
                        .map(j -> calculatePoints(forest, i, j))
                        .toList()
                )
                .flatMap(List::stream)
                .max(Comparator.comparing(Long::longValue))
                .orElse(0L);
    }

    private long calculatePoints(Integer[][] forest, Integer i, Integer j) {
        if (i == 3 && j == 2) {
            int x = 0;
        }

        return TheForest.getLinearNeighbor(forest, i, j)
                .stream()
                .map(l -> getCountOfVisibleTrees(l, forest[i][j]))
                .reduce(1L, (a, b) -> a * b);
    }

    private long getCountOfVisibleTrees(List<Integer> heights, Integer selfHeight) {
        long count = 0;
        for (Integer h : heights) {
            count++;
            if (h >= selfHeight) break;
        }
        return count;

//        if (heights.size() == 0) return 0;
//        long count = heights.stream()
//                .takeWhile(h -> h < selfHeight)
//                .count();
//        return count +
//               (count==heights.size() ? 0 : 1);


    }

    public static void main(String[] args) {
        System.out.println(
                new Day8Part2().calculate("challenges\\day8\\input.txt")
        );
    }
}