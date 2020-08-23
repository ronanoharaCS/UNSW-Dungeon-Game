package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LevelFightScreen {
    private Stage stage;
    private Scene scene;
    private DungeonController controller; 

    public LevelFightScreen(Stage stage) throws IOException {
        this.stage = stage;
        DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("fightClub.json");
        controller = dungeonLoader.loadController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView2.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        scene = new Scene(root);
        root.requestFocus();
    }

    public void start() {
        stage.setScene(scene);
        stage.show();
    }

    public DungeonController getController() {
        return controller;
    }
}