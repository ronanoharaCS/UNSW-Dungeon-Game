package unsw.dungeon;

public class Key extends Entity {

    private int id;

    public Key(int x, int y) {
        super(x, y);

    }

    /* @Override
    public void pickUp(Player player) {
        if (player.getKey() != null) {
            // Drop key in spot
            player.getKey().x().set(player.getX());
            player.getKey().y().set(player.getY());
            player.putBack(player.getKey());
        }

        // Pick up new key
        player.setKey(this);
        player.moveToInventory(this);
    } */

    @Override
    public void interactWith(Player player) {
        player.addInventory(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

}