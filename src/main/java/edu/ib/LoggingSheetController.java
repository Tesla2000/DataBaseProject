package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import edu.ib.structures.Tester;
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



/**
 * edu.ib.LoggingSheetController
 * Allows patient and doctor to log in
 * given correct combination of login and password or
 * transfers user to registration scene
 *
 * @author FR, MD
 * @version 1.0
 * @since 2022-02-08
 */
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

    /**
     * Checks if given combination of login and password is correct and logs in either as patient or doctor
     * @param event on button click
     * @throws IOException thrown is something is wrong with fxml file
     * @throws SQLException thrown if SQL request is not valid
     */
    @FXML
    void LogInAction(ActionEvent event) throws IOException, SQLException {
        ArrayList<ArrayList<String>> combinations = Tester.dataBaseInfo("select PESEL, Haslo from pacjenci_i_hasla;");
        String login = loggingField.getText();
        String password = passwordField.getText();
        for (ArrayList<String> combination: combinations){
            if (combination.get(0).equals(login) && combination.get(1).equals(password)){
                if (login.equals("123"))
                {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/punktSzczepienApp.fxml"));
                    root = loader.load();
                    stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                    else{
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
        }
        loggerResponse.setText("Niepoprawny login lub haslo");

    }

    /**
     * Transfers user to registration
     * @param event on button click
     * @throws IOException thrown is something is wrong with fxml file
     */
    @FXML
    void RegisterAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/registrationSheet.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Methode initializes elements of scene
     */
    @FXML
    void initialize() {
        assert LogInButton != null : "fx:id=\"LogInButton\" was not injected: check your FXML file 'loggingSheet.fxml'.";
        assert RegisterButton != null : "fx:id=\"RegisterButton\" was not injected: check your FXML file 'loggingSheet.fxml'.";
        assert loggerResponse != null : "fx:id=\"loggerResponse\" was not injected: check your FXML file 'loggingSheet.fxml'.";
        assert loggingField != null : "fx:id=\"loggingField\" was not injected: check your FXML file 'loggingSheet.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'loggingSheet.fxml'.";

    }

}
