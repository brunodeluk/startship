package edu.austral.view;

import processing.core.PApplet;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GameView {

    private PApplet graphics;
    private List<SpaceView> views;

    public GameView(PApplet graphics) {
        this.views = new LinkedList<SpaceView>();
        this.graphics = graphics;
    }

    public void setupShapes() {
        views.forEach(view -> view.setupImageAndShape(graphics));
    }

    public void addView(SpaceView view) {
        view.setupImageAndShape(graphics);
        this.views.add(view);
    }

    public void removeView(SpaceView view) {
        views.remove(view);
    }

    public void draw() {
        views.forEach(view -> view.draw(graphics));
    }

    public void clearDeadViews() {
        views = views.stream()
                .filter(SpaceView::isActive)
                .collect(Collectors.toList());
    }
}
