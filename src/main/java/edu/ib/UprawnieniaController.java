package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UprawnieniaController {

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

}
