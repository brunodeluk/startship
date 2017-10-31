package edu.austral.model;

public class Player {

    private static int playerIdTracker = 0;
    private int id;
    private String name;
    private int score;

    public Player() {
        setIdAndName();
    }

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
        this.score = score;
    }

    public int getScore() {
        return score;
    }

}
