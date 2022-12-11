package pl.pacinho.adventofcode2022.challenge.day11.tools;

import pl.pacinho.adventofcode2022.challenge.day11.model.MonkeyDto;
import pl.pacinho.adventofcode2022.challenge.day11.model.OperationDto;
import pl.pacinho.adventofcode2022.challenge.day11.model.enums.Operation;
import pl.pacinho.adventofcode2022.challenge.day11.utils.StringUtils;

import java.util.ArrayDeque;

public class MonkeyParser {

    public static void parse(String line) {
        if (line.startsWith("Monkey")) Monkeys.monkeys.add(new MonkeyDto());
        else if (line.contains("Starting items")) Monkeys.getLast().addItems(ItemsParser.parse(line));
        else if (line.contains("Operation")) Monkeys.getLast().setOperation(getOperation(line));
        else if (line.contains("Test")) Monkeys.getLast().setDivisibleValue(getDivisibleValue(line));
        else if (line.contains("If true")) Monkeys.getLast().setThrowTrue(getThrowTargetMonkey(line));
        else if (line.contains("If false")) Monkeys.getLast().setThrowFalse(getThrowTargetMonkey(line));
    }

    private static int getThrowTargetMonkey(String line) {
        return StringUtils.getLongValue(line).intValue();
    }

    private static long getDivisibleValue(String line) {
        return StringUtils.getLongValue(line);
    }

    private static OperationDto getOperation(String line) {
        return new OperationDto(
                Operation.getBySign(getOperationSign(line)),
                getOperationValue(line)
        );
    }

    private static long getOperationValue(String line) {
        return StringUtils.getLongValue(line);
    }

    private static String getOperationSign(String line) {
        return line.split("Operation: new = old ")[1]
                .split(" ")[0];
    }

}