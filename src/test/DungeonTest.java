// package test;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.Test;
// //import org.junit.jupiter.api.Test;
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.ValueSource;

// import unsw.dungeon.Dungeon;
// import unsw.dungeon.*;
// //import java.util.ArrayList;
// //import java.util.List;
// import java.util.Timer;
// import java.util.TimerTask;


// public class DungeonTest {
//     @Test(expected = IllegalArgumentException.class)
//     public void initialiseSmallDungeon(){
//         Dungeon d = new Dungeon (1,1);
//     }

//     @Test
//     public void initialiseDungeon(){
//         Dungeon d = new Dungeon(1, 2);
//         assertEquals(d.getWidth(), 1);
//         assertEquals(d.getHeight(), 2);
//     }

//     @Test
//     public void initialiseBigDungeon(){
//         Dungeon d = new Dungeon(10, 10);
//         assertEquals(d.getWidth(), 10);
//         assertEquals(d.getHeight(), 10);
//     }

//     @Test
//     public void initialisePlayer() {
//         Dungeon d = new Dungeon(10, 10);
//         Player p = new Player(d, 0, 0);
//         assertEquals(p.getX(), 0);
//         assertEquals(p.getY(), 0);
//     }

//     // ###########################################################
//     // ############# Player movement w/out Boulders ##############
//     // ###########################################################

//     @Test
//     public void playerMovementRightDown() {
//         Dungeon d = new Dungeon(10, 10);
//         Player p = new Player(d, 0,0);
//         p.moveRight();
//         assertEquals(p.getX(), 1);
//         assertEquals(p.getY(), 0);
//         p.moveDown();
//         assertEquals(p.getX(), 1);
//         assertEquals(p.getY(), 1);
//     }

//     @Test
//     public void playerMovementLeftUp() {
//         Dungeon d = new Dungeon(10, 10);
//         Player p = new Player(d, 1,1);
//         p.moveLeft();
//         assertEquals(p.getX(), 0);
//         assertEquals(p.getY(), 1);
//         p.moveUp();
//         assertEquals(p.getX(), 0);
//         assertEquals(p.getY(), 0);
//     }

//     @Test
//     public void playerMoveRightOffMap() {
//         Dungeon d = new Dungeon(3, 3);
//         Player p = new Player(d, 0,0);
//         p.moveRight();
//         p.moveRight();
//         p.moveRight();
//         p.moveRight();
//         p.moveRight();
//         assertEquals(p.getX(), 2); //Should stay at 2
//         assertEquals(p.getY(), 0);
//     }

//     @Test
//     public void playerMoveDownOffMap() {
//         Dungeon d = new Dungeon(3, 3);
//         Player p = new Player(d, 0,0);
//         p.moveDown();
//         p.moveDown();
//         p.moveDown();
//         p.moveDown();
//         //p.moveDown();
//         assertEquals(p.getX(), 0); 
//         assertEquals(p.getY(), 2);//Should stay at 9
//     }

//     @Test
//     public void playerMoveUpOffMap() {
//         Dungeon d = new Dungeon(3, 3);
//         Player p = new Player(d, 0,0);
//         p.moveUp();
//         p.moveUp();
//         p.moveUp();
//         assertEquals(p.getX(), 0); 
//         assertEquals(p.getY(), 0);//Should stay at 0
//     }

//     @Test
//     public void playerMoveLeftOffMap() {
//         Dungeon d = new Dungeon(3, 3);
//         Player p = new Player(d, 0,0);
//         p.moveLeft();
//         p.moveLeft();
//         p.moveLeft();
//         assertEquals(p.getX(), 0); 
//         assertEquals(p.getY(), 0);//Should stay at 0
//     }

//     @Test
//     public void playerMoveIntoWall() {
//         Dungeon d = new Dungeon(2, 2);
//         Player p = new Player(d, 0,0);
//         Wall w = new Wall(1, 0);
//         d.addEntity(w);
//         p.moveRight();
//         assertEquals(p.getX(), 0); //Should stay at 0 since cannot move into wall
//         assertEquals(p.getY(), 0);

