package edu.ib.structures;

import java.time.LocalDate;

public class PatientsVaccine {
    private Vaccine vaccine;
    private Boolean realization;
    private LocalDate date;

    public PatientsVaccine(Vaccine vaccine, Boolean realization, LocalDate date) {
        this.vaccine = vaccine;
        this.realization = realization;
        this.date = date;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public Boolean getRealization() {
        return realization;
    }

    public LocalDate getDate() {
        return date;
    }
}
