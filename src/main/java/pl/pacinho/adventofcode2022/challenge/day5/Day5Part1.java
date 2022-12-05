package pl.pacinho.adventofcode2022.challenge.day5;

import pl.pacinho.adventofcode2022.challenge.CalculateTextI;
import pl.pacinho.adventofcode2022.challenge.day5.model.InputDto;
import pl.pacinho.adventofcode2022.challenge.day5.tools.CargoCrane;
import pl.pacinho.adventofcode2022.challenge.day5.utils.InputUtils;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;

public class Day5Part1 implements CalculateTextI {

    @Override
    public String calculate(String filePath) {
        InputDto input = InputUtils.parse(FileUtils.readTxt(new File(filePath)));
        CargoCrane cc = new CargoCrane(input);
        cc.crateMover9000();
        return cc.getFirstElements();
    }

    public static void main(String[] args) {
        System.out.println(
                new Day5Part1().calculate("challenges\\day5\\input.txt")
        );
    }
}
