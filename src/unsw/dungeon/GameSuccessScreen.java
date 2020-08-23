package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameSuccessScreen {
    private Stage stage;
    private Scene scene;
    private GameSuccessController controller;

    public GameSuccessScreen(Stage stage) throws IOException {
        this.stage = stage;
        controller = new GameSuccessController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameSuccessView.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        scene = new Scene(root);
    }

    public void start() {
        stage.setScene(scene);
        stage.show();
    }

    public GameSuccessController getController() {
        return controller;
    }
}