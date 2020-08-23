package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameFailureScreen {
    private Stage stage;
    private Scene scene;
    private GameFailureController controller;

    public GameFailureScreen(Stage stage) throws IOException {
        this.stage = stage;
        controller = new GameFailureController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameFailureView.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        scene = new Scene(root);
    }

    public void start() {
        stage.setScene(scene);
        stage.show();
    }

    public GameFailureController getController() {
        return controller;
    }
}