package pl.pacinho.adventofcode2022.challenge.day2.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.function.Predicate;

@Getter
@RequiredArgsConstructor
public enum Player2 {

    X(Player1.C, Player1.A,Player1.B, 1L, Points.LOSE.getValue()),
    Y(Player1.A, Player1.B, Player1.C,2L,  Points.DRAW.getValue()),
    Z(Player1.B, Player1.C, Player1.A,3L,  Points.WIN.getValue());

    private final Player1 winner;
    private final Player1 draw;
    private final Player1 lose;
    private final long points;
    private final long strategyPoints;

    public static long getPointByStrategy(Predicate<Player2> predicate){
        return Arrays.stream(Player2.values())
                .filter(predicate)
                .findFirst()
                .get()
                .getPoints();
    }

}
