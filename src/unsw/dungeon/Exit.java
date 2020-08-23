package unsw.dungeon;

public class Exit extends Entity {

    public Exit(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean collide(Entity entity) {
        return false; // Nothing except player can walk on exit
    }

    @Override
    public boolean step(Enemy enemy) {
        return false;
    }
    
}