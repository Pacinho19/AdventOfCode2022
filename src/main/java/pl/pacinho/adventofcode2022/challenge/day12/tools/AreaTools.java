package pl.pacinho.adventofcode2022.challenge.day12.tools;

import pl.pacinho.adventofcode2022.challenge.day12.model.PositionDto;

import java.util.List;

public class AreaTools {

    public static final char END_SIGN = 'E';
    public static final char START_SIGN = 'S';

    public static PositionDto[][] parse(List<String> lines) {
        PositionDto[][] area = new PositionDto[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            String[] split = lines.get(i).split("");
            for (int j = 0; j < split.length; j++) {
                area[i][j] = new PositionDto(i, j, split[j].charAt(0));
            }
        }
        return area;
    }

    public static String findLocation(char endSign, PositionDto[][] area) {
        for (int rowIndex = 0; rowIndex < area.length; rowIndex++) {
            PositionDto[] row = area[rowIndex];
            for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                if (endSign==(row[columnIndex].sign())) {
                    return rowIndex+","+columnIndex;
                }
            }
        }
        return null;
    }
}
