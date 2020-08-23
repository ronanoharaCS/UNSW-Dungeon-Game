package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import unsw.dungeon.Dungeon;
import unsw.dungeon.*;

import java.util.ArrayList;

public class GoalTests {
    //------------------------------------------------------------------------
    //------------------------- Exit -----------------------------------------
    //------------------------------------------------------------------------
    @Test
    public void playerExits() {
        // dungeon and player
        Dungeon d = new Dungeon(3,3);
        Player p = new Player(d, 1, 0);
        d.setPlayer(p);
        // entities and goals
        Exit e = new Exit(1,1);
        d.addEntity(e);
        GoalExit goal = new GoalExit(d);
        d.addGoals(goal);
        // test exit
        assertEquals(d.goalsPassed(), false);
        p.moveDown();
        assertEquals(d.goalsPassed(), true);
    }

    //------------------------------------------------------------------------
    //------------------------- boulders -------------------------------------
    //------------------------------------------------------------------------
    @Test
    public void switchesTwo() {
        // dungeon and player
        Dungeon d = new Dungeon(3,3);
        Player p = new Player(d, 0, 2);
        d.setPlayer(p);
        // add entities 
        Boulder b1 = new Boulder(1,2);
        d.addEntity(b1);
            //
        FloorSwitch fs1 = new FloorSwitch(2,2);
        d.addEntity(fs1);
            //
        Boulder b2 = new Boulder(1,1);
        d.addEntity(b2);
            //
        FloorSwitch fs2 = new FloorSwitch(1,0);
        d.addEntity(fs2);
        // add goals
        GoalBoulder goal = new GoalBoulder(d);
        d.addGoals(goal);
        // test switches
        assertEquals(d.goalsPassed(), false);
        p.moveRight();
        assertEquals(d.goalsPassed(), false);
        p.moveUp();
        assertEquals(d.goalsPassed(), true);
    }

    @Test
    public void switchesUntrigger() {
        // dungeon and player
        Dungeon d = new Dungeon(3,3);
        Player p = new Player(d, 1, 2);
        d.setPlayer(p);
        // add entities 
        Boulder b = new Boulder(1,1);
        d.addEntity(b);
            //
        FloorSwitch switchCentre = new FloorSwitch(1,1);
        switchCentre.setTriggered(true);
        d.addEntity(switchCentre);
            //
        FloorSwitch switchDest = new FloorSwitch(1,0);
        d.addEntity(switchDest);
        // add goals
        GoalBoulder goal = new GoalBoulder(d);
        d.addGoals(goal);
        // test switches -- neither should be triggered
            // at same time and thus fail
        assertEquals(d.goalsPassed(), false);
        assertEquals(switchCentre.isTriggered(), true);
        assertEquals(switchDest.isTriggered(), false);
        p.moveUp();
        assertEquals(switchCentre.isTriggered(), false);
        assertEquals(switchDest.isTriggered(), true);
        assertEquals(d.goalsPassed(), false);
    }

    //------------------------------------------------------------------------
    //------------------------- treasure -------------------------------------
    //------------------------------------------------------------------------
    @Test
    public void treasureSingle() {
        // dungeon and player
        Dungeon d = new Dungeon(3,3);
        Player p = new Player(d, 0, 1);
        d.setPlayer(p);
        // add entities 
        Treasure t = new Treasure(1,1);
        d.addEntity(t);
        // add goals
        GoalTreasure goal = new GoalTreasure(d);
        d.addGoals(goal);
        // test switches -- neither should be triggered
            // at same time and thus fail
        assertEquals(d.goalsPassed(), false);
        p.moveRight();
        assertEquals(d.goalsPassed(), true);
    }

    @Test
    public void treasureTwo() {
        // dungeon and player
        Dungeon d = new Dungeon(3,3);
        Player p = new Player(d, 0, 1);
        d.setPlayer(p);
        // add entities 
        Treasure t = new Treasure(1,1);
        d.addEntity(t);
            //
        Treasure t2 = new Treasure(2,1);
        d.addEntity(t2);
        // add goals
        GoalTreasure goal = new GoalTreasure(d);
        d.addGoals(goal);
        // test switches -- neither should be triggered
            // at same time and thus fail
        assertEquals(d.goalsPassed(), false);
        p.moveRight();
        assertEquals(d.goalsPassed(), false);
        p.moveRight();
        assertEquals(d.goalsPassed(), true);
    }


    //------------------------------------------------------------------------
    //------------------------- enemies --------------------------------------
    //------------------------------------------------------------------------



