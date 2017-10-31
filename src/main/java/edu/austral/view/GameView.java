package edu.austral.view;

import processing.core.PApplet;

import java.util.LinkedList;
import java.util.List;

public class GameView {

    private List<SpaceView> views;

    public GameView() {
        this.views = new LinkedList<SpaceView>();
    }

    public void addView(SpaceView view) {
        this.views.add(view);
    }

    public void removeView(SpaceView view) {
        views.remove(view);
    }

    public void draw(PApplet graphics) {
        views.forEach(view -> view.draw(graphics));
    }
}
