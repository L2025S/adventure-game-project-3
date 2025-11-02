package se.sprinto.hakan.adventuregame.model;

import java.util.Objects;

public class Statistics {
    private String playerName;
    private int score;

    public Statistics(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return playerName + ";" + score;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Statistics that = (Statistics) o;
        return score == that.score && Objects.equals(playerName, that.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, score);
    }
}

