package edu.austral.view;

import edu.austral.model.SpaceModel;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public abstract class WeaponView implements DrawBehaviour {

    @Override
    public void draw(PApplet graphics, PImage image, SpaceModel model) {
        graphics.pushMatrix();
        graphics.imageMode(PConstants.CENTER);
        graphics.noTint();
        graphics.image(image, model.position.x(), model.position.y());
        graphics.popMatrix();
    }

    @Override
    public abstract  PImage loadImage(PApplet graphics);
}
