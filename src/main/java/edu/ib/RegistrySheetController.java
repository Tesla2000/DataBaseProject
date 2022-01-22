package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class RegistrySheetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox RegisterResponse;

    @FXML
    private PasswordField passwordField1;

    @FXML
    private PasswordField passwordField2;

    @FXML
    private TextField peselField;

    @FXML
    private TextField phoneField;

    @FXML
    private Button registryButton;

    @FXML
    void RegisterAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert RegisterResponse != null : "fx:id=\"RegisterResponse\" was not injected: check your FXML file 'registrySheet.fxml'.";
        assert passwordField1 != null : "fx:id=\"passwordField1\" was not injected: check your FXML file 'registrySheet.fxml'.";
        assert passwordField2 != null : "fx:id=\"passwordField2\" was not injected: check your FXML file 'registrySheet.fxml'.";
        assert peselField != null : "fx:id=\"peselField\" was not injected: check your FXML file 'registrySheet.fxml'.";
        assert phoneField != null : "fx:id=\"phoneField\" was not injected: check your FXML file 'registrySheet.fxml'.";
        assert registryButton != null : "fx:id=\"registryButton\" was not injected: check your FXML file 'registrySheet.fxml'.";

    }

}
