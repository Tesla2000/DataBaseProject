package edu.ib.structures;

import java.time.LocalDate;

public record PatientsVaccine(Vaccine vaccine, Boolean realization, LocalDate date) {
    @Override
    public Vaccine vaccine() {
        return vaccine;
    }

    @Override
    public Boolean realization() {
        return realization;
    }

    @Override
    public LocalDate date() {
        return date;
    }
}