//     }
    
    
//     // ###########################################################
//     @Test
//     public void playerMoveThroughPortalUp() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Portal port = new Portal(2, 1);
//         Portal port1 = new Portal(0,0);
//         port.setLink(port1);
//         port1.setLink(port);
//         d.addEntity(port);
//         d.addEntity(port1);
//         // test initial position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//         p.moveUp();
//         // test player final position
//         assertEquals(0, p.getX());
//         assertEquals(0, p.getY());
//     }

//     @Test
//     public void playerMoveThroughPortalDown() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Portal port = new Portal(2, 3);
//         Portal port1 = new Portal(0, 0);
//         port.setLink(port1);
//         port1.setLink(port);
//         d.addEntity(port);
//         d.addEntity(port1);
//         // test initial position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//         p.moveDown();
//         // test player final position
//         assertEquals(0, p.getX());
//         assertEquals(0, p.getY());
//     }

//     @Test
//     public void playerMoveThroughPortalLeft() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Portal port = new Portal(1, 2);
//         Portal port1 = new Portal(0, 0);
//         port.setLink(port1);
//         port1.setLink(port);
//         d.addEntity(port);
//         d.addEntity(port1);
//         // test initial position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//         p.moveLeft();
//         // test player final position
//         assertEquals(0, p.getX());
//         assertEquals(0, p.getY());
//     }

//     @Test
//     public void playerMoveThroughPortalRight() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Portal port = new Portal(3, 2);
//         Portal port1 = new Portal(0, 0);
//         port.setLink(port1);
//         port1.setLink(port);
//         d.addEntity(port);
//         d.addEntity(port1);
//         // test initial position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//         p.moveRight();
//         // test player final position
//         assertEquals(0, p.getX());
//         assertEquals(0, p.getY());
//     }

//     // ###########################################################
//     // ############# Player movement w/ Boulders #################
//     // ###########################################################
//     @Test
//     public void playerMoveBoulderUp(){
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(2,1);
//         d.addEntity(b);
//         p.moveUp();
//         // test boulder position
//         assertEquals(2, b.getX());
//         assertEquals(0, b.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(1, p.getY());
//     }

//     @Test
//     public void playerMoveBoulderDown() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(2, 3);
//         d.addEntity(b);
//         p.moveDown();
//         // test boulder position
//         assertEquals(2, b.getX());
//         assertEquals(4, b.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(3, p.getY());
//     }

//     @Test
//     public void playerMoveBoulderLeft() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(1, 2);
//         d.addEntity(b);
//         p.moveLeft();
//         // test boulder position
//         assertEquals(0, b.getX());
//         assertEquals(2, b.getY());
//         // test player position
//         assertEquals(1, p.getX());
//         assertEquals(2, p.getY());
//     }

//     @Test
//     public void playerMoveBoulderRight() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(3, 2);
//         d.addEntity(b);
//         p.moveRight();
//         // test boulder position
//         assertEquals(4, b.getX());
//         assertEquals(2, b.getY());
//         // test player position
//         assertEquals(3, p.getX());
//         assertEquals(2, p.getY());
//     }

//     // ###########################################################
//     @Test
//     public void boulderBlockedByBoundaryUp() {
//         Dungeon d = new Dungeon(3, 3);
//         Player p = new Player(d, 1, 1);
//         Boulder b = new Boulder(1, 0);
//         d.addEntity(b);
//         p.moveUp();
//         // test boulder position
//         assertEquals(1, b.getX());
//         assertEquals(0, b.getY());
//         // test player position
//         assertEquals(1, p.getX());
//         assertEquals(1, p.getY());
//     }

