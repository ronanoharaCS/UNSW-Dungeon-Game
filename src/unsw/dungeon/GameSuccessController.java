package unsw.dungeon;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GameSuccessController {

    @FXML
    private GridPane background;

    @FXML
    public void initialize() {
        Image bg = new Image((new File("images/victory.png")).toURI().toString());
        background.add(new ImageView(bg), 0,0);
    }
    @FXML
    public void handleReturn(ActionEvent event) {
        DungeonApplication.refresh();
    }

}