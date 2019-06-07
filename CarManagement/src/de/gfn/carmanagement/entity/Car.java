package de.gfn.carmanagement.entity;

//Beschreibt die Entität "car"
public class Car extends AbstractEntity {
    
    private String registration;
    private String brand;

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
