package edu.austral.view;

import edu.austral.model.GameSetup;
import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;

public class MachinegunWeaponView extends WeaponView {

    @Override
    public PImage loadImage(PApplet graphics) {
        String path = new File(GameSetup.WEAPON_MACHINEGUN).getAbsolutePath();
        return graphics.loadImage(path);
    }

}
