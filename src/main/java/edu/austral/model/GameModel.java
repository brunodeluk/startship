package edu.austral.model;

import edu.austral.controller.InputController.Command;
import edu.austral.controller.InputController.InputHandler;
import edu.austral.util.CollisionEngine;
import scala.collection.JavaConverters;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameModel {

    private List<SpaceModel> spaceModels, spaceships;
    private CollisionEngine<SpaceModel> collisionEngine;

    public GameModel() {
        this.spaceModels = new LinkedList<SpaceModel>();
        this.spaceships = new LinkedList<SpaceModel>();
        this.collisionEngine = new CollisionEngine<SpaceModel>();
    }

    public void addSpaceModel(SpaceModel model) {
        this.spaceModels.add(model);
    }

    public void addSpaceship(SpaceModel spaceship) {
        this.spaceships.add(spaceship);
    }

    public void removeModel(SpaceModel model) {
        this.spaceModels.remove(model);
    }

    public void iterate() {
        spaceModels.forEach(SpaceModel::iterate);
    }

    public void checkCollisions() {
        collisionEngine.checkCollisions(JavaConverters.asScalaBuffer(
                Stream.of(spaceModels, spaceships).flatMap(List::stream).collect(Collectors.toList())));
    }

    public void keyPressed(boolean[] keys, InputHandler inputHandler) {
        spaceships.forEach(spaceship -> {
            Command command = inputHandler.handleInput(keys);
            if (command != null) command.execute((Spaceship) spaceship);
        });
    }
}
