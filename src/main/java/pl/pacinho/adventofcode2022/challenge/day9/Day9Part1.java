package pl.pacinho.adventofcode2022.challenge.day9;

import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.challenge.day9.model.elf.Elf;
import pl.pacinho.adventofcode2022.challenge.day9.model.InstructionDto;
import pl.pacinho.adventofcode2022.challenge.day9.tools.MoveLogic;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;

public class Day9Part1 implements CalculateI {

    @Override
    public long calculate(String filePath) {

        Elf elf = new Elf();
        MoveLogic moveLogic = new MoveLogic(elf);

        FileUtils.readTxt(new File(filePath))
                .stream()
                .map(s -> new InstructionDto(s.split(" ")[0], Integer.parseInt(s.split(" ")[1])))
                .forEach(moveLogic::goMove);

        return elf.getTail()
                .getVisitedPositions()
                .size();
    }

    public static void main(String[] args) {
        System.out.println(
                new Day9Part1().calculate("challenges\\day9\\input.txt")
        );
    }
}