package edu.austral.model;

public abstract class Weapon extends SpaceModel {

    private int ammo;
    private Bullet bullet;
    private float fireRate;

    /**
     * Last time we shot
     */

    private long lastShootingTime = System.nanoTime();

    public Weapon(Bullet bullet, int ammo, float fireRate) {
        this.bullet = bullet;
        this.ammo = ammo;
        this.fireRate = fireRate;
    }

    /**
     * Abstract method for defining the way each sub Weapon will shoot
     * @return shoot
     */

    public abstract boolean shoot();

    public void setPlayer(Player player) {
        this.bullet.setPlayer(player);
    }

    /**
     * It handles the frequency in which we want to shoot a new bullet
     * @return if we can shoot
     */

    public boolean canShoot() {
        float diff = System.nanoTime() - lastShootingTime;
        float time = 1000000000/fireRate;
        if (diff > time) {
            lastShootingTime = System.nanoTime();
            return true;
        }

        return false;
    }

    /**
     * Retusn true if we have ammo
     * @return ammo
     */

    public boolean hasAmmo() {
        return ammo > 0;
    }

    /**
     * Returns bullet type
     * @return Bullet
     */

    public Bullet getBullet() {
        return bullet;
    }

    /**
     * We subtract the weapon some number
     * @param amount
     */

    public void unloadAmmo(int amount) {
        ammo -= amount;
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
    public void collide(Star star) {

    }

    /**
     * If we collide with a spaceship we only want to disappear
     * @param spaceship
     */

    @Override
    public void collide(Spaceship spaceship) {
        setActive(false);
    }

    @Override
    public void iterate() {

    }
}
