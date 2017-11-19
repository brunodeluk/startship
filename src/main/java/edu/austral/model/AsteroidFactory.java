package edu.austral.model;

import edu.austral.controller.GameController;
import edu.austral.util.Random;
import edu.austral.view.AsteroidView;
import edu.austral.view.SpaceView;

public class AsteroidFactory implements SpaceFactory<Asteroid> {

    @Override
    public void createSpaceModels(int count, GameController gameController) {
        for (int i = 0; i < count; i++) createSpaceModel(gameController);
    }

    @Override
    public void createSpaceModel(GameController gameController) {
        Asteroid asteroid = createSpaceModel();
        asteroid.add(gameController);
        gameController.getGameModel().addSpaceModel(asteroid);
        SpaceView spaceView = new SpaceView(asteroid, new AsteroidView());
        gameController.getGameView().addView(spaceView);
    }

    @Override
    public Asteroid createSpaceModel() {
        return new Asteroid(Random.random(50, 100));
    }
}
