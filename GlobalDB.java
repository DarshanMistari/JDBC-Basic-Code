package studmanagement;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GlobalDB {
    static Driver d;
    static Connection con;
    static Statement stmt;
   
    public static void createCon() {
        try {
            d = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(d);
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
        
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(GlobalDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void nonSelect(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(GlobalDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeCon() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GlobalDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
