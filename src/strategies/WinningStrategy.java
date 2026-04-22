package strategies;

import models.Board;
import models.Move;

public interface WinningStrategy {
    boolean checkWinner(Move move);
}
