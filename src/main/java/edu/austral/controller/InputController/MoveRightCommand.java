package edu.austral.controller.InputController;

import edu.austral.model.Spaceship;

public class MoveRightCommand implements Command {

    @Override
    public void execute(Spaceship spaceship) {
        spaceship.moveRight();
    }
}
