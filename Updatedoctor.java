package jan1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Updatedoctor extends JFrame {
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField adm;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JTextField name;
    private JTextField age;
    private JTextField qualification;
    private JTextField address;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JTextField phone;
    private JTextField uname;
    private JTextField pwd;
    private JButton jButton3;

    public Updatedoctor() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null); // Use null layout to specify absolute positioning
        setSize(500, 430);
        setLocationRelativeTo(null); // Center the frame
        setResizable(false);

        jLabel1 = new JLabel("UPDATE DOCTOR");
        jLabel2 = new JLabel("USER NAME");

        adm = new JTextField();
        jButton1 = new JButton("search");
        jButton2 = new JButton("clear");

        jLabel3 = new JLabel("name");
        jLabel4 = new JLabel("age");
        jLabel5 = new JLabel("qualification");
        jLabel6 = new JLabel("address");
        jLabel7 = new JLabel("phone");
        jLabel8 = new JLabel("uname");
        jLabel9 = new JLabel("pwd");

        name = new JTextField();
        age = new JTextField();
        qualification = new JTextField();
        address = new JTextField();
        phone = new JTextField();
        uname = new JTextField();
        pwd = new JTextField();
        jButton3 = new JButton("submit");

        jLabel1.setBounds(10, 10, 150, 20);
        jLabel2.setBounds(10, 40, 100, 20);
        adm.setBounds(120, 40, 150, 20);
        jButton1.setBounds(280, 40, 80, 20);
        jButton2.setBounds(370, 40, 80, 20);
        jLabel3.setBounds(10, 80, 100, 20);
        name.setBounds(120, 80, 150, 20);
        jLabel4.setBounds(10, 120, 100, 20);
        age.setBounds(120, 120, 150, 20);
        jLabel5.setBounds(10, 160, 100, 20);
        qualification.setBounds(120, 160, 150, 20);
        jLabel6.setBounds(10, 200, 100, 20);
        address.setBounds(120, 200, 150, 20);
        jLabel7.setBounds(10, 240, 100, 20);
        phone.setBounds(120, 240, 150, 20);
        jLabel8.setBounds(10, 280, 100, 20);
        uname.setBounds(120, 280, 150, 20);
        jLabel9.setBounds(10, 320, 100, 20);
        pwd.setBounds(120, 320, 150, 20);
        jButton3.setBounds(10, 360, 80, 20);

        add(jLabel1);
         add(jLabel2);
          add(jLabel3);
          add(jLabel4); 
           add(jLabel5);
            add(jLabel6);
             add(jLabel7);
              add(jLabel8);
               add(jLabel9);
                add(jButton1);
                add(jButton2);
                add(jButton3);
                add(age);
                add(name);
                add(adm);
                add(qualification);
                add(phone);
                add(pwd);
                add(uname);
                add(address);

        

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String userName = adm.getText();
        try {
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM doctor WHERE uname=?");
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
                JOptionPane.showMessageDialog(null, "Invalid User Name !!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        name.setText("");
        age.setText("");
        qualification.setText("");
        address.setText("");
        phone.setText("");
        uname.setText("");
        pwd.setText("");
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE doctor SET name=?, age=?, qualification=?, address=?, phone=?, pwd=? WHERE uname=?");
            ps.setString(1, name.getText());
            ps.setString(2, age.getText());
            ps.setString(3, qualification.getText());
            ps.setString(4, address.getText());
            ps.setString(5, phone.getText());
            ps.setString(6, uname.getText());
            ps.setString(7, pwd.getText());

            int x = ps.executeUpdate();
            if (x >= 0) {
                JOptionPane.showMessageDialog(null, "DOCTOR Details updated");
            } else {
                JOptionPane.showMessageDialog(null, "Update failed");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Updatedoctor().setVisible(true);
            }
        });
    }
}
