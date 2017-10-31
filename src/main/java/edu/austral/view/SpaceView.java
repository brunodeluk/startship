package edu.austral.view;

import edu.austral.model.SpaceModel;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.geom.Rectangle2D;

public class SpaceView implements View {

    private PImage image;
    private SpaceModel model;
    private DrawBehaviour drawBehaviour;

    public SpaceView(SpaceModel spaceModel, DrawBehaviour drawBehaviour) {
        this.model = spaceModel;
        this.drawBehaviour = drawBehaviour;
    }

    public void draw(PApplet graphics) {
        if (!hasImage()) setUpImageAndShape(graphics);
        drawBehaviour.draw(graphics, image, model);
    }

    private boolean hasImage() {
        return image != null;
    }

    private void setUpImageAndShape(PApplet graphics) {
        image = drawBehaviour.loadImage(graphics);
        model.setShape(new Rectangle2D.Float(model.position.x(), model.position.y(), image.width, image.height));
    }
}