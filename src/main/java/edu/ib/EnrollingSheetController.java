package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * edu.ib.EnrollingSheetController
 * Allows patient to enroll on vaccination and check vaccinations available to given patient
 *
 * @author FR, MD
 * @version 1.0
 * @since 2022-02-08
 */
public class EnrollingSheetController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String login;
    private ObservableList<FreeDate> list = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;
    @FXML
    private Button checkButton;
    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<FreeDate, LocalDateTime> date;

    @FXML
    private TableColumn<FreeDate, Integer> number;

    @FXML
    private Button enrollButton;

    @FXML
    private Text enrollResponse;

    @FXML
    private TextField enrolledDate;

    @FXML
    private TextField enrolledID;

    @FXML
    private TableView<FreeDate> table;

    @FXML
    private TableColumn<FreeDate, String> vaccine;

    /**
     * Reads date from id field and displays vaccines available to given id
     * theoretical or real depending on logged patients permission
     * @param event on button click
     * @throws SQLException thrown if SQL request is not valid
     */
    @FXML
    void checkAction(ActionEvent event) throws SQLException {
        table.getItems().clear();
        String pesel = enrolledID.getText();
        int n = 0;
        Patient patient;
        try {
            patient = new Patient(pesel);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        ArrayList<ArrayList<String>> results = Tester.dataBaseInfo("select * from widok_dostepne_szczepienia;");
        vaccine.setCellValueFactory(new PropertyValueFactory<>("vaccine"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        for (ArrayList<String> result: results){
            String date = result.get(5).split(" ")[0];
            int year = Integer.parseInt(date.split("-")[0]);
            int month = Integer.parseInt(date.split("-")[1]);
            int day = Integer.parseInt(date.split("-")[2]);
            int age = patient.getAgeAtVaccination(LocalDate.of(year, month, day));
            if ((result.get(4).equals("brak") || age <= Integer.parseInt(result.get(4))) &&
                     (result.get(3).equals("brak") || age >= Integer.parseInt(result.get(3))) &&
                    (result.get(2).equals("0") || patient.isWoman())){
                String command = "select Data from widok_szczepien " +
                        "where PESEL like " + pesel +" and Rodzaj_preparatu like '" + result.get(1) + "' and " +
                        "(select count(*) from uprawnienia where zapisywani_pesel like '"+pesel+"' and zapisujacy_pesel like '"+login+"') = 1 " +
                        " order by Data desc limit 1;";
                ArrayList<ArrayList<String>> vaccinesTaken = Tester.dataBaseInfo(command);

                ArrayList<ArrayList<String>> lastTime = Tester.dataBaseInfo("select Data from widok_szczepien " +
                        "where PESEL like " + pesel + " order by Data desc limit 1;");
                if (lastTime.size() == 0)
                {
                    date = result.get(5).split(" ")[1];

                    int hour = Integer.parseInt(date.split(":")[0]);
                    int minute = Integer.parseInt(date.split(":")[1]);
                    n++;
                    list.add(new FreeDate(LocalDateTime.of(year,month,day,hour,minute),
                            result.get(1), n));
                }
                else{
                    String lastTimeTaken;
                    if (vaccinesTaken.size() != 0) lastTimeTaken = vaccinesTaken.get(0).get(0).split(" ")[0];
                    else lastTimeTaken = "1000-12-31";
                    String lastTimeOther = lastTime.get(0).get(0).split(" ")[0];
                    if (Math.abs(ChronoUnit.DAYS.between(LocalDate.of(Integer.parseInt(lastTimeTaken.split("-")[0]),
                            Integer.parseInt(lastTimeTaken.split("-")[1]),
                            Integer.parseInt(lastTimeTaken.split("-")[2])), LocalDate.of(year, month, day))) > 365
                    && Math.abs(ChronoUnit.DAYS.between(LocalDate.of(Integer.parseInt(lastTimeOther.split("-")[0]),
                            Integer.parseInt(lastTimeOther.split("-")[1]),
                            Integer.parseInt(lastTimeOther.split("-")[2])), LocalDate.of(year, month, day))) > 21){
                        date = result.get(5).split(" ")[1];
                        int hour = Integer.parseInt(date.split(":")[0]);
                        int minute = Integer.parseInt(date.split(":")[1]);
                        n++;
                        list.add(new FreeDate(LocalDateTime.of(year,month,day,hour,minute),
                                result.get(1), n));

                    }
                }
            }
        }
        table.setItems(list);
    }

    /**
     * Goes back to the main patient scene with
     *               conserving login
     * @param event on click of button
     * @throws IOException thrown is something is wrong with fxml file
     * @throws SQLException thrown if SQL request is not valid
     */
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

    /**
     * Schedules vaccination of patient whose personal id number is given if logged patient has permission
     * on vaccination given by number
     * @param event on button click
     * @throws SQLException thrown if SQL request is not valid
     */
    @FXML
    void enrollAction(ActionEvent event) throws SQLException {
        table.getItems().clear();
        String pesel = enrolledID.getText();
        int n = 0;
        Patient patient = new Patient(pesel);
        ArrayList<ArrayList<String>> results = Tester.dataBaseInfo("select * from widok_dostepne_szczepienia;");
        vaccine.setCellValueFactory(new PropertyValueFactory<>("vaccine"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        for (ArrayList<String> result: results){
            String date = result.get(5).split(" ")[0];
            int year = Integer.parseInt(date.split("-")[0]);
            int month = Integer.parseInt(date.split("-")[1]);
            int day = Integer.parseInt(date.split("-")[2]);
            int age = patient.getAgeAtVaccination(LocalDate.of(year, month, day));
            if ((result.get(4).equals("null") || result.get(4).equals("brak") || age <= Integer.parseInt(result.get(4))) &&
                    (result.get(3).equals("null") || result.get(3).equals("brak") || age >= Integer.parseInt(result.get(3)))){
                ArrayList<ArrayList<String>> vaccinesTaken = Tester.dataBaseInfo("select Data from widok_szczepien " +
                        "where PESEL like " + pesel +" and Rodzaj_preparatu like '" + result.get(1) +
                        "' order by Data desc limit 1;");
                ArrayList<ArrayList<String>> lastTime = Tester.dataBaseInfo("select Data from widok_szczepien " +
                        "where PESEL like " + pesel + " order by Data desc limit 1;");
                if (lastTime.size() == 0)
                {
                    date = result.get(5).split(" ")[1];
                    int hour = Integer.parseInt(date.split(":")[0]);
                    int minute = Integer.parseInt(date.split(":")[1]);
                    n++;
                    list.add(new FreeDate(LocalDateTime.of(year,month,day,hour,minute),
                            result.get(1), n));
                }
                else{
                    String lastTimeTaken;
                    if (vaccinesTaken.size() != 0) lastTimeTaken = vaccinesTaken.get(0).get(0).split(" ")[0];
                    else lastTimeTaken = "1000-12-31";
                    String lastTimeOther = lastTime.get(0).get(0).split(" ")[0];
                    if (Math.abs(ChronoUnit.DAYS.between(LocalDate.of(Integer.parseInt(lastTimeTaken.split("-")[0]),
                            Integer.parseInt(lastTimeTaken.split("-")[1]),
                            Integer.parseInt(lastTimeTaken.split("-")[2])), LocalDate.of(year, month, day))) > 365
                            && Math.abs(ChronoUnit.DAYS.between(LocalDate.of(Integer.parseInt(lastTimeOther.split("-")[0]),
                            Integer.parseInt(lastTimeOther.split("-")[1]),
                            Integer.parseInt(lastTimeOther.split("-")[2])), LocalDate.of(year, month, day))) > 21){
                        date = result.get(5).split(" ")[1];
                        int hour = Integer.parseInt(date.split(":")[0]);
                        int minute = Integer.parseInt(date.split(":")[1]);
                        n++;
                        list.add(new FreeDate(LocalDateTime.of(year,month,day,hour,minute),
                                result.get(1), n));

                    }
                }
            }
        }
        n = Integer.parseInt(enrolledDate.getText());
        FreeDate row = list.get(n-1);
        for (ArrayList<String> permission: Tester.dataBaseInfo("select * from uprawnienia")){
            if (permission.get(0).equals(enrolledID.getText()) && permission.get(3).equals(login)){
                String command = "select ID from widok_dostepne_szczepienia " +
                        "where TERMIN = '" + row.getDate().toString().replace("T"," ") + "' " +
                        "and PREPARAT like '" + row.getVaccine().toString() + "' limit 1;";
//                System.out.println(command);
                results = Tester.dataBaseInfo(command);
                command = "call zapis_na_szczepienie(" + results.get(0).get(0) + ", '" +
                        row.getDate().toString().replace("T"," ") + "', '" + enrolledID.getText() + "');";
                System.out.println(command);
                Tester.callProcedure(command);
                displayDates(login);
                break;
            }
        }
        table.getItems().clear();
        displayDates(login);
    }

    /**
     * Methode initializes elements of scene
     */
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

    /**
     * Methode displays dates of all available vaccines and saves login in field of class
     * @param login patients personal id number passed from main patients scene
     * @throws SQLException thrown if SQL request is not valid
     */
    public void displayDates(String login) throws SQLException {
        this.login = login;
        int n = 0;
        Patient patient = new Patient(login);
        ArrayList<ArrayList<String>> results = Tester.dataBaseInfo("select * from widok_dostepne_szczepienia;");
        vaccine.setCellValueFactory(new PropertyValueFactory<>("vaccine"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        for (ArrayList<String> result: results){
            String date = result.get(5).split(" ")[0];
            int year = Integer.parseInt(date.split("-")[0]);
            int month = Integer.parseInt(date.split("-")[1]);
            int day = Integer.parseInt(date.split("-")[2]);
            date = result.get(5).split(" ")[1];
            int hour = Integer.parseInt(date.split(":")[0]);
            int minute = Integer.parseInt(date.split(":")[1]);
            n++;
            list.add(new FreeDate(LocalDateTime.of(year,month,day,hour,minute),
                    result.get(1), n));

            }
        table.setItems(list);
        }

    }
