package pl.pacinho.adventofcode2022.challenge.day10.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.pacinho.adventofcode2022.challenge.day10.tools.CommandSystem;

import java.util.function.Consumer;

@RequiredArgsConstructor
public enum Command {

    noop(1, CommandSystem.NOOP),
    addx(2, CommandSystem.ADDX);

    @Getter
    private final int cycleCount;
    private final Consumer<Integer> func;

    public void run(int value) {
        this.func.accept(value);
    }
}