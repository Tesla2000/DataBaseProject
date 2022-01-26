package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoggingSheetController {
    private Stage stage;
    private Scene scene;
    private Parent root;

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
    void LogInAction(ActionEvent event) throws IOException, SQLException {
        ArrayList<ArrayList<String>> combinations = Tester.dataBaseInfo("select PESEL, Haslo from pacjenci_i_hasla;");
        String login = loggingField.getText();
        String password = passwordField.getText();
        for (ArrayList<String> combination: combinations){
            if (combination.get(0).equals(login) && combination.get(1).equals(password)){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/patientSheet.fxml"));
                root = loader.load();
                PatientSheetController patientSheetController = loader.getController();
                patientSheetController.displayVaccines(login);
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                break;
            }
        }
        loggerResponse.setText("Niepoprawny login lub hasło");

    }

    @FXML
    void RegisterAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/registrationSheet.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
