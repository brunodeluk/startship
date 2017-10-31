package edu.austral.controller.InputController;

import java.awt.event.KeyEvent;

public class InputHandler {

    private Command moveUp;
    private Command moveDown;
    private Command moveLeft;
    private Command moveRight;

    public InputHandler() {
        this.moveUp = new MoveUpCommand();
        this.moveDown = new MoveDownCommand();
        this.moveRight = new MoveRightCommand();
        this.moveLeft = new MoveLeftCommand();
    }

    public Command handleInput(boolean[] keys) {
        if (keys[KeyEvent.VK_UP]) return moveUp;
        if (keys[KeyEvent.VK_DOWN]) return moveDown;
        if (keys[KeyEvent.VK_LEFT]) return moveLeft;
        if (keys[KeyEvent.VK_RIGHT]) return moveRight;
        return null;
    }
}