//     @Test
//     public void boulderBlockedByBoundaryDown() {
//         Dungeon d = new Dungeon(3, 3);
//         Player p = new Player(d, 1, 1);
//         Boulder b = new Boulder(1, 2);
//         d.addEntity(b);
//         p.moveDown();
//         // test boulder position
//         assertEquals(1, b.getX());
//         assertEquals(2, b.getY());
//         // test player position
//         assertEquals(1, p.getX());
//         assertEquals(1, p.getY());
//     }

//     @Test
//     public void boulderBlockedByBoundaryLeft() {
//         Dungeon d = new Dungeon(3, 3);
//         Player p = new Player(d, 1, 1);
//         Boulder b = new Boulder(0, 1);
//         d.addEntity(b);
//         p.moveLeft();
//         // test boulder position
//         assertEquals(0, b.getX());
//         assertEquals(1, b.getY());
//         // test player position
//         assertEquals(1, p.getX());
//         assertEquals(1, p.getY());
//     }

//     @Test
//     public void boulderBlockedByBoundaryRight() {
//         Dungeon d = new Dungeon(3, 3);
//         Player p = new Player(d, 1, 1);
//         Boulder b = new Boulder(2, 1);
//         d.addEntity(b);
//         p.moveRight();
//         // test boulder position
//         assertEquals(2, b.getX());
//         assertEquals(1, b.getY());
//         // test player position
//         assertEquals(1, p.getX());
//         assertEquals(1, p.getY());
//     }

//     // ###########################################################
//     @Test
//     public void boulderBlockedByBoulderUp() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(2, 1);
//         Boulder b1 = new Boulder(2, 0);
//         d.addEntity(b);
//         d.addEntity(b1);
//         p.moveUp();
//         // test boulder positions
//         assertEquals(2, b.getX());
//         assertEquals(1, b.getY());
//         assertEquals(2, b1.getX());
//         assertEquals(0, b1.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }

//     @Test
//     public void boulderBlockedByBoulderDown() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(2, 3);
//         Boulder b1 = new Boulder(2, 4);
//         d.addEntity(b);
//         d.addEntity(b1);
//         p.moveDown();
//         // test boulder positions
//         assertEquals(2, b.getX());
//         assertEquals(3, b.getY());
//         assertEquals(2, b1.getX());
//         assertEquals(4, b1.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }

//     @Test
//     public void boulderBlockedByBoulderLeft() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(1, 2);
//         Boulder b1 = new Boulder(0, 2);
//         d.addEntity(b);
//         d.addEntity(b1);
//         p.moveLeft();
//         // test boulder positions
//         assertEquals(1, b.getX());
//         assertEquals(2, b.getY());
//         assertEquals(0, b1.getX());
//         assertEquals(2, b1.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }

//     @Test
//     public void boulderBlockedByBoulderRight() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(3, 2);
//         Boulder b1 = new Boulder(4, 2);
//         d.addEntity(b);
//         d.addEntity(b1);
//         p.moveRight();
//         // test boulder positions
//         assertEquals(3, b.getX());
//         assertEquals(2, b.getY());
//         assertEquals(4, b1.getX());
//         assertEquals(2, b1.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }
    
//     // ###########################################################
//     @Test
//     public void boulderBlockedByWallUp() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(2, 1);
//         Wall w = new Wall(2, 0);
//         d.addEntity(b);
//         d.addEntity(w);
//         p.moveUp();
//         // test boulder positions
//         assertEquals(2, b.getX());
//         assertEquals(1, b.getY());
//         assertEquals(2, w.getX());
//         assertEquals(0, w.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }
    
//     @Test
//     public void boulderBlockedByWallDown() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(2, 3);
//         Wall w = new Wall(2, 4);
//         d.addEntity(b);
//         d.addEntity(w);
//         p.moveDown();
//         // test boulder positions
//         assertEquals(2, b.getX());
//         assertEquals(3, b.getY());
//         assertEquals(2, w.getX());
//         assertEquals(4, w.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }

