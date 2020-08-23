package unsw.dungeon;

public class Wall extends Entity {

    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean step(Player player) {
        return false;
    }

    @Override
    public boolean step(Enemy enemy) {
        return false;
    }

    @Override
    public boolean collide(Entity entity) {
        // Nothing can collide with wall
        return false; 
    }
}