    //------------------------------------------------------------------------
    //------------------------- AND ------------------------------------------
    //------------------------------------------------------------------------
    @Test
    public void BoulderANDExit() {
        // dungeon and player
        Dungeon d = new Dungeon(3,3);
        Player p = new Player(d, 0, 1);
        d.setPlayer(p);
        // add entities 
        Boulder b1 = new Boulder(1,1);
        d.addEntity(b1);
            //
        FloorSwitch fs1 = new FloorSwitch(2,1);
        d.addEntity(fs1);
            //
        Exit exit = new Exit(1,0);
        d.addEntity(exit);
        // add goals
        GoalCompositeAND boulderANDexit = new GoalCompositeAND();
        GoalBoulder boulderGoal = new GoalBoulder(d);
        GoalExit exitGoal = new GoalExit(d);
        ArrayList<Goal> subGoals = new ArrayList<Goal>();
        subGoals.add(boulderGoal);
        subGoals.add(exitGoal);
        boulderANDexit.addSubGoals(subGoals);
        d.addGoals(boulderANDexit);
        // test switches -- neither should be triggered
            // at same time and thus fail
        assertEquals(d.goalsPassed(), false);
        p.moveRight();
        assertEquals(d.goalsPassed(), false);
        p.moveUp();
        assertEquals(d.goalsPassed(), true);
    }

    //------------------------------------------------------------------------
    //------------------------- OR -------------------------------------------
    //------------------------------------------------------------------------
    @Test
    public void BoulderORExit() {
        // dungeon and player
        Dungeon d = new Dungeon(3,3);
        Player p = new Player(d, 0, 1);
        d.setPlayer(p);
        // add entities 
        Boulder b1 = new Boulder(1,1);
        d.addEntity(b1);
            //
        FloorSwitch fs1 = new FloorSwitch(2,1);
        d.addEntity(fs1);
            //
        Exit exit = new Exit(1,0);
        d.addEntity(exit);
        // add goals
        GoalCompositeOR boulderORexit = new GoalCompositeOR();
        GoalBoulder boulderGoal = new GoalBoulder(d);
        GoalExit exitGoal = new GoalExit(d);
        ArrayList<Goal> subGoals = new ArrayList<Goal>();
        subGoals.add(boulderGoal);
        subGoals.add(exitGoal);
        boulderORexit.addSubGoals(subGoals);
        d.addGoals(boulderORexit);
        // test switches -- neither should be triggered
            // at same time and thus fail
        assertEquals(d.goalsPassed(), false);
        p.moveRight();
        assertEquals(d.goalsPassed(), true);
    }


    //------------------------------------------------------------------------
    //------------------------- AND/OR ---------------------------------------
    //------------------------------------------------------------------------

    @Test
    public void exitAND_boulderORTreasure() {
        // dungeon and player
        Dungeon d = new Dungeon(3,3);
        Player p = new Player(d, 1, 1);
        d.setPlayer(p);
        // add entities 
        Boulder b1 = new Boulder(0,1);
        d.addEntity(b1);
            //
        FloorSwitch fs1 = new FloorSwitch(0,2);
        d.addEntity(fs1);
            //
        Treasure t = new Treasure(2,1);
        d.addEntity(t);
            //
        Exit exit = new Exit(1,0);
        d.addEntity(exit);
        // add goals
        GoalCompositeAND exitAND_ = new GoalCompositeAND();
        ArrayList<Goal> subGoalsAND = new ArrayList<Goal>();
        GoalExit exitGoal = new GoalExit(d);
        subGoalsAND.add(exitGoal);
            //
        GoalCompositeOR boulderORTreasure = new GoalCompositeOR();
        GoalBoulder boulderGoal = new GoalBoulder(d);
        GoalTreasure treasureGoal = new GoalTreasure(d);
        ArrayList<Goal> subGoalsOR = new ArrayList<Goal>();
        subGoalsOR.add(boulderGoal);
        subGoalsOR.add(treasureGoal);
        boulderORTreasure.addSubGoals(subGoalsOR);
            //
        subGoalsAND.add(exitGoal);
        subGoalsAND.add(boulderORTreasure);
        exitAND_.addSubGoals(subGoalsAND);
        d.addGoals(exitAND_);
        // test goals
        assertEquals(d.goalsPassed(), false);
        p.moveUp();
        assertEquals(d.goalsPassed(), false);
        p.moveDown();
        assertEquals(d.goalsPassed(), false);
        p.moveRight();
        assertEquals(d.goalsPassed(), false);
        p.moveLeft();
        assertEquals(d.goalsPassed(), false);
        p.moveUp();
        assertEquals(d.goalsPassed(), true);
    }


}