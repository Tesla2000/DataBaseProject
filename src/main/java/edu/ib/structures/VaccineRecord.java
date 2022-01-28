package edu.ib.structures;

import java.time.LocalDate;

public record VaccineRecord(Boolean realization,LocalDate date, int pesel, String nazwisko) {

    public Boolean getRealization() {
        return realization;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPesel(){
        return pesel;
    }

    public String getNazwisko() {
        return nazwisko;
    }
}
