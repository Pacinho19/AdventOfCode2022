package pl.pacinho.adventofcode2022.challenge.day9.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.pacinho.adventofcode2022.challenge.day9.model.elf.Elf;
import pl.pacinho.adventofcode2022.challenge.day9.tools.MoveLogic;

import java.util.Arrays;
import java.util.function.Consumer;

@Getter
@RequiredArgsConstructor
public enum Move {

    UP("U", MoveLogic.HEAD_UP, MoveLogic.TAIL_UP),
    DOWN("D", MoveLogic.HEAD_DOWN, MoveLogic.TAIL_DOWN),
    LEFT("L", MoveLogic.HEAD_LEFT, MoveLogic.TAIL_LEFT),
    RIGHT("R", MoveLogic.HEAD_RIGHT, MoveLogic.TAIL_RIGHT);

    private final String sign;
    private final Consumer<Elf> headMove;
    private final Consumer<Elf> tailMove;

    public static Move findBySign(String sign) {
        return Arrays.stream(Move.values())
                .filter(m -> m.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Illegal sign"));
    }

    public void goMove(Elf elf) {
        headMove.accept(elf);
        tailMove.accept(elf);
    }

}
