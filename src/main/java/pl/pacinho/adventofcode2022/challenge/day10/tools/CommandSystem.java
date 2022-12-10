package pl.pacinho.adventofcode2022.challenge.day10.tools;

import pl.pacinho.adventofcode2022.challenge.day10.model.Cpu;
import pl.pacinho.adventofcode2022.challenge.day10.model.enums.Command;

import java.util.function.Consumer;

public class CommandSystem {
    public static final Consumer<Integer> NOOP = value -> {
        Cpu cpu = Cpu.getInstance();
        cpu.resetInstructionCycle();
    };
    public static final Consumer<Integer> ADDX = value -> {
        Cpu cpu = Cpu.getInstance();
        if (cpu.getInstructionCycle() == Command.addx.getCycleCount())
            cpu.changeX(value);
        else
            cpu.nextInstructionCycle();
    };
}