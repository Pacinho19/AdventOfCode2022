package pl.pacinho.adventofcode2022.challenge.day9.tools;

import pl.pacinho.adventofcode2022.challenge.day9.model.elf.Elf;
import pl.pacinho.adventofcode2022.challenge.day9.model.InstructionDto;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class MoveLogic {

    private Elf elf;

    public MoveLogic(Elf elf) {
        this.elf = elf;
    }

    public void goMove(InstructionDto i) {
        IntStream.range(0, i.step())
                .boxed()
                .forEach(step ->
                        i.move().goMove(elf)
                );
    }

    public static final Consumer<Elf> HEAD_UP = elf -> elf.getHead().changeY(1);
    public static final Consumer<Elf> HEAD_DOWN = elf -> elf.getHead().changeY(-1);
    public static final Consumer<Elf> HEAD_LEFT = elf -> elf.getHead().changeX(-1);
    public static final Consumer<Elf> HEAD_RIGHT = elf -> elf.getHead().changeX(1);

    public static final Consumer<Elf> TAIL_UP = elf -> {
        if (checkConnectWithHead(elf)) return;
        else if (inTheSameCol(elf)) elf.getTail().changePosition(t -> t.changeY(1));
        else moveDiagonally(elf);
    };

    public static final Consumer<Elf> TAIL_DOWN = elf -> {
        if (checkConnectWithHead(elf)) return;
        else if (inTheSameCol(elf)) elf.getTail().changePosition(t -> t.changeY(-1));
        else moveDiagonally(elf);
    };

    public static final Consumer<Elf> TAIL_LEFT = elf -> {
        if (checkConnectWithHead(elf)) return;
        else if (inTheSameRow(elf)) elf.getTail().changePosition(t -> t.changeX(-1));
        else moveDiagonally(elf);

    };

    public static final Consumer<Elf> TAIL_RIGHT = elf -> {
        if (checkConnectWithHead(elf)) return;
        else if (inTheSameRow(elf)) elf.getTail().changePosition(t -> t.changeX(1));
        else moveDiagonally(elf);
    };

    private static void moveDiagonally(Elf elf) {
        int[] newTailPos = Arrays.stream(NeighborsUtils.getNeighborsDiagonally(elf.getTail().getX(), elf.getTail().getY())
                        .stream()
                        .filter(pos -> checkConnectWithHead(elf, pos))
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException("Illegal diagonally state"))
                        .split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        elf.getTail().jump(newTailPos);
    }

    private static boolean checkConnectWithHead(Elf elf, String pos) {
        int[] posArr = Arrays.stream(pos.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        return NeighborsUtils.getNeighbors(posArr[0], posArr[1])
                .stream()
                .anyMatch(ngh -> ngh.equals(elf.getHead().getPosition()));
    }


    private static boolean inTheSameRow(Elf elf) {
        return elf.getTail().getY() == elf.getHead().getY();
    }

    private static boolean inTheSameCol(Elf elf) {
        return elf.getTail().getX() == elf.getHead().getX();
    }

    private static boolean checkConnectWithHead(Elf elf) {
        return NeighborsUtils.getNeighbors(elf.getTail().getX(), elf.getTail().getY())
                .stream()
                .anyMatch(ngh -> ngh.equals(elf.getHead().getPosition()));
    }


}
