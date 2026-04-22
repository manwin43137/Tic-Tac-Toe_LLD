package strategies;

import models.Move;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy {

    private int size;
    private HashMap<String, Integer> mainDiagonal;
    private HashMap<String, Integer> antiDiagonal;

    public DiagonalWinningStrategy(int size) {
        this.size = size;
        this.mainDiagonal = new HashMap<>();
        this.antiDiagonal = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Move move) {
        String symbolName = move.getPlayer().getSymbol().getSymbolName();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row == col) {
            mainDiagonal.put(symbolName, mainDiagonal.getOrDefault(symbolName, 0) + 1);
        }

        if(row + col == size - 1) {
            antiDiagonal.put(symbolName, antiDiagonal.getOrDefault(symbolName, 0) + 1);
        }

        boolean wonOnMain = mainDiagonal.get(symbolName) == size;
        boolean wonOnAnti = antiDiagonal.get(symbolName) == size;

        return wonOnMain || wonOnAnti;

    }
}
