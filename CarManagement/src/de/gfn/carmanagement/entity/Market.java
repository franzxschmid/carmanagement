package de.gfn.carmanagement.entity;


public class Market extends AbstractEntity {
    
    private String country;
    
    private int inhabitants;
    
    private int carsPerCapita;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(int inhabitants) {
        this.inhabitants = inhabitants;
    }

    public int getCarsPerCapita() {
        return carsPerCapita;
    }

    public void setCarsPerCapita(int carsPerCapita) {
        this.carsPerCapita = carsPerCapita;
    }
    
    
}

