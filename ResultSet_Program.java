
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ResultSet_Program {
    
    public static void main(String[] args) {

        try{

            // Step 1 Register the Driver
            Driver d = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(d);
            System.err.println("Register the  Driver SucessFully....");


            // Step 2 Get Connection 
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Darshan");
            System.err.println("Get Connection SucessFully... Connection id :"+ con);

            // Step 3 Create Statement Object
            Statement stmt = con.createStatement();
            System.err.println("Statement Object is Created...");

            // Step 4 Execute the Query
            System.err.println("All Data is Access in DataBase :");
            ResultSet res = stmt.executeQuery("select * from stud");

            while(res.next())
            {
                System.err.println( res.getInt(1)+"\t"+ res.getString(2));
            }

            // Step 5 Conection is Close
            con.close();

        }
        catch(SQLException ex)
        {
            System.err.println("Error is DataBase Connection...");
        }
    }
}
