package edu.austral.view;

import edu.austral.model.SpaceModel;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public abstract class BulletView implements DrawBehaviour {

    @Override
    public void draw(PApplet graphics, PImage image, SpaceModel model) {
        graphics.pushMatrix();
        graphics.imageMode(PConstants.CENTER);
        graphics.translate(model.position.x(), model.position.y());
        graphics.rotate(model.direction.angle() + (float) Math.PI/2);
        graphics.noTint();
        graphics.image(image, 0, 0);
        graphics.popMatrix();
    }

    @Override
    public abstract PImage loadImage(PApplet graphics);
}
