

package de.gfn.carmanagement.entity;


public class Vendor extends AbstractEntity{
    
    private String owner;
    private String address;
    private String firstBrand;
    private String secondBrand;

    //Konsruktor der den Builder verwendet
    public Vendor(VendorBuilder builder){
        this.owner = builder.owner;
        this.address = builder.address;
        this.firstBrand = builder.firstBrand;
        this.secondBrand = builder.secondBrand;
    }

    public Vendor() {}
    
    //Getter und Setter
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstBrand() {
        return firstBrand;
    }

    public void setFirstBrand(String firstBrand) {
        this.firstBrand = firstBrand;
    }

    public String getSecondBrand() {
        return secondBrand;
    }

    public void setSecondBrand(String secondBrand) {
        this.secondBrand = secondBrand;
    }
    
    //Builder
    public static class VendorBuilder{
           
        private String owner;
        private String address;
        private String firstBrand;
        private String secondBrand;
        
        public VendorBuilder(){}
        
        public VendorBuilder withOwner(String owner){
            this.owner = owner;
            return this;
        }
        
        public VendorBuilder withAddress(String address){
            this.address = address;
            return this;
        }
        
        public VendorBuilder withFirstBrand(String firstBrand){
            this.firstBrand = firstBrand;
            return this;
        }
        
        public VendorBuilder withSecondBrand(String secondBrand){
            this.secondBrand = secondBrand;
            return this;
        }
        
        public Vendor build(){
            return new Vendor(this);
        }
        
        
        
    }
    
}

