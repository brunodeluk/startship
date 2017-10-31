package edu.austral;

import edu.austral.controller.GameController;
import edu.austral.model.GameSetup;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.io.File;

public class Main extends GameFramework {

    private GameController gameController;
    private boolean[] keys = new boolean[255];
    PImage background;

    public static void main(String args[]) {
        PApplet.main("edu.austral.Main");
    }

    @Override
    public void setup() {
        super.setup();
        background = loadImage(new File(GameSetup.BACKGROUND).getAbsolutePath());
        background.resize(GameSetup.WIDTH, GameSetup.HEIGHT);
        gameController = new GameController(this);
        gameController.setup();
    }

    @Override public void draw(float time, PApplet graphics) {
        background(background);
        gameController.draw();
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
