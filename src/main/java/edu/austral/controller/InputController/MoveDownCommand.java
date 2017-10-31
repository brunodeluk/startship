package edu.austral.controller.InputController;

import edu.austral.model.Spaceship;

public class MoveDownCommand implements Command {

    @Override
    public void execute(Spaceship spaceship) {
        spaceship.moveDown();
    }
}
