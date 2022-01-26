package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

public class PatientSheetController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Patient, LocalDateTime> dateColumn;

    @FXML
    private Button enrollButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button permissionsButton;

    @FXML
    private TableColumn<Patient, Boolean> realisationColumn;

    @FXML
    private TableView<Patient> table;

    @FXML
    private TableColumn<Patient, Vaccine> vaccineColumn;

    @FXML
    void enrollAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/enrollingSheet.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void displayVaccines(String PESEL) throws SQLException {
        ArrayList<ArrayList<String>> result = Tester.dataBaseInfo("select * from zrealizowane_szczepienia");

    }
    @FXML
    void logOutAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/loggingSheet.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void permissionsAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/permissionSheet.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
