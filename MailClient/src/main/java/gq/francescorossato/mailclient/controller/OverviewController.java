package gq.francescorossato.mailclient.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gq.francescorossato.mailclient.model.Message;
import gq.francescorossato.mailclient.model.Pop3Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class OverviewController implements Initializable {


    private Pop3Client pop3Client;
    private boolean isConnected;

    @FXML private Label username;
    @FXML private Label messageNum;
    @FXML private TextField subject;
    @FXML private TextField sender;
    @FXML private TextArea messageContent;
    @FXML private Button delete;
    @FXML private  Button refresh;
    @FXML private Button logout;
    @FXML private TableView<Message> mailTable;
    @FXML private TableColumn<Message, String> fromColumn;
    @FXML private TableColumn<Message, String> subjectColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }
    public void setPop3Client(Pop3Client pop3Client){
        this.pop3Client = pop3Client;
        username.setText(pop3Client.getUser());
        try {
            messageNum.setText(String.valueOf(pop3Client.getNumOfMessages()));
            onRefresh();
            mailTable.setItems(pop3Client.getMessages());
            showMail(null);
            mailTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showMail(newValue));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private boolean onDelete(){
        boolean deleted = false;
        try {
            deleted = pop3Client.delete(mailTable.getSelectionModel().getSelectedIndex());
            onRefresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deleted;
    }
    @FXML
    private void onRefresh(){
        try {
            pop3Client.getMessages();
            fromColumn.setCellValueFactory(cellData -> cellData.getValue().fromProperty());
            subjectColumn.setCellValueFactory(cellData -> cellData.getValue().subjectProperty());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMail(Message message){
        if(message != null){
            subject.setText(message.getSubject());
            sender.setText(message.getFrom());
            messageContent.setText(message.getMessage());
        } else {
            subject.setText("");
            sender.setText("");
            messageContent.setText("");
        }
    }


}
