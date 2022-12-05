package pl.pacinho.adventofcode2022.challenge.day5.tools;

import pl.pacinho.adventofcode2022.challenge.day5.model.InputDto;
import pl.pacinho.adventofcode2022.challenge.day5.model.InstructionDto;

import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CargoCrane {
    private final InputDto input;

    public CargoCrane(InputDto input) {
        this.input = input;
    }

    public void crateMover9000() {
        input.instructions()
                .forEach(this::move);
    }

    private void move(InstructionDto instructionDto) {
        Deque<String> target = input.stacks().get(instructionDto.to());
        Deque<String> from = input.stacks().get(instructionDto.from());
        IntStream.rangeClosed(1, instructionDto.count())
                .mapToObj(i -> from.poll())
                .forEach(target::addFirst);
    }

    public String getFirstElements() {
        return input.stacks()
                .values()
                .stream()
                .map(Deque::getFirst)
                .collect(Collectors.joining());
    }

    public void crateMover9001() {
        input.instructions()
                .forEach(this::move2);
    }

    private void move2(InstructionDto instructionDto) {
        Deque<String> target = input.stacks().get(instructionDto.to());
        Deque<String> from = input.stacks().get(instructionDto.from());
        List<String> list = IntStream.rangeClosed(1, instructionDto.count())
                .mapToObj(i -> from.poll())
                .collect(Collectors.toList());
        Collections.reverse(list);
        list.forEach(target::addFirst);
    }
}
