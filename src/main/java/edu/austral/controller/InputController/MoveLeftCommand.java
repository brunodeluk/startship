package edu.austral.controller.InputController;

import edu.austral.model.Spaceship;

public class MoveLeftCommand implements Command {

    @Override
    public void execute(Spaceship spaceship) {
        spaceship.moveLeft();
    }
}
