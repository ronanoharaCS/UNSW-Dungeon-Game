package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import unsw.dungeon.Dungeon;
import unsw.dungeon.*;
public class BoulderMoveTests {
    @Test //PASS
    public void playerMoveBoulderUp(){
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 2);
        Boulder b = new Boulder(0, 1);
        d.addEntity(b);
        p.moveUp();
        // test boulder position
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(1, p.getY());
    }

    @Test //PASS
    public void playerMoveBoulderDown() {
        Dungeon d = new Dungeon(5, 5);
        Player p = new Player(d, 2, 2);
        Boulder b = new Boulder(2, 3);
        d.addEntity(b);
        p.moveDown();
        // test boulder position
        assertEquals(2, b.getX());
        assertEquals(4, b.getY());
        // test player position
        assertEquals(2, p.getX());
        assertEquals(3, p.getY());
    }

    @Test //PASS
    public void playerMoveBoulderLeft() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 2, 0);
        Boulder b = new Boulder(1, 0);
        d.addEntity(b);
        p.moveLeft();
        // test boulder position
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(1, p.getX());
        assertEquals(0, p.getY());
    }

    @Test //PASS
    public void playerMoveBoulderRight() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(1, 0);
        d.addEntity(b);
        p.moveRight();
        // test boulder position
        assertEquals(2, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(1, p.getX());
        assertEquals(0, p.getY());
    }

