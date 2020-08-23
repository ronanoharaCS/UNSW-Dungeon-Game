/**
 *
 */
package unsw.dungeon;

import java.util.ArrayList;
//import java.util.List;
//import unsw.dungeon.Wall;   

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

//import javax.sound.sampled.Port;

// Exceptions
//import java.lang.Exception;
import java.lang.IllegalArgumentException;
//import java.util.Timer;
//import java.util.TimerTask;


/**
 * A dungeon in the interactive dungeon player.
 *
 * A dungeon can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 *
 * @author Robert Clifton-Everest
 *
 */
public class Dungeon implements Subject, Observer {

    private int width, height;
    private ArrayList<Entity> entities;
    private Player player;
    private Goal goals;
    private BooleanProperty complete;
    ArrayList<Observer> listObservers = new ArrayList<Observer>();


    public Dungeon(int width, int height) {
        if ((width < 1 || height < 1) || (width < 2 && height <2)) 
            throw new IllegalArgumentException("Dungeons must be larger than 1x1");
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<Entity>();
        this.player = null;
        this.goals = null;
        this.complete = new SimpleBooleanProperty(false);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addGoals(Goal goal){
        this.goals = goal;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addEntity(Entity entity) {
        Portal p = new Portal(0,0);
        Enemy e = new Enemy(0,0);
        //Player pl = new Player(this, 0,0);
        if (entity.getClass() == p.getClass()) {
            // LINK PORTALS
            link((Portal) entity);
        }
        else if (entity.getClass() == e.getClass()) {
            //System.out.println("Adding enemy");//remove
            Enemy enemy = (Enemy) entity;
            /* if (this.player != null) {
                this.player.attach(enemy);
                //enemy.setDungeon(this);
                enemy.movement();
            } */
            enemy.setDungeon(this);
            //System.out.println("DUNGEON IS SET FOR ENEMY" +enemy.getDungeon());//remove
            
        }
        
        // add entity to list
        entities.add(entity);

        // update goals
        //goals.addGoal(entity);
    }

    // Remove entity if destroyed/disappears/used
    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }



    public void link(Portal p1) {
        Portal p = new Portal(0,0);
        int id = p1.getId();
        for (Entity e : entities) {
            // Scan through portals for same ID
            if (e.getClass() == p.getClass()) {
                Portal ePortal = (Portal) e;
                if (id == ePortal.getId()) {
                    p1.setLink(ePortal);
                    ePortal.setLink(p1);
                    // System.out.println("PORTALS LINKED "+id);
                }
            }
        }
    }

    
    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public BooleanProperty dungeonCompletion() {
        return complete;
    }

    public boolean getComplete() {
        return complete.get();
    }

    public void setComplete(boolean complete) {
        this.complete.set(complete);
    }

    public boolean coordinateOnMap(int x, int y){
        
        if(x < 0 || y < 0){
            //System.out.println(x+"<0 OR "+y+"<0");//remove
            return false;
        } else if (x > getWidth() - 1 || y > getHeight() - 1){
            //System.out.println(x+">width-1 OR "+y+">height-1");//remove
            return false;
        }
        //System.out.println(x+","+y+" Returns true");//remove
        return true;
    }

    

    // CHECKING FOR OBSTRUCTION
    public ArrayList<Entity> getEntitiesBySquare(int x, int y){
        ArrayList<Entity> list = new ArrayList<Entity>();
        for (Entity currEnt : this.entities) {
                if (currEnt.getX() == x && currEnt.getY() == y) {
                    list.add(currEnt);
                }
        }
        return list;
    }


    /* public void gameOver() {
        // END GAME
        System.out.println("GAME OVER");
        for (Entity entity : entities) {
            entities.remove(entity);
        }
    } */

    public void triggerEnemies() {
        Enemy e = new Enemy(0,0);
        for (Entity entity : entities) {
            if (entity.getClass() == e.getClass()) {
                player.attach((Enemy) entity);
                ((Enemy) entity).movement();
            }
        }
    }

    
    @Override
	public void attach(Observer o) {
        if(! listObservers.contains(o)) { 
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
		for(Observer obs : listObservers) {
			obs.update(this);
		}
	} 

    @Override
	public boolean update(Subject obj) {
        if (obj instanceof Player) {
            this.player = (Player) obj; // Updates state of player
            //System.out.println(((Player)obj).getX()+","+((Player)obj).getY()+","+((Player)obj).getPotion());
            // Runs Entity checks
            //System.out.println("updating P");
            //(getEntitiesBySquare(((Player) obj).getX(), ((Player) obj).getY()));
        }
        return true;
    }

    // Get specific entities for goals
    public ArrayList<FloorSwitch> getFloorSwitches(){
        ArrayList<FloorSwitch> list = new ArrayList<FloorSwitch>();
        FloorSwitch fs = new FloorSwitch(0,0); 
        for(Entity e : entities){
            if(e.getClass() == fs.getClass()){
                list.add((FloorSwitch)e);
            }
        }
        return list;
    }

    public ArrayList<Treasure> getTreasure(){
        ArrayList<Treasure> list = new ArrayList<Treasure>();
        Treasure t = new Treasure(0,0); 
        for(Entity e : entities){
            if(e.getClass() == t.getClass()){
                list.add((Treasure)e);
            }
        }
        return list;
    }

    public ArrayList<Enemy> getEnemies(){
        ArrayList<Enemy> list = new ArrayList<Enemy>();
        Enemy enemy = new Enemy(0,0); 
        for(Entity e : entities){
            if(e.getClass() == enemy.getClass()){
                list.add((Enemy)e);
            }
        }
        return list;
    }

    public Exit getExit(){
        Exit exit = new Exit(0,0);
        
        for(Entity e : entities){
            if(e.getClass().equals(exit.getClass())){
                return (Exit)e;
            }
        }
        return null;
    }

    public Boolean isPlayerOnExit(){
        Exit exit = getExit();
        if(player.getX() == exit.getX() &&  player.getY() == exit.getY()){
            return true;
        }
        return false;
    }

    public Boolean goalsPassed(){
        if (goals.isComplete()){
            //System.out.println("All Goals Completed!");
            setComplete(true);
        }
        return goals.isComplete();

    }


    // ------------------------------------------------------------------------
    // ------------------------ moving boulder & trigger changes --------------
    // ------------------------------------------------------------------------


    public Boulder getBoulderBySquare(int x, int y){
        Boulder b = new Boulder(0,0);
        for (Entity e : this.getEntitiesBySquare(x, y)){
            if (e.getClass() == b.getClass()){
                return (Boulder)e;
            }
        }
        return null;
    } 

    public void moveBoulder(int x0, int y0, int x1, int y1) {
        // find the boulder object and move it
        Boulder b = getBoulderBySquare(x0, y0);
        b.moveBoulder(x1, y1);
        // adjust the triggering of any floor switches
        floorSwitchesUpdate(x0, y0, x1, y1);
    }


    public void floorSwitchesUpdate(int x0, int y0, int x1, int y1){
        for (FloorSwitch fs: this.getFloorSwitches()){
            if(fs.getX() == x0 && fs.getY() == y0){
                fs.setTriggered(false);
            }
            if(fs.getX() == x1 && fs.getY() == y1){
                fs.setTriggered(true);
            }
        }
    }




}