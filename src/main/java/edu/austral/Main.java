package edu.austral;

import edu.austral.controller.GameController;
import processing.core.PApplet;
import processing.event.KeyEvent;

public class Main extends GameFramework {

    private GameController gameController;
    private boolean[] keys = new boolean[255];

    public static void main(String args[]) {
        PApplet.main("edu.austral.Main");
    }

    @Override
    public void setup() {
        super.setup();
        gameController = new GameController();
        gameController.setup();
    }

    @Override public void draw(float time, PApplet graphics) {
        gameController.draw(graphics);
        gameController.keyPressed(keys);
        gameController.iterate();
    }

    @Override public void keyPressed(KeyEvent event) {
        keys[event.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(processing.event.KeyEvent event) {
        super.keyReleased(event);
        keys[event.getKeyCode()] = false;
    }
}
