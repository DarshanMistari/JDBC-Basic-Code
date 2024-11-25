import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_PreparedStatement
{
  public static void main(String args[])
  {
    try
    {
      //    Step 1 Register the Driver
         Driver d = new oracle.jdbc.driver.OracleDriver();
         DriverManager.registerDriver(d);
         System.err.println("Register the Driver is SuccessFully...");

      //   Step 2 Get Connection 
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Darshan");
        System.err.println("Get Connection is SuccessFully ..."+con);

      //   Step 3 Create PreparedStatemment Object 
      //   Statement stmt = con.createStatement();

        PreparedStatement pstmt = con.prepareStatement("insert into stud values(?,?)");
        System.err.println("Statement Object is Created");

        Scanner sc = new Scanner(System.in);
        System.err.println("Please Enter the ID and Name :");
        int id = sc.nextInt();
        String name = sc.next();

        pstmt.setInt(1, id);
        pstmt.setString(2, name);

      //   step 4 Execute Query
      //   insert Date from Table
        pstmt.executeUpdate();

      //   Step 5 Close Connection
        con.close();
    }
    catch(SQLException ex)
    {
      System.err.println("Error in the Code..");
    }
  }
}
