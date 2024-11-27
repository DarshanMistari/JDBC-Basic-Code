
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ResultSet_Scrollable {
    
    public static void main(String[] args) {
        
        try
        {
            // Step 1 Register the Driver
            Driver d = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(d);
            System.err.println("Driver Register the SucessFully...");

            // Step 2 Get Conection 
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Darshan");
            System.err.println("Get Connection is Sucessufully .... Connection id :"+con);

            // Step 3 Create Statement Object
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_UPDATABLE);
            System.err.println("Statement Object is Created...");

            // Step 4 Execute the Query
            ResultSet rs = stmt.executeQuery("select * from stud");

            while(rs.next())
            {
                System.err.println( rs.getInt(1) +"\t"+ rs.getString(2 ));
            }

            // First Row Data Acess In DataBase
            System.err.print("\n First Row Data Acess In DataBase :");
            rs.first();
            System.err.println(+rs.getInt(1) +"\t"+ rs.getString(2) );

            // Specific Row Data Acess In DataBase
            System.err.print("\n Specific Row Data Acess In DataBase : ");
            rs.absolute(5);
             System.err.println(+rs.getInt(1) +"\t"+ rs.getString(2) );


            // Last Row Data Acess In DataBase
            System.err.print("\n Last Row Data Acess In DataBase :  ");
            rs.last();
            System.err.println(+rs.getInt(1) +"\t"+ rs.getString(2) );

            // Step 5 Close Connection
            con.close();

        }
        catch(SQLException ex )
        {
            System.err.println("Error in DataBase Conection");
        }
    }
}
