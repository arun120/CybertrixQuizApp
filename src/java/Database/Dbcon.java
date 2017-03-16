/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alagesh
 */
public class Dbcon {
    
    public static Connection getConnection(){
       Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
             conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cybertrix", "root","1234");
            
        } catch (Exception ex) {
      ex.printStackTrace();
        }
        
        return conn;
    }
}
