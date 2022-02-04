package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import edu.ib.structures.Patient;
import edu.ib.structures.Tester;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistrationSheetController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox RegisterResponse;

    @FXML
    private PasswordField passwordField1;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField2;

    @FXML
    private TextField peselField;

    @FXML
    private TextField phoneField;

    @FXML
    private Button registryButton;

    @FXML
    private Text resp;

    @FXML
    void RegisterAction(ActionEvent event) throws IOException, SQLException {
        if (peselField.getText().length() != 11)
            resp.setText("Numer PESEL jest nieprawidłowy");
        else{
            try {
                new Patient(peselField.getText());
                Long.valueOf(peselField.getText());
                if (Tester.dataBaseInfo("select count(*) from pacjenci_i_hasla where PESEL like '" + peselField.getText()
                        + "';").get(0).get(0).equals("1"))
                    resp.setText("Ten numer PESEL jest już zarejestrowany w bazie");
                else {
                    if (!passwordField1.getText().equals(passwordField2.getText()))
                        resp.setText("Podane hasła nie są ze sobą zgodne");
                    else {
                        String name = nameField.getText();
                        String pass1 = passwordField1.getText();
                        String phone = phoneField.getText();
                        if (phone.equals("")) phone = null;
                        if (name.equals(""))
                            resp.setText("Imię nie może pozostać puste");
                        else {
                            if (pass1.equals(""))
                                resp.setText("Pole hasło nie może pozostac puste");
                            else{
                                if (passwordField1.getText().replaceAll("[^a-zA-Z0-9]","").equals(passwordField1.getText())){
                                    if (!passwordField1.getText().replaceAll("[A-Z]","").equals(passwordField1.getText())){
                                        if (!passwordField1.getText().replaceAll("[0-9]","").equals(passwordField1.getText()))
                                        {
                                            if (passwordField1.getText().length() >= 8 && passwordField1.getText().length() <= 22)
                                            {
                                                System.out.println(peselField.getText());
                                                Tester.callProcedure("call rejestracja_zapisujacy('"+peselField.getText()+"', '"+
                                                        name +"', '" + pass1 + "', "+ phone +");");
                                                Parent root= FXMLLoader.load(getClass().getResource("/fxml/loggingSheet.fxml"));
                                                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                                                scene = new Scene(root);
                                                stage.setScene(scene);
                                                stage.show();
                                            } else{
                                                resp.setText("Hasło musi mieć długość od 8 do 22 znaków");
                                            }
                                        } else{
                                            resp.setText("Hasło musi zawierać przynajmniej jedną cyfrę");
                                        }
                                    } else {
                                        resp.setText("Hasło musi zawierać przynajmniej jedną wielką literę");
                                    }
                                } else {
                                    resp.setText("Hasło może zawirać tylko cyfry, małe i duże litery");
                                }
                            }
                        }
                    }
                }
            }catch (Exception e){
                resp.setText("Pesel nie jest poprawny");
            }

        }
    }

    @FXML
    void initialize() {
        assert RegisterResponse != null : "fx:id=\"RegisterResponse\" was not injected: check your FXML file 'registrationSheet.fxml'.";
        assert passwordField1 != null : "fx:id=\"passwordField1\" was not injected: check your FXML file 'registrationSheet.fxml'.";
        assert passwordField2 != null : "fx:id=\"passwordField2\" was not injected: check your FXML file 'registrationSheet.fxml'.";
        assert peselField != null : "fx:id=\"peselField\" was not injected: check your FXML file 'registrationSheet.fxml'.";
        assert phoneField != null : "fx:id=\"phoneField\" was not injected: check your FXML file 'registrationSheet.fxml'.";
        assert registryButton != null : "fx:id=\"registryButton\" was not injected: check your FXML file 'registrationSheet.fxml'.";

    }

}
