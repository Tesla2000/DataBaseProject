package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import edu.ib.structures.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 * edu.ib.EnrollingSheetController
 * Handles the function of the main window for vaccination clinic.
 *
 * @author FR, MD
 * @version 1.0
 * @since 2022-02-08
 */
public class PunktSzczepienAppContoller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<VaccineRecord, Integer> kolumnaId;


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
    private TableColumn<VaccineRecord, String> lastName;

    @FXML
    private TableColumn<VaccineRecord, String> pesel;

    @FXML
    private TableColumn<VaccineRecord, Boolean> Finalizaion;

    @FXML
    private TableColumn<VaccineRecord, LocalDate> date;

    @FXML
    private TableView<VaccineRecord> tabelaTableView;

    @FXML
    private TextField terminTextField;

    @FXML
    private Button wykonanoButton;

    @FXML
    private Button zatwierdzButton;


    @FXML
    private TextField idPreparatu;


    /**
     * Switches the window to adding permissions.
     * @param event on button click
     * @throws IOException thrown if SQL request is not valid
     */
    @FXML
    void UprawnieniaAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/uprawnienia.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    /**
     * Switches the window to adding new vaccine types.
     * @param event on button click
     * @throws IOException thrown if SQL request is not valid
     */
    @FXML
    void dodajPreparat(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/dodawaniePreparatu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Methode initializes elements of the scene for vaccination clinic window.
     */
    @FXML
    void initialize() throws SQLException {
        assert Finalizaion != null : "fx:id=\"Finalizaion\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert Szczepionki != null : "fx:id=\"Szczepionki\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert dodajUprawnieniaButton != null : "fx:id=\"dodajUprawnieniaButton\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert idPreparatu != null : "fx:id=\"idPreparatu\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert idText != null : "fx:id=\"idText\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
//        assert id_szczepionki != null : "fx:id=\"id_szczepionki\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert iloscMiejscTextField != null : "fx:id=\"iloscMiejscTextField\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert kolumnaId != null : "fx:id=\"kolumnaId\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert lastName != null : "fx:id=\"lastName\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert nazwa_szczepionki != null : "fx:id=\"nazwa_szczepionki\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert pesel != null : "fx:id=\"pesel\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert plusButton != null : "fx:id=\"plusButton\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert tabelaTableView != null : "fx:id=\"tabelaTableView\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert terminTextField != null : "fx:id=\"terminTextField\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert wykonanoButton != null : "fx:id=\"wykonanoButton\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert zatwierdzButton != null : "fx:id=\"zatwierdzButton\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";

        displayRealization();


        ObservableList<Szczepionka> lista = FXCollections.observableArrayList();
        nazwa_szczepionki.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
//        id_szczepionki.setCellValueFactory(new PropertyValueFactory<>("id"));
        for (ArrayList<String> record : Tester.dataBaseInfo("select Rodzaj_preparatu, `id` from Typy_szczepien_view;")){
            lista.add(new Szczepionka(
                    record.get(0)));

        }

        Szczepionki.setItems(lista);
    }

    /**
     * Handles loading items into the table of visits
     * @throws SQLException thrown if SQL request is not valid
     */
    public void displayRealization() throws SQLException {
        ObservableList<VaccineRecord> list = FXCollections.observableArrayList();
        pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        Finalizaion.setCellValueFactory(new PropertyValueFactory<>("realization"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        kolumnaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        for (ArrayList<String> record : Tester.dataBaseInfo("select * from `widok_szczepienia_do_realizacji` where REALIZACJA = 0;")) {
            int year = Integer.parseInt(record.get(2).split(" ")[0].split("-")[0]);
            int month = Integer.parseInt(record.get(2).split(" ")[0].split("-")[1]);
            int day = Integer.parseInt(record.get(2).split(" ")[0].split("-")[2]);

            list.add(new VaccineRecord(
                    Boolean.parseBoolean(record.get(0)), //wykonanie
                    Integer.parseInt(record.get(1)),    //id
                    LocalDate.of(year, month, day),     // data
                    Long.parseLong(record.get(3)),    // pesel
                    record.get(4)));                    // nazwisko
        }
        tabelaTableView.setItems(list);
    }


    /**
     * Allows changing realisation to "true" for a specific record in database
     * @param event on button click
     * @throws IOException thrown if SQL request is not valid
     */
    @FXML
    void zmienNaWykonane(ActionEvent event) throws SQLException {
        String id = idText.getText(); // pobieram id
        Tester.callProcedure("Call zatwierdzenie_szczepienia('" + id + "');");    // zatwierdzam w bazie danych
        // aktualizowane danych w tabeli
        tabelaTableView.getItems().clear();
        displayRealization();

    }

    /**
     * Handles adding new appointments
     * @param event on button click
     * @throws IOException thrown if SQL request is not valid
     */
    @FXML
    void dodajTermin(ActionEvent event) throws SQLException {

        int iloscMiejsc = Integer.parseInt(iloscMiejscTextField.getText());
        String command = "select id from typy_szczepien where " +
                "Rodzaj_preparatu like '"+idPreparatu.getText()+"' limit 1;";
        System.out.println(command);
        int id = Integer.parseInt(Tester.dataBaseInfo(command).get(0).get(0));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime termin = LocalDateTime.parse(terminTextField.getText(), formatter);

        for (int i = 0; i < iloscMiejsc; i++) {
            // jak jest kilka terminów to dodaję w odstępie 15 min
            System.out.println(termin.plusMinutes(i * 15));
            Tester.callProcedure("Call dodawanie_godzin('" + termin.plusMinutes(i * 15).
                    toString().replace("T", " ") + "'," + id + ");");
        }


    }
    @FXML
    private TableView<Szczepionka> Szczepionki;


    @FXML
    private TableColumn<Szczepionka, String> nazwa_szczepionki;

    /**
     * Switches the window to statistics
     * @param event on button click
     * @throws IOException thrown if SQL request is not valid
     */
    @FXML
    void goToStaty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/statystyki.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Button staty;
}
