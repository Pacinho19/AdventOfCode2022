package pl.pacinho.adventofcode2022.challenge.day10.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Cpu {

    @Setter
    private List<InstructionDto> instructions;
    private int actualInstruction;
    @Getter
    private int instructionCycle;
    @Getter
    private int x;

    Cpu() {
        this.actualInstruction = 0;
        this.instructionCycle = 0;
        this.x = 1;
    }

    private static Cpu self;

    public static Cpu getInstance() {
        if (self == null) self = new Cpu();
        return self;
    }

    public void reset() {
        this.actualInstruction = 0;
        instructionCycle = 1;
        x = 1;
    }

    public void nextInstructionCycle() {
        instructionCycle++;
    }

    public void runCommand() {
        InstructionDto instructionDto = instructions.get(actualInstruction);
        instructionDto.getCommand().run(instructionDto.getValue());
    }

    public void changeX(Integer value) {
        x += value;
        resetInstructionCycle();
    }

    public void resetInstructionCycle() {
        instructionCycle = 1;
        actualInstruction++;
    }
}