/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FLAVIO
 */
public class ConnectionFactory {
    
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/client";
        String username = "root";
        String password = "";
        return DriverManager.getConnection(url, username, password);
    }    
}
