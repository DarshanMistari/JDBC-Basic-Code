import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PasswordField{
    private JPasswordField jPasswordField1;
    private JCheckBox jCheckBox1;
    public PasswordField() {
        jPasswordField1 = new JPasswordField(10);
        jCheckBox1 = new JCheckBox("Show Password");
        jCheckBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jCheckBox1.isSelected()) {
                    jPasswordField1.setEchoChar((char) 0); // Make password visible
                } else {
                    jPasswordField1.setEchoChar('*'); // Make password non-visible
                }
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Field Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        PasswordField passwordField = new PasswordField();
        frame.add(passwordField.jPasswordField1);
        frame.add(passwordField.jCheckBox1);
        frame.pack();
        frame.setVisible(true);
    }
}