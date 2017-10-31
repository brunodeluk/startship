package edu.austral.model;

import edu.austral.controller.GameController;
import edu.austral.view.BasicBulletView;
import edu.austral.view.SpaceView;

public class BulletFactory {

    /**
     * By having the spaceship, we can define a new bullet
     * and setting its position and direction relative to the spaceship. Then we use
     * the GameController to pass the bullet to the model and view.
     * @param gameController
     * @param spaceship
     */

    public void createBullet(GameController gameController, Spaceship spaceship) {
        Bullet bullet = new Bullet(spaceship.getWeapon().getBullet());
        bullet.position = spaceship.position;
        bullet.direction = spaceship.direction.rotate(spaceship.getAngle());
        gameController.getGameModel().addSpaceModel(bullet);
        SpaceView bulletView = new SpaceView(bullet, new BasicBulletView());
        gameController.getGameView().addView(bulletView);
    }

}
