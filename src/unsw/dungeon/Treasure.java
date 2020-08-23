package unsw.dungeon;

public class Treasure extends Entity {// implements Collectable {

    private boolean collected;

    public Treasure(int x, int y) {
        super(x, y);
        collected = false; // true when picked up
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    @Override
    public void interactWith(Player player) {
        //System.out.println("Adding treasure");//remove
        player.addInventory(this);
    }

    

    /* @Override
    public void pickUp(Player player) {
        player.addTreasure(this);
        player.moveToInventory(this);
    } */

    /* verride
    public void interact(Player player) {
        player.addTreasure(this);
        player.moveToInventory(this);
        setCollected(true);
    } */


}