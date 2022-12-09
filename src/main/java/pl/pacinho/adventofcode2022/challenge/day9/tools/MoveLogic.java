package pl.pacinho.adventofcode2022.challenge.day9.tools;

import pl.pacinho.adventofcode2022.challenge.day9.model.elf.Body;
import pl.pacinho.adventofcode2022.challenge.day9.model.elf.Elf;
import pl.pacinho.adventofcode2022.challenge.day9.model.InstructionDto;
import pl.pacinho.adventofcode2022.challenge.day9.model.elf.Tail;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiConsumer;
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
                .forEach(step -> {
                            i.move().goMove(elf);
                            debug(elf);
                        }
                );
    }

    public static final Consumer<Elf> HEAD_UP = elf -> elf.getHead().changeY(1);
    public static final Consumer<Elf> HEAD_DOWN = elf -> elf.getHead().changeY(-1);
    public static final Consumer<Elf> HEAD_LEFT = elf -> elf.getHead().changeX(-1);
    public static final Consumer<Elf> HEAD_RIGHT = elf -> elf.getHead().changeX(1);

    public static final BiConsumer<Elf, Integer> TAIL_UP = (elf, tailIndex) -> {
        if (checkConnectWithParent(elf, tailIndex)) return;
        else if (inTheSameCol(elf, tailIndex)) elf.getTail().get(tailIndex).changePosition(t -> t.changeY(1));
        else moveDiagonally(elf, tailIndex);
    };

    public static final BiConsumer<Elf, Integer> TAIL_DOWN = (elf, tailIndex) -> {
        if (checkConnectWithParent(elf, tailIndex)) return;
        else if (inTheSameCol(elf, tailIndex)) elf.getTail().get(tailIndex).changePosition(t -> t.changeY(-1));
        else moveDiagonally(elf, tailIndex);
    };

    public static final BiConsumer<Elf, Integer> TAIL_LEFT = (elf, tailIndex) -> {
        if (checkConnectWithParent(elf, tailIndex)) return;
        else if (inTheSameRow(elf, tailIndex)) elf.getTail().get(tailIndex).changePosition(t -> t.changeX(-1));
        else if (inTheSameCol(elf, tailIndex)) elf.getTail().get(tailIndex).jump(new int[]{elf.getTail().get(tailIndex).getX(), getParent(elf, tailIndex).getY()-1});
        else moveDiagonally(elf, tailIndex);

    };

    public static final BiConsumer<Elf, Integer> TAIL_RIGHT = (elf, tailIndex) -> {
        if (checkConnectWithParent(elf, tailIndex)) return;
        else if (inTheSameRow(elf, tailIndex)) elf.getTail().get(tailIndex).changePosition(t -> t.changeX(1));
        else if (inTheSameCol(elf, tailIndex)) elf.getTail().get(tailIndex).jump(new int[]{elf.getTail().get(tailIndex).getX(), getParent(elf, tailIndex).getY()-1});
        else moveDiagonally(elf, tailIndex);
    };

    private static void moveDiagonally(Elf elf, Integer tailIndex) {
        if (tailIndex == 8) {
            int x = 0;
        }
        Tail t = elf.getTail().get(tailIndex);
        int[] newTailPos = Arrays.stream(NeighborsUtils.getNeighborsDiagonally(t.getX(), t.getY())
                        .stream()
                        .filter(pos -> checkConnectWithParent(elf, pos, tailIndex))
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException("Illegal diagonally state"))
                        .split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        t.jump(newTailPos);
    }

    private static boolean checkConnectWithParent(Elf elf, String pos, int tailIndex) {
        int[] posArr = Arrays.stream(pos.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        return NeighborsUtils.getNeighbors(posArr[0], posArr[1])
                .stream()
                .anyMatch(ngh -> ngh.equals(getParent(elf, tailIndex).getPosition()));
    }


    private static boolean inTheSameRow(Elf elf, Integer tailIndex) {
        return elf.getTail().get(tailIndex).getY() == getParent(elf, tailIndex).getY();
    }

    private static boolean inTheSameCol(Elf elf, Integer tailIndex) {
        return elf.getTail().get(tailIndex).getX() == getParent(elf, tailIndex).getX();
    }

    private static boolean checkConnectWithParent(Elf elf, Integer tailIndex) {
        Tail t = elf.getTail().get(tailIndex);
        return NeighborsUtils.getNeighbors(t.getX(), t.getY())
                .stream()
                .anyMatch(ngh -> ngh.equals(getParent(elf, tailIndex).getPosition()));
    }

    private static Body getParent(Elf elf, Integer tailIndex) {
        return tailIndex == 0 ?
                elf.getHead()
                : elf.getTail().get(tailIndex - 1);
    }

    private void debug(Elf elf) {
        System.out.println("\n=================\n");

        for (int y = 15; y >= -15; y--) {
            for (int x = -15; x <= 15; x++) {
                int finalX = x;
                int finalY = y;

                if (elf.getHead().getX() == finalX && elf.getHead().getY() == finalY) {
                    System.out.print("H");
                    continue;
                }

                int i = elf.getTail()
                        .stream()
                        .filter(t -> t.getX() == finalX && t.getY() == finalY)
                        .mapToInt(t1 -> elf.getTail().indexOf(t1) + 1)
                        .filter(i1 -> i1 > 0)
                        .max()
                        .orElse(-1);

                System.out.print(i == -1 ? "." : i);
            }
            System.out.print("\n");
        }
    }


}
