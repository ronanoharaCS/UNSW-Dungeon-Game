package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuScreen {
    private Stage stage;
    private Scene scene;
    private MenuController controller;

    public MenuScreen(Stage stage) throws IOException {
        this.stage = stage;
        controller = new MenuController();
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("MenuView.fxml"));
        menuLoader.setController(controller);
        Parent root = menuLoader.load();
        scene = new Scene(root);//, 1000, 670);
    }

    public void start() {
        stage.setScene(scene);
        stage.show();
    }

    public MenuController getController() {
        return controller;
    }

    /* public void setController(MenuController controller) {
        this.controller = controller;
    } */
}