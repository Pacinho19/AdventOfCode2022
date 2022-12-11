package pl.pacinho.adventofcode2022.challenge.day11.model.enums;

import lombok.RequiredArgsConstructor;
import pl.pacinho.adventofcode2022.challenge.day11.tools.OperationDefinition;

import java.util.Arrays;
import java.util.function.BiFunction;

@RequiredArgsConstructor
public enum Operation {

    MULTIPLY("*", OperationDefinition.MULTIPLY),
    ADD("+", OperationDefinition.ADD);

    private final String sign;
    private final BiFunction<Long, Long, Long> function;

    public static Operation getBySign(String sign) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Illegal operation sign: " + sign));
    }

    public Long apply(Long value1, Long value2) {
        return function.apply(value1, value2);
    }
}