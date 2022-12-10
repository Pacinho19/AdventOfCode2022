package pl.pacinho.adventofcode2022.challenge.day10.tools;

import pl.pacinho.adventofcode2022.challenge.day10.model.Cpu;

import java.util.stream.IntStream;

public class CycleManager {
    public static long runCycles(Integer count) {
        Cpu cpu = Cpu.getInstance();
        cpu.reset();
        IntStream.range(1, count)
                .boxed()
                .forEach(x -> cpu.runCommand());
        return (long) cpu.getX() * count;
    }
}