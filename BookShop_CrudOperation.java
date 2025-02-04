
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.*;


public class BookShop_CrudOperation {
    
    static  Driver d;
    static  Connection con ;
    static  PreparedStatement pstmt;
    static ResultSet rs;
    public static void CreatedConnection(){

       try {
            d = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(d);

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Darshan");
            System.err.println("Get Connection SuccessFully..");

            pstmt = con.prepareStatement("insert into Bookshop(id , bookname,edition,price) values(?,?,?,?)");
        } catch (SQLException e) {
        System.err.println("Error in DataBase Connection");
       }

    }

    // public static void tableDemo(){
    //     JFrame frame = new JFrame("Table Demo");
    //     JPanel panel = new JPanel();

    //     String data [] [] ={ 
    //     {"1","Darshan Mistari","JDBC"},
    //     {"2","Darshan Mistari","JDBC"},
    //     {"3","Darshan Mistari","JDBC"}
    //     };

    //     String ColumnName [] = {
    //         "id","Name","Course"
    //     };

    //     JTable table = new JTable(data,ColumnName);
    //     table.setBounds(480,100,300,200);

    //     JScrollPane s = new JScrollPane(table);
    //     s.setBounds(450,100,200,200);
    //     frame.add(s);
    //     frame.add(panel);
        
    // }

    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        JPanel panel =new JPanel();

        // Section 1 Book Registration
        JLabel lblhead = new JLabel("Book Shop");
        JLabel lblregister = new JLabel("Registration Page");
        JLabel lblbname = new JLabel("Book Name :");
        JTextField txtbname =new JTextField();
        JLabel lbledition = new JLabel("Book Edition :");
        JTextField txtedition = new JTextField();
        JLabel lblprice = new JLabel("Book Price :");
        JTextField txtprice = new JTextField();

        JButton btnsave = new JButton("Save");
        JButton btnExit = new JButton("Exit");
        JButton btnclear = new JButton("Clear");

        // Section 2 Book Search
        JLabel lblsearch = new JLabel("Search Book:");
        JLabel lblbookid = new JLabel("Book id Number:");
        JTextField txtbookid =new JTextField();

        // Section 3
        JButton btnupdate = new JButton("Update");
        JButton btndelete = new JButton("Delete");

        panel.setLayout(null);

        lblhead.setBounds(410, 30,90,30);
        panel.add(lblhead);

        lblregister.setBounds(100,90,140,30);
        panel.add(lblregister);

        lblbname.setBounds(100,150,100,30);
        panel.add(lblbname);
        
        txtbname.setBounds(230,150,150,30);
        panel.add(txtbname);

        lbledition.setBounds(100,200,150,30);
        panel.add(lbledition);

        txtedition.setBounds(230,200,150,30);
        panel.add(txtedition);

        lblprice.setBounds(100,250,150,30);
        panel.add(lblprice);

        txtprice.setBounds(230,250,150,30);
        panel.add(txtprice);

        btnsave.setBounds(100,300,70,30);
        panel.add(btnsave);

        btnclear.setBounds(205,300,70,30);
        panel.add(btnclear);

        btnExit.setBounds(310,300,70,30);
        panel.add(btnExit);

        lblsearch.setBounds(100,360,100,30);
        panel.add(lblsearch);

        lblbookid.setBounds(100,390,100,30);
        panel.add(lblbookid);

        txtbookid.setBounds(230,390,150,30);
        panel.add(txtbookid);

        btnupdate.setBounds(480,390,150,30);
        panel.add(btnupdate);

        btndelete.setBounds(650,390,150,30);
        panel.add(btndelete);

        JTable table = new JTable();
        table.setBounds(480,100,300,200);

        JScrollPane s = new JScrollPane(table);
        s.setBounds(480,100,350,250);
        frame.add(s);

        frame.add(panel);
        frame.setSize(900,500);
        frame.setLocation(190,60);
        frame.setTitle("Book Shop");
        frame.setVisible(true);
        

        btnsave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
               String id = txtbookid.getText();
               String bookname = txtbname.getText();
               String edition = txtedition.getText();
               String price = txtprice.getText();
                
