package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoggingSheetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LogInButton;

    @FXML
    private Button RegisterButton;

    @FXML
    private Text loggerResponse;

    @FXML
    private TextField loggingField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void LogInAction(ActionEvent event) {

    }

    @FXML
    void RegisterAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert LogInButton != null : "fx:id=\"LogInButton\" was not injected: check your FXML file 'loggingSheet.fxml'.";
        assert RegisterButton != null : "fx:id=\"RegisterButton\" was not injected: check your FXML file 'loggingSheet.fxml'.";
        assert loggerResponse != null : "fx:id=\"loggerResponse\" was not injected: check your FXML file 'loggingSheet.fxml'.";
        assert loggingField != null : "fx:id=\"loggingField\" was not injected: check your FXML file 'loggingSheet.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'loggingSheet.fxml'.";

    }

}
