package unsw.dungeon;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class SelectorController {
    private MenuScreen menuScreen;
    private LevelMazeScreen levelMazeScreen;
    private LevelTreasureScreen levelTreasureScreen;
    private LevelBoulderScreen levelBoulderScreen;
    private LevelFightScreen levelFightScreen;
    private LevelBossScreen levelBossScreen;

    @FXML
    GridPane background;

    @FXML
    public void initialize() {
        Image ground = new Image((new File("images/dirt_0_new.png")).toURI().toString());
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 70; j++) {
                background.add(new ImageView(ground), i, j);
            }
        }
    }

    @FXML
    public void handleBack(ActionEvent event) {
        this.menuScreen.start();
    }

    @FXML
    public void handleMaze(ActionEvent event) {
        this.levelMazeScreen.start();
    }

    @FXML
    public void handleTreasure(ActionEvent event) {
        this.levelTreasureScreen.start();
    }

    @FXML
    public void handleBoulder(ActionEvent event) {
        this.levelBoulderScreen.start();
    }

    @FXML
    public void handleFight(ActionEvent event) {
        this.levelFightScreen.start();
    }

    @FXML
    public void handleBoss(ActionEvent event) {
        this.levelBossScreen.start();
    }


    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }

	public void setLevelMazeScreen(LevelMazeScreen levelMazeScreen) {
		this.levelMazeScreen = levelMazeScreen;
	}

	public void setLevelTreasureScreen(LevelTreasureScreen levelTreasureScreen) {
		this.levelTreasureScreen = levelTreasureScreen;
	}

	public void setLevelBoulderScreen(LevelBoulderScreen levelBoulderScreen) {
		this.levelBoulderScreen = levelBoulderScreen;
	}

	public void setLevelFightScreen(LevelFightScreen levelFightScreen) {
		this.levelFightScreen = levelFightScreen;
	}

	public void setLevelBossScreen(LevelBossScreen levelBossScreen) {
		this.levelBossScreen = levelBossScreen;
	}

    
}