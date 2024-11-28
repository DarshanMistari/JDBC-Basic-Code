import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class ResultSet_Update_Insert 
{
    public static void main(String agrs[])
    {
        try
        {
            // Step 1: Register the Driver
            Driver d = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(d);
            System.err.println("Register the Driver SuccessFully..agrs.");
    
            // Step 2: Get Connection 
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Darshan");
            System.err.println("Connection is SuccessFully..Connection id:"+con);

            // Step 3: Create Statement Object
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE);
            System.err.println("Create Statement Object Successfully...");

            // Step 4:Execute Query
            ResultSet rs = stmt.executeQuery("select * from stud");

            while(rs.next())
            {
                System.err.println(rs.getInt(1)+"\t"+ rs.getString(2));
            }

            rs.first();
            System.err.println("First Row Data :"+rs.getInt(1) +"\t"+ rs.getString(2));

            rs.last();
            System.err.println("Last Row Data :"+rs.getInt(1) +"\t"+ rs.getString(2));
            
            rs.absolute(3);
            System.err.println("Third Row Data :"+rs.getInt(1) +"\t"+ rs.getString(2));
            
            //Step 5 Close Connection
            con.close();
        }
        catch(SQLException ex)
        {
            System.err.println("Error Connection");
        }
    }
}
