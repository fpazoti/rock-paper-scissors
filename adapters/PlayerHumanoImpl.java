package adapters;

import domain.Move;
import ports.Player;

public class PlayerHumanoImpl implements Player {
    private final String name;
    private final Move move;

    public PlayerHumanoImpl(String name, Move move) {
        this.name = name;
        this.move = move;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Move getMove() {
        return this.move;
    }
}
