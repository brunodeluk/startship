package edu.austral.model;

public interface Observable {

    public void add(Observer observer);
    public void remove(Observer observer);
    public void spawnBullet();
    public void notifyObservers();
}
