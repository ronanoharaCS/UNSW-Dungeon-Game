package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import unsw.dungeon.Dungeon;
import unsw.dungeon.*;

public class InitialisationTests {
    @Test(expected = IllegalArgumentException.class)
    public void initialiseSmallDungeon(){
        Dungeon d = new Dungeon (1,1);
    }

    @Test
    public void initialiseDungeon(){
        Dungeon d = new Dungeon(1, 2);
        assertEquals(d.getWidth(), 1);
        assertEquals(d.getHeight(), 2);
    }

    @Test
    public void initialiseBigDungeon(){
        Dungeon d = new Dungeon(10, 10);
        assertEquals(d.getWidth(), 10);
        assertEquals(d.getHeight(), 10);
    }

    @Test
    public void initialisePlayer() {
        Dungeon d = new Dungeon(10, 10);
        Player p = new Player(d, 0, 0);
        assertEquals(p.getX(), 0);
        assertEquals(p.getY(), 0);
    }
}