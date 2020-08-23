package unsw.dungeon;

import java.io.File;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class MenuController {
    private HelpScreen helpScreen;
    private SelectorScreen selectorScreen;
    
    @FXML
    GridPane background;
    
    @FXML
    public void initialize() {
        Image ground = new Image((new File("images/dirt_0_new.png")).toURI().toString());
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 60; j++) {
                background.add(new ImageView(ground), i, j);
            }
        }
    }

    
    
    @FXML
    public void handlePlay(ActionEvent event) {
        this.selectorScreen.start();
    }

    @FXML
    public void handleHelp(ActionEvent event) {
        this.helpScreen.start();
    }

    @FXML
    public void handleExit(ActionEvent event) {
        System.exit(0);
    }

    public void setHelpScreen(HelpScreen helpScreen) {
        this.helpScreen = helpScreen;
    }

	public void setSelectorScreen(SelectorScreen selectorScreen) {
		this.selectorScreen = selectorScreen;
	}

    

}