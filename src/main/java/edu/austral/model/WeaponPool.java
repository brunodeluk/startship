package edu.austral.model;

import edu.austral.controller.GameController;
import edu.austral.util.Random;

import java.util.LinkedList;
import java.util.List;

/**
 * This class is a pool in which we have a collection of
 * weapons and every 20 seconds we generate a new weapon
 */

public class WeaponPool {

    /**
     * Hold every weapon in the game
     */

    private List<SpaceFactory<Weapon>> weapons;

    /**
     * Last time we generated a random weapon
     */

    private long lastTimeCreated = System.nanoTime();

    public WeaponPool() {
        this.weapons = new LinkedList<>();
        registerWeapons();
    }

    /**
     * We register every weapon in the game. Or at least
     * the once we want the pool to generate
     */

    private void registerWeapons() {
        this.weapons.add(new BasicWeaponFactory());
        this.weapons.add(new MachinegunWeaponFactory());
    }

    /***
     * Every 20 seconds we generate a random Weapon
     * @param gameController used to set the weapon on the game
     */

    public void generateRandomWeapon(GameController gameController) {
        long diff = System.nanoTime() - lastTimeCreated;
        long time = diff / 1000000;
        if (time > 20000) {
            lastTimeCreated = System.nanoTime();
            weapons.get(Random.random(0, weapons.size())).createSpaceModel(gameController);
        }
    }



}
