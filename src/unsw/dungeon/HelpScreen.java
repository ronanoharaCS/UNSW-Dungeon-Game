package unsw.dungeon;


import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelpScreen {
    private Stage stage;
    private Scene scene;
    private HelpController controller;

    public HelpScreen(Stage stage) throws IOException {
        this.stage = stage;
        controller = new HelpController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HelpView.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        scene = new Scene(root);
    }

    public void start() {
        stage.setScene(scene);
        stage.show();
    }
    
    public HelpController getController() {
        return controller;
    }
}