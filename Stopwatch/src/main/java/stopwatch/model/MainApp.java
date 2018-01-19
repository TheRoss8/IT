package stopwatch.model;

import javafx.application.Application;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by francesco.rossato on 19/01/2018.
 */
public class MainApp extends Application {
    private Stage primaryStage;
    private AnchorPane mainActivity;

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Stopwatch");
        this.primaryStage = primaryStage;

    }

    public static void main(String[] args) {
        launch(args);
    }
}
