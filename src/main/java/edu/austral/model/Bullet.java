package edu.austral.model;

public class Bullet extends SpaceModel {

    private int damage;
    private Player player;

    public Bullet(int damage, float speed) {
        this.speed = speed;
        this.damage = damage;
    }

    public Bullet(Bullet bullet) {
        this.damage = bullet.getDamage();
        this.speed = bullet.speed;
        this.player = bullet.player;
    }

    public int getDamage() {
        return damage;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void collisionedWith(SpaceModel spaceModel) {
        spaceModel.collide(this);
    }

    @Override
    public void checkBounds() {
        if (isOutOfBoundX() || isOutOfBoundY()) setActive(false);
    }

    /**
     * If we collide with an asteroid, we disappear from the view
     * @param asteroid
     */

    @Override
    public void collide(Asteroid asteroid) {
        setActive(false);
    }

    @Override
    public void collide(Bullet bullet) {

    }

    @Override
    public void collide(Weapon weapon) {

    }

    @Override
    public void collide(Star star) {

    }

    @Override
    public void collide(Spaceship spaceship) {

    }

    @Override
    public void iterate() {
        move();
        checkBounds();
        translateShape(direction.$times(speed));
    }

    /**
     * Method that defines how the bullets moves
     */

    private void move() {
        position = position.$plus(direction.$times(speed));
    }
}
