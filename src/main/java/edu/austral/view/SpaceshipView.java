package edu.austral.view;

import edu.austral.model.GameSetup;
import edu.austral.model.SpaceModel;
import edu.austral.model.Spaceship;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

import java.io.File;

public class SpaceshipView implements DrawBehaviour {

    @Override
    public void draw(PApplet graphics, PImage image, SpaceModel model) {
        graphics.pushMatrix();
        graphics.imageMode(PConstants.CENTER);
        graphics.translate(model.position.x(), model.position.y());
        graphics.rotate(((Spaceship) model).getAngle());
        graphics.image(image, 0, 0);
        graphics.popMatrix();
//        graphics.rect(
//                model.getShape().getBounds().x,
//                model.getShape().getBounds().y,
//                model.getShape().getBounds().height,
//                model.getShape().getBounds().width);
    }

    @Override
    public PImage loadImage(PApplet graphics) {
        String path = new File(GameSetup.SPACESHIP_URL).getAbsolutePath();
        PImage image = graphics.loadImage(path);
        image.resize(50, 50);
        return image;
    }
}
