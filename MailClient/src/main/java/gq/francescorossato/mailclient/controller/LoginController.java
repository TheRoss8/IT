package gq.francescorossato.mailclient.controller;

import gq.francescorossato.mailclient.model.MainApp;
import gq.francescorossato.mailclient.model.Pop3Client;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

/**
 * Created by francesco.rossato on 16/02/2018.
 */
public class LoginController implements Initializable {
    private boolean isConnected = false;

    @FXML private TextField username;
    @FXML private PasswordField password;

    private MainApp mainApp;

    @FXML
    private void handleLogin(){
        if(!username.getText().equals("")){
            if (!password.getText().equals("")){
                try {
                    Pop3Client pop3Client = new Pop3Client(username.getText(), password.getText(), InetAddress.getByName("in.alice.it"));
                    boolean isConnected = pop3Client.connect();
                    if(isConnected){
                        mainApp.setPop3Client(pop3Client);
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Overview.fxml"));
                        Parent root1 = fxmlLoader.load();
                        OverviewController overviewController = fxmlLoader.getController();
                        overviewController.setPop3Client(pop3Client);
                        Stage stage = new Stage();
                        stage.setTitle("Mail");
                        stage.setScene(new Scene(root1));
                        stage.show();
                    }
                    else {
                        new Alert(Alert.AlertType.ERROR, "Username or password incorrect").show();
                        handleReset();
                    }
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
                new Alert(Alert.AlertType.ERROR, "The password field can not be blank").show();
        }
        else
            new Alert(Alert.AlertType.ERROR, "The username field cannot be blank").show();
    }
    @FXML
    private void handleReset(){
        username.setText("");
        password.setText("");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