// ########  BOULDER -> BOUNDARY  #########
    @Test //PASS
    public void boulderBlockedByBoundaryUp() {
    Dungeon d = new Dungeon(3, 3);
    Player p = new Player(d, 1, 1);
    Boulder b = new Boulder(1, 0);
    d.addEntity(b);
    p.moveUp();
    // test boulder position
    assertEquals(1, b.getX());
    assertEquals(0, b.getY());
    // test player position
    assertEquals(1, p.getX());
    assertEquals(1, p.getY());
    }

    @Test //PASS
    public void boulderBlockedByBoundaryDown() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 1, 1);
        Boulder b = new Boulder(1, 2);
        d.addEntity(b);
        p.moveDown();
        // test boulder position
        assertEquals(1, b.getX());
        assertEquals(2, b.getY());
        // test player position
        assertEquals(1, p.getX());
        assertEquals(1, p.getY());
    }

    @Test //PASS
    public void boulderBlockedByBoundaryLeft() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 1, 0);
        Boulder b = new Boulder(0, 0);
        d.addEntity(b);
        p.moveLeft();
        // test boulder position
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(1, p.getX());
        assertEquals(0, p.getY());
    }

    @Test //PASS
    public void boulderBlockedByBoundaryRight() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 1, 0);
        Boulder b = new Boulder(2, 0);
        d.addEntity(b);
        p.moveRight();
        // test boulder position
        assertEquals(2, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(1, p.getX());
        assertEquals(0, p.getY());
    }

    // ########  BOULDER -> WALL  #########
    @Test //PASS
    public void boulderBlockedByWallUp() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 2);
        Boulder b = new Boulder(0, 1);
        Wall w = new Wall(0, 0);
        d.addEntity(b);
        d.addEntity(w);
        p.moveUp();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(1, b.getY());
        // test wall
        assertEquals(0, w.getX());
        assertEquals(0, w.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(2, p.getY());
    }

    @Test //PASS
    public void boulderBlockedByWallDown() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(0, 1);
        Wall w = new Wall(0, 2);
        d.addEntity(b);
        d.addEntity(w);
        p.moveDown();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(1, b.getY());
        // test wall
        assertEquals(0, w.getX());
        assertEquals(2, w.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
    }

    @Test //PASS
    public void boulderBlockedByWallLeft() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 2, 0);
        Boulder b = new Boulder(1, 0);
        Wall w = new Wall(0, 0);
        d.addEntity(b);
        d.addEntity(w);
        p.moveLeft();
        // test boulder positions
        assertEquals(1, b.getX());
        assertEquals(0, b.getY());
        // test wall
        assertEquals(0, w.getX());
        assertEquals(0, w.getY());
        // test player position
        assertEquals(2, p.getX());
        assertEquals(0, p.getY());
    }
    @Test //PASS
    public void boulderBlockedByWallRight() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(1, 0);
        Wall w = new Wall(2, 0);
        d.addEntity(b);
        d.addEntity(w);
        p.moveRight();
        // test boulder positions
        assertEquals(1, b.getX());
        assertEquals(0, b.getY());
        // test wall
        assertEquals(2, w.getX());
        assertEquals(0, w.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
    }

    // ########  BOULDER -> PORTAL  #########

    @Test //PASS
    public void boulderBlockedByPortalUp() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 2);
        Boulder b = new Boulder(0, 1);
        Portal port = new Portal(0, 0);
        d.addEntity(b);
        d.addEntity(port);
        p.moveUp();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(1, b.getY());
        assertEquals(0, port.getX());
        assertEquals(0, port.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(2, p.getY());
    }

    @Test //PASS
    public void boulderBlockedByPortalDown() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(0, 1);
        Portal port = new Portal(0, 2);
        d.addEntity(b);
        d.addEntity(port);
        p.moveDown();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(1, b.getY());
        assertEquals(0, port.getX());
        assertEquals(2, port.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
    }

    @Test //PASS
    public void boulderBlockedByPortalLeft() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 2, 0);
        Boulder b = new Boulder(1, 0);
        Portal port = new Portal(0, 0);
        d.addEntity(b);
        d.addEntity(port);
        p.moveLeft();
        // test boulder positions
        assertEquals(1, b.getX());
        assertEquals(0, b.getY());
        assertEquals(0, port.getX());
        assertEquals(0, port.getY());
        // test player position
        assertEquals(2, p.getX());
        assertEquals(0, p.getY());
    }
    @Test //PASS
    public void boulderBlockedByPortalRight() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(1, 0);
        Portal port = new Portal(2, 0);
        d.addEntity(b);
        d.addEntity(port);
        p.moveRight();
        // test boulder positions
        assertEquals(1, b.getX());
        assertEquals(0, b.getY());
        assertEquals(2, port.getX());
        assertEquals(0, port.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
    }

    // ########  BOULDER -> ENEMY  #########
    @Test //PASS
    public void boulderBlockedByEnemyUp() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 2);
        Boulder b = new Boulder(0, 1);
        Enemy e = new Enemy(0, 0);
        d.addEntity(b);
        d.addEntity(e);
        p.moveUp();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(1, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(2, p.getY());
    }

    @Test //PASS
    public void boulderBlockedByEnemyDown() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(0, 1);
        Enemy e = new Enemy(0, 2);
        d.addEntity(b);
        d.addEntity(e);
        p.moveDown();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(1, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
    }

    @Test //PASS
    public void boulderBlockedByEnemyLeft() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 2, 0);
        Boulder b = new Boulder(1, 0);
        Enemy e = new Enemy(0, 0);
        d.addEntity(b);
        d.addEntity(e);
        p.moveLeft();
        // test boulder positions
        assertEquals(1, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(2, p.getX());
        assertEquals(0, p.getY());
    }
    @Test //PASS
    public void boulderBlockedByEnemyRight() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(1, 0);
        Enemy e = new Enemy(2, 0);
        d.addEntity(b);
        d.addEntity(e);
        p.moveRight();
        // test boulder positions
        assertEquals(1, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
    }

    // ########  BOULDER -> DOOR  #########
    @Test //PASS
    public void boulderBlockedByDoorUp() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 2);
        Boulder b = new Boulder(0, 1);
        Door dr = new Door(0, 0);
        d.addEntity(b);
        d.addEntity(dr);
        p.moveUp();
        assertEquals(true, dr.getLocked());
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(1, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(2, p.getY());
        // UNLOCK DOOR
        dr.unlock();
        assertEquals(false, dr.getLocked());
        p.moveUp();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(1, p.getY()); 
    }
    @Test //PASS
    public void boulderBlockedByDoorDown() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(0, 1);
        Door dr = new Door(0, 2);
        d.addEntity(b);
        d.addEntity(dr);
        p.moveDown();
        assertEquals(true, dr.getLocked());
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(1, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
        // UNLOCK DOOR
        dr.unlock();
        assertEquals(false, dr.getLocked());
        p.moveDown();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(2, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(1, p.getY()); 
    }
    @Test //PASS
    public void boulderBlockedByDoorLeft() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 2, 0);
        Boulder b = new Boulder(1, 0);
        Door dr = new Door(0, 0);
        d.addEntity(b);
        d.addEntity(dr);
        p.moveLeft();
        assertEquals(true, dr.getLocked());
        // test boulder positions
        assertEquals(1, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(2, p.getX());
        assertEquals(0, p.getY());
        // UNLOCK DOOR
        dr.unlock();
        assertEquals(false, dr.getLocked());
        p.moveLeft();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(1, p.getX());
        assertEquals(0, p.getY()); 
    }
    @Test //PASS
    public void boulderBlockedByDoorRight() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(1, 0);
        Door dr = new Door(2, 0);
        d.addEntity(b);
        d.addEntity(dr);
        p.moveRight();
        assertEquals(true, dr.getLocked());
        // test boulder positions
        assertEquals(1, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
        // UNLOCK DOOR
        dr.unlock();
        assertEquals(false, dr.getLocked());
        p.moveRight();
        // test boulder positions
        assertEquals(2, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(1, p.getX());
        assertEquals(0, p.getY()); 
    }

    // ########  BOULDER -> EXIT  #########
    @Test //PASS
    public void boulderBlockedByExitUp() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 2);
        Boulder b = new Boulder(0, 1);
        Exit e = new Exit(0, 0);
        d.addEntity(b);
        d.addEntity(e);
        p.moveDown();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(1, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(2, p.getY());
    }

    @Test //PASS
    public void boulderBlockedByExitDown() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(0, 1);
        Exit e = new Exit(0, 2);
        d.addEntity(b);
        d.addEntity(e);
        p.moveDown();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(1, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
    }

    @Test //PASS
    public void boulderBlockedByExitLeft() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 2, 0);
        Boulder b = new Boulder(1, 0);
        Exit e = new Exit(0, 0);
        d.addEntity(b);
        d.addEntity(e);
        p.moveLeft();
        // test boulder positions
        assertEquals(1, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(2, p.getX());
        assertEquals(0, p.getY());
    }
    @Test //PASS
    public void boulderBlockedByExitRight() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(1, 0);
        Exit e = new Exit(2, 0);
        d.addEntity(b);
        d.addEntity(e);
        p.moveRight();
        // test boulder positions
        assertEquals(1, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
    }

    // ########  BOULDER -> FLOOR SWITCH  #########
    @Test //PASS
    public void boulderOntoSwitchUp() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 2);
        Boulder b = new Boulder(0, 1);
        FloorSwitch s = new FloorSwitch(0, 0);
        d.addEntity(b);
        d.addEntity(s);
        p.moveUp();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(1, p.getY());
    }

    @Test //PASS
    public void boulderOntoSwitchDown() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(0, 1);
        FloorSwitch s = new FloorSwitch(0, 2);
        d.addEntity(b);
        d.addEntity(s);
        p.moveDown();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(2, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(1, p.getY());
    }

    @Test //PASS
    public void boulderOntoSwitchLeft() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 2, 0);
        Boulder b = new Boulder(1, 0);
        FloorSwitch s = new FloorSwitch(0, 0);
        d.addEntity(b);
        d.addEntity(s);
        p.moveLeft();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(1, p.getX());
        assertEquals(0, p.getY());
    }
    @Test //PASS
    public void boulderOntoSwitchRight() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(1, 0);
        FloorSwitch s = new FloorSwitch(2, 0);
        d.addEntity(b);
        d.addEntity(s);
        p.moveRight();
        // test boulder positions
        assertEquals(2, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(1, p.getX());
        assertEquals(0, p.getY());
    }

    // ########  BOULDER -> KEY  #########
    @Test //PASS
    public void boulderOntoKeyUp() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 2);
        Boulder b = new Boulder(0, 1);
        Key k = new Key(0, 0);
        d.addEntity(b);
        d.addEntity(k);
        p.moveUp();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(1, p.getY());
    }
    @Test //PASS
    public void boulderOntoKeyDown() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(0, 1);
        Key k = new Key(0, 2);
        d.addEntity(b);
        d.addEntity(k);
        p.moveDown();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(2, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(1, p.getY());
    }

    @Test //PASS
    public void boulderOntoKeyLeft() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 2, 0);
        Boulder b = new Boulder(1, 0);
        Key k = new Key(0, 0);
        d.addEntity(b);
        d.addEntity(k);
        p.moveLeft();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(1, p.getX());
        assertEquals(0, p.getY());
    }

    @Test //PASS
    public void boulderOntoKeyRight() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(1, 0);
        Key k = new Key(2, 0);
        d.addEntity(b);
        d.addEntity(k);
        p.moveRight();
        // test boulder positions
        assertEquals(2, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(1, p.getX());
        assertEquals(0, p.getY());
    }

    // ########  BOULDER -> SWORD  #########
    @Test //PASS
    public void boulderOntoSwordUp() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 2);
        Boulder b = new Boulder(0, 1);
        Sword k = new Sword(0, 0);
        d.addEntity(b);
        d.addEntity(k);
        p.moveUp();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(1, p.getY());
    }

    @Test //PASS
    public void boulderOntoSwordDown() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(0, 1);
        Sword k = new Sword(0, 2);
        d.addEntity(b);
        d.addEntity(k);
        p.moveDown();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(2, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(1, p.getY());
    }
    @Test //PASS
    public void boulderOntoSwordLeft() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 2, 0);
        Boulder b = new Boulder(1, 0);
        Sword k = new Sword(0, 0);
        d.addEntity(b);
        d.addEntity(k);
        p.moveLeft();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(1, p.getX());
        assertEquals(0, p.getY());
    }
    
    @Test //PASS
    public void boulderOntoSwordRight() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(1, 0);
        Sword k = new Sword(2, 0);
        d.addEntity(b);
        d.addEntity(k);
        p.moveRight();
        // test boulder positions
        assertEquals(2, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(1, p.getX());
        assertEquals(0, p.getY());
    }

    // ########  BOULDER -> TREASURE  #########
    @Test //PASS
    public void boulderOntoTreasureUp() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 2);
        Boulder b = new Boulder(0, 1);
        Treasure k = new Treasure(0, 0);
        d.addEntity(b);
        d.addEntity(k);
        p.moveUp();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(1, p.getY());
    }
    @Test //PASS
    public void boulderOntoTreasureDown() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(0, 1);
        Treasure k = new Treasure(0, 2);
        d.addEntity(b);
        d.addEntity(k);
        p.moveDown();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(2, b.getY());
        // test player position
        assertEquals(0, p.getX());
        assertEquals(1, p.getY());
    }
    @Test //PASS
    public void boulderOntoTreasureLeft() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 2, 0);
        Boulder b = new Boulder(1, 0);
        Treasure k = new Treasure(0, 0);
        d.addEntity(b);
        d.addEntity(k);
        p.moveLeft();
        // test boulder positions
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(1, p.getX());
        assertEquals(0, p.getY());
    }
    @Test //PASS
    public void boulderOntoTreasureRight() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Boulder b = new Boulder(1, 0);
        Treasure k = new Treasure(2, 0);
        d.addEntity(b);
        d.addEntity(k);
        p.moveRight();
        // test boulder positions
        assertEquals(2, b.getX());
        assertEquals(0, b.getY());
        // test player position
        assertEquals(1, p.getX());
        assertEquals(0, p.getY());
    }
    
    public static void main(String[] args) {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 2, 0);
        Boulder b = new Boulder(1, 0);
        Door dr = new Door(0, 0);
        d.addEntity(b);
        d.addEntity(dr);

        p.moveLeft();
        System.out.println("PLAYER: "+p.getX()+","+p.getY());
        System.out.println("BLDR: "+b.getX()+","+b.getY());
        dr.unlock();
        p.moveLeft();
        System.out.println("PLAYER2: "+p.getX()+","+p.getY());
        System.out.println("BLDR2: "+b.getX()+","+b.getY());
    }



}