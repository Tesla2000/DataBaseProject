package edu.ib;

import java.util.ArrayList;

public class Patient {
    private String name;
    private Long id;
    private Long phoneNumber = null;
    private String password;
    private ArrayList<Patient> permissions = new ArrayList<>();

    public Patient(String name, Long id, Long phoneNumber, String password) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Patient(String name, Long id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }
    public void addPermission(Patient patient){
        permissions.add(patient);
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


}
