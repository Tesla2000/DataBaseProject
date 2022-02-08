package edu.ib.structures;

import java.time.LocalDate;

/**
 * edu.ib.structures.PatientsVaccine
 * class used to hold data put in table on patients main scene
 *
 * @author FR, MD
 * @version 1.0
 * @since 2022-02-08
 */
public class PatientsVaccine {
    private String vaccine;
    private Boolean realization;
    private LocalDate date;

    /**
     * Condtrctor of class
     * @param vaccine name of vaccine
     * @param realization true if vaccines was already taken false otherwise
     * @param date date and hour of vaccination
     */
    public PatientsVaccine(String vaccine, Boolean realization, LocalDate date) {
        this.vaccine = vaccine;
        this.realization = realization;
        this.date = date;
    }

    public String getVaccine() {
        return vaccine;
    }

    public Boolean getRealization() {
        return realization;
    }

    public LocalDate getDate() {
        return date;
    }
}
