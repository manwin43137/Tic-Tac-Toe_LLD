package controller;

import models.Game;
import models.Player;
import strategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int size, List<Player> players, List<WinningStrategy> winningStrategies) {
        Game game = new Game(size, players, winningStrategies);
        return game;
    }

    public void display(Game game) {
        game.getBoard().display();
    }

    public void makeMove(Game game) {}
}
