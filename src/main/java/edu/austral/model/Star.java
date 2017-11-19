package edu.austral.model;

public class Star extends SpaceModel {

    public Star(int score) {
        super(score, 1);
    }

    @Override
    public void collisionedWith(SpaceModel spaceModel) {
        spaceModel.collide(this);
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
        this.setActive(false);
    }

    @Override
    public void collide(Star star) {

    }

    @Override
    public void iterate() {

    }

    @Override
    public void checkBounds() {

    }
}