//     @Test
//     public void boulderBlockedByWallLeft() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(1, 2);
//         Wall w = new Wall(0, 2);
//         d.addEntity(b);
//         d.addEntity(w);
//         p.moveLeft();
//         // test boulder positions
//         assertEquals(1, b.getX());
//         assertEquals(2, b.getY());
//         assertEquals(0, w.getX());
//         assertEquals(2, w.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }

//     @Test
//     public void boulderBlockedByWallRight() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(3, 2);
//         Wall w = new Wall(4, 2);
//         d.addEntity(b);
//         d.addEntity(w);
//         p.moveRight();
//         // test boulder positions
//         assertEquals(3, b.getX());
//         assertEquals(2, b.getY());
//         assertEquals(4, w.getX());
//         assertEquals(2, w.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }
    
//     // ###########################################################
//     @Test
//     public void boulderBlockedByClosedDoorUp() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(2, 1);
//         Door door = new Door(2, 0);
//         d.addEntity(b);
//         d.addEntity(door);
//         p.moveUp();
//         // test boulder positions
//         assertEquals(2, b.getX());
//         assertEquals(1, b.getY());
//         assertEquals(2, door.getX());
//         assertEquals(0, door.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }

//     @Test
//     public void boulderBlockedByClosedDoorDown() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(2, 3);
//         Door door = new Door(2, 4);
//         d.addEntity(b);
//         d.addEntity(door);
//         p.moveDown();
//         // test boulder positions
//         assertEquals(2, b.getX());
//         assertEquals(3, b.getY());
//         assertEquals(2, door.getX());
//         assertEquals(4, door.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }

//     @Test
//     public void boulderBlockedByClosedDoorLeft() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(1, 2);
//         Door door = new Door(0, 2);
//         d.addEntity(b);
//         d.addEntity(door);
//         p.moveLeft();
//         // test boulder positions
//         assertEquals(1, b.getX());
//         assertEquals(2, b.getY());
//         assertEquals(0, door.getX());
//         assertEquals(2, door.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }

//     @Test
//     public void boulderBlockedByClosedDoorRight() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(3, 2);
//         Door door = new Door(4, 2);
//         d.addEntity(b);
//         d.addEntity(door);
//         p.moveRight();
//         // test boulder positions
//         assertEquals(3, b.getX());
//         assertEquals(2, b.getY());
//         assertEquals(4, door.getX());
//         assertEquals(2, door.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }

//     // ###########################################################
//     @Test
//     public void boulderThroughOpenDoorUp() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(2, 1);
//         Door door = new Door(2, 0);
//         door.unlock();
//         d.addEntity(b);
//         d.addEntity(door);
//         p.moveUp();
//         // test boulder positions
//         assertEquals(2, b.getX());
//         assertEquals(0, b.getY());
//         assertEquals(2, door.getX());
//         assertEquals(0, door.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(1, p.getY());
//     }

//     @Test
//     public void boulderThroughOpenDoorDown() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(2, 3);
//         Door door = new Door(2, 4);
//         door.unlock();
//         d.addEntity(b);
//         d.addEntity(door);
//         p.moveDown();
//         // test boulder positions
//         assertEquals(2, b.getX());
//         assertEquals(4, b.getY());
//         assertEquals(2, door.getX());
//         assertEquals(4, door.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(3, p.getY());
//     }

//     @Test
//     public void boulderThroughOpenDoorLeft() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(1, 2);
//         Door door = new Door(0, 2);
//         door.unlock();
//         d.addEntity(b);
//         d.addEntity(door);
//         p.moveLeft();
//         // test boulder positions
//         assertEquals(0, b.getX());
//         assertEquals(2, b.getY());
//         assertEquals(0, door.getX());
//         assertEquals(2, door.getY());
//         // test player position
//         assertEquals(1, p.getX());
//         assertEquals(2, p.getY());
//     }

