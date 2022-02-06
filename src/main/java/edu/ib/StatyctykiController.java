package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class StatyctykiController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private TableColumn<?, ?> data;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> pacjent;

    @FXML
    private TableColumn<?, ?> preparat;

    @FXML
    private TableColumn<?, ?> realizacja;

    @FXML
    private Button sortowanie_alfabet;

    @FXML
    private Button sortowanie_data;

    @FXML
    private TableView<?> tabela;

    @FXML
    void alfabet_action(ActionEvent event) {

    }

    @FXML
    void back_action(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/punktSzczepienApp.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void data_action(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'Statystyki.fxml'.";
        assert data != null : "fx:id=\"data\" was not injected: check your FXML file 'Statystyki.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'Statystyki.fxml'.";
        assert pacjent != null : "fx:id=\"pacjent\" was not injected: check your FXML file 'Statystyki.fxml'.";
        assert preparat != null : "fx:id=\"preparat\" was not injected: check your FXML file 'Statystyki.fxml'.";
        assert realizacja != null : "fx:id=\"realizacja\" was not injected: check your FXML file 'Statystyki.fxml'.";
        assert sortowanie_alfabet != null : "fx:id=\"sortowanie_alfabet\" was not injected: check your FXML file 'Statystyki.fxml'.";
        assert sortowanie_data != null : "fx:id=\"sortowanie_data\" was not injected: check your FXML file 'Statystyki.fxml'.";
        assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'Statystyki.fxml'.";

    }

}
