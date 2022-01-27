package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import edu.ib.structures.Tester;
import edu.ib.structures.Vaccine;
import edu.ib.structures.VaccineRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PatientSheetController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String login = "";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<VaccineRecord, LocalDate> dateColumn;

    @FXML
    private Button enrollButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button permissionsButton;

    @FXML
    private TableColumn<VaccineRecord, Boolean> realisationColumn;

    @FXML
    private TableView<VaccineRecord> table;

    @FXML
    private TableColumn<VaccineRecord, Vaccine> vaccineColumn;

    @FXML
    void enrollAction(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/enrollingSheet.fxml"));
        root = loader.load();
        EnrollingSheetController enrollingSheetController = loader.getController();
        enrollingSheetController.displayDates(login);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void displayVaccines(String PESEL) throws SQLException {
        login = PESEL;
        ArrayList<ArrayList<String>> results = Tester.dataBaseInfo("select * from zrealizowane_szczepienia " +
                "where pesel like " + PESEL + ";");
        vaccineColumn.setCellValueFactory(new PropertyValueFactory<VaccineRecord, Vaccine>("vaccine"));
        realisationColumn.setCellValueFactory(new PropertyValueFactory<VaccineRecord, Boolean>("realization"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<VaccineRecord, LocalDate>("date"));
        ObservableList<VaccineRecord> list = FXCollections.observableArrayList();
        for (ArrayList<String> result: results){
            String date = result.get(3).split(" ")[0];
            int year = Integer.parseInt(date.split("-")[0]);
            int month = Integer.parseInt(date.split("-")[1]);
            int day = Integer.parseInt(date.split("-")[2]);
            list.add(new VaccineRecord(Vaccine.valueOf(result.get(2)), result.get(4).equals("true"),
                    LocalDate.of(year,month,day)));
        }
        table.setItems(list);


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
    void permissionsAction(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/permission.fxml"));
        root = loader.load();
        PermissionsSheetController enrollingSheetController = loader.getController();
        enrollingSheetController.displayPermissions(login);
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
