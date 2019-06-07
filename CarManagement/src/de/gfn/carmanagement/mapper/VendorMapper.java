package de.gfn.carmanagement.mapper;

import de.gfn.carmanagement.entity.Vendor;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VendorMapper extends AbstractMapper<Vendor>{

    public VendorMapper(String table) {
        super("vendors");
    }

    @Override
    public Vendor create(ResultSet rs) throws SQLException {
        Vendor vendor = new Vendor();
        
        //Setzen der ID
        vendor.setId(rs.getInt("id"));
        //Setzen der Vendor spezifischen Felder
        vendor.setOwner(rs.getString("owner"));
        vendor.setAddress(rs.getString("address"));
        vendor.setFirstBrand(rs.getString("firstBrand"));
        vendor.setSecondBrand(rs.getString("secondBrand"));
        
        return vendor;
    }
}
    
    
    
    