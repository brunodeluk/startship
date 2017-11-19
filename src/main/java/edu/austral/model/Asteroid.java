package edu.austral.model;

import edu.austral.util.Random;
import edu.austral.util.Vector2;

import java.util.LinkedList;
import java.util.List;

public class Asteroid extends SpaceModel implements Observable{

    private int damage;
    private int size;

    private List<Observer> observers;

    public Asteroid(int life) {
        super((life*3)/2, life);
        this.damage = life / 2;
        this.size = (3*life) / 4;
        this.observers = new LinkedList<>();
        setRandomPosition();
    }

    /**
     * Sets the Asteroid a random position, direction and speed;
     */

    private void setRandomPosition() {
        position = new Vector2(Random.random(0, GameSetup.WIDTH), Random.random(0, GameSetup.HEIGHT / 2));
        direction = new Vector2(Random.nextFloat(), Random.nextFloat()).unitary();
        speed = Random.nextFloat() * 2;
    }

    /**
     * Returns the Asteroids damage
     * @return damage
     */

    public int getDamage() {
        return this.damage;
    }

    private void reduceDamage(int amount) {
        this.damage -= amount;
    }

    public int getSize() {
        return this.size;
    }

    private void reduceSize(int amount) {
        this.size -= amount;
    }

    /**
     * Implementation of the parents collisionedWith()
     * @param spaceModel spaceModel we collided with
     */

    @Override
    public void collisionedWith(SpaceModel spaceModel) {
        spaceModel.collide(this);
    }

    /**
     * Implementation of parents checkBounds. If we are out of bound, we want to rotate
     * the Asteroid
     */

    @Override
    public void checkBounds() {
        if (isOutOfBoundX() || isOutOfBoundY()) rotate();
    }

    @Override
    public void collide(Asteroid asteroid) { }

    /**
     *  If we collide with a bullet, we take the damage received and ask if
     *  we are still alive. If not, we set the bullets player our score and
     *  disappear from the view.
     * @param bullet
     */

    @Override
    public void collide(Bullet bullet) {
        takeLife(bullet.getDamage());
        reduceSize((bullet.getDamage()) / 4);
        reduceDamage((bullet.getDamage()) / 4);
        if (!isAlive()) {
            bullet.getPlayer().setScore(getScore());
            if (getScore() > 140) notifyObservers();
            setActive(false);
        }
    }

    @Override
    public void collide(Weapon weapon) {

    }

    @Override
    public void collide(Star star) {

    }

    @Override
    public void collide(Spaceship spaceship) {
        rotate();
    }

    @Override
    public void iterate() {
        move();
        translateShape(direction);
        checkBounds();
    }

    /**
     * Method that defines how the Asteroid moves
     */

    private void move() {
        position = position.$plus(direction);
    }

    /**
     * Rotates the Asteroid 90 deg
     */

    private void rotate() {
        direction = direction.rotate((float) Math.PI / 2);
    }

    @Override
    public void add(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void spawnBullet() {

    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.spawnStar(this));
    }
}
