package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LevelTreasureScreen {
    private Stage stage;
    private Scene scene;
    private DungeonController controller;

    public LevelTreasureScreen(Stage stage) throws IOException {
        this.stage = stage;
        DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("treasureHunt.json");
        controller = dungeonLoader.loadController();
        //controller = new LevelTreasureController();
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