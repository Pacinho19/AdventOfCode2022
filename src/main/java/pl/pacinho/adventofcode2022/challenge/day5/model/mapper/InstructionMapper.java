package pl.pacinho.adventofcode2022.challenge.day5.model.mapper;

import pl.pacinho.adventofcode2022.challenge.day5.model.InstructionDto;

public class InstructionMapper {
    public static InstructionDto parse(String s) {
        String[] parts = s.split(" ");
        return new InstructionDto(
                Integer.parseInt(parts[3]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[5])
        );
    }
}
