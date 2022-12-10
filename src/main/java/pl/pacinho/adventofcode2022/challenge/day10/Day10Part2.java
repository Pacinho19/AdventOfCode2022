package pl.pacinho.adventofcode2022.challenge.day10;

import pl.pacinho.adventofcode2022.challenge.CalculateTextI;
import pl.pacinho.adventofcode2022.challenge.day10.model.Cpu;
import pl.pacinho.adventofcode2022.challenge.day10.model.InstructionDto;
import pl.pacinho.adventofcode2022.challenge.day10.tools.Painter;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;
import java.util.List;
import java.util.stream.IntStream;

public class Day10Part2 implements CalculateTextI {

    private final int CRT_LENGTH = 40;
    private final int CRT_HEIGHT = 6;

    @Override
    public String calculate(String filePath) {
        List<InstructionDto> instructions = FileUtils.readTxt(new File(filePath))
                .stream()
                .map(InstructionDto::parse)
                .toList();

        Cpu cpu = Cpu.getInstance();
        cpu.setInstructions(instructions);

        StringBuilder out = new StringBuilder();
        int position = 0;
        int lines = 0;
        while (!cpu.instructionsFinished()) {
            out.append(Painter.getSign(position));
            position++;
            cpu.runCommand();
            if (cpu.getCycle() % CRT_LENGTH == 0) {
                out.append("\n");
                position = 0;
                lines++;
            }
            if (lines == CRT_HEIGHT)
                break;
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new Day10Part2().calculate("challenges\\day10\\input.txt")
        );
    }
}