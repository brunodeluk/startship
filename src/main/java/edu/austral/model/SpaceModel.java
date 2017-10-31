package edu.austral.model;

import edu.austral.util.Collisionable;
import edu.austral.util.Vector2;

import java.awt.Shape;
import java.awt.geom.AffineTransform;

public abstract class SpaceModel implements Model, Collisionable<SpaceModel> {

    public Vector2 position, direction;
    public float speed;

    private Shape shape;

    public void translateShape(Vector2 direction) {
        final AffineTransform transform = AffineTransform.getTranslateInstance(
                direction.x(), direction.y());
        shape = transform.createTransformedShape(shape).getBounds2D();
    }

    public boolean isOutOfBoundX() {
        return position.x() > GameSetup.WIDTH || position.x() < 0;
    }

    public boolean isOutOfBoundY() {
        return position.y() > GameSetup.HEIGHT || position.y() < 0;
    }

    public void setShape(Shape shape) {this.shape = shape;}

    @Override
    public abstract void collisionedWith(SpaceModel spaceModel);

    @Override
    public Shape getShape() { return this.shape; }
    public abstract void checkBounds();
    public abstract void collide(Asteroid asteroid);
    public abstract void collide(Bullet bullet);
    public abstract void collide(Weapon weapon);
    public abstract void collide(Spaceship spaceship);
    public abstract void iterate();

}
