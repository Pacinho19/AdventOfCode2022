package pl.pacinho.adventofcode2022.challenge.day11.tools;

import pl.pacinho.adventofcode2022.challenge.day11.model.MonkeyDto;
import pl.pacinho.adventofcode2022.challenge.day11.model.OperationDto;

public class ItemInspector {

    public static void inspect(MonkeyDto monkey) {
        while (!monkey.getItems().isEmpty()) {
            monkey.incrementInspectionCheckingCount();
            OperationDto operation = monkey.getOperation();
            Long i = monkey.getItems().poll();
            Long newWorryLevel = operation.operation().apply(i, operation.value() == -1 ? i : Long.valueOf(operation.value()));
            long divided = Math.round(newWorryLevel / 3);
            if (divided % monkey.getDivisibleValue() == 0) throwTo(monkey.getThrowTrue(), divided);
            else throwTo(monkey.getThrowFalse(), divided);
        }
    }

    private static void throwTo(int monkeyIndex, long divided) {
        Monkeys.monkeys.get(monkeyIndex)
                .addItem(divided);
    }
}