package adapters;

import java.util.List;
import java.util.Random;

import domain.Move;
import ports.Player;

public class PlayerRoboticImpl implements Player {
    private final String name;
    private final List<Move> availableMoves;
    private static Random random = new Random();

    public PlayerRoboticImpl(String name, List<Move> availableMoves) {
        this.name = name;
        this.availableMoves = availableMoves;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Move getMove() {
        return this.availableMoves.get(random.nextInt(0, this.availableMoves.size()));
    }
}
