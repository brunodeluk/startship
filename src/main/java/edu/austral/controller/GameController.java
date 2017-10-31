package edu.austral.controller;

import edu.austral.controller.InputController.InputHandler;
import edu.austral.model.AsteroidFactory;
import edu.austral.model.GameModel;
import edu.austral.model.SpaceshipFactory;
import edu.austral.view.GameView;
import processing.core.PApplet;

public class GameController implements Controller {

    private GameModel gameModel;
    private GameView gameView;
    private InputHandler inputHandler;

    public GameController() {
        this.gameModel = new GameModel();
        this.gameView = new GameView();
        this.inputHandler = new InputHandler();
    }

    public void setup() {
        spawnAsteroids(20);
        spawnSpaceship();
    }

    public void spawnAsteroids(int asteroids) {
        AsteroidFactory asteroidFactory = new AsteroidFactory();
        asteroidFactory.createSpaceModels(asteroids, gameModel, gameView);
    }

    public void spawnSpaceship() {
        SpaceshipFactory spaceshipFactory = new SpaceshipFactory();
        spaceshipFactory.createSpaceModel(gameModel, gameView);
    }

    public void iterate() {
        gameModel.iterate();
        checkCollisions();
    }

    public void checkCollisions() {
        this.gameModel.checkCollisions();
    }

    public void keyPressed(boolean[] keys) {
        gameModel.keyPressed(keys, inputHandler);
    }

    public void draw(PApplet graphics) {
        this.gameView.draw(graphics);
    }

}