//     @Test
//     public void boulderThroughOpenDoorRight() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(3, 2);
//         Door door = new Door(4, 2);
//         door.unlock();
//         d.addEntity(b);
//         d.addEntity(door);
//         p.moveRight();
//         // test boulder positions
//         assertEquals(4, b.getX());
//         assertEquals(2, b.getY());
//         assertEquals(4, door.getX());
//         assertEquals(2, door.getY());
//         // test player position
//         assertEquals(3, p.getX());
//         assertEquals(2, p.getY());
//     }

//     // ###########################################################
//     @Test
//     public void boulderOntoSwitch() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(1, 2);
//         FloorSwitch fs = new FloorSwitch(0, 2);
//         d.addEntity(b);
//         d.addEntity(fs);
//         // test initially untriggered
//         assertEquals(false, fs.isTriggered());
//         // move boulder
//         p.moveLeft();
//         // test new triggered status
//         assertEquals(true, fs.isTriggered());
//         // test boulder positions
//         assertEquals(0, b.getX());
//         assertEquals(2, b.getY());
//         assertEquals(0, fs.getX());
//         assertEquals(2, fs.getY());
//         // test player position
//         assertEquals(1, p.getX());
//         assertEquals(2, p.getY());
//     }

//     @Test
//     public void boulderOffOfSwitch() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 1, 2);
//         Boulder b = new Boulder(2, 2);
//         FloorSwitch fs = new FloorSwitch(2, 2);
//         fs.setTriggered(true);
//         d.addEntity(b);
//         d.addEntity(fs);
//         // test initially triggered
//         assertEquals(true, fs.isTriggered());
//         // move boulder
//         p.moveRight();
//         // test new triggered status
//         assertEquals(false, fs.isTriggered());
//         // test boulder positions
//         assertEquals(3, b.getX());
//         assertEquals(2, b.getY());
//         assertEquals(2, fs.getX());
//         assertEquals(2, fs.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }

//     // ###########################################################
//     @Test
//     public void boulderBlockedByPortalUp() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(2, 1);
//         Portal port = new Portal(2, 0);
//         d.addEntity(b);
//         d.addEntity(port);
//         p.moveUp();
//         // test boulder positions
//         assertEquals(2, b.getX());
//         assertEquals(1, b.getY());
//         assertEquals(2, port.getX());
//         assertEquals(0, port.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }

//     @Test
//     public void boulderBlockedByPortalDown() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(2, 3);
//         Portal port = new Portal(2, 4);
//         d.addEntity(b);
//         d.addEntity(port);
//         p.moveDown();
//         // test boulder positions
//         assertEquals(2, b.getX());
//         assertEquals(3, b.getY());
//         assertEquals(2, port.getX());
//         assertEquals(4, port.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }

//     @Test
//     public void boulderBlockedByPortalLeft() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(1, 2);
//         Portal port = new Portal(0, 2);
//         d.addEntity(b);
//         d.addEntity(port);
//         p.moveLeft();
//         // test boulder positions
//         assertEquals(1, b.getX());
//         assertEquals(2, b.getY());
//         assertEquals(0, port.getX());
//         assertEquals(2, port.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }

//     @Test
//     public void boulderBlockedByPortalRight() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(3, 2);
//         Portal port = new Portal(4, 2);
//         d.addEntity(b);
//         d.addEntity(port);
//         p.moveRight();
//         // test boulder positions
//         assertEquals(3, b.getX());
//         assertEquals(2, b.getY());
//         assertEquals(4, port.getX());
//         assertEquals(2, port.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }

//     // ###########################################################
//     @Test
//     public void boulderBlockedByEnemyUp() {
//         Dungeon d = new Dungeon(5, 5);
//         Player p = new Player(d, 2, 2);
//         Boulder b = new Boulder(2, 1);
//         Enemy e = new Enemy(2, 0);
//         d.addEntity(b);
//         d.addEntity(e);
//         p.moveUp();
//         // test boulder positions
//         assertEquals(2, b.getX());
//         assertEquals(1, b.getY());
//         // test player position
//         assertEquals(2, p.getX());
//         assertEquals(2, p.getY());
//     }
   
