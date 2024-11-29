
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import oracle.jdbc.driver.OracleDriver;

public class MetaDataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			Driver driver = new OracleDriver();
			DriverManager.registerDriver(driver);
			System.out.println("Driver Registered Successfully!!!");
			
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Darshan");
			System.out.println("Connection Created Successfully!!!");
			
			// Database MetaData --> Data about Data
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			System.out.println("DB Product Name="+databaseMetaData.getDatabaseProductName());
			System.out.println("DB Version="+databaseMetaData.getDatabaseProductVersion());
			System.out.println("DB Major Version="+databaseMetaData.getDatabaseMajorVersion());
			System.out.println("DB Minor Version="+databaseMetaData.getDatabaseMinorVersion());
			System.out.println("JDBC Driver = "+databaseMetaData.getJDBCMajorVersion()+"-"+databaseMetaData.getJDBCMinorVersion());
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from stud");
			
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			System.out.println("Column Count="+resultSetMetaData.getColumnCount());
			System.out.println("Column Names="+resultSetMetaData.getColumnName(1)+"\t"+resultSetMetaData.getColumnName(2));
			System.out.println("Column 1 Type="+resultSetMetaData.getColumnType(1));
			if(resultSetMetaData.getColumnType(1)==Types.NUMERIC) {
				System.out.println("Column Type is NUMERIC");
			}
			System.out.println("Column 1 Type="+resultSetMetaData.getColumnTypeName(1));
			System.out.println("Column 2 Type="+resultSetMetaData.getColumnTypeName(2));
			connection.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
