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

    public GameController(PApplet applet) {
        this.gameModel = new GameModel();
        this.gameView = new GameView(applet);
        this.inputHandler = new InputHandler();
    }

    public void setup() {
        spawnAsteroids(2);
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
        clearDeadModels();
    }

    private void clearDeadModels() {
        gameView.clearDeadViews();
        gameModel.clearDeadModels();
    }

    public void checkCollisions() {
        this.gameModel.checkCollisions();
    }

    public void keyPressed(boolean[] keys) {
        gameModel.keyPressed(keys, inputHandler, gameView);
    }

    public void draw() {
        this.gameView.draw();
    }

}
