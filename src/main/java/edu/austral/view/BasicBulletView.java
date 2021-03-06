package edu.austral.view;

import edu.austral.model.GameSetup;
import edu.austral.model.SpaceModel;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

import java.io.File;

public class BasicBulletView extends BulletView {

    @Override
    public PImage loadImage(PApplet graphics) {
        String path = new File(GameSetup.LASER_URL).getAbsolutePath();
        return graphics.loadImage(path);
    }
}
