package sample;

import java.util.ArrayList;


public abstract class MovieishEntity {

    private String entityType;
    private String name;
    private int date;
    private int length;
    private float price;
    private Distributor distributor;
    private ArrayList<String> countries;
    private String countriesString;
    private float note;

    public void Display() {
        System.out.println(this.toString());
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int lenght) {
        this.length = lenght;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public ArrayList<String> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<String> countries) {
        this.countries = countries;
    }

    public String getCountriesString() {
        return countriesString;
    }

    public void setCountriesString(String countriesString) {
        this.countriesString = countriesString;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
}
