
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatement_JDBC {
    
    public static void main(String[] args) {
        
        try
        {
            // Step 1 Register the Driver
          Driver d = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(d);
            System.err.println("Driver is Register the SucessFully...");

            // Step 2 Get Conection 
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Darshan");
            System.out.println("Get Connection is Sucessfully..connection id :"+con);

            // Step 3 Create Statement Object 
           CallableStatement call = con.prepareCall(" { CALL studAddDatabase(?,?)} ");
            System.err.println("Statement Object is Created...");

            call.setInt(1, 9);
            call.setString(2, "Paresh_Kumbhar");

            // Step 4 Execute the Query
            call.executeUpdate();

            // step 5 Close Connection
            con.close();
        }
        catch(SQLException ex)
        {
            System.err.println("Error in Database Conection...");
        }
    }
}
