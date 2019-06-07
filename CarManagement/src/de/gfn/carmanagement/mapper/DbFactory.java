package de.gfn.carmanagement.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Enthält Factory Methode zum Aufbau einer Verbindung zur Datenbank
public class DbFactory {

    private DbFactory() {
    }
    
    //Verbindung mit Datenbank in zentralem Aufruf
    //Hier sind: URL, Benutzer und Passwort hinterlegt 
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/carmanagement?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
    }
}
