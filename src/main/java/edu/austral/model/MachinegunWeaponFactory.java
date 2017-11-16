package edu.austral.model;

import edu.austral.controller.GameController;
import edu.austral.util.Random;
import edu.austral.util.Vector2;
import edu.austral.view.MachinegunWeaponView;
import edu.austral.view.SpaceView;

public class MachinegunWeaponFactory implements SpaceFactory<Weapon> {

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
        SpaceView view = new SpaceView(weapon, new MachinegunWeaponView());
        gameController.getGameView().addView(view);
    }

    @Override
    public Weapon createSpaceModel() {
        return new MachinegunWeapon(new Bullet(10, 20), 100, 7.5f);
    }
}
