package edu.ib;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Patient {
    private String name = null;
    private String id; // May begin with zero
    private String phoneNumber = null;  // May begin with zero
    private String password = null;
    private ArrayList<Vaccine> vaccines = new ArrayList<>();
    private String gender;
    private final ArrayList<Patient> permissions = new ArrayList<>();
    private final int yearOfBirth;
    private final int monthOfBirth;
    private final int dayOfBirth;

//    public Patient(String id) {
//        this.id = id;
//        if (Integer.parseInt(id)%2 == 1) this.gender = "Man";
//        else this.gender = "Woman";
//        if (id.charAt(2) == '2' || id.charAt(2) == '3')
//            yearOfBirth = 2000 + Integer.parseInt(id.substring(0,2));
//        else
//            yearOfBirth = 1900 + Integer.parseInt(id.substring(0,2));
//        monthOfBirth = Integer.parseInt(id.substring(2,4))%20;
//        dayOfBirth = Integer.parseInt(id.substring(4,6));
//    }

    public Patient(String name, String id, String phoneNumber, String password, ArrayList<Vaccine> vaccines) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.vaccines = vaccines;
        if (Integer.parseInt(id)%2 == 1) this.gender = "Man";
        else this.gender = "Woman";
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


    public int getAgeAtVaccination(LocalDateTime vaccinationDate) {
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

    public String getGender() {
        return gender;
    }
}
