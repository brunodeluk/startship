package edu.austral.view;

import edu.austral.model.GameSetup;
import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;

public class BasicWeaponView extends WeaponView {

    @Override
    public PImage loadImage(PApplet graphics) {
        String path = new File(GameSetup.WEAPON_BASIC).getAbsolutePath();
        return graphics.loadImage(path);
    }
}
