package pl.pacinho.adventofcode2022.challenge.day10.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pacinho.adventofcode2022.challenge.day10.model.enums.Command;

@Getter
@AllArgsConstructor
public class InstructionDto {

    private Command command;
    private int value;

    public InstructionDto(Command command) {
        this.command = command;
        this.value = 0;
    }

    public static InstructionDto parse(String s) {
        String[] split = s.split(" ");
        Command cmd = Command.valueOf(split[0]);
        if (split.length == 1) return new InstructionDto(cmd);
        return new InstructionDto(cmd, Integer.parseInt(split[1]));
    }
}