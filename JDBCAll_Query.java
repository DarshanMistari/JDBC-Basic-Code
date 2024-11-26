import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class JDBCAll_Query
{
    public static void main(String args[])
    {
        try
        {
            // step 1 Register the Driver//
            Driver d = (Driver) new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(d);

            // Step 2 Get Connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Darshan");
            System.err.println("Get Connection is SuccessFully ....");

            //Step 3 Create Statement Object
            Statement stmt = con.createStatement();
            System.err.println("Create Statement Object SuccessFully ... Connection id :"+con);

            //Step 4 Execute Query 
            // create table 
            //stmt.executeUpdate("create table stud(id number(3),name varchar2(30) , city varchar2(20))");

            //insert Data from Table
            //stmt.executeUpdate("insert into stud values(4, 'Darshan Mistari')");

            //Updat Data fron Table
            //stmt.executeUpdate("update stud set name='Jayesh Sonar' where id=4");
            System.err.println("Execute the Query..");

            //Delete Data From Table
            stmt.executeUpdate("delete from stud where id=9");
        }
        catch(SQLException ex)
        {
            System.err.println("Error in Code");
        }

    }
}