//     // ###########################################################
//     // ###########################################################
//     // ###########################################################
   

//     @Test
//     public void enemyDestinationIsItselfInitially() {
//         Dungeon d = new Dungeon(3,3);
//         Player p = new Player(d, 0,0);
//         Enemy e = new Enemy(2,2);
//         d.addEntity(e);
//         assertEquals(e.getDestinationX(), 2);
//         assertEquals(e.getDestinationY(), 2);
//     }

//     @Test
//     public void enemyDestinationIsPlayer() {
//         Dungeon d = new Dungeon(3,3);
//         Player p = new Player(d, 0,0);
//         Enemy e = new Enemy(2,2);
//         p.attach(e);
//         d.addEntity(e);
//         assertEquals(e.getDestinationX(), 2); //Itself Initially
//         assertEquals(e.getDestinationY(), 2);
//         p.moveRight(); // Player makes a move
//         assertEquals(e.getDestinationX(), 1);
//         assertEquals(e.getDestinationY(), 0);
//     }

//     @Test
//     public void enemyDestinationIsPlayerMultipleMoves() {
//         Dungeon d = new Dungeon(3,3);
//         Player p = new Player(d, 0,0);
//         Enemy e = new Enemy(2,2);
//         p.attach(e);
//         d.addEntity(e);
//         assertEquals(e.getDestinationX(), 2); //Itself Initially
//         assertEquals(e.getDestinationY(), 2);
//         p.moveRight(); // Player makes a move
//         assertEquals(e.getDestinationX(), 1); // Destination changes everytime player moves
//         assertEquals(e.getDestinationY(), 0);
//         p.moveDown();
//         assertEquals(e.getDestinationX(), 1);
//         assertEquals(e.getDestinationY(), 1);
//         p.moveLeft();
//         assertEquals(e.getDestinationX(), 0);
//         assertEquals(e.getDestinationY(), 1);
//         p.moveUp();
//         assertEquals(e.getDestinationX(), 0);
//         assertEquals(e.getDestinationY(), 0);

//     }

//     @Test
//     public void enemyRunsAwayIfPlayerInvincible() {
//         Dungeon d = new Dungeon(3,3);
//         Player p = new Player(d, 0,0);
//         Enemy e = new Enemy(2,2);
//         p.attach(e);
//         InvincibilityPotion pot = new InvincibilityPotion(1,1);
//         d.addEntity(pot);
//         assertEquals(true, e.isHostile());
//         p.setPotion(pot);
//         assertEquals(false, e.isHostile());
//     }

//     @Test
//     public void playerPickUpTreasure() {
//         Dungeon d = new Dungeon(3, 3);
//         Player p = new Player(d, 0,0);
//         Treasure t = new Treasure(1, 0);
//         p.attach(d);
//         d.addEntity(t);
//         assertEquals(true, p.getTreasure().isEmpty()); //Player treasure empty
//         p.moveRight(); //Player walks over treasure
//         assertEquals(false, p.getTreasure().isEmpty()); //Treasure picked up
//         assertEquals(false, d.getEntitiesBySquare(1, 0).contains(t)); //Square now empty
//     }

//     @Test
//     public void playerPickUpMultipleTreasure() {
//         Dungeon d = new Dungeon(3, 3);
//         Player p = new Player(d, 0,0);
//         Treasure t1 = new Treasure(1, 0);
//         Treasure t2 = new Treasure(2, 0);
//         Treasure t3 = new Treasure(2,1);
//         p.attach(d);
//         d.addEntity(t1);
//         d.addEntity(t2);
//         d.addEntity(t3);
//         assertEquals(true, p.getTreasure().isEmpty()); //Player treasure empty
//         p.moveRight();
//         assertEquals(2, d.getEntities().size()); //2 Left to collect
//         p.moveRight();
//         p.moveDown();
//         assertEquals(0, d.getEntities().size()); //No more treasure to collect
//         assertEquals(3, p.getTreasure().size()); //3 treasure in player inventory
//     }

