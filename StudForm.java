package com.infogalaxy.jdbc;

import javax.xml.soap.Text;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudForm {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel lblID = new JLabel();
        JTextField txtID = new JTextField();
        JLabel lblName = new JLabel();
        JTextField txtName = new JTextField();
        JButton btnAdd = new JButton("ADD");

        frame.setSize(400,400);
        panel.setLayout(null);

        lblID.setBounds(50,50,50,30);
        lblID.setText("ID:");
        panel.add(lblID);

        txtID.setBounds(110,50,100,30);
        panel.add(txtID);

        lblName.setBounds(50,90,50,30);
        lblName.setText("Name:");
        panel.add(lblName);

        txtName.setBounds(110,90,100,30);
        panel.add(txtName);

        btnAdd.setBounds(50,130,70,30);
        panel.add(btnAdd);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Button Clicked...");
                try
                {
                    //Step 1 Register the Driver
                    Driver d = new com.mysql.cj.jdbc.Driver();
                    System.out.println("Driver Registered Successfully...");

                    //Step 2 Get Connection
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
                    System.out.println("Connection Created with ID = "+ con);

                    //Step 3 Create Statement Object
                    Statement stmt = con.createStatement();
                    System.out.println("Statement Object Created...");

                    //Step 4 Execute the Query
                    //stmt.executeUpdate("insert into course values(4,'Android')");
                    stmt.executeUpdate("insert into stud values("+txtID.getText().toString()+",'"+txtName.getText().toString()+"')");
                    System.out.println("Query Executed... Data Added...");

                    //Step 5 Close Connection
                    con.close();

                } catch (SQLException ex) {
                    // TODO Auto-generated catch block
                    ex.printStackTrace();
                }

                txtID.setText("");
                txtName.setText("");
                txtID.requestFocus();
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

}
