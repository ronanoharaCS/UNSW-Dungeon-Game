package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;

import unsw.dungeon.Dungeon;
import unsw.dungeon.*;

public class PlayerInventoryTest {
    // ############## TREASURE #################
    @Test //PASS
    public void collectTreasure() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Treasure t = new Treasure(1,0);
        d.addEntity(t);
        assertEquals(true, p.getInventory().getTreasure().size() == 0);
        p.moveRight();
        assertEquals(false, p.getInventory().getTreasure().size() == 0);
    }

    @Test
    public void treasureDisappears() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Treasure t = new Treasure(1,0);
        d.addEntity(t);
        assertEquals(true, t.getVisible() == true);
        p.moveRight();
        assertEquals(false, t.getVisible() == true);
    }
    
    @Test //PASS
    public void collectSword() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Sword t = new Sword(1,0);
        d.addEntity(t);
        assertEquals(true, p.getInventory().getSword() == null);
        p.moveRight();
        assertEquals(false, p.getInventory().getSword() == null);
    }

    @Test //PASS
    public void collectPotion() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        InvincibilityPotion t = new InvincibilityPotion(1,0);
        d.addEntity(t);
        assertEquals(true, p.getInventory().getiPotion() == null);
        p.moveRight();
        assertEquals(false, p.getInventory().getiPotion() == null);
    }
    
    public static void main(String[] args) {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        Sword t = new Sword(1,0);
        d.addEntity(t);
        p.moveRight();
        if (p.getInventory().getSword() == null) System.out.println("EMPTY");
    }
    
}