package unsw.dungeon;

public interface State {
    //public void enemyCollision();
    //public void enemyEffect();
    public void interact(Entity entity);
}