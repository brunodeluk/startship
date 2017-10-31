package edu.austral.model;

import edu.austral.util.Random;
import edu.austral.util.Vector2;

public class Asteroid extends SpaceModel {

    public Asteroid() {
        setRandomPosition();
    }

    private void setRandomPosition() {
        position = new Vector2(Random.random(0, GameSetup.WIDTH), Random.random(0, GameSetup.HEIGHT));
        direction = new Vector2(Random.nextFloat(), Random.nextFloat());
        speed = 1;
    }

    @Override
    public void collisionedWith(SpaceModel spaceModel) {
        spaceModel.collide(this);
    }

    @Override
    public void checkBounds() {
        if (isOutOfBoundX() || isOutOfBoundY()) rotate();
    }

    @Override
    public void collide(Asteroid asteroid) {

    }

    @Override
    public void collide(Bullet bullet) {

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

    private void move() {
        position = position.$plus(direction);
    }

    private void rotate() {
        direction = direction.rotate((float) Math.PI / 2);
    }

}
