package pl.pacinho.adventofcode2022.challenge.day10.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum PencilSign {

    DOT("  ", false),
    HASH("██", true);

    @Getter
    private final String sign;
    private final boolean condition;

    public static PencilSign findByCondition(boolean b) {
        return Arrays.stream(PencilSign.values())
                .filter(s -> s.condition == b)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Illegal PencilSign condition param: " + b));
    }
}