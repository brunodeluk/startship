package edu.austral.model;

import edu.austral.util.Vector2;
import edu.austral.view.GameView;

public class Spaceship extends SpaceModel {

    private float angle;
    private Player player;
    private Weapon weapon;

    public Spaceship() {
        position = new Vector2(100, 100);
        direction = new Vector2(0, -1);
        speed = 3f;
        angle = 0;
        setWeapon(new BasicWeapon(0, 2.5f));
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setAngle(float angle) {
        this.angle = angle;
    }
    public float getAngle() {
        return this.angle;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.weapon.setPlayer(this.player);
    }

    public void shoot(GameModel gameModel, GameView gameView) {
        this.weapon.shoot(gameModel, gameView, this.position, this.direction.rotate(angle));
    }

    @Override
    public void collisionedWith(SpaceModel spaceModel) {
        spaceModel.collide(this);
    }

    @Override
    public void checkBounds() {
        if (isOutOfBoundX()) teleportX();
        if (isOutOfBoundY()) teleportY();
    }

    @Override
    public void collide(Asteroid asteroid) {

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
    public void iterate() {

    }

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

    private void teleportX() {
        Vector2 vec = new Vector2(GameSetup.WIDTH ,0);
        if (position.x() < 0) {
            position = position.$plus(vec);
            translateShape(vec);
        } else {
            position = position.$plus(vec.rotate((float) Math.PI));
            translateShape(vec.rotate((float) Math.PI));
        }
    }

    private void teleportY() {
        Vector2 vec = new Vector2(0 , GameSetup.HEIGHT);
        if (position.y() < 0) {
            position = position.$plus(vec);
            translateShape(vec);
        } else {
            position = position.$plus(vec.rotate((float) Math.PI));
            translateShape(vec.rotate((float) Math.PI));
        }
    }
}
