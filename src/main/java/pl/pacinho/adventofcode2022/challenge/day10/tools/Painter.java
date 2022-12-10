package pl.pacinho.adventofcode2022.challenge.day10.tools;

import pl.pacinho.adventofcode2022.challenge.day10.model.Cpu;
import pl.pacinho.adventofcode2022.challenge.day10.model.enums.PencilSign;

import java.util.List;
import java.util.stream.IntStream;

public class Painter {
    public static String getSign(int position) {
        Cpu c = Cpu.getInstance();
        return PencilSign.findByCondition(
                getPencilIndexes(c.getX()).contains(position)
        ).getSign();
    }

    private static List<Integer> getPencilIndexes(int x) {
        return IntStream.rangeClosed(-1, 1)
                .boxed()
                .map(i -> x - i)
                .toList();
    }
}