package edu.austral.model;

import edu.austral.util.Collisionable;
import edu.austral.util.Vector2;

import java.awt.Shape;
import java.awt.geom.AffineTransform;

public abstract class SpaceModel implements Model, Collisionable<SpaceModel> {

    private boolean active = true;
    private Shape shape;
    private int score, life;

    public Vector2 position, direction;
    public float speed;

    public SpaceModel() {

    }

    public SpaceModel(int score, int life) {
        this.score = score;
        this.life = life;
    }

    /**
     * Retuns the score
     * @return score
     */

    public int getScore() {
        return score;
    }

    /**
     * Returns the life
     * @return life
     */

    public int getLife() {
        return life;
    }

    /**
     * Sets life
     * @param life
     */

    public void setLife(int life) {
        this.life = life;
    }

    /**
     * Method that subtracts life certain damage.
      * @param damage
     */

    public void takeLife(int damage) {
        life -= damage;
    }

    /**
     * Retuns true if the space model is alive
     * @return
     */

    public boolean isAlive() {
        return life > 0;
    }

    /**
     * Method that handles the trasportation of the shape
     * @param direction in which we are moving
     */

    public void translateShape(Vector2 direction) {
        final AffineTransform transform = AffineTransform
                .getTranslateInstance(direction.x(), direction.y());
        shape = transform.createTransformedShape(shape).getBounds2D();
    }

    /**
     * Return true if the model is out of bound in the X coordinate
     * @return boolean
     */

    public boolean isOutOfBoundX() {
        return position.x() > GameSetup.WIDTH || position.x() < 0;
    }

    /**
     * Returns true if the model is out of bound in the Y coordinate
     * @return boolean
     */

    public boolean isOutOfBoundY() {
        return position.y() > GameSetup.HEIGHT || position.y() < 0;
    }

    /**
     * Returns the state of the model
     * @return
     */

    public boolean isActive() {
        return active;
    }

    /**
     * Sets the state of the model
     * @param active
     */

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Implementation of the collisionedWith(). This method HAS to be
     * implemented by each of the sub classes. It uses polymorphism to
     * handle collisions with a space model
     * @param spaceModel
     */

    @Override
    public abstract void collisionedWith(SpaceModel spaceModel);

    /**
     * Sets the shape of the model
     * @param shape
     */

    public void setShape(Shape shape) {this.shape = shape;}

    /**
     * Returns the shape of the model
     * @return
     */

    @Override
    public Shape getShape() { return this.shape; }

    public abstract void checkBounds();

    /**
     * Abstract method for handling collisions with an Asteroid
     * @param asteroid
     */

    public abstract void collide(Asteroid asteroid);

    /**
     * Abstract method for handling collisions with a Bullet
     * @param bullet
     */


    public abstract void collide(Bullet bullet);

    /**
     * Abstract method for handling collisions with a weapon
     * @param weapon
     */

    public abstract void collide(Weapon weapon);

    /**
     * Abstract method for handling collisions with a Spaceship
     * @param spaceship
     */

    public abstract void collide(Spaceship spaceship);

    /**
     * Abstract method for handling each sub class iteration
     */

    public abstract void iterate();

}
