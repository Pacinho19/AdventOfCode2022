package pl.pacinho.adventofcode2022.challenge.day9.model;

public record InstructionDto(Move move, int step) {

    public InstructionDto(String sign, int step) {
        this(Move.findBySign(sign), step);

    }
}
