package edu.austral.controller.InputController;

import java.awt.event.KeyEvent;

/**
 * Main class that handles every input of the game.
 * We use the Commander Design Pattern
 */

public class InputHandler {

    private Command moveUp;
    private Command moveDown;
    private Command moveLeft;
    private Command moveRight;
    private Command shoot;

    public InputHandler() {
        this.moveUp = new MoveUpCommand();
        this.moveDown = new MoveDownCommand();
        this.moveRight = new MoveRightCommand();
        this.moveLeft = new MoveLeftCommand();
        this.shoot = new ShootCommand();
    }

    /**
     * We receive an array of keys and return the respective command
     * @param keys array of keys
     * @return command
     */

    public Command handleInput(boolean[] keys) {
        if (keys[KeyEvent.VK_UP]) return moveUp;
        if (keys[KeyEvent.VK_DOWN]) return moveDown;
        if (keys[KeyEvent.VK_LEFT]) return moveLeft;
        if (keys[KeyEvent.VK_RIGHT]) return moveRight;
        if (keys[KeyEvent.VK_SPACE]) return shoot;
        return null;
    }
}
