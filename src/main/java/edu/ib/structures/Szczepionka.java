package edu.ib.structures;

/**
 * edu.ib.structures.Szczepionka
 * class used to hold data put in table of inserted vaccine names
 *
 * @author FR, MD
 * @version 1.0
 * @since 2022-02-08
 */
public class Szczepionka {

    private String nazwa;

    /**
     * Class constructor
     * @param nazwa name of vaccine
     */
    public Szczepionka(String nazwa) {
        this.nazwa = nazwa;
    }


    public String getNazwa() {
        return nazwa;
    }
}
