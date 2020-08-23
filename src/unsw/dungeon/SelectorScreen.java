package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SelectorScreen {
    private Stage stage;
    private Scene scene;
    private SelectorController controller;

    public SelectorScreen(Stage stage) throws IOException {
        this.stage = stage;
        controller = new SelectorController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SelectorView.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        scene = new Scene(root);
    }

    public void start() {
        stage.setScene(scene);
        stage.show();
    }

    public SelectorController getController() {
        return controller;
    }
}