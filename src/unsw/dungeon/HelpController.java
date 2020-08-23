package unsw.dungeon;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class HelpController {
    private MenuScreen menuScreen;
    
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

    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }

}