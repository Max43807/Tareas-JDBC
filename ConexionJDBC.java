/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareasjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Maxi
 */
public class ConexionJDBC {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/tareas_db", "root", "root"); //Cadeba de conexión...
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
            
        }
    }
}
