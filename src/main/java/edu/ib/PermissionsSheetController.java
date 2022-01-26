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

public class PermissionsSheetController {
    private Stage stage;
    private Scene scene;
    private Parent root;

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
    void backAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/patientSheet.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
