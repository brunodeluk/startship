package edu.austral.view;

import edu.austral.model.SpaceModel;
import processing.core.PApplet;
import processing.core.PImage;

public interface DrawBehaviour {

    public void draw(PApplet graphics, PImage image, SpaceModel model);
    public PImage loadImage(PApplet graphics);
}
