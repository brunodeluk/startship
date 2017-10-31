package edu.austral.model;

import edu.austral.controller.GameController;
import edu.austral.view.GameView;
import edu.austral.view.SpaceView;
import edu.austral.view.SpaceshipView;

public class SpaceshipFactory implements SpaceFactory<Spaceship> {

    @Override
    public void createSpaceModels(int i, GameController gameController) {

    }

    @Override
    public void createSpaceModel(GameController gameController) {
        Spaceship spaceship = createSpaceModel();
        spaceship.add(gameController);
        gameController.getGameModel().addSpaceship(spaceship);
        SpaceView spaceView = new SpaceView(spaceship, new SpaceshipView());
        gameController.getGameView().addView(spaceView);
    }

    @Override
    public Spaceship createSpaceModel() {
        Player player = new Player();
        Spaceship spaceship = new Spaceship(500);
        spaceship.setPlayer(player);
        spaceship.setWeapon(new BasicWeapon(
                new Bullet(10, 15),
                1,
                5f));
        return spaceship;
    }
}
