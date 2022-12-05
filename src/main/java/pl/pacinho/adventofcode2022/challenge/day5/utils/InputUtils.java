package pl.pacinho.adventofcode2022.challenge.day5.utils;

import pl.pacinho.adventofcode2022.challenge.day5.model.InputDto;
import pl.pacinho.adventofcode2022.challenge.day5.model.InstructionDto;
import pl.pacinho.adventofcode2022.challenge.day5.model.mapper.InstructionMapper;

import java.util.*;

public class InputUtils {

    private static final int FIRST = 1;
    private static final int STEP = 4;

    public static InputDto parse(List<String> readTxt) {
        List<InstructionDto> instructions = new ArrayList<>();
        HashMap<Integer, Deque<String>> stacks = new HashMap();
        readTxt.forEach(s -> {
            if (s.contains("[")) addToStack(s, stacks);
            if (s.trim().isEmpty()) return;
            if (s.startsWith("move")) instructions.add(InstructionMapper.parse(s));
        });
        return new InputDto(instructions, stacks);
    }

    private static void addToStack(String s, Map<Integer, Deque<String>> stacks) {
        String[] s1 = s.split("");
        for (int i = FIRST; i <= s1.length; i += STEP) {
            if (!isAlpha(s1[i])) continue;
            stacks.computeIfAbsent(getKey(i), k -> new ArrayDeque<>())
                    .add(s1[i]);
        }
    }

    private static Integer getKey(int i) {
        return (i / STEP) + 1;
    }

    private static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }
}
