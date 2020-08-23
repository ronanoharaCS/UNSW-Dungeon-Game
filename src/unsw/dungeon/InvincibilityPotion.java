package unsw.dungeon;

public class InvincibilityPotion extends Entity implements Observer {

    private int uses;
    private Player player;

    public InvincibilityPotion(int x, int y) {
        super(x, y);
        this.uses = 15; // Disappears after 15 player's moves
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }

    /*
     * @Override public void pickUp(Player player) { if (player.getPotion() != null)
     * { player.setPotion(this); player.moveToInventory(this); player.attach(this);
     * }
     * 
     * }
     */

    @Override
    public void interactWith(Player player) {
        player.addInventory(this);
        //System.out.println("Potion added to inventory");
        player.setState(player.getInvincibleState());
        //System.out.println("Player invincible");
        player.attach(this);
        //System.out.println("Player listening ");
        this.player = player;
    }

    @Override
    public boolean update(Subject obj) {
        if (obj instanceof Player) {
            //System.out.println("SUBJ = PLAYER");//remove
            setUses(this.uses-1);
            //System.out.println("UPDATING POTION");//remove
            if (this.uses == 0) {
                //System.out.println("NO MORE USES");//remove
                // Remove from inventory
                player.removeInventory(this);
                // Revert player back to normal state
                player.setState(player.getNormalState());
                // Detach observer
                //player.detach(this);
                return false;
            }
        }
        return true;
    }

    

    

}