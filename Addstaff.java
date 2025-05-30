package jan1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

public class Addstaff extends JFrame {
    private JLabel nameLabel, ageLabel, qualificationLabel, addressLabel, phoneLabel, unameLabel, pwdLabel;
    private JTextField name, age, qualification, address, phone, uname;
    private JPasswordField pwd;
    private JButton submitButton, clearButton;

    public Addstaff() {
        setTitle("Add New Staff");
        setLayout(null);  // Set layout to null for absolute positioning

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 10, 80, 25);
        add(nameLabel);

        name = new JTextField();
        name.setBounds(100, 10, 200, 25);
        add(name);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(10, 40, 80, 25);
        add(ageLabel);

        age = new JTextField();
        age.setBounds(100, 40, 200, 25);
        add(age);

        qualificationLabel = new JLabel("Qualification:");
        qualificationLabel.setBounds(10, 70, 80, 25);
        add(qualificationLabel);

        qualification = new JTextField();
        qualification.setBounds(100, 70, 200, 25);
        add(qualification);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(10, 100, 80, 25);
        add(addressLabel);

        address = new JTextField();
        address.setBounds(100, 100, 200, 25);
        add(address);

        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(10, 130, 80, 25);
        add(phoneLabel);

        phone = new JTextField();
        phone.setBounds(100, 130, 200, 25);
        add(phone);

        unameLabel = new JLabel("Username:");
        unameLabel.setBounds(10, 160, 80, 25);
        add(unameLabel);

        uname = new JTextField();
        uname.setBounds(100, 160, 200, 25);
        add(uname);

        pwdLabel = new JLabel("Password:");
        pwdLabel.setBounds(10, 190, 80, 25);
        add(pwdLabel);

        pwd = new JPasswordField();
        pwd.setBounds(100, 190, 200, 25);
        add(pwd);

        submitButton = new JButton("Submit");
        submitButton.setBounds(10, 220, 100, 25);
        add(submitButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(120, 220, 100, 25);
        add(clearButton);

        // Add an action listener to the Submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = Connectiondb.getConnection();
                    PreparedStatement ps = con.prepareStatement("INSERT INTO staff(name, age, qualification, address, phone, uname, pwd) VALUES(?, ?, ?, ?, ?, ?, ?)");
                    ps.setString(1, name.getText());
                    ps.setString(2, age.getText());
                    ps.setString(3, qualification.getText());
                    ps.setString(4, address.getText());
                    ps.setString(5, phone.getText());
                    ps.setString(6, uname.getText());
                    ps.setString(7, new String(pwd.getPassword()));  // Get the password as a string

                    int x = ps.executeUpdate();
                    if (x > 0) {
                        JOptionPane.showMessageDialog(null, "Staff Added");
                        clearFields();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        // Add an action listener to the Clear button
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        
        setSize(320, 300);
        setLocationRelativeTo(null); // Center the frame
        setResizable(false);
    }

    private void clearFields() {
        name.setText("");
        age.setText("");
        qualification.setText("");
        address.setText("");
        phone.setText("");
        uname.setText("");
        pwd.setText("");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Addstaff().setVisible(true);
            }
        });
    }
}

