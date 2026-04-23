import controller.GameController;
import models.*;
import models.enums.GameState;
import strategies.ColumnWinningStrategy;
import strategies.DiagonalWinningStrategy;
import strategies.RowWinningStrategy;
import strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) {

        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        int size = 3;
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
            System.out.print("Enter row: ");
            int row = scanner.nextInt();

            System.out.print("Enter column: ");
            int column = scanner.nextInt();

            Move move;

            try{
                move = gameController.makeMove(game, row, column);
            } catch (Exception e) {
                System.out.println("Cell already filled or out of bounds!. Give the input again");
                continue;
            }

            gameController.addMove(game, move);
            gameController.display(game);
            if(gameController.checkWinner(game, move)) {
                gameController.setGameState(game);
            }
        }
    }
}
