package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import edu.ib.structures.Tester;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DodawaniePreparatuController {

    private Stage stage;
    private Scene scene;
    private Parent root;



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
    void zatwierdzenie_dodania(ActionEvent event) throws SQLException, IOException {
        int czyTylkoDlaKobiet;
        if (tylkoKobiety.isSelected()) czyTylkoDlaKobiet = 1;
        else czyTylkoDlaKobiet = 0;
        String min = wiekMin.getText();
        String max = wiekMax.getText();
        String nazwaPreparatu = nazwa.getText();
        if (min.equals("")) min = "null";
        if (max.equals("")) max = "null";

        String command = "Call dodawanie_szczepien('"+nazwaPreparatu+"',"+min+","+max+","+czyTylkoDlaKobiet+");";
        System.out.println(command);
        Tester.callProcedure(command);
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/punktSzczepienApp.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


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


