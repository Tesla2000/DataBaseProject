package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import edu.ib.structures.PatientsVaccine;
import edu.ib.structures.Tester;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * edu.ib.PatientSheetController
 * shows scheduled and take vaccines of a patient and
 * allows him to move to other scenes
 *
 * @author FR, MD
 * @version 1.0
 * @since 2022-02-08
 */
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
    private TableColumn<PatientsVaccine, LocalDate> dateColumn;

    @FXML
    private Button enrollButton;


    @FXML
    private Button logOutButton;

    @FXML
    private Button permissionsButton;
    @FXML
    private Button unsubscribeButton;

    @FXML
    private TextField unsubscribeField;

    @FXML
    private TableColumn<PatientsVaccine, Boolean> realisationColumn;

    @FXML
    private TableView<PatientsVaccine> table;

    @FXML
    private TableColumn<PatientsVaccine, String> vaccineColumn;

    /**
     * Allows patient to unsubscribe for vaccination takes name of vaccine from field
     * and cancels one scheduled vaccination of given name of vaccine
     * @param event button click
     * @throws SQLException thrown if SQL request is not valid
     */
    @FXML
    void unsubscribeAction(ActionEvent event) throws SQLException {
        String vaccine = unsubscribeField.getText();
        String permit = "select count(*) from uprawnienia where '"+login+"' like zapisywani_pesel " +
                "and '"+login+"' like zapisujacy_pesel";
        if (Tester.dataBaseInfo(permit).get(0).get(0).equals("1")){
            String command = "call usuwanie_szczepienia_pacjent((select id from widok_szczepien where " +
                    "realizacja = 0 and PESEL like '"+login+"' and Rodzaj_preparatu like '"+vaccine+"' limit 1));";
            System.out.println(command);
            Tester.callProcedure(command);
        }
        displayVaccines(login);

    }

    /**
     * Changes scene to enrolling and passes patients personal id number as argument
     * @param event on button click
     * @throws IOException thrown is something is wrong with fxml file
     * @throws SQLException thrown if SQL request is not valid
     */
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

    /**
     * Shows scheduled and take vaccines of a patient
     * @param PESEL patients personal id number
     * @throws SQLException thrown if SQL request is not valid
     */
    public void displayVaccines(String PESEL) throws SQLException {
        login = PESEL;
        ArrayList<ArrayList<String>> results = Tester.dataBaseInfo("select * from zrealizowane_szczepienia " +
                "where pesel like " + PESEL + ";");
        vaccineColumn.setCellValueFactory(new PropertyValueFactory<>("vaccine"));
        realisationColumn.setCellValueFactory(new PropertyValueFactory<>("realization"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        ObservableList<PatientsVaccine> list = FXCollections.observableArrayList();
        for (ArrayList<String> result: results){
            String date = result.get(3).split(" ")[0];
            int year = Integer.parseInt(date.split("-")[0]);
            int month = Integer.parseInt(date.split("-")[1]);
            int day = Integer.parseInt(date.split("-")[2]);
            list.add(new PatientsVaccine(result.get(2), result.get(4).equals("1"),
                    LocalDate.of(year,month,day)));
        }
        table.setItems(list);


    }

    /**
     * Changes scene to logging
     * @param event on button click
     * @throws IOException thrown is something is wrong with fxml file
     */
    @FXML
    void logOutAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/loggingSheet.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Changes scene to permissions and passes patients personal id number as argument
     * @param event on button click
     * @throws IOException thrown is something is wrong with fxml file
     * @throws SQLException thrown if SQL request is not valid
     */
    @FXML
    void permissionsAction(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/permissionSheet.fxml"));
        root = loader.load();
        PermissionsSheetController permissionsSheetController = loader.getController();
        permissionsSheetController.displayPermissions(login);
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
        assert dateColumn != null : "fx:id=\"dateColumn\" was not injected: check your FXML file 'patientSheet.fxml'.";
        assert enrollButton != null : "fx:id=\"enrollButton\" was not injected: check your FXML file 'patientSheet.fxml'.";
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'patientSheet.fxml'.";
        assert permissionsButton != null : "fx:id=\"permissionsButton\" was not injected: check your FXML file 'patientSheet.fxml'.";
        assert realisationColumn != null : "fx:id=\"realisationColumn\" was not injected: check your FXML file 'patientSheet.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'patientSheet.fxml'.";
        assert vaccineColumn != null : "fx:id=\"vaccineColumn\" was not injected: check your FXML file 'patientSheet.fxml'.";

    }

}
