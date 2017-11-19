package edu.austral.model;

import edu.austral.util.Vector2;

import java.util.LinkedList;
import java.util.List;

public class Spaceship extends SpaceModel implements Observable {

    private float angle;
    private Player player;
    private Weapon weapon;

    private List<Observer> observers;

    public Spaceship(int life) {
        this.observers = new LinkedList<>();
        position = new Vector2(GameSetup.WIDTH / 2, 2*GameSetup.HEIGHT / 3);
        direction = new Vector2(0, -1);
        speed = 3f;
        angle = 0;
        setLife(life);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getAngle() {
        return this.angle;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.weapon.setPlayer(player);
    }

    public void shoot() {
        if (hasWeapon() && weapon.shoot()) spawnBullet();
    }

    private boolean hasWeapon() {
        return weapon != null;
    }

    @Override
    public void collisionedWith(SpaceModel spaceModel) {
        spaceModel.collide(this);
    }

    @Override
    public void checkBounds() {}

    @Override
    public void collide(Asteroid asteroid) {
        takeLife(asteroid.getDamage());
        if (!isAlive()) notifyObservers();
    }

    @Override
    public void collide(Bullet bullet) {

    }

    @Override
    public void collide(Weapon weapon) {
        setWeapon(weapon);
    }

    @Override
    public void collide(Spaceship spaceship) {

    }

    @Override
    public void collide(Star star) {
        this.getPlayer().setScore(star.getScore());
    }

    @Override
    public void iterate() {

    }

    /**
     * Methods that define the movement of the spaceship
     */

    public void moveUp() {
        move(0);
    }
    public void moveDown() {
        move((float) Math.PI);
    }
    public void moveLeft() {
        move(((float)(Math.PI / 2) * 3));
    }
    public void moveRight() {
        move((float)Math.PI / 2);
    }

    private void move(float angle) {
        position = position.$plus(direction.$times(speed).rotate(angle));
        setAngle(angle);
        translateShape(direction.$times(speed).rotate(angle));
        checkBounds();
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void spawnBullet() {
        observers.forEach(o -> o.spawnBullet(this));
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}
