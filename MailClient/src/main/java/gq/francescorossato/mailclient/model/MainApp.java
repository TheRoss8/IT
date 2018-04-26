package gq.francescorossato.mailclient.model;

import gq.francescorossato.mailclient.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    private Pop3Client pop3Client;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(MainApp.class.getResource("/fxml/Login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("POP3 Client");
        stage.setScene(scene);
        stage.show();
        LoginController loginController = fxmlLoader.getController();
        loginController.setMainApp(this);

    }

    public Pop3Client getPop3Client() {
        return pop3Client;
    }

    public void setPop3Client(Pop3Client pop3Client) {
        this.pop3Client = pop3Client;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
