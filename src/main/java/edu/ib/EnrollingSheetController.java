package edu.ib;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EnrollingSheetController {
    private Stage stage;
    private Scene scene;
    private Parent root;

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
    void backAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/patientSheet.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
