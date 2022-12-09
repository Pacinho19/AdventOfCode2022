package pl.pacinho.adventofcode2022.challenge.day9.model.elf;

import lombok.Getter;

@Getter
public class Elf {
    private Head head;
    private Tail tail;

    public Elf() {
        this.head = new Head();
        this.tail = new Tail();
    }
}
