package edu.austral.controller.InputController;

import edu.austral.model.GameModel;
import edu.austral.model.Spaceship;
import edu.austral.view.GameView;

public class MoveDownCommand implements Command {

    @Override
    public void execute(Spaceship spaceship) {
        spaceship.moveDown();
    }
}
