package edu.austral.controller.InputController;

import edu.austral.model.GameModel;
import edu.austral.model.Spaceship;
import edu.austral.view.GameView;

public interface Command {

    public void execute(Spaceship spaceship, GameView gameVie, GameModel gameModel);

}
