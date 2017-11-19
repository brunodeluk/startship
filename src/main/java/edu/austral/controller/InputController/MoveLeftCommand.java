package edu.austral.controller.InputController;

import edu.austral.model.GameModel;
import edu.austral.model.Spaceship;
import edu.austral.view.GameView;

public class MoveLeftCommand implements Command {

    @Override
    public void execute(Spaceship spaceship) {
        spaceship.moveLeft();
    }
}
