package de.gfn.carmanagement.entity;

//Beschreibt die Entität "Customer"
public class Customer extends AbstractEntity {
    
    private String firstname;
    private String lastname;
    private String email;

    //Konstruktor unter Verwendung Builder
    public Customer(CustomerBuilder builder){
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.email = builder.email;
    }

    public Customer() {}
    
    //Getter und Setter
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //Builder
    public static class CustomerBuilder{
       
        private String firstname;
        private String lastname;
        private String email;
        
        //Konstruktor vom Builder
        public CustomerBuilder(){}
        
        //With und Build Methoden
        public CustomerBuilder withFirstname(String firstname){
            this.firstname = firstname;
            return this;
        }
        
        public CustomerBuilder withLastname(String lastname){
            this.lastname = lastname;
            return this;
        }
        
        public CustomerBuilder withEmail(String email){
            this.email = email;
            return this;
        }
        
        public Customer build(){
            return new Customer(this);
        }
         
    }
   
}
