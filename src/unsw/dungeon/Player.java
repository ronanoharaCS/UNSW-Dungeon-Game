package unsw.dungeon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.util.TimerTask;

import javafx.beans.property.IntegerProperty;

/**
 * The player entity
 * 
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Entity implements Subject, Observer {
    private Dungeon dungeon;
    private State state; // Current player state
    // Player States
    private State normalState;
    private State invincibleState;
    private boolean alive;
    private PlayerInventory inventory;
    /* private IntegerProperty swordHits;
    private IntegerProperty potionMoves;
    private IntegerProperty nTreasure;
    private IntegerProperty keyID; */
    //private int defence;

    /*
     * private Sword sword; private InvincibilityPotion potion; private
     * List<Treasure> treasure; private Key key;
     */
    ArrayList<Observer> listObservers = new ArrayList<Observer>();

    /**
     * Create a player positioned in square (x,y)
     * 
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;

        normalState = new PlayerNormalState(this);
        invincibleState = new PlayerInvincibleState(this);
        state = normalState; // Default state is normal
        alive = true; // Initially alive
        inventory = new PlayerInventory();
        inventory.setPlayer(this);


        /*
         * this.sword = null; this.potion = null; this.treasure = new
         * ArrayList<Treasure>(); this.key = null;
         */

        // connectToEntities();
    }



    // CollideCheck -- tells you if the entity is a boulder
    // collide -- tells you if the two entities can share a square/move on to eachother

    // MOVEMENT
    public void moveUp() {
        int x = getX();
        int y = getY();
        // check destination square is on map
        if (!dungeon.coordinateOnMap(x, y - 1)){
            return; 
        } 
        Boulder boulder = null; // potential boulder to move
        // Search through any entities in the destination square
        for (Entity entity : dungeon.getEntitiesBySquare(x, y - 1)) {
            // Checks if this entity is a boulder 
            if (entity.collideCheck()) {
                // if the boulder moves will it remain within map
                if (!dungeon.coordinateOnMap(x, y - 2)) {
                    return; 
                }
                // Search through any entities in the square where the boulder would move to
                for (Entity e : dungeon.getEntitiesBySquare(x, y - 2)) {
                    // ignore the self comparison
                    if (entity.equals(e)) {
                        continue;
                    }
                    // if the square contains an entity the boulder CANNOT share a square with
                    // (i.e. collide with) then neither the boulder nor player can move
                    if (e.collide(entity) == false) {
                        return; 
                    } 
                }
                // a moveable boulder
                boulder = (Boulder)entity;
            }
            // Checks if the non boulder entity stops the player moving
            else if (entity.step(this) == false) {
                return; // INVALID Can't step
            }
        }
        // ~~ MOVE PLAYER UP
        y().set(y - 1);

        notifyObservers();
        // ~~ MOVE Boulder UP (if applicable)
        if(boulder != null){
            int origBoulderX = x;
            int origBoulderY = y-1;
            // move boulder
            boulder.y().set(origBoulderY - 1);
            // update switches
            getDungeon().floorSwitchesUpdate(origBoulderX, origBoulderY, origBoulderX, origBoulderY - 1);
        }
        // Interact with entities on new location
        interactSquare(this.getX(), this.getY());

        // Check goal completion
        getDungeon().goalsPassed();

    }

    public void moveDown() {
        int x = getX();
        int y = getY();
        // check destination square is on map
        if (!dungeon.coordinateOnMap(x, y + 1)){
            return; 
        } 
        Boulder boulder = null; // potential boulder to move
        // Search through any entities in the destination square
        for (Entity entity : dungeon.getEntitiesBySquare(x, y + 1)) {
            // Checks if this entity is a boulder 
            if (entity.collideCheck()) {
                // if the boulder moves will it remain within map
                if (!dungeon.coordinateOnMap(x, y + 2)) {
                    return; 
                }
                // Search through any entities in the square where the boulder would move to
                for (Entity e : dungeon.getEntitiesBySquare(x, y + 2)) {
                    // ignore the self comparison
                    if (entity.equals(e)) {
                        continue;
                    }
                    // if the square contains an entity the boulder CANNOT share a square with
                    // (i.e. collide with) then neither the boulder nor player can move
                    if (e.collide(entity) == false) {
                        return; 
                    } 
                }
                // a moveable boulder
                boulder = (Boulder)entity;
            }
            // Checks if the non boulder entity stops the player moving
            else if (entity.step(this) == false) {
                return; // INVALID Can't step
            }
        }
        // ~~ MOVE PLAYER Down
        y().set(y + 1);

        notifyObservers();
        // ~~ MOVE Boulder DOWN (if applicable)
        if(boulder != null){
            int origBoulderX = x;
            int origBoulderY = y+1;
            // move boulder
            boulder.y().set(origBoulderY + 1);
            // update switches
            getDungeon().floorSwitchesUpdate(origBoulderX, origBoulderY, origBoulderX, origBoulderY + 1);
        }
        // Interact with entities on new location
        interactSquare(this.getX(), this.getY());
        
        
        // Check goal completion
        getDungeon().goalsPassed();

    }

    public void moveLeft() {
        int x = getX();
        int y = getY();
        // check destination square is on map
        if (!dungeon.coordinateOnMap(x - 1, y)){
            return; 
        } 
        Boulder boulder = null; // potential boulder to move
        // Search through any entities in the destination square
        for (Entity entity : dungeon.getEntitiesBySquare(x - 1, y)) {
            // Checks if this entity is a boulder 
            if (entity.collideCheck()) {
                // if the boulder moves will it remain within map
                if (!dungeon.coordinateOnMap(x - 2, y)) {
                    return; 
                }
                // Search through any entities in the square where the boulder would move to
                for (Entity e : dungeon.getEntitiesBySquare(x - 2, y)) {
                    // ignore the self comparison
                    if (entity.equals(e)) {
                        continue;
                    }
                    // if the square contains an entity the boulder CANNOT share a square with
                    // (i.e. collide with) then neither the boulder nor player can move
                    if (e.collide(entity) == false) {
                        return; 
                    } 
                }
                // a moveable boulder
                boulder = (Boulder)entity;
            }
            // Checks if the non boulder entity stops the player moving
            else if (entity.step(this) == false) {
                return; // INVALID Can't step
            }
        }
        // ~~ MOVE PLAYER UP
        x().set(x - 1);

        notifyObservers();
        // ~~ MOVE Boulder UP (if applicable)
        if(boulder != null){
            int origBoulderX = x-1;
            int origBoulderY = y;
            // move boulder
            boulder.x().set(origBoulderX - 1);
            // update switches
            getDungeon().floorSwitchesUpdate(origBoulderX, origBoulderY, origBoulderX -1, origBoulderY);
        }
        // Interact with entities on new location
        interactSquare(this.getX(), this.getY());

        // Check goal completion
        getDungeon().goalsPassed();
    }

    public void moveRight() {
        int x = getX();
        int y = getY();
        // check destination square is on map
        if (!dungeon.coordinateOnMap(x + 1, y)){
            return; 
        } 
        Boulder boulder = null; // potential boulder to move
        // Search through any entities in the destination square
        for (Entity entity : dungeon.getEntitiesBySquare(x + 1, y)) {
            // Checks if this entity is a boulder 
            if (entity.collideCheck()) {
                // if the boulder moves will it remain within map
                if (!dungeon.coordinateOnMap(x + 2, y)) {
                    return; 
                }
                // Search through any entities in the square where the boulder would move to
                for (Entity e : dungeon.getEntitiesBySquare(x + 2, y)) {
                    // ignore the self comparison
                    if (entity.equals(e)) {
                        continue;
                    }
                    // if the square contains an entity the boulder CANNOT share a square with
                    // (i.e. collide with) then neither the boulder nor player can move
                    if (e.collide(entity) == false) {
                        return; 
                    } 
                }
                // a moveable boulder
                boulder = (Boulder)entity;
            }
            // Checks if the non boulder entity stops the player moving
            else if (entity.step(this) == false) {
                return; // INVALID Can't step
            }
        }
        // ~~ MOVE PLAYER UP
        x().set(x + 1);

        notifyObservers();
        // ~~ MOVE Boulder UP (if applicable)
        if(boulder != null){
            int origBoulderX = x+1;
            int origBoulderY = y;
            // move boulder
            boulder.x().set(origBoulderX + 1);
            // update switches
            getDungeon().floorSwitchesUpdate(origBoulderX, origBoulderY, origBoulderX + 1, origBoulderY);
        }
        // Interact with entities on new location
        interactSquare(this.getX(), this.getY());
        
        // Check goal completion
        getDungeon().goalsPassed();
        
        
        
    }

    // ############# GETTERS & SETTERS #############
    public Dungeon getDungeon() {
        return dungeon;
    }

    /*
     * public void setDungeon(Dungeon dungeon) { this.dungeon = dungeon; }
     */

    public PlayerInventory getInventory() {
        return inventory;
    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getNormalState() {
        return normalState;
    }

    public State getInvincibleState() {
        return invincibleState;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
/* 
    public IntegerProperty getSwordHits() {
        return swordHits;
    }

    public void setSwordHits(int swordHits) {
        this.swordHits.set(swordHits);
    }

    public IntegerProperty getPotionMoves() {
        return potionMoves;
    }

    public void setPotionMoves(int potionMoves) {
        this.potionMoves.set(potionMoves);
    }

    public IntegerProperty getnTreasure() {
        return nTreasure;
    }

    public void setnTreasure(int nTreasure) {
        this.nTreasure.set(nTreasure);
    }

    public IntegerProperty getKeyID() {
        return keyID;
    }

    public void setKeyID(int keyID) {
        this.keyID.set(keyID);
    } */

    // ############# METHODS #############

    public boolean invincible() {
        if (this.state.equals(invincibleState)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addInventory(Entity entity) {
        return inventory.addItem(entity);
    }

    public boolean removeInventory(Entity entity) { 
        return inventory.removeItem(entity); 
    }

    public void connectToEntities() {
        Enemy enemy = new Enemy(0, 0);

        for (Entity e : dungeon.getEntities()) {
            if (e.getClass() == enemy.getClass()) {
                Enemy connect = (Enemy) e;
                this.attach(connect);
            }
        }
    }

    /* public void drop(Entity entity) {
        entity.setVisible(true);
        //entity.x().set(this.getX());
        entity.y().set(this.getY());
        //eturn; // (!) IMPLEMETNT
    } */

    public void hitEnemy() {
        //System.out.println("nHits: "+inventory.nHits());
        if (inventory.nHits() == 1) {
            //HIT
            inventory.getSword().hit();
            //DELETE SWORD
            Sword nullSword = null;
            inventory.setSword(nullSword);

            //setSwordHits(0);
        }
        else {
            inventory.getSword().hit();
            //setSwordHits(inventory.getSword().getHits());
        }
    }

    /**
     * Function allows player to interact with entities on square.
     * 
     * @param x
     * @param y
     */
    public void interactSquare(int x, int y) {
        // System.out.println("Interacting "+x+","+y);//remove
        ArrayList<Entity> entities = dungeon.getEntitiesBySquare(x, y);
        for (Entity entity : entities) {
            if (entity.equals(this))
                continue;
            // System.out.println(entity);//remove
            state.interact(entity);
        }
    }

    public void die() {
        // IMPLEMENT PLAYER DEATH (!)
        setAlive(false);
        this.setVisible(false);
        dungeon.removeEntity(this);
        //System.out.println("PLAYER IS DEAD!!!!");// remove
        //dungeon.
    }

    public boolean armed() {
        if (this.inventory.getSword() != null)
            return true;
        //System.out.println("player not armed");
        return false;
    }

    /*
     * // Removes entity from dungeon public void moveToInventory(Entity e) {
     * dungeon.removeEntity(e); }
     * 
     * // Returns from inventory to dungeon map public void putBack(Entity e) {
     * dungeon.addEntity(e); }
     */

    // SUBJECT METHODS for enemies
    @Override
    public void attach(Observer o) {
        if (!listObservers.contains(o)) {
            listObservers.add(o);
            o.update(this);
        }
    };

    @Override
    public void detach(Observer o) {
        listObservers.remove(o);
    }

    @Override
    public void notifyObservers() {
        ArrayList<Observer> delete = new ArrayList<Observer>();
        for (Iterator<Observer> it = listObservers.iterator(); it.hasNext();) {
            Observer o = it.next();
            boolean keep = o.update(this);
            if (keep == false) {
                delete.add(o);
            }
        }
        
        
        
        
        /* // boolean keep;
        ArrayList<Observer> delete = new ArrayList<Observer>();
        // Observer delete;
        for (Observer observer : listObservers) {
            boolean keep = observer.update(this);
            if (keep == false) {
                delete.add(observer);
            }
        } */

        for (Observer o : delete) {
            //System.out.println("Detaching o");
            detach(o);
        }
    }

    @Override
    public boolean update(Subject obj) {
        
        
        // TODO Auto-generated method stub
        return false;
    }

    

    

}

