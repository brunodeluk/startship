package edu.austral.model;

import edu.austral.util.Vector2;
import edu.austral.view.GameView;

public abstract class Weapon extends SpaceModel {

    private int ammo;
    private float fireRate;
    private Player player;
    private long lastTimeShoot = System.nanoTime();

    public Weapon(int ammo, float fireRate) {
        this.ammo = ammo;
        this.fireRate = fireRate;
    }

    public abstract void shoot(GameModel model, GameView gameView, Vector2 position, Vector2 direction);

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    protected boolean canShoot() {
        float diff = System.nanoTime() - lastTimeShoot;
        float time = 1000000000/fireRate;
        if (diff > time) {
            lastTimeShoot = System.nanoTime();
            return true;
        }

        return false;
    }

    protected boolean hasAmmo() {
        return ammo > 0;
    }

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
