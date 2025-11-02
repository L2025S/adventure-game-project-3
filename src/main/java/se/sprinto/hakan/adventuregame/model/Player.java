package se.sprinto.hakan.adventuregame.model;

public class Player extends AbstractCharacter {
    private boolean foundKey;
    private boolean defeatedEnemy;
    private boolean openedChest;

    public Player(String name, int health, int score, int strength) {
        super(name, health, score, strength);
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
