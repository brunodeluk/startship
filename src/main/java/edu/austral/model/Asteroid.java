package edu.austral.model;

import edu.austral.util.Random;
import edu.austral.util.Vector2;

public class Asteroid extends SpaceModel {

    private int damage;

    public Asteroid(int score, int life, int damage) {
        super(score, life);
        this.damage = damage;
        setRandomPosition();
    }

    /**
     * Sets the Asteroid a random position, direction and speed;
     */

    private void setRandomPosition() {
        position = new Vector2(Random.random(0, GameSetup.WIDTH), Random.random(0, GameSetup.HEIGHT / 2));
        direction = new Vector2(Random.nextFloat(), Random.nextFloat()).unitary();
        speed = 1;
    }

    /**
     * Returns the Asteroids damage
     * @return damage
     */

    public int getDamage() {
        return damage;
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

    /**
     * Define method for colliding with another asteroid
     * @param asteroid
     */

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

        if (!isAlive()) {
            bullet.getPlayer().setScore(getScore());
            setActive(false);
        }
    }

    @Override
    public void collide(Weapon weapon) {

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

}
