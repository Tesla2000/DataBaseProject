package edu.ib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * edu.ib.VaccinationClinicApp
 * initializes application and displays login scene
 *
 * @author FR, MD
 * @version 1.0
 * @since 2022-02-08
 */
public class VaccinationClinicApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Displays logging scene
     * @param primaryStage
     * @throws IOException thrown is something is wrong with fxml file
     */
    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("/fxml/loggingSheet.fxml"));
        Scene scene= new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}