package de.gfn.carmanagement.entity;


public class Car extends AbstractEntity {
    
    //Attribute
    private String registration;
    private String brand;

    //Default Konstruktor
    public Car(){};
    
    //Konstruktor der den Builder nutzt
    public Car(CarBuilder builder){
        this.registration = builder.registration;
        this.brand = builder.brand; 
    }
    
    //Getter und Setter
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
    
    //Builder
    public static class CarBuilder{
           
        private String registration;
        private String brand;
        
        //Builder Konstruktor
        public CarBuilder(String registration){
            this.registration = registration;
        }
        
        //With-Methode
        public CarBuilder withBrand(String brand){
            this.brand = brand;
            return this;
        }
        
        //Build-Methode
        public Car build(){
            return new Car(this);
        }
          
    }

}
