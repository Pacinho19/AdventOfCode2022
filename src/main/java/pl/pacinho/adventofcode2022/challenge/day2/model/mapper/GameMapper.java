package pl.pacinho.adventofcode2022.challenge.day2.model.mapper;

import pl.pacinho.adventofcode2022.challenge.day2.model.Game;
import pl.pacinho.adventofcode2022.challenge.day2.model.Player1;
import pl.pacinho.adventofcode2022.challenge.day2.model.Player2;

public class GameMapper {
    public static Game parse(String text) {
        String[] split = text.split(" ");
        return new Game(
                Player1.valueOf(split[0]),
                Player2.valueOf(split[1])
        );
    }
}