//     @Test
//     public void playerPickUpKey() {
//         Dungeon d = new Dungeon(3, 3);
//         Player p = new Player(d, 0,0);
//         Key k = new Key(0,1);
//         d.addEntity(k);
//         p.attach(d);
//         assertEquals(true, p.getKey() == null); //Player sword slot empty
//         p.moveDown();
//         assertEquals(false, p.getKey() == null); //Player sword slot full
//         assertEquals(true, d.getEntitiesBySquare(0, 1).isEmpty()); //Square not empty
//     }

//     @Test
//     public void playerPickUp2ndKey() {
//         Dungeon d = new Dungeon(3, 3);
//         Player p = new Player(d, 0,0);
//         Key k1 = new Key(0,1);
//         Key k2 = new Key(1,1);
//         d.addEntity(k1);
//         d.addEntity(k2);
//         p.attach(d);
//         assertEquals(true, p.getKey() == null); //Player sword slot empty
//         p.moveDown();
//         assertEquals(false, p.getKey() == null); //Player sword slot full
//         assertEquals(true, d.getEntitiesBySquare(0, 1).isEmpty()); //Square not empty
//         assertEquals(true, p.getKey() == k1); //Player has key 1
//         p.moveRight(); //Player walks over 2nd key
//         assertEquals(false, p.getKey() == k1); 
//         assertEquals(true, p.getKey() == k2); //Player now has key 2
//         assertEquals(true, d.getEntitiesBySquare(1, 1).contains(k1)); //Square now contains key 1
//     }

//     @Test
//     public void playerUnlocksDoorWithKey() {
//         Dungeon d = new Dungeon(3,3);
//         Player p = new Player(d, 0,0);
//         Key k1 = new Key(0,1);
//         Door door = new Door(1,1);
//         p.attach(d);
//         d.addEntity(k1);
//         d.addEntity(door);
//         assertEquals(true, p.getKey() == null); //Player sword slot empty
//         p.moveDown(); //Player collects key
//         assertEquals(true, p.getKey() == k1);
//         p.moveRight();
//         assertEquals(0, p.getX());
//         assertEquals(1, p.getY()); //Can't move through
//         door.setKey(k1); //Set key for door
//         p.moveRight();
//         assertEquals(1, p.getX());
//         assertEquals(1, p.getY());//Can walk through
//     }

//     @Test
//     public void playerPickUpSword() {
//         Dungeon d = new Dungeon(3,3);
//         Player p = new Player(d, 0,0);
//         Sword s = new Sword(0, 1);
//         p.attach(d);
//         d.addEntity(s);
//         assertEquals(true, p.getSword() == null); //Player no sword
//         p.moveDown();
//         assertEquals(false, p.getSword() == null);
//         assertEquals(true, p.getSword().equals(s)); //Player has sword
//         assertEquals(false, d.getEntitiesBySquare(0, 1).contains(s)); //Empty square now
//         p.moveDown();
//         assertEquals(false, p.getSword() == null); //Check player still has sword
//     }   

//     @Test
//     public void playerCantPickUpMultipleSwords() {
//         Dungeon d = new Dungeon(3,3);
//         Player p = new Player(d, 0,0);
//         Sword s1 = new Sword(0, 1);
//         Sword s2 = new Sword(0,2);
//         p.attach(d);
//         d.addEntity(s1);
//         d.addEntity(s2);
//         assertEquals(true, p.getSword() == null); //Player no sword
//         p.moveDown();
//         assertEquals(false, p.getSword() == null);
//         assertEquals(true, p.getSword().equals(s1)); //Player has sword
//         p.moveDown();
//         assertEquals(false, p.getSword().equals(s2)); //Player has s1 not s2
//     }

