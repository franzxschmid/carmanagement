package de.gfn.carmanagement.mapper;

import de.gfn.carmanagement.entity.AbstractEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


//Deklariert abstrakte Methoden für die ORM
public interface Mapper<T extends AbstractEntity> {
    
    List<T> find() throws SQLException;
    
    T find(int id) throws SQLException;
    
    boolean insert(T t) throws SQLException;
    
    boolean update(T t) throws SQLException;
    
    boolean delete(T t) throws SQLException;
    
    // Wandelt eine Zeile des ResultSets in ein EntityObjekt um
    T create(ResultSet rs) throws SQLException;
}
