package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.sql.ResultSet;

import com.user.entity.User;
import com.user.util.Util;

public class UserDao {

	static Connection con = Util.createConnection();

//	public static void saveUser(User users) {
//		try {
//			Statement st = con.createStatement();
//			st.execute("insert into users values('"+users.getUserId()+"','"+users.getUserName()+"','"+users.getPassword()+"','"+users.getEmail()+"','"+users.getAddress()+"','"+users.getMobileNo()+"')");
//			System.out.println("User Register");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

	public static void saveUser(User users) {
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into users values(?,?,?,?,?,?)"); // Query Parameter
			pstmt.setInt(1, users.getUserId());
			pstmt.setString(2, users.getUserName());
			pstmt.setString(3, users.getPassword());
			pstmt.setString(4, users.getEmail());
			pstmt.setString(5, users.getAddress());
			pstmt.setLong(6, users.getMobileNo());

			pstmt.executeUpdate();

			System.out.println("User Register SuccesFully.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateUser(User users) {
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"update users set username=?, password=?, email=?,address=?,mobileNo=? where id=?");
			pstmt.setString(1, users.getUserName());
			pstmt.setString(2, users.getPassword());
			pstmt.setString(3, users.getEmail());
			pstmt.setString(4, users.getAddress());
			pstmt.setLong(5, users.getMobileNo());
			pstmt.setInt(6, users.getUserId());
			pstmt.executeUpdate();

			System.out.println("User Updated SuccesFully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteUser(int id) {
		try {
			PreparedStatement pstmt = con.prepareStatement("delete from users where id =?");
			pstmt.setInt(1, id);

			pstmt.executeUpdate();

			System.out.println("User Deleted SucessFully.");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void getAllRecords() {

		try {
			PreparedStatement pstmt = con.prepareStatement("select * from users");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
//				
//				System.out.println(rs.getInt(1) +"\t"+ rs.getString(2) +"\t"+ rs.getString(3) +"\t"+ rs.getString(4) +"\t"+ rs.getString(5) +"\t"+ rs.getLong(6));
				System.out.println(rs.getInt(1) + "\n" + rs.getString(2) + "\n" + rs.getString(3) + "\n"
						+ rs.getString(4) + "\n" + rs.getString(5) + "\n" + rs.getLong(6));

				System.out.println("============================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void getUserById(int id) {
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from users");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int bookId = rs.getInt("");
				System.out.println("============================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {

		User user = new User();
		user.setUserId(7);
		user.setUserName("Chetan Patil");
		user.setPassword("2373");
		user.setEmail("chetan@gmail.com");
		user.setAddress("Pune");
		user.setMobileNo(1234509876);

		saveUser(user);
		updateUser(user);
		deleteUser(7);
		getAllRecords();
	}
}
