package pl.pacinho.adventofcode2022.challenge.day11.tools;

import pl.pacinho.adventofcode2022.challenge.day11.model.MonkeyDto;

import java.util.LinkedList;
import java.util.List;

public class Monkeys {

    public static List<MonkeyDto> monkeys = new LinkedList<>();

    public static MonkeyDto getLast() {
        return monkeys.get(monkeys.size() - 1);
    }
}