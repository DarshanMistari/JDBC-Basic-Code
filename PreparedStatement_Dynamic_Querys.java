import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class PreparedStatement_Dynamic_Query
{
    public static void main(String args[])
    {
        try
        {
            // Step 1 Register the Driver
            Driver d = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(d);
            System.err.println("Register the Driver SucessFully...");

            // Step 2 Get Connection 
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Darshan");
            System.err.println("Get Connection Successufully .... Connection id :"+con);

            // Step 3 Prepared Statement object Created
            PreparedStatement pstmt = con.prepareStatement("insert into stud values(?,?)");

            // PreparedStatement pstmt = con.prepareStatement("delete from stud where id=9");
            System.err.println("Prepared Statement Object is Created....");

            Scanner sc = new Scanner(System.in);
            System.err.println("Please Enter the Id and Name :");
            int id = sc.nextInt();
            String name = sc.next();

            pstmt.setInt(1, id);
            pstmt.setString(2, name);

            System.err.println("Operation is Perform from Database...");

            // Step 4 Execute the Query
            pstmt.executeUpdate();

            // Step 5 Close Connection
            con.close();

        }
        catch(SQLException ex)

        {
            System.err.println("Error is Database Connection...");
        }

    }
}