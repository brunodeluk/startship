package edu.austral.model;

public class Bullet extends SpaceModel {

    private int damage;
    private Player player;

    public Bullet(int damage) {
        this.damage = damage;
        speed = 10;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void collisionedWith(SpaceModel spaceModel) {

    }

    @Override
    public void checkBounds() {
        if (isOutOfBoundY() || isOutOfBoundX()) active = false;
    }

    @Override
    public void collide(Asteroid asteroid) {
        System.out.println("pepi");
    }

    @Override
    public void collide(Bullet bullet) {

    }

    @Override
    public void collide(Weapon weapon) {

    }

    @Override
    public void collide(Spaceship spaceship) {

    }

    @Override
    public void iterate() {
        move();
        translateShape(direction);
        checkBounds();
    }

    private void move() {
        position = position.$plus(direction.$times(speed));
    }
}
