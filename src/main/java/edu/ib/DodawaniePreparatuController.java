package edu.ib;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import edu.ib.structures.Tester;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class DodawaniePreparatuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nazwa;

    @FXML
    private CheckBox tylkoKobiety;

    @FXML
    private TextField wiekMax;

    @FXML
    private TextField wiekMin;

    @FXML
    private Button zatwierdzam;

    @FXML
    void zatwierdzenie_dodania(ActionEvent event) throws SQLException {

        Boolean czyTylkoDlaKobiet = tylkoKobiety.isSelected();
        String min = wiekMin.getText();
        String max = wiekMax.getText();
        String nazwaPreparatu = nazwa.getText();


        Tester.callProcedure("Call Dodawanie_szczepień("+nazwaPreparatu+","+min+","+max+","+czyTylkoDlaKobiet+");");



    }

    @FXML
    void initialize() {
        assert nazwa != null : "fx:id=\"nazwa\" was not injected: check your FXML file 'dodawaniePreparatu.fxml'.";
        assert tylkoKobiety != null : "fx:id=\"tylkoKobiety\" was not injected: check your FXML file 'dodawaniePreparatu.fxml'.";
        assert wiekMax != null : "fx:id=\"wiekMax\" was not injected: check your FXML file 'dodawaniePreparatu.fxml'.";
        assert wiekMin != null : "fx:id=\"wiekMin\" was not injected: check your FXML file 'dodawaniePreparatu.fxml'.";
        assert zatwierdzam != null : "fx:id=\"zatwierdzam\" was not injected: check your FXML file 'dodawaniePreparatu.fxml'.";

    }




}


