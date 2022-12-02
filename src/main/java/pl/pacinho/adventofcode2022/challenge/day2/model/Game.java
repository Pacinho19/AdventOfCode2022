package pl.pacinho.adventofcode2022.challenge.day2.model;

public record Game(Player1 player1, Player2 player2) {

    public long calculatePoints() {
        return (player2.getWinner() == player1 ? Points.WIN.getValue()
                : player2.getDraw() == player1 ?  Points.DRAW.getValue()
                : 0) + player2.getPoints();
    }

    public long checkRoundForStrategy2() {
        return (player2 == Player2.X ? Player2.getPointByStrategy(p2 -> p2.getLose() == player1)
                        : player2 == Player2.Y ? Player2.getPointByStrategy(p2 -> p2.getDraw() == player1)
                        : Player2.getPointByStrategy(p2 -> p2.getWinner() == player1))
                + player2().getStrategyPoints();
    }
}
