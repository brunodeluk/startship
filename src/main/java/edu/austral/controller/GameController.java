package edu.austral.controller;

import edu.austral.controller.InputController.InputHandler;
import edu.austral.model.*;
import edu.austral.view.GameView;
import edu.austral.view.SpaceView;
import edu.austral.view.StarView;
import processing.core.PApplet;

public class GameController implements Controller, Observer {

    private GameModel gameModel;
    private GameView gameView;
    private WeaponPool weaponPool;
    private BulletFactory bulletFactory;
    private InputHandler inputHandler;

    public GameController(PApplet graphics) {
        this.gameModel      = new GameModel();
        this.gameView       = new GameView(graphics);
        this.inputHandler   = new InputHandler();
        this.weaponPool     = new WeaponPool();
        this.bulletFactory  = new BulletFactory();
    }

    /**
     * Sets up Asteroids and Spaceships in game
     */

    public void setup() {
        spawnAsteroids();
        spawnSpaceship();
    }

    /**
     * We use a factory that generates new Asteroids. We pass THIS controllers so that
     * the factory can assign the new model to the game model and the view to the game view
     */

    public void spawnAsteroids() {
        AsteroidFactory asteroidFactory = new AsteroidFactory();
        asteroidFactory.createSpaceModels(GameSetup.ASTEROIDS, this);
    }

    /**
     * Using a spceship factory we can generate new Spaceships
     */

    public void spawnSpaceship() {
        SpaceshipFactory spaceshipFactory = new SpaceshipFactory();
        spaceshipFactory.createSpaceModel(this);
    }

    /**
     * Like the other factories, it generates new bullets and assigns them to
     * its respective game model and view
     * @param spaceship used to get useful properties
     */

    public void newBullet(Spaceship spaceship) {
        bulletFactory.createBullet(this, spaceship);
    }

    /**
     * Spawns random Weapon model into the view
     */

    public void spawnWeapons() {
        this.weaponPool.generateRandomWeapon(this);
    }

    public void newStar(Asteroid asteroid) {
        Star star = new Star(1000);
        star.position = asteroid.position;
        gameModel.addSpaceModel(star);
        gameView.addView(new SpaceView(star, new StarView()));
    }

    public void iterate() {
        gameModel.iterate();
        spawnWeapons();
        checkCollisions();
        removeDeadModels();
    }

    /**
     * For every iteration we check if there is an inactive model in the array. If so, we
     * remove it.
     */

    private void removeDeadModels() {
        this.gameModel.removeDeadModels();
        this.gameView.removeDeadViews();
    }

    /**
     * Main method for checking collisions
     */

    public void checkCollisions() {
        this.gameModel.checkCollisions();
    }

    /**
     * Handles key events by passing and array of boolean where each position represents
     * the key value
     * @param keys keys
     */

    public void keyPressed(boolean[] keys) {
        gameModel.keyPressed(keys, inputHandler);
    }

    /**
     * Calls game view to render each model
     */

    public void draw() {
        this.gameView.draw();
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public GameView getGameView() {
        return gameView;
    }

    /**
     * Observable pattern implementation to update the game every time a spaceship
     * fires a bullet
     * @param spaceship that fired the bullet
     */

    @Override
    public void spawnBullet(Spaceship spaceship) {
        newBullet(spaceship);
    }

    @Override
    public void spawnStar(Asteroid asteroid) {
        newStar(asteroid);
    }

    @Override
    public void update() {
        this.endGame();
    }

    private void endGame() {
        gameView.stopRender();
    }
}
