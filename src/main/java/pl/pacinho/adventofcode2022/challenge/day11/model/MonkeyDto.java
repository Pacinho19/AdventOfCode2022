package pl.pacinho.adventofcode2022.challenge.day11.model;

import lombok.*;
import pl.pacinho.adventofcode2022.challenge.day11.tools.ItemInspector;

import java.util.ArrayDeque;
import java.util.function.Function;

@Setter
@Getter
public class MonkeyDto {

    private ArrayDeque<Long> items;
    private long divisibleValue;
    private OperationDto operation;
    private int throwTrue;
    private int throwFalse;
    private long checkingCount;

    public MonkeyDto() {
        items = new ArrayDeque<>();
        checkingCount = 0;
    }

    public void addItems(ArrayDeque<Long> values) {
        getItems().addAll(values);
    }

    public void addItem(Long value) {
        items.addLast(value);
    }

    public void go() {
        ItemInspector.inspect(this);
    }

    public void incrementInspectionCheckingCount() {
        this.checkingCount++;
    }
}