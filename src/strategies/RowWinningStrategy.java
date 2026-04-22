package strategies;

import models.Move;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy {

    private int size;
    private HashMap<String, Integer>[] rowCount;

    public RowWinningStrategy(int size) {
        this.size = size;
        rowCount = new HashMap[size];
        for(int i = 0; i < size; i++) {
            rowCount[i] = new HashMap<>();
        }
    }

    @Override
    public boolean checkWinner(Move move) {
        int row = move.getCell().getRow();
        String symbol = move.getPlayer().getSymbol().getSymbolName();

        rowCount[row].put(symbol, rowCount[row].getOrDefault(symbol, 0) + 1);
        return rowCount[row].get(symbol) == size;
    }
}
