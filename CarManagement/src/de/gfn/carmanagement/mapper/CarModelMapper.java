
package de.gfn.carmanagement.mapper;


import de.gfn.carmanagement.entity.CarModel;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CarModelMapper extends AbstractMapper<CarModel>{

    public CarModelMapper(String table) {
        super("carModels");
    }

    @Override
    public CarModel create(ResultSet rs) throws SQLException {

        CarModel carModel = new CarModel();
        
        carModel.setId(rs.getInt("id"));
        carModel.setName(rs.getString("name"));
        carModel.setBrand(rs.getString("brand"));
        carModel.setPrice(rs.getInt("price"));
        return carModel;
    }
    
}
