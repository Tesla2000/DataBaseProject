package edu.ib.structures;

public record Permit(String PESEL, String name, String phoneNumber) {
    @Override
    public String PESEL() {
        return PESEL;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String phoneNumber() {
        return phoneNumber;
    }
}
