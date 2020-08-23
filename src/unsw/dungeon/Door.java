package unsw.dungeon;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Door extends Entity {

    // private boolean locked;
    private BooleanProperty locked;
    private Key key;
    private int id;

    public Door(int x, int y) {
        super(x, y);
        locked = new SimpleBooleanProperty(true);
        key = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getLocked() {
        return this.locked.get();
    }

    public BooleanProperty lockStatus() {
        return this.locked;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void unlock() {
        this.locked.set(false);
    }

    /*
     * @Override public void interact(Player player) { // If player has key to this
     * door in inventory, can unlock if (player.getKey().equals(this.key)) {
     * unlock(); } }
     */

    @Override
    public boolean step(Player player) {
        if (locked.get() == true) {
            int playerKey = player.getInventory().inventoryKeyID();
            if (playerKey == this.id) {
                this.unlock(); // WHAT HAPPENS TO KEY (!)
                player.getInventory().setKey(null);
                //System.out.print("KEY IS NULL");
                return true;
            } else
                return false;
        } else
            return true;
    }

    @Override
    public boolean collide(Entity entity) {
        // Boulder b = new Boulder(0, 0);
        // if (entity.getClass() == b.getClass())
        if (locked.get() == true)
            return false;
        else
            return true;
    }

    @Override
    public boolean step(Enemy entity) {
        if (locked.get() == true) return false;
        else return true;
    }

    

   /*  @Override
    public void interactWith(Player player) {
        if (locked.get() == true) {
            int playerKey = player.getInventory().inventoryKeyID();
            if (playerKey == this.id) {
                this.unlock();
                System.out.println("unlocked");
                // WHAT HAPPENS TO KEY (!)
            }
        }
        
    } */

    


    

    

}