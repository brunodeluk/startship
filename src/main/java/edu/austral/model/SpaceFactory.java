package edu.austral.model;

import edu.austral.view.GameView;

public interface SpaceFactory {
    public void createSpaceModels(int i, GameModel gameModel, GameView gameView);
    public void createSpaceModel(GameModel gameModel, GameView gameView);
    public SpaceModel createSpaceModel();
}
