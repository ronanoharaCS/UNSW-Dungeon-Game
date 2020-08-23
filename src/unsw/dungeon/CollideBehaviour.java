package unsw.dungeon;

public interface CollideBehaviour {
    /**
     * Checks if entity needs to check collision
     * @return boolean
     */
    public boolean collideCheck();

    /**
     * Checks if entity can collide with another entity
     * @param entity entity to be collided with
     * @param x X coordinate of adjacent square
     * @param y Y coordinate of adjacent square
     * @return boolean
     */
    public boolean collide(Entity entity);

}