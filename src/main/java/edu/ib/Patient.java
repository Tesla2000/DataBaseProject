package edu.ib;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Patient {
    private String name;
    private Long id;
    private Long phoneNumber = null;
    private String password;
    private String gender;
    private ArrayList<Patient> permissions = new ArrayList<>();

    public Patient(String name, Long id, Long phoneNumber, String password) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.password = password;
        if (id % 2 == 1) this.gender = "Man";
        else this.gender = "Woman";
    }

    public Patient(String name, Long id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
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
        int yearOfBirth;
        if (id % 1000000000 > 200000000)
            yearOfBirth = 2000 + (int) (id / 100000000);
        else
            yearOfBirth = 1900 + (int) (id / 100000000);
        int monthOfBirth = (int) ((id % 200000000) / 10000000);
        int dayOfBirth = (int) ((id % 10000000) / 100000);
        int age = year - yearOfBirth;
        if (monthOfBirth > month) age -= 1;
        else if (monthOfBirth==month && dayOfBirth > day) age -= 1;
        return age >= 18;
    }


    public int getAgeAtVaccination(LocalDateTime vaccinationDate) {
        int year = vaccinationDate.getYear();
        int month = vaccinationDate.getMonth().getValue();
        int day = vaccinationDate.getDayOfMonth();
        int yearOfBirth;
        if (id % 1000000000 > 200000000)
            yearOfBirth = 2000 + (int) (id / 100000000);
        else
            yearOfBirth = 1900 + (int) (id / 100000000);
        int monthOfBirth = (int) ((id % 200000000) / 10000000);
        int dayOfBirth = (int) ((id % 10000000) / 100000);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
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