               try {

                    // // step 1 Driver Register
                    // Driver d = new oracle.jdbc.driver.OracleDriver();
                    // DriverManager.registerDriver(d);

                    // //Step 2 Get Connection
                    // Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Darshan");
                    // System.err.println("Coonecttion SuccessFully..");
                    BookShop_CrudOperation.CreatedConnection();

                    //Step 3 PreparedStatement Object Created
                    PreparedStatement pstmt = con.prepareStatement("insert into Bookshop(id , bookname,edition,price) values(?,?,?,?)");
                    pstmt.setString(1, id);
                    pstmt.setString(2, bookname);
                    pstmt.setString(3, edition);
                    pstmt.setString(4, price);
                    pstmt.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Record Added Succesfully..");

                    txtbname.setText("");
                    txtedition.setText("");
                    txtprice.setText("");
                    txtbookid.setText("");
                    txtbname.requestFocus();
                    
                    // Step 5 close Connection
                    con.close();

               } catch (SQLException ex) {
                System.err.println("Erro Genrated Save Method");
                
               }
            }
        });

        txtbookid.addKeyListener(new KeyAdapter(){

            @Override
            public void keyReleased(KeyEvent e){

                try {
                    String id = txtbookid.getText();
                   BookShop_CrudOperation.CreatedConnection();
                    //Step 3 PreparedStatement Object Created
                    PreparedStatement pstmt = con.prepareStatement("select bookname , edition, price from Bookshop where id=?");

                    pstmt.setString(1, id);
                    ResultSet rs = pstmt.executeQuery();

                    if(rs.next()==true){
                        String bookname = rs.getString(1);
                        String edition =rs.getString(2);
                        String price =rs.getString(3);

                        txtbname.setText(bookname);
                        txtedition.setText(edition);
                        txtprice.setText(price);
                    }else{
                        txtbname.setText("");
                        txtedition.setText("");
                        txtprice.setText("");

                    }

                }catch (SQLException ex) {
                    // TODO: handle exception
                    System.err.println("Error in Key Relese Event..");
                }
                
            }
        });

        btnupdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
               String id = txtbookid.getText();
               String bookname = txtbname.getText();
               String edition = txtedition.getText();
               String price = txtprice.getText();
                
               try {
                    // //Step 2 Get Connection
                    // Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Darshan");
                    // System.err.println("Coonecttion SuccessFully..");
                    BookShop_CrudOperation.CreatedConnection();
                    //Step 3 PreparedStatement Object Created
                    PreparedStatement pstmt = con.prepareStatement("update Bookshop set bookname=?, edition=?, price=? where id=?");

                    pstmt.setString(1, bookname);
                    pstmt.setString(2, edition);
                    pstmt.setString(3, price);
                    pstmt.setString(4, id);
                    pstmt.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Record Updated Succesfully..");

                    txtbname.setText("");
                    txtedition.setText("");
                    txtprice.setText("");
                    txtbookid.setText("");
                    txtbname.requestFocus();
               } catch (SQLException ex) {
                System.err.println("Error in Genrated Update Method.");
                
               }
            }
        });

        btndelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
               String id = txtbookid.getText();

               try {

                    BookShop_CrudOperation.CreatedConnection();
                    //Step 3 PreparedStatement Object Created
                    PreparedStatement pstmt = con.prepareStatement("delete from Bookshop where id=?");

                    pstmt.setString(1, id);
                    pstmt.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Record Deleted Succesfully..");

                    txtbname.setText("");
                    txtedition.setText("");
                    txtprice.setText("");
                    txtbookid.setText("");
                    txtbname.requestFocus();
               } catch (SQLException ex) {
                System.err.println("Error in Genrated Deleted Method.");
                
               }
            }
        });

        btnclear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                txtbname.setText("");
                txtedition.setText("");
                txtprice.setText("");
                txtbookid.setText("");
                txtbname.requestFocus();

            }
        });

        btnExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                frame.dispose();
            }
        });

    }
    
}
