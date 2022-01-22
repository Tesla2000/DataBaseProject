package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PermissionsSheetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> phone;

    @FXML
    private TableView<?> table;

    @FXML
    void backAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'permissionSheet.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'permissionSheet.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'permissionSheet.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'permissionSheet.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'permissionSheet.fxml'.";

    }

}
