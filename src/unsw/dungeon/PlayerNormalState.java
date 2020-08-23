package unsw.dungeon;

public class PlayerNormalState implements State {
    private Player player;

    public PlayerNormalState(Player player) {
        this.player = player;
    }

    @Override
    public void interact(Entity entity) {
        //NORMAL - DIE
        //System.out.println("PLAYER NORMAL "); //remove
        Enemy e = new Enemy(0,0);
        if (e.getClass() == entity.getClass()) {
            Enemy enemy = (Enemy) entity;
            if (player.armed()) {
                player.hitEnemy();
                enemy.die();
                return;
            }
            else {
                player.die();
                return;
            }
        }

        entity.interactWith(player);
    }


    
}