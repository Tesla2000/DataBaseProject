package edu.ib.structures;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * edu.ib.structures.Patient
 * class used to check if person with given e-mail can take specific vaccine
 * also used to prevent from SQL code injection
 *
 * @author FR, MD
 * @version 1.0
 * @since 2022-02-08
 */
public class Patient {
    private String name = null;
    private String id; // May begin with zero
    private String phoneNumber = null;  // May begin with zero
    private String password = null;
    private ArrayList<String> vaccines = new ArrayList<>();
    private final Gender gender;
    private final ArrayList<Patient> permissions = new ArrayList<>();
    private final int yearOfBirth;
    private final int monthOfBirth;
    private final int dayOfBirth;

    /**
     * Class constructor calculating day of birth and gender from id
     * @param id personal id number of patient
     */
    public Patient(String id) {
        this.id = id;
        if (Long.parseLong(id)%2 == 1) this.gender = Gender.Man;
        else this.gender = Gender.Woman;
        if (id.charAt(2) == '2' || id.charAt(2) == '3')
            yearOfBirth = 2000 + Integer.parseInt(id.substring(0,2));
        else if (id.charAt(2) == '0' || id.charAt(2) == '1')
            yearOfBirth = 1900 + Integer.parseInt(id.substring(0,2));
        else throw new IllegalArgumentException("Invalid Pesel");
        monthOfBirth = Integer.parseInt(id.substring(2,4))%20;
        if (monthOfBirth>12) throw new IllegalArgumentException("Invalid Pesel");
        dayOfBirth = Integer.parseInt(id.substring(4,6));
        if (dayOfBirth>31 ||
                (dayOfBirth>30 && (monthOfBirth==4 || monthOfBirth==6 || monthOfBirth==9 || monthOfBirth == 11))
        || (dayOfBirth > 29 && monthOfBirth==2) || (dayOfBirth > 28 && monthOfBirth==2 && (yearOfBirth%4!=0 ||
                (yearOfBirth%100==0 && yearOfBirth%400!=0)))) throw new IllegalArgumentException("Invalid Pesel");
    }

    /**
     * Method determines if patients gender is woman
     * @return boolean true if patient is a woman false otherwise
     */
    public boolean isWoman(){
        return gender.equals(Gender.Woman);
    }

    /**
     * Methode returns patients age at vaccination to compare with required
     * @param vaccinationDate LocalDate date of vaccination
     * @return int age at vaccination date
     */
    public int getAgeAtVaccination(LocalDate vaccinationDate) {
        int year = vaccinationDate.getYear();
        int month = vaccinationDate.getMonth().getValue();
        int day = vaccinationDate.getDayOfMonth();
        int age = year - yearOfBirth;
        if (monthOfBirth > month) age -= 1;
        else if (monthOfBirth==month && dayOfBirth > day) age -= 1;
        return age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
