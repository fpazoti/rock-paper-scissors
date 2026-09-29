package domain;

import java.util.List;
import java.util.Optional;

import ports.Player;

public abstract class RockPaperScissors {
    public abstract List<Move> availableMoves();
    protected abstract Result determineWinner(Player player1, Player player2);

    public final Optional<Player> winner(Player player1, Player player2) {
        var availableMoves = availableMoves();
        if (!availableMoves.contains(player1.getMove()))
            throw new RuntimeException("Player 1's move is invalid");

        if (!availableMoves.contains(player2.getMove()))
            throw new RuntimeException("Player 2's move is invalid");

        var result = determineWinner(player1, player2);

        return switch (result) {
            case Result.WIN -> Optional.of(player1);
            case Result.LOSS -> Optional.of(player2);
            default -> Optional.empty();
        };
    }
}
