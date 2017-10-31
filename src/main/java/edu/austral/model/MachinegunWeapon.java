package edu.austral.model;

public class MachinegunWeapon extends Weapon {

    public MachinegunWeapon(Bullet bullet, int ammo, float fireRate) {
        super(bullet, ammo, fireRate);
    }

    /**
     * Beacuse this is a machine gun, and has bullets, we want to
     * check if we have ammo and if we can shoot. If so, we subtract 1
     * bullet and return true.
     * @return
     */

    @Override
    public boolean shoot() {
        if (hasAmmo() && canShoot()){
            unloadAmmo(1);
            return true;
        }
        return false;
    }
}
