package unsw.dungeon;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.File;

/**
 * A DungeonLoader that also creates the necessary ImageViews for the UI,
 * connects them via listeners to the model, and creates a controller.
 * 
 * @author Robert Clifton-Everest
 *
 */
public class DungeonControllerLoader extends DungeonLoader {

    private List<ImageView> entities;

    // Images
    private Image playerImage;
    private Image wallImage;
    private Image boulderImage;
    private Image exitImage;
    private Image switchImage;
    private Image treasureImage;
    private Image doorClosedImage;
    private Image doorOpenImage;
    private Image iPotionImage;
    private Image enemyImage;
    private Image swordImage;
    private Image keyImage;
    private Image portalImage;

    public DungeonControllerLoader(String filename) throws FileNotFoundException {
        super(filename);
        entities = new ArrayList<>();
        playerImage = new Image((new File("images/human_new.png")).toURI().toString());
        wallImage = new Image((new File("images/brick_brown_0.png")).toURI().toString());
        // Other entities
        boulderImage = new Image((new File("images/boulder.png")).toURI().toString());
        exitImage = new Image((new File("images/exit.png")).toURI().toString());
        switchImage = new Image((new File("images/pressure_plate.png")).toURI().toString());
        treasureImage = new Image((new File("images/gold_pile.png")).toURI().toString());
        doorClosedImage = new Image((new File("images/closed_door.png")).toURI().toString());
        doorOpenImage = new Image((new File("images/open_door.png")).toURI().toString());
        iPotionImage = new Image((new File("images/brilliant_blue_new.png")).toURI().toString());
        enemyImage = new Image((new File("images/deep_elf_master_archer.png")).toURI().toString());
        keyImage = new Image((new File("images/key.png")).toURI().toString());
        swordImage = new Image((new File("images/greatsword_1_new.png")).toURI().toString());
        portalImage = new Image((new File("images/portal.png")).toURI().toString());
    }

    @Override
    public void onLoad(Entity player) {
        ImageView view = new ImageView(playerImage);
        addEntity(player, view);
    }

    @Override
    public void onLoad(Wall wall) {
        ImageView view = new ImageView(wallImage);
        addEntity(wall, view);
    }

    private void addEntity(Entity entity, ImageView view) {
        trackPosition(entity, view);
        entities.add(view);
    }

    // ADD OTHER ENTITIES
    @Override
    public void onLoad(Boulder boulder) {
        ImageView view = new ImageView(boulderImage);
        addEntity(boulder, view);
    }

    @Override
    public void onLoad(Exit exit) {
        ImageView view = new ImageView(exitImage);
        addEntity(exit, view);
    }

    @Override
    public void onLoad(FloorSwitch fSwitch) {
        ImageView view = new ImageView(switchImage);
        addEntity(fSwitch, view);
    }

    @Override
    public void onLoad(Treasure treasure) {
        ImageView view = new ImageView(treasureImage);
        addEntity(treasure, view);
    }

    @Override
    public void onLoad(Door door) {
        ImageView view = new ImageView(doorClosedImage);
        addEntity(door, view);
        //ImageView view = new 
    }

    @Override
    public void onLoad(InvincibilityPotion iPotion) {
        ImageView view = new ImageView(iPotionImage);
        addEntity(iPotion, view);
    }

    @Override
    public void onLoad(Enemy enemy) {
        ImageView view = new ImageView(enemyImage);
        addEntity(enemy, view);
    }

    @Override
    public void onLoad(Sword sword) {
        ImageView view = new ImageView(swordImage);
        addEntity(sword, view);
    }

    @Override
    public void onLoad(Key key) {
        ImageView view = new ImageView(keyImage);
        addEntity(key, view);
    }

    @Override
    public void onLoad(Portal portal) {
        ImageView view = new ImageView(portalImage);
        addEntity(portal, view);
    }

    /**
     * Set a node in a GridPane to have its position track the position of an entity
     * in the dungeon.
     *
     * By connecting the model with the view in this way, the model requires no
     * knowledge of the view and changes to the position of entities in the model
     * will automatically be reflected in the view.
     * 
     * @param entity
     * @param node
     */
    private void trackPosition(Entity entity, Node node) {
        GridPane.setColumnIndex(node, entity.getX());
        GridPane.setRowIndex(node, entity.getY());
        ChangeListener<Number> xListen = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                GridPane.setColumnIndex(node, newValue.intValue());
            }
        };
        entity.x().addListener(xListen);
        ChangeListener<Number> yListen = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                GridPane.setRowIndex(node, newValue.intValue());
            }
        };
        entity.y().addListener(yListen);
        entity.visibility().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, 
                Boolean oldValue, Boolean newValue) {
                //System.out.println(newValue); //remove
                node.setVisible(newValue);//.booleanValue());
                //node.setVisible(false);

            entity.x().removeListener(xListen);
            entity.y().removeListener(yListen);
            }
        });
        // DOOR
        Door doorTemp = new Door(0,0);
        if (entity.getClass() == doorTemp.getClass()) {
            //Image openDoorView = new ImageView(doorOpenImage);
            Door door = (Door) entity;
            door.lockStatus().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, 
                    Boolean oldValue, Boolean newValue) {
                    //System.out.println(newValue);
                    if (newValue.booleanValue() == false) {
                        //node.setImage
                        ImageView n = (ImageView) node;
                        //n.setImage(openDoorView);
                        n.setImage(doorOpenImage);
                    }
                }
            });
        }
       /*  // Inventory listeners
        Player p = new Player(new Dungeon(3,3),0,0);
        if (entity.getClass() == p.getClass()) {
            Player player = (Player) entity;
            ChangeListener<Number> keyListen = new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    
                    GridPane.setColumnIndex(node, newValue.intValue());
                }
            };
            player.getKeyID().addListener(keyListen);
        } */
    }


    /**
     * Create a controller that can be attached to the DungeonView with all the
     * loaded entities.
     * 
     * @return
     * @throws FileNotFoundException
     */
    public DungeonController loadController() throws FileNotFoundException {
        return new DungeonController(load(), entities);
    }


   


}
