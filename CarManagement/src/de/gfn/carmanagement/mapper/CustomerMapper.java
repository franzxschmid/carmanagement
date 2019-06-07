package de.gfn.carmanagement.mapper;

import de.gfn.carmanagement.entity.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;

//ORM: Wandelt das SQL-Abfrageergebniss in ein Objekt
public class CustomerMapper extends AbstractMapper<Customer>{

    public CustomerMapper() {
        super("customers");
    }
    
    @Override
    public Customer create(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setFirstname(rs.getString("firstname"));
        customer.setLastname(rs.getString("lastname"));
        customer.setEmail(rs.getString("email"));
        return customer;
    }
}
