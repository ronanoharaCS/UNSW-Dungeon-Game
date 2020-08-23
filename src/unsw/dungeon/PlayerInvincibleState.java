package unsw.dungeon;

public class PlayerInvincibleState implements State {
    private Player player;

    public PlayerInvincibleState(Player player) {
        this.player = player;
    }
    
    @Override
    public void interact(Entity entity) {
        //System.out.println("PLAYER INVINCIBLE "); //remove
        Enemy e = new Enemy(0,0);
        if (e.getClass() == entity.getClass()) {
            Enemy enemy = (Enemy) entity;
            enemy.die();
            return;
        }
        entity.interactWith(player);
    }
 
}