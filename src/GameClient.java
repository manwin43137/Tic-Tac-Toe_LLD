import controller.GameController;
import models.Game;
import models.HumanPlayer;
import models.Player;
import models.Symbol;
import models.enums.GameState;
import strategies.ColumnWinningStrategy;
import strategies.DiagonalWinningStrategy;
import strategies.RowWinningStrategy;
import strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameClient {
    public static void main(String[] args) {

        GameController gameController = new GameController();

        int size = 4;
        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer(1, "Manwin", new Symbol("X"), 24));
        players.add(new HumanPlayer(2, "Won", new Symbol("O"), 24));
        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy(size));
        winningStrategies.add(new ColumnWinningStrategy(size));
        winningStrategies.add(new DiagonalWinningStrategy(size));

        Game game = gameController.startGame(size, players, winningStrategies);
        gameController.display(game);

        while(game.getGameState() == GameState.IN_PROGRESS) {
            gameController.makeMove(game);
        }
    }
}
