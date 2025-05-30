package jan1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Updatestaff extends JFrame {

    private JTextField adm, name, age, qualification, address, phone, uname, pwd;

    public Updatestaff() {
        initComponents();
    }

    private void initComponents() {
        // Initialize all components
        JLabel titleLabel = new JLabel("UPDATE STAFF");
        JLabel usernameLabel = new JLabel("USER NAME");
        adm = new JTextField();
        JButton searchButton = new JButton("SEARCH");
        JButton clearButton = new JButton("CLEAR");

        JLabel nameLabel = new JLabel("NAME");
        JLabel ageLabel = new JLabel("AGE");
        JLabel qualificationLabel = new JLabel("QUALIFICATION");
        JLabel addressLabel = new JLabel("ADDRESS");
        JLabel phoneLabel = new JLabel("PHONE");
        JLabel unameLabel = new JLabel("UNAME");
        JLabel pwdLabel = new JLabel("PWD");

        name = new JTextField();
        age = new JTextField();
        qualification = new JTextField();
        address = new JTextField();
        phone = new JTextField();
        uname = new JTextField();
        pwd = new JTextField();

        JButton updateButton = new JButton("UPDATE");

        // Set layout for the frame
        setLayout(null); // Use null layout for absolute positioning

        // Position and size of components
        titleLabel.setBounds(150, 10, 200, 30);
        usernameLabel.setBounds(20, 50, 100, 20);
        adm.setBounds(120, 50, 150, 20);
        searchButton.setBounds(300, 50, 80, 20);
        clearButton.setBounds(390, 50, 80, 20);

        nameLabel.setBounds(20, 100, 100, 20);
        name.setBounds(120, 100, 150, 20);
        ageLabel.setBounds(20, 130, 100, 20);
        age.setBounds(120, 130, 150, 20);
        qualificationLabel.setBounds(20, 160, 100, 20);
        qualification.setBounds(120, 160, 150, 20);
        addressLabel.setBounds(20, 190, 100, 20);
        address.setBounds(120, 190, 150, 20);
        phoneLabel.setBounds(20, 220, 100, 20);
        phone.setBounds(120, 220, 150, 20);
        unameLabel.setBounds(20, 250, 100, 20);
        uname.setBounds(120, 250, 150, 20);
        pwdLabel.setBounds(20, 280, 100, 20);
        pwd.setBounds(120, 280, 150, 20);

        updateButton.setBounds(180, 320, 100, 30);

        // Add action listeners
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchButtonActionPerformed(e);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearButtonActionPerformed(e);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateButtonActionPerformed(e);
            }
        });

        // Add components to the frame
        add(titleLabel);
        add(usernameLabel);
        add(adm);
        add(searchButton);
        add(clearButton);

        add(nameLabel);
        add(name);
        add(ageLabel);
        add(age);
        add(qualificationLabel);
        add(qualification);
        add(addressLabel);
        add(address);
        add(phoneLabel);
        add(phone);
        add(unameLabel);
        add(uname);
        add(pwdLabel);
        add(pwd);
        add(updateButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setTitle("Update Staff Information");
    }

    private void searchButtonActionPerformed(ActionEvent evt) {
        String userName = adm.getText();
        try {
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM staff WHERE uname = ?");
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                adm.setEditable(false);
                name.setText(rs.getString("name"));
                age.setText(rs.getString("age"));
                qualification.setText(rs.getString("qualification"));
                address.setText(rs.getString("address"));
                phone.setText(rs.getString("phone"));
                uname.setText(rs.getString("uname"));
                pwd.setText(rs.getString("pwd"));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid User Name!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearButtonActionPerformed(ActionEvent evt) {
        adm.setEditable(true);
        adm.setText("");
        name.setText("");
        age.setText("");
        qualification.setText("");
        address.setText("");
        phone.setText("");
        uname.setText("");
        pwd.setText("");
    }

    private void updateButtonActionPerformed(ActionEvent evt) {
        try {
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE staff SET name = ?, age = ?, qualification = ?, address = ?, phone = ?, pwd = ? WHERE uname = ?");
            ps.setString(1, name.getText());
            ps.setString(2, age.getText());
            ps.setString(3, qualification.getText());
            ps.setString(4, address.getText());
            ps.setString(5, phone.getText());
            ps.setString(6, uname.getText());
            ps.setString(7, pwd.getText());
            int x = ps.executeUpdate();
            if (x > 0) {
                JOptionPane.showMessageDialog(null, "Staff Details updated");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Updatestaff().setVisible(true);
            }
        });
    }
}
