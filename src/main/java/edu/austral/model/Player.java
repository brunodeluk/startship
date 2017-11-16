package edu.austral.model;

public class Player {

    /**
     * We want to share the id tracker between each instance
     */

    private static int playerIdTracker = 0;
    private int id;
    private int score;

    public Player() {
        setId();
    }

    /**
     * Sets name of the player using the ID
     */

    private void setId() {
        id = ++playerIdTracker;
    }

    public int getId() {
        return id;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

}
