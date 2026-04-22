import controller.GameController;
import models.Game;
import models.enums.GameState;

public class GameClient {
    public static void main(String[] args) {

        GameController gameController = new GameController();

        Game game = gameController.startGame();
        gameController.display(game);

        while(game.getGameState() == GameState.IN_PROGRESS) {

        }
    }
}
