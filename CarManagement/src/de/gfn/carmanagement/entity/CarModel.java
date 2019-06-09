
package de.gfn.carmanagement.entity;


public class CarModel extends AbstractEntity{
    
    private String name;
    private String brand;
    private int price;

    //Default Konstruktor
    public CarModel(){}
    
    //Konstruktor unter Verwendung des Builders
    public CarModel(CarModelBuilder builder){
        this.name = builder.name;
        this.brand = builder.brand;
        this.price = builder.price;
    }
    
    //Getter und Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    //Builder Klasse
    public static class CarModelBuilder{
        
        private String name;
        private String brand;
        private int price;
        
        //Konstruktor Builder
        public CarModelBuilder(){}
        
        //With und Build Methoden
        public CarModelBuilder withName(String name){
            this.name = name;
            return this;
        }
        
        public CarModelBuilder withBrand(String brand){
            this.brand = brand;
            return this;
        }
        
        public CarModelBuilder withPrice(int price){
            this.price = price;
            return this;
        }
        
        public CarModel build(){
            return new CarModel(this);
        }

    }
}
