package domain;

import java.util.Arrays;
import java.util.List;

import ports.Player;

public class ClassicRockPaperScissors extends RockPaperScissors {
    public enum Moves implements Move {
        ROCK, PAPER, SCISSORS
    }

    @Override
    public List<Move> availableMoves() {
        return Arrays.asList(Moves.values());
    }

    @Override
    protected Result determineWinner(Player player1, Player player2) {
        if (player1.getMove() == player2.getMove()) return Result.DRAW;

        return switch ((Moves) player1.getMove()) {
            case ROCK -> player2.getMove() == Moves.SCISSORS ? Result.WIN : Result.LOSS;
            case PAPER -> player2.getMove() == Moves.ROCK ? Result.WIN : Result.LOSS;
            case SCISSORS -> player2.getMove() == Moves.PAPER ? Result.WIN : Result.LOSS;
        };
    }
}
