package de.gfn.carmanagement;

import de.gfn.carmanagement.entity.Customer;
import de.gfn.carmanagement.mapper.CustomerMapper;
import de.gfn.carmanagement.mapper.Mapper;
import java.util.Scanner;


public class App {

    
    public static void main(String[] args) {
        

        Mapper<Customer> mapper = new CustomerMapper();
        
        Customer customer = new Customer();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Vorname: ");
        customer.setFirstname(scanner.nextLine());
        
        System.out.print("Nachname: ");
        customer.setLastname(scanner.nextLine());
        
        System.out.print("E-Mail: ");
        customer.setEmail(scanner.nextLine());
        
        
        try {
            mapper.insert(customer);
            
            System.out.println("---------");
            
            mapper.find().forEach(c -> System.out.println(c.getId() + ": " + c.getFirstname() + ", " + c.getLastname() + ", " + c.getEmail()));
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
