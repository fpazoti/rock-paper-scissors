import adapters.PlayerHumanoImpl;
import adapters.PlayerRoboticImpl;
import domain.BigBangTheoryRockPaperScissors;
import ports.Player;
import usecases.Game;

void main() {
    var variant = new BigBangTheoryRockPaperScissors();
    var player1 = new PlayerHumanoImpl("Fernando", BigBangTheoryRockPaperScissors.Moves.PAPER);
    var player2 = new PlayerRoboticImpl("Arc", variant.availableMoves());

    Optional<Player> winner = new Game(player1, player2, variant).play();

    IO.println("The winner is: " + winner.map(Player::getName).orElse("Draw"));
}