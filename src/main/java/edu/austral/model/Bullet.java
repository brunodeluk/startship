package edu.austral.model;

public class Bullet extends SpaceModel {

    @Override
    public void collisionedWith(SpaceModel spaceModel) {
        spaceModel.collide(this);
    }

    @Override
    public void checkBounds() {

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

    }

    @Override
    public void iterate() {

    }
}