//     @Test
//     public void playerPickUpPotion() {
//         Dungeon d = new Dungeon(3,3);
//         Player p = new Player(d, 0,0);
//         InvincibilityPotion pot = new InvincibilityPotion(1, 0);
//         p.attach(d);
//         d.addEntity(pot);
//         assertEquals(true, p.getPotion() == null); // no potion
//         p.moveRight();
//         assertEquals(false, p.getPotion() == null); // no potion
//         assertEquals(true, p.getPotion().equals(pot));
//     }

//     @Test
//     public void playerCantPickUpMultiplePotion() {
//         Dungeon d = new Dungeon(3,3);
//         Player p = new Player(d, 0,0);
//         InvincibilityPotion p1 = new InvincibilityPotion(1, 0);
//         InvincibilityPotion p2 = new InvincibilityPotion(2, 0);
//         p.attach(d);
//         d.addEntity(p1);
//         d.addEntity(p2);
//         assertEquals(true, p.getPotion() == null); // no potion
//         p.moveRight();
//         assertEquals(true, p.getPotion().equals(p1)); //player has p1
//         p.moveRight();
//         assertEquals(false, p.getPotion().equals(p2)); //player still has p1
//         assertEquals(true, p.getPotion().equals(p1));
//     }





//     // CHANGE ALL FROM ACTUAL, EXPECTED TO EXPECTED, ACTUAL
    
//    /*  @Test
//     public void enemyFollowsPlayer() {
//         Dungeon d = new Dungeon(3,3);
//         Player p = new Player(d, 0,0);
//         Enemy e = new Enemy(2,2);
//         p.attach(e);
//         d.addEntity(e);
//         d.attach(e); 
//         assertEquals(e.getDestinationX(), 2); //Itself Initially
//         assertEquals(e.getDestinationY(), 2);
//         Timer timer = new Timer();
//         TimerTask check = new TimerTask() {
//             @Override
//             public void run() {

//             }
//         }
//         p.moveRight();
//         assertEquals(0, e.getX());
//         assertEquals(0, e.getY());


//     } */
    


    




//     /* public static String printDungeon(Dungeon d) {
//         String board = "";
//         for (int i = 0; i < d.getHeight(); i++) {
//             board.concat("|");
//             for (int j = 0; j < d.getWidth(); j++) {
//                 for (Entity entity : d.getEntities()) {
//                     if ((entity.getY() == i) && (entity.getX() == j)) {
//                         //System.out.print(" X ");
//                         board.concat("X");
//                         break;
//                     }
//                     else {
//                         System.out.print("[ ]");
//                         //break;
//                         board.concat("_");
//                         break;
//                     //}
//                     }
                    
//                 }
//                 System.out.println("");
//                 //board.concat("\n");
//             }
            
//         }
//         return board;
//     } */


//     //public static void main(String[] args) {
//         // Tests enemy
//         /* Dungeon d = new Dungeon(3,3);
//         Player p = new Player(d, 0,0);
//         Enemy e = new Enemy(2,2);
//         System.out.println(e.getX()+","+e.getY());
//         p.attach(e);
//         d.addEntity(e);
//         //Wall w = new Wall(1,1);
//         //d.addEntity(w);
//         //d.attach(e); 
//         //p.attach(d);
//         p.moveDown(); */
    
//         // Tests pickup
//         /* Dungeon d = new Dungeon(3,3);
//         Player p = new Player(d, 0,0);
//         Treasure t = new Treasure(0,1);
//         p.attach(d);
//         d.addEntity(t);
//         System.out.println(p.getTreasure());
//         System.out.println(d.getEntitiesBySquare(0, 1));
//         p.moveDown();
//         System.out.println(p.getTreasure());

//         Dungeon d = new Dungeon(3, 3);
//         Player p = new Player(d, 0,0);
//         Key k = new Key(0,1);
//         d.addEntity(k);
//         p.attach(d);
//         assertEquals(true, p.getKey() == null); //Player sword slot empty
//         p.moveRight();
//         assertEquals(true, p.getKey() == null); */


//     //}  
    
// }