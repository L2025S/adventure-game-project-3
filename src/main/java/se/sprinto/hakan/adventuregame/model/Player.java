package se.sprinto.hakan.adventuregame.model;

public class Player extends AbstractCharacter {
    private boolean foundKey;
    private boolean defeatedEnemy;
    private boolean openedChest;
    private boolean foundBook;
    private boolean returnedBook;

    public Player(String name, int health, int score, int strength) {
        super(name, health, score, strength);
    }

    public boolean hasFoundBok() {
        return foundBook;
    }
    public void setFoundBook(boolean foundBook) {
        this.foundBook = foundBook;
    }

    public boolean hasReturnedBook() {
        return returnedBook;
    }
    public void setReturnedBook(boolean returnedBook) {
        this.returnedBook = returnedBook;
    }

    public boolean hasFoundKey() {
        return foundKey;
    }

    public void setFoundKey(boolean foundKey) {
        this.foundKey = foundKey;
    }

    public boolean hasDefeatedEnemy() {
        return defeatedEnemy;
    }


    public void setDefeatedEnemy(boolean defeatedEnemy) {
        this.defeatedEnemy = defeatedEnemy;
    }

    public boolean hasOpenedChest() {
        return openedChest;
    }

    public void setOpenedChest(boolean openedChest) {
        this.openedChest = openedChest;
    }

    public boolean hasWon() {
        return foundKey && defeatedEnemy && openedChest;
    }

    @Override
    public void attack(AbstractCharacter target) {
        target.setHealth(target.getHealth() - this.getStrength());

        if (!target.isAlive()) {
            addScore(50);
        }
    }
    public static class Builder{
        private String name;
        private int health;
        private int score;
        private int strength;

    public Builder setName(String name) {
        this.name = name;
        return this;
    }
    public Builder setHealth (int health) {
        this.health = health;
        return this;
    }

    public Builder setScore(int score) {
        this.score = score;
        return this;
    }
    public Builder setStrength(int strength) {
        this.strength = strength;
        return this;
    }

    public Player build() {
        return new Player(name, health, score, strength);
    }

    }
}
