package edu.austral.view;

import edu.austral.model.GameSetup;
import processing.core.PApplet;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Main View class for handling the game Views.
 */

public class GameView {

    private List<SpaceView> views;
    private PApplet graphics;

    public GameView(PApplet graphics) {
        this.graphics = graphics;
        this.views = new LinkedList<SpaceView>();
    }

    /**
     * Creates the shape of the model and add's it to the list
     * @param view
     */

    public void addView(SpaceView view) {
        view.setUpImageAndShape(graphics);
        this.views.add(view);
    }

    /**
     * For every iteration we want to filter the views that have an active model
     */

    public void removeDeadViews() {
        views = views.stream().filter(v -> v.getModel().isActive()).collect(Collectors.toList());
    }

    /**
     * Loops every view and calls for the method Draw()
     */

    public void draw() {
        views.forEach(view -> view.draw(graphics));
    }

    public void stopRender() {
        this.graphics.stop();
        this.graphics.delay(2000);
        this.graphics.clear();
        this.graphics.textSize(32);
        this.graphics.text("GAME OVER", (GameSetup.WIDTH / 2) - 20, GameSetup.HEIGHT / 2);
        this.graphics.fill(0, 102, 153);
    }
}
