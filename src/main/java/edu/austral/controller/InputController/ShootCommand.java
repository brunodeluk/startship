package edu.austral.controller.InputController;

import edu.austral.model.Spaceship;

public class ShootCommand implements Command {

    @Override
    public void execute(Spaceship spaceship) {
        spaceship.shoot();
    }
}
