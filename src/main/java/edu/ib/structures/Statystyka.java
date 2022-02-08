package edu.ib.structures;

import java.time.LocalDate;

/**
 * edu.ib.structures.Statystyka
 * class used to hold data put in table statistics scene
 *
 * @author FR, MD
 * @version 1.0
 * @since 2022-02-08
 */
public class Statystyka {
    private String id;
    private LocalDate data;
    private Boolean realizacja;
    private String preparat;
    private String pacjent;

    /**
     * Class constructor
     * @param id vaccine id number
     * @param data date of vaccination
     * @param realizacja true if vaccines was already taken false otherwise
     * @param preparat name of vaccine
     * @param pacjent patients personal id number
     */
    public Statystyka(String id, LocalDate data, Boolean realizacja, String preparat, String pacjent) {
        this.id = id;
        this.data = data;
        this.realizacja = realizacja;
        this.preparat = preparat;
        this.pacjent = pacjent;
    }

    public String getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Boolean getRealizacja() {
        return realizacja;
    }

    public String getPreparat() {
        return preparat;
    }

    public String getPacjent() {
        return pacjent;
    }
}
