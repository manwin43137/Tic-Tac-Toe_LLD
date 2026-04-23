package controller;

import models.Game;
import models.Move;
import models.Player;
import models.enums.GameState;
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

    public Move makeMove(Game game, int row, int column) {
        Move move = game.getBoard().makeMove(game.getCurrentPlayer(), row, column);
        game.setNextPlayerMove(game.getNextPlayerMove() + 1);
        return move;
    }

    public void addMove(Game game, Move move) {
        game.addMove(move);
    }

    public boolean checkWinner(Game game, Move move) {
        for(WinningStrategy strategy : game.getWinningStrategies()) {
            if(strategy.checkWinner(move)) return true;
        }
        return false;
    }

    public void setGameState(Game game) {
        game.setGameState(GameState.FINISHED);
    }

    public void setWinner(Game game) {
        game.setCurrentWinner();
    }
}
