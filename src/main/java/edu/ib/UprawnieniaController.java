package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import edu.ib.structures.Tester;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UprawnieniaController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button anulujButton;

    @FXML
    private TextField peselDwaTextField;

    @FXML
    private TextField peselPierwszyTextField;

    @FXML
    private Button zatwierdzUprawnieniaButton;

    @FXML
    void initialize() {
        assert anulujButton != null : "fx:id=\"anulujButton\" was not injected: check your FXML file 'uprawnienia.fxml'.";
        assert peselDwaTextField != null : "fx:id=\"peselDwaTextField\" was not injected: check your FXML file 'uprawnienia.fxml'.";
        assert peselPierwszyTextField != null : "fx:id=\"peselPierwszyTextField\" was not injected: check your FXML file 'uprawnienia.fxml'.";
        assert zatwierdzUprawnieniaButton != null : "fx:id=\"zatwierdzUprawnieniaButton\" was not injected: check your FXML file 'uprawnienia.fxml'.";

    }

    @FXML
    void anulujDodawanie(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/punktSzczepienApp.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void zatwierdz(ActionEvent event) throws SQLException {
        String pierwszy = peselPierwszyTextField.getText();
        String drugi = peselDwaTextField.getText();
        Tester.callProcedure("dodawanie_uprawnien("+pierwszy+","+drugi+")");

    }





}
