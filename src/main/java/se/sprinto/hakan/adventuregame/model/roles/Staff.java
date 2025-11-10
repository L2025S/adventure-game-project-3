package se.sprinto.hakan.adventuregame.model.roles;

import se.sprinto.hakan.adventuregame.model.AbstractCharacter;

import java.util.Random;

public class Staff extends AbstractCharacter {

    Staff (String name, int health, int score, int strength){
        super(name, health, score, strength);
    }

    public void drawLotteryFor(AbstractCharacter target) {
        int lottery = new Random().nextInt(200) - 100;
        addScore(-lottery);
        target.addScore(lottery);
        System.out.println("Du har fått " + lottery + " poäng.");
    }

    @Override
    public void attack (AbstractCharacter target) {
        target.setHealth(target.getHealth() - this.getStrength());
    }
    public static class Builder {
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
        public Builder setScore( int score) {
            this.score = score;
            return this;
        }
        public Builder setStrength(int strength) {
            this.strength = strength;
            return this;
        }

        public Staff build() {
            return new Staff(name, health, score, strength);
        }
    }
}
