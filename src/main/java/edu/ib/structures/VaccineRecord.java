package edu.ib.structures;

import java.time.LocalDate;

public class VaccineRecord {
    private Boolean realization;
    private LocalDate date;
    private int pesel;
    private String nazwisko;

    public VaccineRecord(Boolean realization, LocalDate date, int pesel, String nazwisko) {
        this.realization = realization;
        this.date = date;
        this.pesel = pesel;
        this.nazwisko = nazwisko;
    }

    public Boolean getRealization() {
        return realization;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPesel() {
        return pesel;
    }

    public String getNazwisko() {
        return nazwisko;
    }
}
