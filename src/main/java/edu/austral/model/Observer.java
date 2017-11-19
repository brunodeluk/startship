package edu.austral.model;

public interface Observer {

    public void spawnBullet(Spaceship spaceship);
    public void spawnStar(Asteroid asteroid);
    public void update();
}
