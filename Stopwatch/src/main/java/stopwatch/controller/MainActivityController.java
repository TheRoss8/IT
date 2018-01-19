package stopwatch.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import stopwatch.model.MainApp;

/**
 * Created by francesco.rossato on 19/01/2018.
 */
public class MainActivityController {
    @FXML
    private Label hoursLabel;
    @FXML
    private Label minutesLabel;
    @FXML
    private Label secondsLabel;
    @FXML
    private Label fractionLabel;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;

    private boolean startClicked = false;
    private MainApp mainApp;
}
