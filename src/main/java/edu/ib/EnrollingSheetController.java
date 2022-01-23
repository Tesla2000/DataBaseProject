package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class EnrollingSheetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private Button enrollButton;

    @FXML
    private Text enrollResponse;

    @FXML
    private TextField enrolledDate;

    @FXML
    private TextField enrolledID;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> vaccine;

    @FXML
    void backAction(ActionEvent event) {

    }

    @FXML
    void enrollAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'enrollingSheet.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'enrollingSheet.fxml'.";
        assert enrollButton != null : "fx:id=\"enrollButton\" was not injected: check your FXML file 'enrollingSheet.fxml'.";
        assert enrollResponse != null : "fx:id=\"enrollResponce\" was not injected: check your FXML file 'enrollingSheet.fxml'.";
        assert enrolledDate != null : "fx:id=\"enrolledDate\" was not injected: check your FXML file 'enrollingSheet.fxml'.";
        assert enrolledID != null : "fx:id=\"enrolledID\" was not injected: check your FXML file 'enrollingSheet.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'enrollingSheet.fxml'.";
        assert vaccine != null : "fx:id=\"vaccine\" was not injected: check your FXML file 'enrollingSheet.fxml'.";

    }

}
