package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class PlayerInventory {
    private Player player;
    private Key key;
    private List<Treasure> treasure;
    private InvincibilityPotion iPotion;
    private Sword sword;

    public PlayerInventory() {
        key = null;
        treasure = new ArrayList<Treasure>();
        iPotion = null;
        sword = null;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public List<Treasure> getTreasure() {
        return treasure;
    }

    public void setTreasure(List<Treasure> treasure) {
        this.treasure = treasure;
    }

    public InvincibilityPotion getiPotion() {
        return iPotion;
    }

    public void setiPotion(InvincibilityPotion iPotion) {
        this.iPotion = iPotion;
    }

    public Sword getSword() {
        return sword;
    }

    public void setSword(Sword sword) {
        this.sword = sword;
    }

    public int nHits() {
        if (this.sword == null)
            return 0;
        else
            return this.sword.getHits();
    }

    public int nTreasure() {
        return this.getTreasure().size();
    }

    public int inventoryKeyID() {
        if (key == null) return -1;
        else return key.getId();
    }

    /**
     * @param entity item to be picked up
     * @return boolean if player picks up item - TRUE, else - FALSE
     */
    public boolean addItem(Entity entity) {
        // System.out.print("Adding "+entity);//remove
        Treasure t = new Treasure(0, 0);
        Sword s = new Sword(0, 0);
        Key k = new Key(0, 0);
        InvincibilityPotion i = new InvincibilityPotion(0, 0);
        if (entity.getClass() == t.getClass()) {
            // System.out.println("treasure added");//remove
            treasure.add((Treasure) entity);
            entity.setVisible(false);
            player.getDungeon().removeEntity(entity);
            //player.setnTreasure(treasure.size());
            return true;
        } else if (entity.getClass() == s.getClass()) {
            if (sword == null) {
                // System.out.println("Sword");//REMOVE
                setSword((Sword) entity);
                entity.setVisible(false);
                //player.setSwordHits(sword.getHits());
                return true;
            } else
                return false; // Can only hold one sword at a time
        } else if (entity.getClass() == k.getClass()) {
            if (key == null) {
                key = (Key) entity;
                entity.setVisible(false);
                //player.setKeyID(key.getId());
                return true;
            } else {
                this.key.setVisible(true);
                //player.drop(this.key); // (!) IMPLEMENT
                this.key = (Key) entity;
                entity.setVisible(false);
                //player.setKeyID(key.getId());
                return true;
            }
        } else if (entity.getClass() == i.getClass()) {
            if (iPotion == null) {
                iPotion = (InvincibilityPotion) entity;

                entity.setVisible(false);
                //player.setPotionMoves(iPotion.getUses());
                // START LISTENER
                return true;
            } else
                return false; // Can only hold one potion at a time
        } else
            return false;
    }

    public boolean removeItem(Entity entity) {
        //em.out.println("Removing " + entity);// remove
        InvincibilityPotion i = new InvincibilityPotion(0, 0);
        Sword s = new Sword(0, 0);
        if (entity.getClass() == i.getClass()) {
            //System.out.println("Removing potion");// remove
            InvincibilityPotion temp = null;
            setiPotion(temp);
            return true;
        } else if (entity.getClass() == s.getClass()) {
            Sword temp = null;
            setSword(temp);
            return true;
        } else
            return false;
    }


    
}