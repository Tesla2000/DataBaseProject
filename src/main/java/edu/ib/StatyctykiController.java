package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;

import edu.ib.structures.Statystyka;
import edu.ib.structures.Tester;
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

public class StatyctykiController {

    public ObservableList<Statystyka> list = FXCollections.observableArrayList();

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
    private TableColumn<Statystyka, LocalDate> data;

    @FXML
    private TableColumn<Statystyka, String> id;

    @FXML
    private TableColumn<Statystyka, String> pacjent;

    @FXML
    private TableColumn<Statystyka, String> preparat;

    @FXML
    private TableColumn<Statystyka, Boolean> realizacja;

    @FXML
    private Button sortowanie_alfabet;

    @FXML
    private Button sortowanie_data;

    @FXML
    private TableView<Statystyka> tabela;

    @FXML
    /**
     * sorts list of items in the table alphabetically, based on vaccines name.
     */
    void alfabet_action(ActionEvent event) {
        list.sort(Comparator.comparing(Statystyka::getPreparat));
        tabela.setItems(list);
    }

    @FXML
    /**
     * changes active window back to main window for Vaccination clinic.
     */
    void back_action(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/punktSzczepienApp.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    /**
     * sorts list of items in the table by the date.
     */
    void data_action(ActionEvent event) {
        list.sort(Comparator.comparing(Statystyka::getData));
        tabela.setItems(list);
    }

    @FXML
    void initialize() throws SQLException {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'statystyki.fxml'.";
        assert data != null : "fx:id=\"data\" was not injected: check your FXML file 'statystyki.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'statystyki.fxml'.";
        assert pacjent != null : "fx:id=\"pacjent\" was not injected: check your FXML file 'statystyki.fxml'.";
        assert preparat != null : "fx:id=\"preparat\" was not injected: check your FXML file 'statystyki.fxml'.";
        assert realizacja != null : "fx:id=\"realizacja\" was not injected: check your FXML file 'statystyki.fxml'.";
        assert sortowanie_alfabet != null : "fx:id=\"sortowanie_alfabet\" was not injected: check your FXML file 'statystyki.fxml'.";
        assert sortowanie_data != null : "fx:id=\"sortowanie_data\" was not injected: check your FXML file 'statystyki.fxml'.";
        assert tabela != null : "fx:id=\"tabela\" was not injected: check your FXML file 'statystyki.fxml'.";

        daneDoTabeli();

    }

    /**
     * Connects with database and shows received data in the table.
     * @throws SQLException thrown if SQL request is not valid
     */
    public void daneDoTabeli() throws SQLException {

        //ObservableList<Statystyka> list = FXCollections.observableArrayList();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        realizacja.setCellValueFactory(new PropertyValueFactory<>("realizacja"));
        preparat.setCellValueFactory(new PropertyValueFactory<>("preparat"));
        pacjent.setCellValueFactory(new PropertyValueFactory<>("pacjent"));

        for (ArrayList<String> record : Tester.dataBaseInfo("select id, Data, Realizacja, Rodzaj_preparatu, PESEL from widok_szczepien;")) {
            int year = Integer.parseInt(record.get(1).split(" ")[0].split("-")[0]);
            int month = Integer.parseInt(record.get(1).split(" ")[0].split("-")[1]);
            int day = Integer.parseInt(record.get(1).split(" ")[0].split("-")[2]);

            list.add(new Statystyka(

                    record.get(0),                          // id
                    LocalDate.of(year, month, day),         // data
                    Boolean.parseBoolean(record.get(2)),    // wykonanie
                    record.get(3),                          // preparat
                    record.get(4)                           // pacjent id
            ));

        }
        tabela.setItems(list);


    }




}
