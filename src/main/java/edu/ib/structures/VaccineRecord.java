package edu.ib.structures;

import java.time.LocalDate;

/**
 * edu.ib.structures.VaccineRecord
 * class used to hold data put in table of unrealized vaccines
 *
 * @author FR, MD
 * @version 1.0
 * @since 2022-02-08
 */
public class VaccineRecord {
    private Boolean realization;
    private int id;
    private LocalDate date;
    private long pesel;
    private String nazwisko;

    /**
     * Class constructor
     * @param realization true if vaccines was already taken false otherwise
     * @param date date and hour of vaccination
     * @param id id number of vaccine
     * @param pesel personal id number of patient
     * @param nazwisko name of patient
     */
    public VaccineRecord(Boolean realization, int id, LocalDate date, long pesel, String nazwisko) {
        this.realization = realization;
        this.id = id;
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

    public long getPesel() {
        return pesel;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getId() {
        return id;
    }
}
