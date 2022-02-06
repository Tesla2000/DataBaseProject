package edu.ib.structures;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Statystyka {
    private String id;
    private LocalDate data;
    private Boolean realizacja;
    private String preparat;
    private String pacjent;

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
