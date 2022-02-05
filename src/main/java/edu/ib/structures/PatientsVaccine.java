package edu.ib.structures;

import java.time.LocalDate;

public class PatientsVaccine {
    private String vaccine;
    private Boolean realization;
    private LocalDate date;

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
