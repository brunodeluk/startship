package edu.austral.model;

import edu.austral.controller.GameController;

public interface SpaceFactory<T extends SpaceModel> {
    public void createSpaceModels(int i, GameController gameController);
    public void createSpaceModel(GameController gameController);
    public T createSpaceModel();
}
