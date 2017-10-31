package edu.austral.model;

public class Player {

    /**
     * We want to share the id tracker between each instance
     */

    private static int playerIdTracker = 0;
    private int id;
    private String name;
    private int score;

    public Player() {
        setIdAndName();
    }

    /**
     * Sets name of the player using the ID
     */

    private void setIdAndName() {
        id = ++playerIdTracker;
        name = "Player" + id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

}
