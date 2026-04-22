package models;

import models.enums.PlayerType;

public class HumanPlayer extends Player {
    private int age;

    public HumanPlayer(int id, String name, Symbol symbol, int age) {
        super(id, name, symbol, PlayerType.HUMAN);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
