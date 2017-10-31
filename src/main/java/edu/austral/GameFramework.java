package edu.austral;

import edu.austral.model.GameSetup;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.io.File;


public abstract class GameFramework extends PApplet {

    @Override public void settings() {
        size(GameSetup.WIDTH, GameSetup.HEIGHT);
    }

    @Override public void setup() {
        clear();
    }

    @Override public void draw() {
        clear();
        draw((frameRate / 60) * 100, this);
    }


    public abstract void draw(float time, PApplet graphics);

    public abstract void keyPressed(KeyEvent event);

}
