package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LevelMazeScreen {
    private Stage stage;
    private Scene scene;
    private DungeonController controller;

    public LevelMazeScreen(Stage stage) throws IOException {
        this.stage = stage;
        DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("maze.json");
        controller = dungeonLoader.loadController();
        //controller = new LevelMazeController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView2.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        scene = new Scene(root);
        root.requestFocus(); 
    }

    public void start() {
        stage.setScene(scene);

        stage.setResizable(false);
        stage.show();
    }

    public DungeonController getController() {
        return controller;
    } 
}