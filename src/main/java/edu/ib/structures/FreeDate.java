package edu.ib.structures;

import java.time.LocalDateTime;


/**
 * edu.ib.structures.FreeDate
 * class used to hold data put in table on enrolling scene
 *
 * @author FR, MD
 * @version 1.0
 * @since 2022-02-08
 */
public class FreeDate {
    private LocalDateTime date;
    private String vaccine;
    private Integer number;

    /**
     * Contrustor of class
     * @param date date and hour of vaccination
     * @param vaccine name of vaccine
     * @param number id of vaccination in relation to possible vaccines
     */
    public FreeDate(LocalDateTime date, String vaccine, Integer number) {
        this.date = date;
        this.vaccine = vaccine;
        this.number = number;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getVaccine() {
        return vaccine;
    }

    public Integer getNumber() {
        return number;
    }
}
