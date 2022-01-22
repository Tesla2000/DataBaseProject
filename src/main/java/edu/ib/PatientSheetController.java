package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PatientSheetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private Button enrollButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button permissionsButton;

    @FXML
    private TableColumn<?, ?> realisationColumn;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> vaccineColumn;

    @FXML
    void enrollAction(ActionEvent event) {

    }

    @FXML
    void logOutAction(ActionEvent event) {

    }

    @FXML
    void permissionsAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert dateColumn != null : "fx:id=\"dateColumn\" was not injected: check your FXML file 'patientSheet.fxml'.";
        assert enrollButton != null : "fx:id=\"enrollButton\" was not injected: check your FXML file 'patientSheet.fxml'.";
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'patientSheet.fxml'.";
        assert permissionsButton != null : "fx:id=\"permissionsButton\" was not injected: check your FXML file 'patientSheet.fxml'.";
        assert realisationColumn != null : "fx:id=\"realisationColumn\" was not injected: check your FXML file 'patientSheet.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'patientSheet.fxml'.";
        assert vaccineColumn != null : "fx:id=\"vaccineColumn\" was not injected: check your FXML file 'patientSheet.fxml'.";

    }

}
