package unsw.dungeon;

import java.io.IOException;
import java.util.logging.Level;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DungeonApplication extends Application {
    private static Stage currentStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        currentStage = primaryStage;
        primaryStage.setTitle("Dungeon");
        MenuScreen menuScreen = new MenuScreen(primaryStage);
        HelpScreen helpScreen = new HelpScreen(primaryStage);
        SelectorScreen selectorScreen = new SelectorScreen(primaryStage);
        helpScreen.getController().setMenuScreen(menuScreen);
        menuScreen.getController().setHelpScreen(helpScreen);
        menuScreen.getController().setSelectorScreen(selectorScreen);

        GameFailureScreen failureScreen = new GameFailureScreen(primaryStage);
        GameSuccessScreen successScreen = new GameSuccessScreen(primaryStage);

        selectorScreen.getController().setMenuScreen(menuScreen);
        LevelMazeScreen levelMazeScreen = new LevelMazeScreen(primaryStage);
        levelMazeScreen.getController().setSelectorScreen(selectorScreen);
        levelMazeScreen.getController().setSuccessScreen(successScreen);
        levelMazeScreen.getController().setFailureScreen(failureScreen);
        LevelTreasureScreen levelTreasureScreen = new LevelTreasureScreen(primaryStage);
        levelTreasureScreen.getController().setSelectorScreen(selectorScreen);
        levelTreasureScreen.getController().setSuccessScreen(successScreen);
        levelTreasureScreen.getController().setFailureScreen(failureScreen);
        LevelBoulderScreen levelBoulderScreen = new LevelBoulderScreen(primaryStage);
        levelBoulderScreen.getController().setSelectorScreen(selectorScreen);
        levelBoulderScreen.getController().setSuccessScreen(successScreen);
        levelBoulderScreen.getController().setFailureScreen(failureScreen);
        LevelFightScreen levelFightScreen = new LevelFightScreen(primaryStage);
        levelFightScreen.getController().setSelectorScreen(selectorScreen);
        levelFightScreen.getController().setSuccessScreen(successScreen);
        levelFightScreen.getController().setFailureScreen(failureScreen);
        LevelBossScreen levelBossScreen = new LevelBossScreen(primaryStage);
        levelBossScreen.getController().setSelectorScreen(selectorScreen);
        levelBossScreen.getController().setSuccessScreen(successScreen);
        levelBossScreen.getController().setFailureScreen(failureScreen);

        selectorScreen.getController().setLevelMazeScreen(levelMazeScreen);
        selectorScreen.getController().setLevelTreasureScreen(levelTreasureScreen);
        selectorScreen.getController().setLevelBoulderScreen(levelBoulderScreen);
        selectorScreen.getController().setLevelFightScreen(levelFightScreen);
        selectorScreen.getController().setLevelBossScreen(levelBossScreen);
        
        menuScreen.start();


        
        //menuScreen.getController()

/* 
        DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("maze.json");
        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root); */
        //root.requestFocus();
        //primaryStage.setScene(scene);
        //primaryStage.show(); */

    }

    public static void refresh() {
    	try {
            currentStage.close();
            Runnable r = new Runnable() {
				@Override
				public void run() {
					try {
                        Stage s = new Stage();
                        s.setTitle("Dungeon");
                        new DungeonApplication().start(s);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
				}
                
            };
    		Platform.runLater(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public static void main(String[] args) {
        launch(args);
    }
}
