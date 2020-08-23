package unsw.dungeon;

import java.util.Timer;
import java.util.TimerTask;


import java.util.ArrayList;
import java.util.List;

public class Enemy extends Entity implements Observer {
    private int destinationX;
    private int destinationY;
    private boolean hostile; // True if player not on potion
    private boolean alive; // true if dead
    private Dungeon dungeon;

    public Enemy(int x, int y) {
        super(x, y);
        destinationX = x;
        destinationY = y;
        alive = true;
        hostile = true;
        //movement();
    }

    public int getDestinationX() {
        return destinationX;
    }

    public void setDestinationX(int destinationX) {
        this.destinationX = destinationX;
    }

    public int getDestinationY() {
        return destinationY;
    }

    public void setDestinationY(int destinationY) {
        this.destinationY = destinationY;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        //System.out.println("ENEMY DEAD");
        this.alive = false;
        this.setVisible(false);
        dungeon.removeEntity(this);
    }

    public boolean isHostile() {
        return hostile;
    }

    public void setHostile(boolean hostile) {
        this.hostile = hostile;
    }

    @Override
    public boolean update(Subject obj) {
        // If PLAYER Set new destination to player's coordinates
        if (alive == false) return false;
        if (obj instanceof Player) {
            Player p = (Player) obj;
            
            if (dungeon == null) {
                setDungeon(p.getDungeon());
            }
            //System.out.println("Enemy notified"); // remove
            setDestinationX(p.getX());
            setDestinationY(p.getY());
            if ((getDestinationX() == this.getX()) && getDestinationY() == this.getY()) {
                //this.interactWith(p);
                p.getState().interact(this);
                return false;
            }
            if (p.invincible() == true) {
                //System.out.println("Player invincible"); // remove
                setHostile(false);
            } else {
                //System.out.println("Player normal"); // remove
                setHostile(true);
            }
        }
        return true;
        /*
         * If DUNGEON Update entities list if (obj instanceof Dungeon) {
         * setDungeon((Dungeon) obj); }
         */

    }

    /*
     * @Override public void updateMap(Dungeon obj) {
     * setEntities(obj.getEntities()); }
     */

    // Move towards player
    public void movement() {
        //if (dungeon == null) System.out.println("DUNGEON IS NULL");//remove

        //System.out.println("Dungeon; "+getDungeon());
        
        Timer timer = new Timer();
        TimerTask t = new TimerTask() {
            @Override
            public void run() {
                if (alive == false) this.cancel();
                //if (dungeon == null) System.out.println("DUNGEON IS NULL");//remove
                if (getX() == dungeon.getPlayer().getX() && getY() == dungeon.getPlayer().getY()) {
                    /* if (!dungeon.getPlayer().invincible()) {
                        // Not invincible player dies
                        System.out.println("Not invincible player dies");//remove
                        dungeon.getPlayer().die();
                        this.cancel();
                    } else {
                        // Invincible, enemy dies
                        System.out.println("Invincible enemy dies");//remove
                        die();
                        this.cancel();
                    } */
                    update((Subject) dungeon.getPlayer());
                    //dungeon.getPlayer().getState().interact(this); //
                }



                /* if (dungeon != null && getX() == dungeon.getPlayer().getX() && getY() == dungeon.getPlayer().getY()) {
                    System.out.println("SAME SQUARE?");
                    if (hostile == true) {
                        //Player dies
                        dungeon.getPlayer().die();
                    } else {
                        //Enemy dies
                        die();
                        this.cancel();
                    }

                    interactWith(dungeon.getPlayer());
                } */ 
                else if (hostile == true) {
                    // System.out.println(getX() + "," + getY());
                    // System.out.println("FOLLOW");
                    follow();
                }
                else {
                    // runAway();
                    runAway();
                    // System.out.println(getX() + "," + getY());
                }

            }
        };

        timer.schedule(t, 1000, 2000);
    }

    public void follow() {
        if (destinationX == getX()) {
            if (destinationY > getY() && walkableSquare(getX(), getY() + 1)) {
                y().set(getY() + 1);
                return;
            } else if (destinationY < getY() && walkableSquare(getX(), getY() - 1)) {
                y().set(getY() - 1);
                return;
            }
        } else if (destinationY == getY()) {
            if (destinationX > getX() && walkableSquare(getX() + 1, getY())) {
                x().set(getX() + 1);
                return;
            } else if (destinationX < getX() && walkableSquare(getX() - 1, getY())) {
                x().set(getX() - 1);
                return;
            }
        } else if (destinationX < getX() && walkableSquare(getX() - 1, getY())) {
            x().set(getX() - 1);
            return;
        } else if (destinationX > getX() && walkableSquare(getX() + 1, getY())) {
            x().set(getX() + 1);
            return;
        } else if (destinationY < getY() && walkableSquare(getX(), getY() - 1)) {
            y().set(getY() - 1);
            return;
        } else if (destinationY > getY() && walkableSquare(getX(), getY() + 1)) {
            y().set(getY() + 1);
            return;
        }
    }

    public void runAway() {
        if (destinationX == getX()) {
            if (destinationY < getY() && walkableSquare(getX(), getY() + 1)) {
                y().set(getY() + 1);
                return;
            } else if (destinationY > getY() && walkableSquare(getX(), getY() - 1)) {
                y().set(getY() - 1);
                return;
            } else if (walkableSquare(getX() + 1, getY())) {
                x().set(getX() + 1);
                return;
            } else if (walkableSquare(getX() - 1, getY())) {
                x().set(getX() - 1);
                return;
            }
        } else if (destinationY == getY()) {
            if (destinationX < getX() && walkableSquare(getX() + 1, getY())) {
                x().set(getX() + 1);
                return;
            } else if (destinationX > getX() && walkableSquare(getX() - 1, getY())) {
                x().set(getX() - 1);
                return;
            } else if (walkableSquare(getX(), getY() + 1)) {
                y().set(getY() + 1);
                return;
            } else if (walkableSquare(getX(), getY() - 1)) {
                y().set(getY() - 1);
                return;
            }
        } else {
            if (destinationY < getY() && walkableSquare(getX(), getY() + 1)) {
                y().set(getY() + 1);
                return;
            } else if (destinationY > getY() && walkableSquare(getX(), getY() - 1)) {
                y().set(getY() - 1);
                return;
            } else if (destinationX < getX() && walkableSquare(getX() + 1, getY())) {
                x().set(getX() + 1);
                return;
            } else if (destinationX > getX() && walkableSquare(getX() - 1, getY())) {
                x().set(getX() - 1);
                return;
            }

        }
    }

    public boolean walkableSquare(int x, int y) {
        ArrayList<Entity> entities = dungeon.getEntitiesBySquare(x, y);
        for (Entity entity : entities) {
            if (entity.step(this) == false) {
                return false;
            }
        }
        return true;
    }

    /*
     * @Override public void interact(Player player) { setDestroyed(true);
     * player.moveToInventory(this); }
     */

    @Override
    public boolean collide(Entity entity) {
        Boulder b = new Boulder(0, 0);
        // Boulder cannot collide w/ Enemy
        if (entity.getClass() == b.getClass())
            return false;
        else
            return true;
    }

    @Override
    public void interactWith(Player player) {
        /* if (player.invincible()) {
            this.die(); // Enemy dies
        }
        else if (player.armed()) {
            // Enemy dies
            player.hitEnemy();
            this.die();
        } else {
            player.die();
        } */
    }

    @Override
    public boolean step(Enemy entity) {
        return false;
    }



    


}