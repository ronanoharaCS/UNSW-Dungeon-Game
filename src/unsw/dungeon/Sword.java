package unsw.dungeon;

public class Sword extends Entity {//mplements Subject {

    private int hits;
    private Player player;

    public Sword(int x, int y) {
        super(x, y);
        hits = 5; // Initial hits is 5
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void hit() {
        hits = hits - 1;
    }

    @Override
    public void interactWith(Player player) {
        //System.out.println("Adding sword");// remove
        player.addInventory(this);
    }

    /* @Override
    public void attach(Observer o) {
        player = (Player) o;

    }

    @Override
    public void detach(Observer o) {
        player = null;
    }

    @Override
    public void notifyObservers() {
        player.update(this);
    } */


    

    
}