package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PunktSzczepienAppContoller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button dodajUprawnieniaButton;

    @FXML
    private TextField idText;

    @FXML
    private TextField iloscMiejscTextField;

    @FXML
    private Button plusButton;

    @FXML
    private ComboBox<?> preparatComboBox;

    @FXML
    private TableView<?> tabelaTableView;

    @FXML
    private TextField terminDoTextField;

    @FXML
    private TextField terminOdTextField;

    @FXML
    private Button wykonanoButton;

    @FXML
    private Button zatwierdzButton;

    @FXML
    void initialize() {
        assert dodajUprawnieniaButton != null : "fx:id=\"dodajUprawnieniaButton\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert idText != null : "fx:id=\"idText\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert iloscMiejscTextField != null : "fx:id=\"iloscMiejscTextField\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert plusButton != null : "fx:id=\"plusButton\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert preparatComboBox != null : "fx:id=\"preparatComboBox\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert tabelaTableView != null : "fx:id=\"tabelaTableView\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert terminDoTextField != null : "fx:id=\"terminDoTextField\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert terminOdTextField != null : "fx:id=\"terminOdTextField\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert wykonanoButton != null : "fx:id=\"wykonanoButton\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert zatwierdzButton != null : "fx:id=\"zatwierdzButton\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";

    }

}
