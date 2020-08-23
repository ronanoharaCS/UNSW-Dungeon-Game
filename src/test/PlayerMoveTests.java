package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import unsw.dungeon.Dungeon;
import unsw.dungeon.*;

public class PlayerMoveTests {
    @Test
    public void playerMovementRight() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0,0);
        p.moveRight();
        assertEquals(p.getX(), 1);
        assertEquals(p.getY(), 0);
    }

    @Test
    public void playerMovementDown() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0,0);
        p.moveDown();
        assertEquals(p.getX(), 0);
        assertEquals(p.getY(), 1);
    }

    @Test
    public void playerMovementLeft() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0,1);
        p.moveLeft();
        assertEquals(p.getX(), 0);
        assertEquals(p.getY(), 1);
    }

    @Test
    public void playerMovementUp() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0,1);
        p.moveUp();
        assertEquals(p.getX(), 0);
        assertEquals(p.getY(), 0);
    }

    @Test
    public void playerMoveRightOffMap() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0,0);
        p.moveRight();
        p.moveRight();
        p.moveRight();
        p.moveRight();
        p.moveRight();
        assertEquals(p.getX(), 2); //Should stay at 2
        assertEquals(p.getY(), 0);
    }

    @Test
    public void playerMoveDownOffMap() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0,0);
        p.moveDown();
        p.moveDown();
        p.moveDown();
        p.moveDown();
        //p.moveDown();
        assertEquals(p.getX(), 0); 
        assertEquals(p.getY(), 2);//Should stay at 2
    }

    @Test
    public void playerMoveUpOffMap() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0,0);
        p.moveUp();
        p.moveUp();
        p.moveUp();
        assertEquals(p.getX(), 0); 
        assertEquals(p.getY(), 0);//Should stay at 0
    }

    @Test
    public void playerMoveLeftOffMap() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0,0);
        p.moveLeft();
        p.moveLeft();
        p.moveLeft();
        assertEquals(p.getX(), 0); 
        assertEquals(p.getY(), 0);//Should stay at 0
    }

}