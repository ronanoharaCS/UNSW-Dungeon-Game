package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import unsw.dungeon.Dungeon;
import unsw.dungeon.*;

public class EnemyTests {
    @Test
    public void enemyDestinationIsPlayer() {
        Dungeon d = new Dungeon(3,3);
        Player p = new Player(d, 0,0);
        Enemy e = new Enemy(2,2);
        p.attach(e);
        d.addEntity(e);
        assertEquals(e.getDestinationX(), 2); //Itself Initially
        assertEquals(e.getDestinationY(), 2);
        p.moveRight(); // Player makes a move
        assertEquals(e.getDestinationX(), 1);
        assertEquals(e.getDestinationY(), 0);
    }
    @Test
    public void enemyDestinationIsPlayerMultipleMoves() {
        Dungeon d = new Dungeon(3,3);
        Player p = new Player(d, 0,0);
        Enemy e = new Enemy(2,2);
        p.attach(e);
        d.addEntity(e);
        assertEquals(e.getDestinationX(), 2); //Itself Initially
        assertEquals(e.getDestinationY(), 2);
        p.moveRight(); // Player makes a move
        assertEquals(e.getDestinationX(), 1); // Destination changes everytime player moves
        assertEquals(e.getDestinationY(), 0);
        p.moveDown();
        assertEquals(e.getDestinationX(), 1);
        assertEquals(e.getDestinationY(), 1);
        p.moveLeft();
        assertEquals(e.getDestinationX(), 0);
        assertEquals(e.getDestinationY(), 1);
        p.moveUp();
        assertEquals(e.getDestinationX(), 0);
        assertEquals(e.getDestinationY(), 0);

    }
    @Test
    public void enemyRunsAwayIfPlayerInvincible() {
        Dungeon d = new Dungeon(3,3);
        Player p = new Player(d, 0,0);
        Enemy e = new Enemy(2,2);
        p.attach(e);
        InvincibilityPotion pot = new InvincibilityPotion(1,1);
        d.addEntity(pot);
        assertEquals(true, e.isHostile());
        p.setState(p.getInvincibleState());
        assertEquals(false, e.isHostile());
    }
}