
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class JDBCcon {

    public static void main(String args[])
    {

        try{
            // Step 1 Register the Driver
            Driver d =new  oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(d);
            System.err.println("Driver Register Sucessfully");

            // Step 2 Get Connection 
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Darshan");
            System.err.println("Get Connection is SucessFully...Connection is :"+con);

            // Step 3 Create Statement Object
            Statement stmt = con.createStatement();
            System.err.println("Statement Object is Created...");

            // Step 4 Execute Query
            // stmt.executeUpdate("create table stud(id number(5),name varchar (50))"); 
            stmt.executeUpdate("insert into stud values(7,'Kalpesh Mistari')");


            // Step 5 Close Connection
            con.close();

        }
        catch(SQLException ex)
        {
            System.err.println("Error in Database Connextion");
        }


    }
    
}
