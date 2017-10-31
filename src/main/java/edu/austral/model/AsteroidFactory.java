package edu.austral.model;

import edu.austral.view.AsteroidView;
import edu.austral.view.GameView;
import edu.austral.view.SpaceView;

public class AsteroidFactory implements SpaceFactory {

    @Override
    public void createSpaceModels(int count, GameModel gameModel, GameView gameView) {
        for (int i = 0; i < count; i++) createSpaceModel(gameModel, gameView);
    }

    @Override
    public void createSpaceModel(GameModel gameModel, GameView gameView) {
        SpaceModel asteroid = createSpaceModel();
        gameModel.addSpaceModel(asteroid);
        SpaceView spaceView = new SpaceView(asteroid, new AsteroidView());
        gameView.addView(spaceView);
    }

    @Override
    public SpaceModel createSpaceModel() {
        return new Asteroid();
    }
}
