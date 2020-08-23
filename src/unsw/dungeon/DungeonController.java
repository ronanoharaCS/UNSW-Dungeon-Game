package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

/**
 * A JavaFX controller for the dungeon.
 * @author Robert Clifton-Everest
 *
 */
public class DungeonController {
    @FXML
    private BorderPane background;
    @FXML
    private GridPane inventory;
    @FXML
    private GridPane squares;
    @FXML
    private Label keyID;
    @FXML
    private Label hits;
    @FXML
    private Label nTreasure;
    @FXML
    private Label moves;

    private List<ImageView> initialEntities;

    private Player player;

    private Dungeon dungeon;

    private SelectorScreen selectorScreen;
    private GameFailureScreen failureScreen;
    private GameSuccessScreen successScreen;
    

    /* @FXML
    private GridPane extra; */
    

    public DungeonController(Dungeon dungeon, List<ImageView> initialEntities) {
        this.dungeon = dungeon;
        this.player = dungeon.getPlayer();
        this.initialEntities = new ArrayList<>(initialEntities);
    }

    @FXML
    public void initialize() {
        Image ground = new Image((new File("images/dirt_0_new.png")).toURI().toString());
        //squares.getChildren().clear();
        // Add the ground first so it is below all other entities
        for (int x = 0; x < dungeon.getWidth(); x++) {
            for (int y = 0; y < dungeon.getHeight(); y++) {
                squares.add(new ImageView(ground), x, y);
            }
        }

        for (ImageView entity : initialEntities)
            squares.getChildren().add(entity);
    }

    @FXML
    public void editInventory() {
        if (player.armed()) {
            String h = Integer.toString(player.getInventory().nHits());
            hits.setText(h);
        } else {
            hits.setText("-");
        }
        if (player.invincible()) {
            String m = Integer.toString(player.getInventory().getiPotion().getUses());
            moves.setText(m);
        } else {
            moves.setText(Integer.toString(0));
        }
        if (player.getInventory().getKey() != null) {
            String id = Integer.toString(player.getInventory().getKey().getId());
            keyID.setText(id);
        } else {
            keyID.setText("-");
        }
        String n = Integer.toString(player.getInventory().nTreasure());
        nTreasure.setText(n);
    }

    @FXML
    public void handleBack(ActionEvent event) {
        this.selectorScreen.start();
    }

    @FXML
    public void handleRefresh(ActionEvent event) {
        DungeonApplication.refresh();
    }

    @FXML
    public void handleKeyPress(KeyEvent event) {
        //Connect enemies
        dungeon.triggerEnemies();
        
        switch (event.getCode()) {
        case UP:
            player.moveUp();
            break;
        case DOWN:
            player.moveDown();
            break;
        case LEFT:
            player.moveLeft();
            break;
        case RIGHT:
            player.moveRight();
            break;
        /* case R:
            DungeonApplication.restart();
            break; */
        default:
            break;
        }

        if (dungeon.getComplete()) {
            success();
        }
        if (!player.isAlive()) {
            failure();
        }
        editInventory();

    }

    public void setSelectorScreen(SelectorScreen selectorScreen) {
        this.selectorScreen = selectorScreen;
    }
    public void setSuccessScreen(GameSuccessScreen successScreen) {
        this.successScreen = successScreen;
    }

    public void setFailureScreen(GameFailureScreen failureScreen) {
        this.failureScreen = failureScreen;
    } 

    public void success() {
        this.successScreen.start();
    }

    public void failure() {
        this.failureScreen.start();
    }

    public void inventoryCheck() {
        if (player.armed()) {
            String hits = Integer.toString(player.getInventory().nHits());
            TextField t = new TextField(hits);
            inventory.add(t, 1,1);
        }
        if (player.invincible()) {
            String moves = Integer.toString(player.getInventory().getiPotion().getUses());
            TextField t = new TextField(moves);
            inventory.add(t, 1,3);
        }
        if (player.getInventory().getKey() != null) {
            String id = Integer.toString(player.getInventory().getKey().getId());
            TextField t = new TextField(id);
            inventory.add(t, 1,0);
        } 

    }


    /* @FXML
    public void reinitialize() {
        Image ground = new Image((new File("images/dirt_0_new.png")).toURI().toString());

        // Add the ground first so it is below all other entities
        for (int x = 0; x < dungeon.getWidth(); x++) {
            for (int y = 0; y < dungeon.getHeight(); y++) {
                squares.getChildren().clear();
                squares.add(new ImageView(ground), x, y);
            }
        }

        for (ImageView entity : initialEntities)
            squares.getChildren().add(entity);

    } */
}

