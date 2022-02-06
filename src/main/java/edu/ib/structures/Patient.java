package edu.ib.structures;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

    public Patient(String name, String id, String phoneNumber, String password, ArrayList<String> vaccines) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.vaccines = vaccines;
        if (Long.parseLong(id)%2 == 1) this.gender = Gender.Man;
        else this.gender = Gender.Woman;
        if (id.charAt(2) == '2' || id.charAt(2) == '3')
            yearOfBirth = 2000 + Integer.parseInt(id.substring(0,2));
        else
            yearOfBirth = 1900 + Integer.parseInt(id.substring(0,2));
        monthOfBirth = Integer.parseInt(id.substring(2,4))%20;
        dayOfBirth = Integer.parseInt(id.substring(4,6));
    }


    public void addPermission(Patient patient) {
        permissions.add(patient);
    }

    public boolean isWoman(){
        return gender.equals(Gender.Woman);
    }

    public void revokePermission(Patient patient){
        permissions.remove(patient);
    }

    public boolean isAdult() {
        int year = LocalDateTime.now().getYear();
        int month = LocalDateTime.now().getMonth().getValue();
        int day = LocalDateTime.now().getDayOfMonth();
        int age = year - yearOfBirth;
        if (monthOfBirth > month) age -= 1;
        else if (monthOfBirth==month && dayOfBirth > day) age -= 1;
        return age >= 18;
    }


    public int getAgeAtVaccination(LocalDate vaccinationDate) {
        int year = vaccinationDate.getYear();
        int month = vaccinationDate.getMonth().getValue();
        int day = vaccinationDate.getDayOfMonth();
        int age = year - yearOfBirth;
        if (monthOfBirth > month) age -= 1;
        else if (monthOfBirth==month && dayOfBirth > day) age -= 1;
        return age;
    }

    public ArrayList<Patient> getPermissions() {
        return permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }
}
