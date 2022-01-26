package edu.ib;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record VaccineRecord(Vaccine vaccine, Boolean realization, LocalDate date) {

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
