package edu.ib.structures;

public class Szczepionka {

    private String nazwa;
    private int id;
    private String minAge;
    private String maxAge;

    public Szczepionka(String nazwa) {
        this.nazwa = nazwa;
    }

    public Szczepionka(String nazwa, int id, String minAge, String maxAge) {
        this.nazwa = nazwa;
        this.id = id;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getId() {
        return id;
    }

    public String getMinAge() {
        return minAge;
    }

    public String getMaxAge() {
        return maxAge;
    }
}
