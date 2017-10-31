package edu.austral.view;

import edu.austral.model.SpaceModel;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.geom.Rectangle2D;

/**
 * Class for handling the model's view. In this implementation
 * of MVC, the View knows the Model.
 *
 * We use the Strategy Design Pattern to handle drawing behaviours
 */

public class SpaceView implements View {

    private PImage image;
    private SpaceModel model;
    private DrawBehaviour drawBehaviour;

    public SpaceView(SpaceModel spaceModel, DrawBehaviour drawBehaviour) {
        this.model = spaceModel;
        this.drawBehaviour = drawBehaviour;
    }

    /**
     * Returns the model
     * @return model
     */

    public SpaceModel getModel() {
        return model;
    }

    /**
     * Method that calls the respective draw behaviour which
     * really knows how to draw the model
     * @param graphics
     */

    public void draw(PApplet graphics) {
        drawBehaviour.draw(graphics, image, model);
    }

    /**
     * Sets a new Shape relative to the image dimensions
     * @param graphics
     */

    public void setUpImageAndShape(PApplet graphics) {
        image = drawBehaviour.loadImage(graphics);
        model.setShape(new Rectangle2D.Float(model.position.x(), model.position.y(), image.width, image.height));
    }
}
