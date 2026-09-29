package ports;

import domain.Move;

public interface Player {
    String getName();
    Move getMove();
}