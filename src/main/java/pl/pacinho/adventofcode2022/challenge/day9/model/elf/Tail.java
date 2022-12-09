package pl.pacinho.adventofcode2022.challenge.day9.model.elf;

import lombok.Getter;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Tail extends Body {

    @Getter
    private Set<String> visitedPositions;

    public Tail() {
        super();
        this.visitedPositions = new LinkedHashSet<>();
        addPosition(); //Start pos
    }

    private void addPosition() {
        this.visitedPositions.add(getPosition());
    }

    public void changePosition(Consumer<Tail> move) {
        move.accept(this);
        addPosition();
    }

    public void jump(int[] newTailPos) {
        this.setX(newTailPos[0]);
        this.setY(newTailPos[1]);
        addPosition();
    }
}
