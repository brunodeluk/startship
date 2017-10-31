package edu.austral.model;

import edu.austral.util.Vector2;
import edu.austral.view.BasicBulletView;
import edu.austral.view.GameView;
import edu.austral.view.SpaceView;

public class BasicWeapon extends Weapon {

    public BasicWeapon(int ammo, float fireRate) {
        super(ammo, fireRate);
    }

    @Override
    public void shoot(GameModel model, GameView gameView, Vector2 position, Vector2 direction) {
        if (canShoot()) createBullet(model, gameView, position, direction);
    }

    private void createBullet(GameModel gameModel, GameView gameView, Vector2 position, Vector2 direction) {
        Bullet bullet = new Bullet(10);
        bullet.setPlayer(getPlayer());
        bullet.position = position;
        bullet.direction = direction;
        gameModel.addSpaceModel(bullet);
        SpaceView view = new SpaceView(bullet, new BasicBulletView());
        gameView.addView(view);
    }
}
