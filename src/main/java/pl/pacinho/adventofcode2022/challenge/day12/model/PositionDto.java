package pl.pacinho.adventofcode2022.challenge.day12.model;

public record PositionDto(int row, int col, char sign) {

    public String getPosAsString() {
        return row + ";" + col;
    }
}
