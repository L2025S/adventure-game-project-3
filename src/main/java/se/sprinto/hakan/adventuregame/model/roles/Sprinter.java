package se.sprinto.hakan.adventuregame.model.roles;

import se.sprinto.hakan.adventuregame.model.AbstractCharacter;

public class Sprinter extends AbstractCharacter {


    public Sprinter(String name, int health, int score, int strength) {
        super(name, health, score, strength);
    }

    public int run100m() {
         return (int) (Math.random()*10);

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

        public Builder setScore (int score) {
            this.score = score;
            return this;
        }

        public Builder setStrength ( int strength) {
            this.strength = strength;
            return this;
        }

        public Sprinter build() {
            return new Sprinter (name, health, score, strength);
        }
    }
}
