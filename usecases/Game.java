package usecases;

import java.util.Optional;

import domain.RockPaperScissors;
import ports.Player;

public class Game {
    private final Player player1;
    private final Player player2;
    private final RockPaperScissors variant;

    public Game(Player player1, Player player2, RockPaperScissors variant) {
        this.player1 = player1;
        this.player2 = player2;
        this.variant = variant;
    }

    public Optional<Player> play() {
        return this.variant.winner(player1, player2);
    }
}
