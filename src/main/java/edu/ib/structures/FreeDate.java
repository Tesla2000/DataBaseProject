package edu.ib.structures;

import java.time.LocalDateTime;

public record FreeDate(LocalDateTime date, Vaccine vaccine, Integer number) {
    @Override
    public LocalDateTime date() {
        return date;
    }

    @Override
    public Vaccine vaccine() {
        return vaccine;
    }

    @Override
    public Integer number() {
        return number;
    }
}
