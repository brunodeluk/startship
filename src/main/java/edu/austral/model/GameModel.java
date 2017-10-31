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

    /**
     * Adds any SpaceModel into the list
     * @param model
     */

    public void addSpaceModel(SpaceModel model) {
        this.spaceModels.add(model);
    }

    /**
     * Adds a new Spaceship into the list
     * @param spaceship
     */

    public void addSpaceship(SpaceModel spaceship) {
        this.spaceships.add(spaceship);
    }

    /**
     * Loops over the spaceModel's list and calls each one to iterate
     */

    public void iterate() {
        spaceModels.forEach(SpaceModel::iterate);
    }

    /**
     * For every iteration, we want to filter the models that are still active
     */

    public void removeDeadModels() {
        spaceModels = spaceModels.stream().filter(SpaceModel::isActive).collect(Collectors.toList());
    }

    /**
     * Loops over the main list and checks for collisions
     */

    public void checkCollisions() {
        collisionEngine.checkCollisions(JavaConverters.asScalaBuffer(
                Stream.of(spaceModels, spaceships).flatMap(List::stream).collect(Collectors.toList())));
    }

    /**
     * If there was a key pressed, we want to loop over the spaceship's list
     * and call for each of the spaceships commands.
     * @param keys array of keys
     * @param inputHandler to handle input events
     */

    public void keyPressed(boolean[] keys, InputHandler inputHandler) {
        spaceships.forEach(spaceship -> {
            Command command = inputHandler.handleInput(keys);
            if (command != null) command.execute((Spaceship) spaceship);
        });
    }
}
