
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

public class StudentInfo_SwingJDBC {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Student info Swing JDBC");
        JPanel panel = new JPanel();

        JLabel lblTitle =new JLabel("Student Information");
        JLabel lblId = new JLabel("Enter Stud ID :");
        JTextField txtId =new JTextField();
        JLabel lblName = new JLabel("Enter Stud Name :");
        JTextField txtName = new JTextField();
        JLabel lblCity = new JLabel("Enter Stud City :");
        JTextField txtCity = new JTextField();
        JLabel lblCourse = new JLabel("Enter Stud Course:");
        JTextField txtCourse =new JTextField();
        JButton btnAddInfo = new JButton("ADD Information to DataBase");

        panel.setLayout(null);

        lblTitle.setBounds(140,40,150,30);
        panel.add(lblTitle);

        lblId.setBounds(80,100,100,30);
        panel.add(lblId);

        txtId.setBounds(210,100,150,30);
        panel.add(txtId);

        lblName.setBounds(80,150,150,30);
        panel.add(lblName);

        txtName.setBounds(210,150,150,30);
        panel.add(txtName);

        lblCity.setBounds(80,200,150,30);
        panel.add(lblCity);

        txtCity.setBounds(210,200,150,30);
        panel.add(txtCity);

        lblCourse.setBounds(80,250,150,30);
        panel.add(lblCourse);

        txtCourse.setBounds(210,250,150,30);
        panel.add(txtCourse);

        btnAddInfo.setBounds( 80,300,280,30);
        panel.add(btnAddInfo);

        btnAddInfo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae){

                try {
                    // Step 1 Register Driver 
                    Driver d = new oracle.jdbc.driver.OracleDriver();
                    DriverManager.registerDriver(d);

                    // Step 2 Get Connection
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Darshan");
                    System.out.println("Get Connection SuccessFully..");

                    // Step 3 Statement Object Crated
                    Statement stmt =con.createStatement();

                    // Step 4  Eexcute Query
                    stmt.executeUpdate("insert into student values("+txtId.getText().toString()+",'"+txtName.getText().toString()+"','"+txtCity.getText().toString()+"','"+txtCourse.getText().toString()+"')");
                    JOptionPane.showMessageDialog(null,"Data is Inserte SuccessFully");
                    // Step 5 close con
                    con.close();

                } catch (SQLException ex) {
                  ex.printStackTrace();
                }

                txtId.setText("");
                txtName.setText("");
                txtCity.setText("");
                txtCourse.setText("");
                txtId.requestFocus();
            }
        });

        frame.add(panel);
        frame.setSize(450,450);
        frame.setLocation(50,50);
        frame.setVisible(true);

    }
}
