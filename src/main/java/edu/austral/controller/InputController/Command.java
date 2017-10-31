package edu.austral.controller.InputController;

import edu.austral.model.Spaceship;

public interface Command {

    public void execute(Spaceship spaceship);

}
