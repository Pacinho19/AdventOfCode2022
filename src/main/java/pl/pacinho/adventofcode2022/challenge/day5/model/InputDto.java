package pl.pacinho.adventofcode2022.challenge.day5.model;

import java.util.Deque;
import java.util.HashMap;
import java.util.List;

public record InputDto(List<InstructionDto> instructions, HashMap<Integer, Deque<String>> stacks) {
}
