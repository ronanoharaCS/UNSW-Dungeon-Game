package unsw.dungeon;

public interface MoveBehaviour {
    public boolean step(Player player);
    public boolean step(Enemy entity);
}