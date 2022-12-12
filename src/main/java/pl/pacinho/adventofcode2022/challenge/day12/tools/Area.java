package pl.pacinho.adventofcode2022.challenge.day12.tools;

import lombok.Getter;
import org.apache.commons.lang3.tuple.ImmutablePair;
import pl.pacinho.adventofcode2022.challenge.day12.model.PositionDto;
import pl.pacinho.adventofcode2022.challenge.day3.utils.AlphabetUtils;

import java.util.*;


public class Area {

    private static final char START_POS = 'S';
    private static final char END_POS = 'E';

    private static final List<ImmutablePair> NEIGHBORS = List.of(
            new ImmutablePair<>(-1, 0),
            new ImmutablePair<>(0, -1),
            new ImmutablePair<>(0, 1),
            new ImmutablePair<>(1, 0)
    );

    private PositionDto[][] area;
    @Getter
    private List<List<PositionDto>> paths;

    public Area(List<String> lines) {
        this.area = parseArea(lines);
        this.paths = new ArrayList<>();
    }

    private PositionDto[][] parseArea(List<String> lines) {
        PositionDto[][] area = new PositionDto[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            String[] split = lines.get(i).split("");
            for (int j = 0; j < split.length; j++) {
                area[i][j] = new PositionDto(i, j, split[j].charAt(0));
            }
        }
        area[0][0] = new PositionDto(0, 0, 'a'); //START POSITION
        return area;
    }

    public void checkPaths() {
        check(Arrays.asList(area[0][0]));
    }

    private int getMinPathLength() {
        return paths.stream()
                .mapToInt(List::size)
                .min()
                .orElse(Integer.MAX_VALUE);
    }

    private void check(List<PositionDto> path) {
        if (getMinPathLength() <= path.size()) return;

        PositionDto lastPos = path.get(path.size() - 1);
        List<PositionDto> neighbors = getNeighbors(lastPos, path);

        boolean finished = neighbors.stream()
                .anyMatch(n -> n.sign() == 'E');

        if (finished) {
            System.out.println("Finish " + path.size());
            paths.add(new ArrayList<>(path));
            return;
        }

        neighbors.forEach(n -> {
            ArrayList<PositionDto> newList = new ArrayList<>(path);
            newList.add(n);
            check(newList);
        });

    }

    private List<PositionDto> getNeighbors(PositionDto pos, List<PositionDto> path) {
        return NEIGHBORS.stream()
                .map(i -> checkNeighbor(pos, i))
                .filter(Objects::nonNull)
                .filter(n -> !checkVisited(n, path))
                .toList();
    }

    private static boolean checkVisited(PositionDto positionDto, List<PositionDto> path) {
        return path.stream()
                .map(PositionDto::getPosAsString)
                .anyMatch(pS -> pS.equals(positionDto.getPosAsString()));
    }

    private PositionDto checkNeighbor(PositionDto pos, ImmutablePair<Integer, Integer> i) {
        int row = pos.row() + i.getLeft();
        int col = pos.col() + i.getRight();

        if (row < 0 || row >= area.length
            || col < 0 || col >= area[0].length) return null;

        PositionDto neigh = area[row][col];
        char sign = neigh.sign() == END_POS ? 'z' : neigh.sign();
        return AlphabetUtils.alphabet.indexOf(sign) <= AlphabetUtils.alphabet.indexOf(pos.sign()) + 1
                ? neigh : null;
    }

}
