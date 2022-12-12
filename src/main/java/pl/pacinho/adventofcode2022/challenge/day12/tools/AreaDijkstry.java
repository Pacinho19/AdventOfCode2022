package pl.pacinho.adventofcode2022.challenge.day12.tools;

import org.apache.commons.lang3.tuple.ImmutablePair;
import pl.pacinho.adventofcode2022.challenge.day12.model.PositionDto;
import pl.pacinho.adventofcode2022.challenge.day3.utils.AlphabetUtils;

import java.util.*;
import java.util.stream.IntStream;

public class AreaDijkstry {

    private LinkedHashMap<String, Integer> dV;
    private LinkedHashMap<String, String> pV;
    private static final char END_SIGN = 'E';
    private static final char START_SIGN = 'S';
    private static String END_LOCATION;
    private static String START_LOCATION;

    private static final List<ImmutablePair> NEIGHBORS = List.of(
            new ImmutablePair<>(-1, 0),
            new ImmutablePair<>(0, -1),
            new ImmutablePair<>(0, 1),
            new ImmutablePair<>(1, 0)
    );

    private PositionDto[][] area;

    private List<String> completed;
    private final int ROW_COUNT;
    private final int COL_COUNT;

    public AreaDijkstry(List<String> lines) {
        this.area = parseArea(lines);
        this.ROW_COUNT = area.length;
        this.COL_COUNT = area[0].length;
    }

    private PositionDto[][] parseArea(List<String> lines) {
        PositionDto[][] area = new PositionDto[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            String[] split = lines.get(i).split("");
            for (int j = 0; j < split.length; j++) {
                if (split[j].charAt(0) == END_SIGN)
                    END_LOCATION = i + "," + j;
                else if (split[j].charAt(0) == START_SIGN) {
                    area[i][j] = new PositionDto(i, j, 'a'); //START POSITION
                    if (START_LOCATION == null)
                        START_LOCATION = i + "," + j;
                    continue;
                }
                area[i][j] = new PositionDto(i, j, split[j].charAt(0));
            }
        }
        return area;
    }

    public void checkPaths() {
        fill_dV();
        fill_pV();

        completed = new ArrayList<>();
        while (completed.size() < ROW_COUNT * COL_COUNT) {
            if (completed.size() > 0 && completed.size() % 100 == 0) {
                System.out.println(completed.size());
            }
            String key = Collections.min(
                    dV.entrySet()
                            .stream()
                            .filter(k -> !completed.contains(k.getKey()))
                            .toList()
                    , Map.Entry.comparingByValue()).getKey();
            checkPoint(key);
        }
    }

    private void checkPoint(String point) {
        List<String> nextWays = getNextWays(point);
        nextWays.forEach(newPoint -> {
            Integer cost = 1;
            Integer oldPointCost = dV.get(newPoint);

            if (dV.get(point) + cost < oldPointCost) {
                dV.put(newPoint, dV.get(point) + cost);
                pV.put(newPoint, point);
            }
        });
        completed.add(point);
    }

    private List<String> getNextWays(String point) {
        return getNeighbors(point)
                .stream()
                .map(p -> p.row() + "," + p.col())
                .toList();
    }

    private List<PositionDto> getNeighbors(String pos) {
        return NEIGHBORS.stream()
                .map(i -> checkNeighbor(pos, i))
                .filter(Objects::nonNull)
                .toList();
    }

    private PositionDto checkNeighbor(String currentPos, ImmutablePair<Integer, Integer> i) {
        String[] split = currentPos.split(",");
        int row = Integer.parseInt(split[0]) + i.getLeft();
        int col = Integer.parseInt(split[1]) + i.getRight();

        if (row < 0 || row >= area.length
            || col < 0 || col >= area[0].length) return null;

        PositionDto neigh = area[row][col];
        PositionDto currentPosition = area[Integer.parseInt(split[0])][Integer.parseInt(split[1])];

        char sign = neigh.sign() == END_SIGN ? 'z' : neigh.sign();
        return AlphabetUtils.alphabet.indexOf(sign) <= AlphabetUtils.alphabet.indexOf(currentPosition.sign()) + 1
                ? neigh : null;
    }

    private void fill_pV() {
        pV = new LinkedHashMap<>();
        IntStream.range(0, ROW_COUNT)
                .forEach(row -> IntStream.range(0, COL_COUNT)
                        .forEach(col -> pV.put(row + "," + col, "-")));
    }

    private void fill_dV() {
        dV = new LinkedHashMap<>();
        IntStream.range(0, ROW_COUNT)
                .forEach(row -> IntStream.range(0, COL_COUNT)
                        .forEach(col -> dV.put(row + "," + col, Integer.MAX_VALUE)));
        dV.put(START_LOCATION, 0);
    }

    public long getMinPath() {
        return dV.get(END_LOCATION);
    }

}
