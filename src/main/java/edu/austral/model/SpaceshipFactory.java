package edu.austral.model;

import edu.austral.view.GameView;
import edu.austral.view.SpaceView;
import edu.austral.view.SpaceshipView;

public class SpaceshipFactory implements SpaceFactory {

    @Override
    public void createSpaceModels(int i, GameModel gameModel, GameView gameView) {

    }

    @Override
    public void createSpaceModel(GameModel gameModel, GameView gameView) {
        SpaceModel spaceship = createSpaceModel();
        gameModel.addSpaceship(spaceship);
        SpaceView spaceView = new SpaceView(spaceship, new SpaceshipView());
        gameView.addView(spaceView);
    }

    @Override
    public SpaceModel createSpaceModel() {
        Player player = new Player();
        Spaceship spaceship = new Spaceship();
        spaceship.setPlayer(player);
        return spaceship;
    }
}
