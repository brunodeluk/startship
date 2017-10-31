package edu.austral.model;

public class BasicWeapon extends Weapon {

    public BasicWeapon(Bullet bullet, int ammo, float fireRate) {
        super(bullet, ammo, fireRate);
    }

    /**
     * Override of parent. Because this is the basic weapon and we have infinite
     * amount of bullets, we only want to return is we can shoot.
     * @return can shoot
     */

    @Override
    public boolean shoot() {
        return canShoot();
    }
}
