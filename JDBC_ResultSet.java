import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

class JDBC_ResultSet
{
    public static void main(String[] args) 
    {
        try
        {
            // Step 1: Register the Driver
            Driver d =new oracle.jdbc.driver.OracleDriver();
            System.err.println("Register the Driver SuccesuFully...");
            DriverManager.registerDriver(d);
            


            // Step 2: Get Connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Darshan");
            System.err.println("Connection is SuccessFully... Connection id :"+con);

            // Step 3: ceate Statement Object
            Statement stmt = con.createStatement();
            System.err.println("Statement Object Created SuccessFullys..");

            // Step 4: Execute Query
            // Access the Data from Table

            ResultSet rs = stmt.executeQuery("select * from stud");

            while (rs.next()) {
                System.err.println(rs.getInt(1) +"\t"+rs.getString(2));
             
            }
            
            // Step 5: Close Connection
            con.close();
        }
        catch(SQLException ex)
        {
            System.err.println("Error Connection");
        }


    }
}