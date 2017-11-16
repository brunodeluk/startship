package edu.austral.controller.InputController;

import edu.austral.model.Spaceship;

public class MoveUpCommand implements Command {

    @Override
    public void execute(Spaceship spaceship) {spaceship.moveUp();}
}
