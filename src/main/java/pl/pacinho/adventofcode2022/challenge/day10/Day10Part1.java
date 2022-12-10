package pl.pacinho.adventofcode2022.challenge.day10;

import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.challenge.day10.model.Cpu;
import pl.pacinho.adventofcode2022.challenge.day10.model.InstructionDto;
import pl.pacinho.adventofcode2022.challenge.day10.tools.CycleManager;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;
import java.util.List;

public class Day10Part1 implements CalculateI {

    private static final List<Integer> CYCLES = List.of(20, 60, 100, 140, 180, 220);

    @Override
    public long calculate(String filePath) {
        List<InstructionDto> instructions = FileUtils.readTxt(new File(filePath))
                .stream()
                .map(InstructionDto::parse)
                .toList();

        Cpu.getInstance()
                .setInstructions(instructions);

        return CYCLES.stream()
                .map(CycleManager::runCycles)
                .reduce(0L, Long::sum);

    }

    public static void main(String[] args) {
        System.out.println(
                new Day10Part1().calculate("challenges\\day10\\input.txt")
        );
    }
}