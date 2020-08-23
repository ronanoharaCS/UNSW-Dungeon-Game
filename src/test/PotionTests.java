package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import unsw.dungeon.Dungeon;
import unsw.dungeon.*;

public  class PotionTests {
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

    @Test
    public void invincibilityEffect() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        InvincibilityPotion t = new InvincibilityPotion(1,0);
        d.addEntity(t);
        assertEquals(true, p.getState() == p.getNormalState());
        p.moveRight();
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveRight(); //1
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveDown(); //2
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveDown(); //3
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveLeft(); //4
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveLeft(); //5
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveUp(); //6
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveDown(); //7
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveUp(); //8
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveDown(); //9
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveUp(); //10 BACK TO NORMAL
        assertEquals(true, p.getState() == p.getNormalState());
    }

    @Test
    public void potionDisappearsAfterUse() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        InvincibilityPotion t = new InvincibilityPotion(1,0);
        d.addEntity(t);
        assertEquals(true, p.getState() == p.getNormalState());
        p.moveRight();
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveRight(); //1
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveDown(); //2
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveDown(); //3
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveLeft(); //4
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveLeft(); //5
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveUp(); //6
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveDown(); //7
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveUp(); //8
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveDown(); //9
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveUp(); //10 BACK TO NORMAL
        assertEquals(true, p.getState() == p.getNormalState());

        //POTION DISAPPEARS
        assertEquals(true, p.getInventory().getiPotion() == null);
    }

    @Test
    public void enemyBecomesNotHostile() {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        InvincibilityPotion t = new InvincibilityPotion(1,0);
        Enemy e = new Enemy(2,2);
        d.addEntity(t);
        assertEquals(true, p.getState() == p.getNormalState());
        p.moveRight();
        //HOSTLE
        //assertEquals(true, e.g);
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveRight(); //1
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveDown(); //2
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveDown(); //3
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveLeft(); //4
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveLeft(); //5
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveUp(); //6
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveDown(); //7
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveUp(); //8
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveDown(); //9
        assertEquals(false, p.getState() == p.getNormalState());
        p.moveUp(); //10 BACK TO NORMAL
        assertEquals(true, p.getState() == p.getNormalState());

        //POTION DISAPPEARS
        assertEquals(true, p.getInventory().getiPotion() == null);
    }

    public static void main(String[] args) {
        Dungeon d = new Dungeon(3, 3);
        Player p = new Player(d, 0, 0);
        InvincibilityPotion t = new InvincibilityPotion(1,0);
        d.addEntity(t);
        System.out.println(p.invincible());
        p.moveRight();
        System.out.println(p.invincible());
        System.out.println(p.getInventory().getiPotion());
    }

}