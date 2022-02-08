package edu.ib.structures;

/**
 * edu.ib.structures.Permit
 * class used to hold data put in table on permitions scene
 *
 * @author FR, MD
 * @version 1.0
 * @since 2022-02-08
 */
public class Permit{
    private String PESEL;
    private String name;
    private String phoneNumber;

    /**
     * Constructor of class
     * @param PESEL personal id number of patient
     * @param name name of patient
     * @param phoneNumber phone number of patient
     */
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
