package de.gfn.carmanagement.mapper;

import de.gfn.carmanagement.entity.Market;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MarketMapper extends AbstractMapper<Market>{

    public MarketMapper(String table) {
        super("market");
    }

    @Override
    public Market create(ResultSet rs) throws SQLException {
        
        Market market = new Market();
        
        market.setId(rs.getInt("id"));
        
        market.setCountry(rs.getString("country"));
        market.setInhabitants(rs.getInt("inhabitants"));
        market.setCarsPerCapita(rs.getInt("carsPerCapita"));
        
        return market;
    }
    
}
