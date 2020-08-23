package unsw.dungeon;

public class Boulder extends Entity {

    public Boulder(int x, int y) {
        super(x, y);
    }

    public void moveBoulder(int x, int y) {
        x().set(x);
        y().set(y);
    }

    @Override
    public boolean step(Player player) {
        // If boulder can move - TRUE

        return false;
    }

    @Override
    public boolean step(Enemy enemy) {
        return false;
    }


    @Override
    public boolean collide(Entity entity) {
        //if (entity.collide(this) == true) return true;
        //else return false;
        return false;
    }

    @Override
    public boolean collideCheck() {
        return true;
    }

    

    
    
    

}