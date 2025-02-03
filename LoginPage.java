
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class LoginPage extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		JLabel lbltitle = new JLabel("Login Page");
		JLabel lblusername = new JLabel("Username :");
		JTextField  txtusername = new JTextField();
		
		JLabel lblpassword = new JLabel("Password :");
		JTextField txtpassword = new JTextField();
		
		JButton btnlogin = new JButton("Login");
		JButton btnsignup = new JButton("Signup");
		
		panel.setLayout(null);
		
		lbltitle.setBounds(100,20,90,30);
		panel.add(lbltitle);
		
		lblusername.setBounds(60,60,90,30);
		panel.add(lblusername);
		
		txtusername.setBounds(60,90,170,30);
		panel.add(txtusername);
		
		lblpassword.setBounds(60,120,90,30);
		panel.add(lblpassword);
		
		txtpassword.setBounds(60,150,170,30);
		panel.add(txtpassword);
		
		btnlogin.setBounds(60,190,70,30);
		panel.add(btnlogin);
		
		btnsignup.setBounds(160,190,70,30);
		panel.add(btnsignup);
		
		btnlogin.addActionListener(new ActionListener() {
			
            @Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					// Step 1 Register the Driver
					Driver d = new oracle.jdbc.driver.OracleDriver();
					DriverManager.registerDriver(d);

					// Step 2 Get Connection
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Darshan");
					System.out.println("Connection is SuccessFully..Con id :"+con);
					
					// Step 3 Statement Object is Created
					Statement stmt = con.createStatement();

                    // Step 4 Execute Query
					String sql = "select * from LoginPage where userName='"+txtusername.getText().toString()+"',password='"+txtpassword.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"Login SuccessFully...");
					}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect UserName & Password..");
					}
                    // Step 5 Close  Connection
					con.close();
				}catch(SQLException ex) {
					System.out.print("Error in Database Connection:");
				}

			}
		});

		frame.add(panel);
		frame.setSize(300,300);
		frame.setLocation(50,50);
		frame.setTitle("Login Page");
		frame.setVisible(true);
		
		
	}

}

