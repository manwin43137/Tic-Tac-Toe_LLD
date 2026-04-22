package strategies;

import models.Move;

import java.util.HashMap;

public class ColumnWinningStrategy implements WinningStrategy{

    private int size;
    private HashMap<String, Integer>[] colCount;

    public ColumnWinningStrategy(int size) {
        this.size = size;
        this.colCount = new HashMap[size];
        for (int i = 0; i < size; i++) {
            colCount[i] = new HashMap<>();
        }
    }

    @Override
    public boolean checkWinner(Move move) {
        String symbolName = move.getPlayer().getSymbol().getSymbolName();
        int col = move.getCell().getCol();

        colCount[col].put(symbolName, colCount[col].getOrDefault(symbolName, 0) + 1);

        return colCount[col].get(symbolName) == size;
    }
}
