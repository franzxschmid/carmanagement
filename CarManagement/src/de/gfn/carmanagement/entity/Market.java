package de.gfn.carmanagement.entity;


public class Market extends AbstractEntity {
    
    private String country;
    private int inhabitants;
    private int carsPerCapita;

    //Konstruktor unter Verwendung Builder
    public Market(MarketBuilder builder){
        this.country = builder.country;
        this.inhabitants = builder.inhabitants;
        this.carsPerCapita = builder.carsPerCapita;
    }

    public Market() {}
    
    //Getter und Setter
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
    
    //Builder
    public static class MarketBuilder{
       
        private String country;
        private int inhabitants;
        private int carsPerCapita;
        
        public MarketBuilder(String country){
            this.country = country;
        }
        
        //With und Build Methoden
        public MarketBuilder withInhabitants(int inhabitants){
            this.inhabitants = inhabitants;
            return this;
        }
        
        public MarketBuilder withCarsPerCapita(int carsPerCapita){
            this.carsPerCapita = carsPerCapita;
            return this;
        }
        
        public Market build(){
            return new Market(this);
        }
    }
}
