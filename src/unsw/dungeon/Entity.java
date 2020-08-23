package unsw.dungeon;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * An entity in the dungeon.
 * 
 * @author Robert Clifton-Everest
 *
 */
public class Entity implements MoveBehaviour, CollideBehaviour, InteractBehaviour {

    // IntegerProperty is used so that changes to the entities position can be
    // externally observed.
    private IntegerProperty x, y;
    private BooleanProperty visible;

    /**
     * Create an entity positioned in square (x,y)
     * 
     * @param x
     * @param y
     */
    public Entity(int x, int y) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.visible = new SimpleBooleanProperty(true);
    }

    public IntegerProperty x() {
        return x;
    }

    public IntegerProperty y() {
        return y;
    }

    public int getY() {
        return y().get();
    }

    public int getX() {
        return x().get();
    }

    public boolean getVisible() {
        return this.visible.get();
    }

    public BooleanProperty visibility() {
        return this.visible;
    }

    public void setVisible(boolean visibility) {
        // BooleanProperty b = new SimpleBooleanProperty(visibility);
        this.visible.set(visibility);
    }

    @Override
    public void interactWith(Player player) {
        // Not all entities can interact
        // Those that do are override this function
        return;
    }

    @Override
    public boolean step(Player player) {
        return true;
    }


    @Override
    public boolean step(Enemy entity) {
        return true;
    }

    @Override
    public boolean collide(Entity entity) {
        return true; // Default is true (Entities can collide)
    }

    @Override
    public boolean collideCheck() {
        return false; // Default is unrequired
    }


    
}
