package edu.austral.view;

import edu.austral.model.GameSetup;
import edu.austral.model.SpaceModel;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

import java.io.File;

public class AsteroidView implements DrawBehaviour {

    @Override
    public void draw(PApplet graphics, PImage image, SpaceModel asteroid) {
        graphics.pushMatrix();
        graphics.imageMode(PConstants.CENTER);
        graphics.translate(asteroid.position.x(), asteroid.position.y());
        graphics.rotate(PApplet.radians(asteroid.position.module()));
        graphics.noTint();
        graphics.image(image, 0, 0);
        graphics.popMatrix();
        graphics.pushMatrix();
        graphics.text(asteroid.getLife(), asteroid.position.x(), asteroid.position.y() + 50);
        graphics.popMatrix();
    }

    @Override
    public PImage loadImage(PApplet graphics) {
        String path = new File(GameSetup.ASTEROID_URL).getAbsolutePath();
        PImage image = graphics.loadImage(path);
        image.resize(50, 50);
        return image;
    }
}
