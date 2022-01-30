package edu.ib.structures;

public class Permit{
    private String PESEL;
    private String name;
    private String phoneNumber;

    public Permit(String PESEL, String name, String phoneNumber) {
        this.PESEL = PESEL;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getPESEL() {
        return PESEL;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
