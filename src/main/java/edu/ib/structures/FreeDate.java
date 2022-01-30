package edu.ib.structures;

import java.time.LocalDateTime;

public class FreeDate {
    private LocalDateTime date;
    private Vaccine vaccine;
    private Integer number;

    public FreeDate(LocalDateTime date, Vaccine vaccine, Integer number) {
        this.date = date;
        this.vaccine = vaccine;
        this.number = number;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public Integer getNumber() {
        return number;
    }
}
