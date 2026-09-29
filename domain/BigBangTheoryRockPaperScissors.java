package domain;

import java.util.Arrays;
import java.util.List;

import ports.Player;

public class BigBangTheoryRockPaperScissors extends RockPaperScissors {
    public enum Moves implements Move {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }

    @Override
    public List<Move> availableMoves() {
        return Arrays.asList(Moves.values());
    }

    @Override
    protected Result determineWinner(Player player1, Player player2) {
        if (player1.getMove() == player2.getMove()) return Result.DRAW;

        // Expanded rules isolated in this class
        return switch ((Moves) player1.getMove()) {
            case ROCK -> (player2.getMove() == Moves.SCISSORS || player2.getMove() == Moves.LIZARD) ? Result.WIN : Result.LOSS;
            case PAPER -> (player2.getMove() == Moves.ROCK || player2.getMove() == Moves.SPOCK) ? Result.WIN : Result.LOSS;
            case SCISSORS -> (player2.getMove() == Moves.PAPER || player2.getMove() == Moves.LIZARD) ? Result.WIN : Result.LOSS;
            case LIZARD -> (player2.getMove() == Moves.SPOCK || player2.getMove() == Moves.PAPER) ? Result.WIN : Result.LOSS;
            case SPOCK -> (player2.getMove() == Moves.SCISSORS || player2.getMove() == Moves.ROCK) ? Result.WIN : Result.LOSS;
        };
    }
}
