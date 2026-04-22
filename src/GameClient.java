import controller.GameController;
import models.Game;

public class GameClient {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Game game = gameController.startGame();
    }
}
