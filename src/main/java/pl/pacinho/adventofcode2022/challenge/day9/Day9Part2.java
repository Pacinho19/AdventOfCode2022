package pl.pacinho.adventofcode2022.challenge.day9;

import pl.pacinho.adventofcode2022.challenge.CalculateI;
public class Day9Part2 implements CalculateI {

    private final int TAIL_LENGTH = 9;

    @Override
    public long calculate(String filePath) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(
                new Day9Part2().calculate("challenges\\day9\\input.txt")
        );
    }
}