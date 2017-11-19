package edu.austral.view;

import edu.austral.model.GameSetup;
import edu.austral.model.SpaceModel;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

import java.io.File;

public class StarView implements DrawBehaviour {

    @Override
    public void draw(PApplet graphics, PImage image, SpaceModel model) {
        graphics.pushMatrix();
        graphics.imageMode(PConstants.CENTER);
        graphics.translate(model.position.x(), model.position.y());
        graphics.noTint();
        graphics.image(image, 0, 0);
        graphics.popMatrix();
    }

    @Override
    public PImage loadImage(PApplet graphics) {
        String path = new File(GameSetup.STAR).getAbsolutePath();
        return graphics.loadImage(path);
    }
}
