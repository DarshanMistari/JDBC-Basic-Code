import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// import java.util.Scanner;
// import java.sql.PreparedStatement;


public class JDBC_Revision {
    
    
    public static void main(String[] args) {
        
        try {
            // Step 1 Register Driver Interface

            Driver d  = (Driver) new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(d);
            System.out.println("Register Driver SucessFully");

            // Step 2 Get Connection 

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Darshan");
            System.out.println("Connection Created SucessFully..");

            // Step 3 Create Statement Object

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            // PreparedStatement pstmt = con.prepareStatement("insert into studentInfo values(?,?,?)");
            System.out.println("Statement object Created SuccessFully");

            // System.err.println("Please Enter the ID and Name and  :");
            // Scanner scanner = new Scanner(System.in);

            // int id = scanner.nextInt();
            // String name = scanner.next();
            // String city = scanner.next();
            

            // pstmt.setInt(1, id);
            // pstmt.setString(2, name);
            // pstmt.setString(3, city);
            


            // step 4 ExecuteQuery Performed Crud Operation

            // stmt.executeUpdate("create table studentInfo(id number(3),name varchar2(30) , city varchar2(30))");
            //  stmt.executeUpdate("insert into studentInfo values("+id+" , '"+name+"', '"+city+"'))");
             
            // pstmt.executeUpdate();
            // System.out.println("Table is created SucessFully");

            
            ResultSet rs = stmt.executeQuery("select id , name , city from studentInfo");
            while(rs.next()){
                System.err.println(rs.getInt(1) +"\t"+ rs.getString(2) +"\t"+ rs.getString(3));
            }

            System.err.println("\n First in Table :");
            rs.first();
            System.err.println(rs.getInt(1) +"\t"+ rs.getString(2) +"\t"+ rs.getString(3));

            System.err.println("\n absolute in Table :");
            rs.absolute(2);
            System.err.println(rs.getInt(1) +"\t"+ rs.getString(2) +"\t"+ rs.getString(3));

            System.err.println("\n Last in Table :");
            rs.last();
            System.err.println(rs.getInt(1) +"\t"+ rs.getString(2) +"\t"+ rs.getString(3));

            // Update data in DataBase ResultSet concur Updatable
            rs.absolute(3);
            rs.updateString( "name" , "Umesh");
            rs.updateRow();

            // Insert Data in Database 
            rs.moveToInsertRow();
            rs.updateInt(1,5);
            rs.updateString(2, "Ritesh");
            rs.updateString(3,"Deur");
            rs.insertRow();
            rs.moveToCurrentRow();




            // Step 5 close Connection
            con.close();
            
        } catch (SQLException e) {
            System.out.println("Error in database");
        }

    }
}
