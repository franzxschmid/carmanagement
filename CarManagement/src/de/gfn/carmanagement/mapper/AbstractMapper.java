
package de.gfn.carmanagement.mapper;

import de.gfn.carmanagement.entity.AbstractEntity;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Enthält generische Methoden zum Arbeiten mit der
public abstract class AbstractMapper<T extends AbstractEntity> implements Mapper<T> {

    public final String TABLE;

    public AbstractMapper(String table) {
        this.TABLE = table;
    }
    
    //Gibt Resultset als Liste zurück
    @Override
    public List<T> find() throws SQLException {
        try(Connection dbh = DbFactory.getConnection(); Statement stmt = dbh.createStatement()) {
            stmt.execute("SELECT * FROM " + TABLE + " ORDER BY id");
            ResultSet results = stmt.getResultSet();
            List<T> list = new ArrayList<>();
            while(results.next()) {
                list.add(create(results));
            }
            return list;
        }
    }

    //Bit eine Entität zurück
    @Override
    public T find(int id) throws SQLException {
        try(Connection dbh = DbFactory.getConnection(); Statement stmt = dbh.createStatement()) {
            stmt.execute("SELECT * FROM " + TABLE + " WHERE id = " + id);
            ResultSet results = stmt.getResultSet();
            results.next();
            return create(results);
        }
    }
    
    //Führt belibigen SQL-Befehl aus
    private boolean execute(String sql) throws SQLException {
        try(Connection dbh = DbFactory.getConnection(); Statement stmt = dbh.createStatement()) {
            stmt.execute(sql);
            return stmt.getUpdateCount() > 0;
        }
    }
    
    //Führt belibigen SQL-Befehl mit bestimmer Entiät aus
    private boolean execute(String sql, T t) throws SQLException, RuntimeException {
        try(Connection dbh = DbFactory.getConnection(); PreparedStatement stmt = dbh.prepareStatement(sql)) {
            int i = 0;
            for(Field f : t.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                try {
                    stmt.setObject(++i, f.get(t));
                }
                catch(IllegalAccessException e) {
                    throw new RuntimeException("Not Accessible", e);
                }
            }
            stmt.execute();
            return stmt.getUpdateCount() > 0;
        }
    }
    
    //Führt ein SQL-Update aus
    @Override
    public boolean update(T t) throws SQLException {
        
        StringBuilder fields = new StringBuilder();
        for(Field f : t.getClass().getDeclaredFields()) {
            if(fields.length() > 1) {
                fields.append(",");
            }
            fields.append(f.getName()).append(" = ?");
        }
        
        String sql = "UPDATE " + TABLE + " SET " + fields.toString() + " WHERE id = " + t.getId();
        return execute(sql, t);
    }
    
    //Fürt eine SQL-Insert aus
    @Override
    public boolean insert(T t) throws SQLException {
        
        StringBuilder fields = new StringBuilder();
        StringBuilder values = new StringBuilder();
        
        // Eigenschaften der Elternklasse
        //Field[] superFields = t.getClass().getSuperclass().getDeclaredFields();
        
        //Listet alle Felder auf die von der Klasse t deklariert werden
        for(Field f : t.getClass().getDeclaredFields()) {
            if(fields.length() > 1) {
                fields.append(",");
                values.append(",");
            }
            fields.append(f.getName());
            values.append("?");
        }
        String sql = "INSERT INTO " + TABLE + " (" + fields.toString() + ") VALUES(" + values.toString() + ")";
        return execute(sql, t);
    }
    
    
    //Führt SQL-Delete aus
    @Override
    public boolean delete(T t) throws SQLException {
        return AbstractMapper.this.execute("DELETE FROM " + TABLE + " WHERE id = " + t.getId());
    }
}
