package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import unsw.dungeon.Dungeon;
import unsw.dungeon.*;

public class PortalTests {
    @Test
    public void playerThroughPortal() {
        Dungeon d = new Dungeon(5, 5);
        Player p = new Player(d, 0, 0);
        Portal port = new Portal(1, 0);
        Portal port1 = new Portal(2,2);
        port.setLink(port1);
        port1.setLink(port);
        d.addEntity(port);
        d.addEntity(port1);
        // test initial position
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
        p.moveRight();
        // test player final position
        assertEquals(2, p.getX());
        assertEquals(2, p.getY());
    }

    public static void main(String[] args) {
        Dungeon d = new Dungeon(5, 5);
        Player p = new Player(d, 0, 0);
        Portal port = new Portal(1, 0);
        Portal port1 = new Portal(2,2);
        port.setLink(port1);
        port1.setLink(port);
        d.addEntity(port);
        d.addEntity(port1);
        System.out.println("initial "+p.getX()+","+p.getY());
        p.moveRight();
        System.out.println("final "+p.getX()+","+p.getY());
    }
}