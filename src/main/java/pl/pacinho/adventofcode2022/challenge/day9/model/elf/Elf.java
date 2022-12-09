package pl.pacinho.adventofcode2022.challenge.day9.model.elf;

import lombok.Getter;

import java.util.List;
import java.util.stream.IntStream;

@Getter
public class Elf {
    private Head head;
    private List<Tail> tail;

    public Elf(int tailSize) {
        this.head = new Head();
        this.tail = IntStream.range(0, tailSize)
                .boxed()
                .map(i -> new Tail())
                .toList();
    }
}
