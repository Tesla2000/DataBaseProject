package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import edu.ib.structures.Permit;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PunktSzczepienAppContoller {

    private Stage stage;
    private Scene scene;
    private Parent root;

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
    private TableView<VaccineRecord> tabelaTableView;

    @FXML
    private TextField terminDoTextField;

    @FXML
    private TextField terminOdTextField;

    @FXML
    private Button wykonanoButton;

    @FXML
    private Button zatwierdzButton;


    @FXML
    void UprawnieniaAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/uprawnienia.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }





    @FXML
    void initialize() throws SQLException {
        assert dodajUprawnieniaButton != null : "fx:id=\"dodajUprawnieniaButton\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert idText != null : "fx:id=\"idText\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert iloscMiejscTextField != null : "fx:id=\"iloscMiejscTextField\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert plusButton != null : "fx:id=\"plusButton\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert preparatComboBox != null : "fx:id=\"preparatComboBox\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert tabelaTableView != null : "fx:id=\"tabelaTableView\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert terminDoTextField != null : "fx:id=\"terminDoTextField\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert terminOdTextField != null : "fx:id=\"terminOdTextField\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert wykonanoButton != null : "fx:id=\"wykonanoButton\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";
        assert zatwierdzButton != null : "fx:id=\"zatwierdzButton\" was not injected: check your FXML file 'punktSzczepienApp.fxml'.";


        ObservableList<VaccineRecord> list = FXCollections.observableArrayList();
        for (ArrayList<String> record: Tester.dataBaseInfo("select * `from widok_szczepienia_do_realizacji`")) {
            record.get(0);
            list.add(new VaccineRecord(
                    Boolean.parseBoolean(record.get(0)), //wykonanie
                    LocalDate.parse(record.get(1)),     // data
                    Integer.parseInt(record.get(2)),    // pesel
                    record.get(3)));                    // nazwisko
        }
        tabelaTableView.setItems(list);
    }

    @FXML
    void zmienNaWykonane(ActionEvent event) throws SQLException {

        String id = idText.getText(); // pobieram id
        Tester.callProcedure("Call zatwierdzenie_szczepienia("+id+");");    // zatwierdzam w bazie danych
        // aktualizowane danych w tabeli
        ObservableList<VaccineRecord> list = FXCollections.observableArrayList();
        for (ArrayList<String> record: Tester.dataBaseInfo("select * `from widok_szczepienia_do_realizacji`")) {
            record.get(0);
            list.add(new VaccineRecord(
                    Boolean.parseBoolean(record.get(0)), //wykonanie
                    LocalDate.parse(record.get(1)),     // data
                    Integer.parseInt(record.get(2)),    // pesel
                    record.get(3)));                    // nazwisko
        }
        tabelaTableView.setItems(list);


    }







}
