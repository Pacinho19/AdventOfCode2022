package pl.pacinho.adventofcode2022.challenge.day8.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class TheForest {

    public static List<List<Integer>> getLinearNeighbor(Integer[][] forest, Integer i, Integer j) {
        return List.of(
                getLine(forest, i, j+1, i, forest[i].length - 1),
                reverse(getLine(forest, i, 0, i, j-1)),
                reverse(getLine(forest, 0, j, i-1, j)),
                getLine(forest, i+1, j, forest.length-1, j)
        );
    }
    private static List<Integer> getLine(Integer[][] forest, Integer i, Integer j, int iMax, int jMax) {
        return IntStream.rangeClosed(i, iMax)
                .boxed()
                .map(i2 -> IntStream.rangeClosed(j, jMax)
                        .boxed()
                        .map(j2 -> forest[i2][j2])
                        .toList())
                .flatMap(List::stream)
                .toList();
    }

    public static Integer[][] parseForest(List<String> strings) {
        Integer[][] forest = new Integer[strings.size()][strings.get(0).length()];
        for (int i = 0; i < strings.size(); i++) {
            String[] split = strings.get(i).split("");
            for (int j = 0; j < split.length; j++) {
                forest[i][j] = Integer.parseInt(split[j]);
            }
        }
        return forest;
    }

    private static List<Integer> reverse(List<Integer> line) {
        ArrayList<Integer> newList = new ArrayList<>(line);
        Collections.reverse(newList);
        return newList;
    }
}
