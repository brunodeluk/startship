package edu.austral.view;

import edu.austral.model.GameSetup;
import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;

public class MachinegunBulletView extends BulletView {

    @Override
    public PImage loadImage(PApplet graphics) {
        String path = new File(GameSetup.GREEN_LASER_URL).getAbsolutePath();
        return graphics.loadImage(path);
    }
}
