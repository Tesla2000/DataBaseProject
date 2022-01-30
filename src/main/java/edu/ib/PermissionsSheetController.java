package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import edu.ib.structures.Permit;
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

public class PermissionsSheetController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String login;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<Permit, String> id;

    @FXML
    private TableColumn<Permit, String> name;

    @FXML
    private TableColumn<Permit, String> phone;

    @FXML
    private TableView<Permit> table;

    @FXML
    void backAction(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/patientSheet.fxml"));
        root = loader.load();
        PatientSheetController patientSheetController = loader.getController();
        patientSheetController.displayVaccines(login);
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

    public void displayPermissions(String login) throws SQLException {
        this.login = login;
        id.setCellValueFactory(new PropertyValueFactory<Permit, String>("PESEL"));
        name.setCellValueFactory(new PropertyValueFactory<Permit, String>("name"));
        phone.setCellValueFactory(new PropertyValueFactory<Permit, String>("phoneNumber"));
        ObservableList<Permit> list = FXCollections.observableArrayList();
        for (ArrayList<String> permission: Tester.dataBaseInfo("select * from uprawnienia where " +
                "zapisujacy_pesel like '" + login + "';")) {
            permission.get(0);
            list.add(new Permit(permission.get(0), permission.get(1), permission.get(2)));
        }
        table.setItems(list);

    }
}
