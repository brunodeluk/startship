package edu.austral.model;

import edu.austral.controller.GameController;
import edu.austral.util.Random;
import edu.austral.util.Vector2;
import edu.austral.view.BasicWeaponView;
import edu.austral.view.SpaceView;

public class BasicWeaponFactory implements SpaceFactory<Weapon> {

    @Override
    public void createSpaceModels(int i, GameController gameController) {

    }

    @Override
    public void createSpaceModel(GameController gameController) {
        Weapon weapon = createSpaceModel();
        weapon.position = new Vector2(
                Random.random(0, GameSetup.WIDTH),
                Random.random(0, GameSetup.HEIGHT));
        gameController.getGameModel().addSpaceModel(weapon);
        SpaceView view = new SpaceView(weapon, new BasicWeaponView());
        gameController.getGameView().addView(view);
    }

    @Override
    public Weapon createSpaceModel() {
        return new BasicWeapon(new Bullet(10, 15), 1, 5f);
    }
}
