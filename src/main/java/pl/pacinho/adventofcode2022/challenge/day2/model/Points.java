package pl.pacinho.adventofcode2022.challenge.day2.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Points {

    WIN(6),
    DRAW(3),
    LOSE(0);

    private final int value;
}
